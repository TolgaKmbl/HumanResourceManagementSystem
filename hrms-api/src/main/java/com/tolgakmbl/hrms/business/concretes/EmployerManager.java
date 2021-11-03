package com.tolgakmbl.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.CompanyStaffVerificationService;
import com.tolgakmbl.hrms.business.abstracts.EmailActivationService;
import com.tolgakmbl.hrms.business.abstracts.EmployerService;
import com.tolgakmbl.hrms.business.abstracts.UserService;
import com.tolgakmbl.hrms.core.utilities.business.BusinessRules;
import com.tolgakmbl.hrms.core.utilities.helpers.image.ImageService;
import com.tolgakmbl.hrms.core.utilities.helpers.image.cloudinary.CloudinaryImageHelper;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.ErrorDataResult;
import com.tolgakmbl.hrms.core.utilities.results.ErrorResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.core.utilities.results.SuccessDataResult;
import com.tolgakmbl.hrms.core.utilities.results.SuccessResult;
import com.tolgakmbl.hrms.dataAccess.abstracts.EmployerDao;
import com.tolgakmbl.hrms.dataAccess.abstracts.EmployerUpdateDao;
import com.tolgakmbl.hrms.entities.concretes.CompanyStaffVerification;
import com.tolgakmbl.hrms.entities.concretes.Employer;
import com.tolgakmbl.hrms.entities.concretes.EmployerUpdate;
import com.tolgakmbl.hrms.entities.dtos.EmployerForRegisterDto;
import com.tolgakmbl.hrms.entities.dtos.EmployerForUpdateDto;

@Service
public class EmployerManager implements EmployerService{
	
	private final EmployerDao employerDao;
	private final EmployerUpdateDao employerUpdateDao;
	private final UserService userService;
	private final EmailActivationService emailActivationService;
	private final CompanyStaffVerificationService companyStaffVerificationService;
	private final ImageService imageService;

	@Autowired
	public EmployerManager(final EmployerDao employerDao, final EmployerUpdateDao employerUpdateDao,
			final UserService userService, final EmailActivationService emailActivationService,
			final CompanyStaffVerificationService companyStaffVerificationService, final ImageService imageService) {		
		this.employerDao = employerDao;
		this.employerUpdateDao = employerUpdateDao;
		this.userService = userService;
		this.emailActivationService = emailActivationService;
		this.companyStaffVerificationService = companyStaffVerificationService;
		this.imageService = imageService;
	}
	
	private Result arePasswordMatch(final String password, final String confirmPassword) {
		return password.equals(confirmPassword) ? new SuccessResult()
				: new ErrorResult("Passwords are not match");
	}

	@Override
	public Result add(Employer employer) {
		employerDao.save(employer);
		return new SuccessResult("Employer added");
	}

	@Override
	public Result delete(int id) {
		employerDao.deleteById(id);
		return new SuccessResult("Employer deleted");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"Employers listed");
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(employerDao.findById(id).get());
	}

	@Override
	public Result update(Employer employer) {
		employerDao.save(employer);
		return new SuccessResult("Employer updated");
	}

	@Override
	public DataResult<EmployerUpdate> getLastUpdateByUserId(int id) {
		List<EmployerUpdate> employerUpdates = employerUpdateDao
				.findAllByEmployer_IdOrderByUpdatedAtDesc(id);

		if (employerUpdates.size() == 0)
			return new ErrorDataResult<>("User not found");

		return new SuccessDataResult<EmployerUpdate>(employerUpdates.get(0));
	}

	@Override
	public DataResult<List<EmployerUpdate>> getAllByIsApprovedAndIsDeleted(boolean isApproved, boolean isDeleted) {
		List<EmployerUpdate> employerUpdates = employerUpdateDao.findAllByIsApprovedAndIsDeleted(isApproved,
				isDeleted);

		return new SuccessDataResult<List<EmployerUpdate>>(employerUpdates);
	}

	@Override
	public Result register(EmployerForRegisterDto employerForRegister) {
		Result businessRulesResult = BusinessRules.run(
				userService.isNotEmailExist(employerForRegister.getEmail()),
				arePasswordMatch(employerForRegister.getPassword(), employerForRegister.getConfirmPassword()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		Employer employer = Employer.childBuilder()
			.email(employerForRegister.getEmail())
			.password(employerForRegister.getPassword())
			.companyName(employerForRegister.getCompanyName())
			.website(employerForRegister.getWebsite())
			.phone(employerForRegister.getPhone())
			.build();
		add(employer);

		emailActivationService.createAndSendActivationCodeByMail(employer, employer.getEmail());
		companyStaffVerificationService.add(CompanyStaffVerification.builder().user(employer).build());

		return new SuccessResult("Employer registered succesfully");
	}

	@Override
	public Result updateByUser(EmployerForUpdateDto employerForUpdateDto, MultipartFile companyImage) {
		Optional<Employer> employer = employerDao.findById(employerForUpdateDto.getEmployerId());
		if (employer.isEmpty())
			return new ErrorResult("User not found");

		Result businessRulesResult = BusinessRules
				.run(arePasswordMatch(employer.get().getPassword(), employerForUpdateDto.getPassword()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		final EmployerUpdate.EmployerUpdateBuilder employerUpdate = EmployerUpdate.builder()
				.employer(employer.get())
				.companyName(employerForUpdateDto.getCompanyName())
				.website(employerForUpdateDto.getWebsite())				
				.phone(employerForUpdateDto.getPhone());
		if (companyImage != null) {
			String companyImageUrl = imageService.save(companyImage).getData().getUrl();
			employerUpdate.companyImageUrl(companyImageUrl);
		}
		employerUpdateDao.save(employerUpdate.build());

		return new SuccessResult("Employer updated succesfully");
	}

	@Override
	public Result verifyUpdate(int employerUpdateId) {
		final Optional<EmployerUpdate> employerUpdate = employerUpdateDao.findById(employerUpdateId);
		if (employerUpdate.isEmpty())
			return new ErrorResult("User not found");

		final Employer employer = getById(employerUpdate.get().getEmployer().getId()).getData();
		employer.setCompanyName(employerUpdate.get().getCompanyName());
		if (employerUpdate.get().getCompanyImageUrl() != null) {
			if (employer.getCompanyImageUrl() != null) {
				String imagePublicId = CloudinaryImageHelper.getImagePublicIdFromUrl(employer.getCompanyImageUrl());
				imageService.delete(imagePublicId);
			}
			employer.setCompanyImageUrl(employerUpdate.get().getCompanyImageUrl());
		}
		employer.setWebsite(employerUpdate.get().getWebsite());
		employer.setPhone(employerUpdate.get().getPhone());
		update(employer);

		employerUpdate.get().setApproved(true);
		employerUpdate.get().setDeleted(true);
		employerUpdateDao.save(employerUpdate.get());

		return new SuccessResult("Employer update verified");
	}

	@Override
	public Result denyUpdate(int employerUpdateId) {
		final Optional<EmployerUpdate> employerUpdate = employerUpdateDao.findById(employerUpdateId);
		if (employerUpdate.isEmpty())
			return new ErrorResult("User not found");

		if (employerUpdate.get().getCompanyImageUrl() != null) {
			String imagePublicId = CloudinaryImageHelper
					.getImagePublicIdFromUrl(employerUpdate.get().getCompanyImageUrl());
			imageService.delete(imagePublicId);
		}
		employerUpdate.get().setApproved(false);
		employerUpdate.get().setDeleted(true);
		employerUpdateDao.save(employerUpdate.get());

		return new SuccessResult("Employer update denied");
	}	


}
