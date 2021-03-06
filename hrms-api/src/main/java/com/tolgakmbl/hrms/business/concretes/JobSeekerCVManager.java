package com.tolgakmbl.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.JobSeekerCVService;
import com.tolgakmbl.hrms.core.utilities.results.*;
import com.tolgakmbl.hrms.dataAccess.abstracts.JobSeekerCVDao;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCV;

@Service
public class JobSeekerCVManager implements JobSeekerCVService {

	private JobSeekerCVDao jobSeekerCVDao;
	
	@Autowired
	public JobSeekerCVManager(JobSeekerCVDao jobSeekerCVDao) {
		super();
		this.jobSeekerCVDao = jobSeekerCVDao;
	}

	@Override
	public Result add(JobSeekerCV jobSeekerCV) {
		jobSeekerCVDao.save(jobSeekerCV);
		return new SuccessResult("Job Seeker CV added");
	}

	@Override
	public Result delete(int id) {
		jobSeekerCVDao.deleteById(id);
		return new SuccessResult("Job Seeker CV deleted");
	}

	@Override
	public DataResult<List<JobSeekerCV>> getAll() {
		return new SuccessDataResult<List<JobSeekerCV>>(jobSeekerCVDao.findAll(),"Job Seeker CVs listed");
	}

	@Override
	public DataResult<JobSeekerCV> getById(int id) {
		return new SuccessDataResult<JobSeekerCV>(jobSeekerCVDao.findById(id).get());
	}

	@Override
	public Result update(JobSeekerCV jobSeekerCV) {
		jobSeekerCVDao.save(jobSeekerCV);
		return new SuccessResult("Job Seeker CV updated");
	}

	@Override
	public DataResult<JobSeekerCV> getByJobSeeker_Id(int jobSeekerId) {
		final Optional<JobSeekerCV> jobSeekerCV = jobSeekerCVDao.findByJobSeeker_Id(jobSeekerId);

		if (jobSeekerCV.isEmpty())
			return new ErrorDataResult<>("Job seeker has not found");

		return new SuccessDataResult<>(jobSeekerCV.get());
	}

}
