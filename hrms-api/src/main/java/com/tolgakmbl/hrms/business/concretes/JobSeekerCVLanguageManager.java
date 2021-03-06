package com.tolgakmbl.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.JobSeekerCVLanguageService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.core.utilities.results.SuccessDataResult;
import com.tolgakmbl.hrms.core.utilities.results.SuccessResult;
import com.tolgakmbl.hrms.dataAccess.abstracts.JobSeekerCVLanguageDao;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVLanguage;

@Service
public class JobSeekerCVLanguageManager implements JobSeekerCVLanguageService{
	
	private JobSeekerCVLanguageDao jobSeekerCVLanguageDao;

	@Autowired
	public JobSeekerCVLanguageManager(JobSeekerCVLanguageDao jobSeekerCVLanguageDao) {
		super();
		this.jobSeekerCVLanguageDao = jobSeekerCVLanguageDao;
	}

	@Override
	public Result add(JobSeekerCVLanguage jobSeekerCVLanguage) {
		jobSeekerCVLanguageDao.save(jobSeekerCVLanguage);
		return new SuccessResult("Job Seeker CV Language added");
	}

	@Override
	public Result delete(int id) {
		jobSeekerCVLanguageDao.deleteById(id);
		return new SuccessResult("Job Seeker CV Language deleted");
	}

	@Override
	public DataResult<List<JobSeekerCVLanguage>> getAll() {
		return new SuccessDataResult<List<JobSeekerCVLanguage>>(jobSeekerCVLanguageDao.findAll(),"Job Seeker CV Languages listed");
	}

	@Override
	public DataResult<JobSeekerCVLanguage> getById(int id) {
		return new SuccessDataResult<JobSeekerCVLanguage>(jobSeekerCVLanguageDao.findById(id).get());
	}

	@Override
	public Result update(JobSeekerCVLanguage jobSeekerCVLanguage) {
		jobSeekerCVLanguageDao.save(jobSeekerCVLanguage);
		return new SuccessResult("Job Seeker CV Language updated");
	}

	@Override
	public DataResult<List<JobSeekerCVLanguage>> getAllByJobSeekerCV_Id(int jobSeekerCVId) {
		final List<JobSeekerCVLanguage> jobSeekerCVLanguages = jobSeekerCVLanguageDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVLanguages);
	}

}
