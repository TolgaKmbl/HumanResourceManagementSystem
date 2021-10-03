package com.tolgakmbl.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.EmailActivationService;
import com.tolgakmbl.hrms.business.abstracts.JobSeekerService;
import com.tolgakmbl.hrms.business.abstracts.MernisActivationService;
import com.tolgakmbl.hrms.business.abstracts.UserService;
import com.tolgakmbl.hrms.business.adapters.mernisService.PersonForValidateFromMernisService;
import com.tolgakmbl.hrms.core.utilities.business.BusinessRules;
import com.tolgakmbl.hrms.core.utilities.results.*;
import com.tolgakmbl.hrms.dataAccess.abstracts.JobSeekerDao;
import com.tolgakmbl.hrms.dataAccess.abstracts.JobSeekersFavoriteJobAdvertDao;
import com.tolgakmbl.hrms.entities.concretes.JobSeeker;
import com.tolgakmbl.hrms.entities.concretes.JobSeekersFavoriteJobAdvert;
import com.tolgakmbl.hrms.entities.concretes.MernisActivation;
import com.tolgakmbl.hrms.entities.dtos.JobSeekerForRegisterDto;


@Service
public class JobSeekerManager implements JobSeekerService {
	
	private final JobSeekerDao jobSeekerDao;
	private final UserService userService;
	private final MernisActivationService mernisActivationService;
	private final EmailActivationService emailActivationService;
	private final JobSeekersFavoriteJobAdvertDao jobSeekersFavoriteJobAdvertDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserService userService,
			MernisActivationService mernisActivationService, EmailActivationService emailActivationService,
			JobSeekersFavoriteJobAdvertDao jobSeekersFavoriteJobAdvertDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userService = userService;
		this.mernisActivationService = mernisActivationService;
		this.emailActivationService = emailActivationService;
		this.jobSeekersFavoriteJobAdvertDao = jobSeekersFavoriteJobAdvertDao;
	}
	
	private Result arePasswordMatch(final String password, final String confirmPassword) {
		return password.equals(confirmPassword) ? new SuccessResult() : new ErrorResult("Passwords do not match");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Job Seeker added");
	}

	@Override
	public Result delete(int id) {
		jobSeekerDao.deleteById(id);
		return new SuccessResult("Job Seeker deleted");
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(),"Job Seekers listed");
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(jobSeekerDao.findById(id).get());
	}

	@Override
	public Result update(JobSeeker jobSeeker) {
		jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Job Seeker updated");
	}

	@Override
	public DataResult<JobSeeker> getByIdentityNumber(String identityNumber) {
		final Optional<JobSeeker> jobSeeker = jobSeekerDao.findByNationalId(identityNumber);

		if (jobSeeker.isEmpty())
			return new ErrorDataResult<>("Job seeker has not found");

		return new SuccessDataResult<>(jobSeeker.get());
	}

	@Override
	public Result isNotNationalIdentityExist(String identityNumber) {
		return jobSeekerDao.findByNationalId(identityNumber).isEmpty() ? new SuccessResult()
				: new ErrorResult("A job seeker with this identity number already exists");
	}

	@Override
	public Result register(JobSeekerForRegisterDto jobSeekerForRegisterDto) {
		final Result businessRulesResult = BusinessRules.run(
				userService.isNotEmailExist(jobSeekerForRegisterDto.getEmail()),
				isNotNationalIdentityExist(jobSeekerForRegisterDto.getIdentityNumber()),
				arePasswordMatch(jobSeekerForRegisterDto.getPassword(), jobSeekerForRegisterDto.getConfirmPassword()),
				mernisActivationService.check(PersonForValidateFromMernisService.builder()
						.ad(jobSeekerForRegisterDto.getFirstName())
						.soyad(jobSeekerForRegisterDto.getLastName())
						.TCKimlikNo(Long.parseLong(jobSeekerForRegisterDto.getIdentityNumber()))
						.dogumYili(jobSeekerForRegisterDto.getBirthDate().getYear())
						.build()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		final JobSeeker jobSeeker = JobSeeker.childBuilder()
				.email(jobSeekerForRegisterDto.getEmail())
				.password(jobSeekerForRegisterDto.getPassword())
				.firstName(jobSeekerForRegisterDto.getFirstName())
				.lastName(jobSeekerForRegisterDto.getLastName())
				.nationalId(jobSeekerForRegisterDto.getIdentityNumber())
				.birthDate(jobSeekerForRegisterDto.getBirthDate())
				.build();

		add(jobSeeker);

		emailActivationService.createAndSendActivationCodeByMail(jobSeeker, jobSeeker.getEmail());
		mernisActivationService.add(MernisActivation.builder().user(jobSeeker).build());

		return new SuccessResult("Job seeker has registered");
	}

	@Override
	public DataResult<JobSeekersFavoriteJobAdvert> getFavoriteByJobSeekerIdAndJobAdvertId(int jobSeekerId,
			int jobAdvertId) {
		Optional<JobSeekersFavoriteJobAdvert> jobSeekersFavoriteJobAdvert = this.jobSeekersFavoriteJobAdvertDao
				.findByJobSeeker_IdAndJobAdvert_Id(jobSeekerId, jobAdvertId);

		if (jobSeekersFavoriteJobAdvert.isEmpty())
			return new ErrorDataResult<>("Job seeker's favorite job advert has not found");

		return new SuccessDataResult<>(jobSeekersFavoriteJobAdvert.get());
	}

	@Override
	public Result undoFavoriteJobAdvert(int id) {
		Optional<JobSeekersFavoriteJobAdvert> jobSeekersFavoriteJobAdvert = jobSeekersFavoriteJobAdvertDao.findById(id);

		if (jobSeekersFavoriteJobAdvert.isEmpty())
			return new ErrorDataResult<>("Favorite job advert has not found");

		jobSeekersFavoriteJobAdvertDao.delete(jobSeekersFavoriteJobAdvert.get());

		return new SuccessResult("Favorite job advert has succesfully deleted");
	}

	@Override
	public Result favoriteJobAdvert(JobSeekersFavoriteJobAdvert jobSeekersFavoriteJobAdvert) {
		boolean isThereSameFavorite = !this.jobSeekersFavoriteJobAdvertDao
				.findByJobSeeker_IdAndJobAdvert_Id(jobSeekersFavoriteJobAdvert.getJobSeeker().getId(),
						jobSeekersFavoriteJobAdvert.getJobAdvert().getId())
				.isEmpty();
		if (isThereSameFavorite)
			return new ErrorResult("Favorite job advert already exists");

		this.jobSeekersFavoriteJobAdvertDao.save(jobSeekersFavoriteJobAdvert);

		return new SuccessResult("Favorite job advert has succesfully added");
	}

}
