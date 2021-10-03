package com.tolgakmbl.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.JobSeekerCVExperienceService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.core.utilities.results.SuccessDataResult;
import com.tolgakmbl.hrms.core.utilities.results.SuccessResult;
import com.tolgakmbl.hrms.dataAccess.abstracts.JobSeekerCVExperienceDao;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVExperience;

@Service
public class JobSeekerCVExperienceManager implements JobSeekerCVExperienceService{

	private JobSeekerCVExperienceDao jobSeekerCVExperienceDao;
	
	@Autowired
	public JobSeekerCVExperienceManager(JobSeekerCVExperienceDao jobSeekerCVExperienceDao) {
		super();
		this.jobSeekerCVExperienceDao = jobSeekerCVExperienceDao;
	}

	@Override
	public Result add(JobSeekerCVExperience jobSeekerCVExperience) {
		jobSeekerCVExperienceDao.save(jobSeekerCVExperience);
		return new SuccessResult("Job Seeker CV Experience added");
	}

	@Override
	public Result delete(int id) {
		jobSeekerCVExperienceDao.deleteById(id);
		return new SuccessResult("Job Seeker CV Experience deleted");
	}

	@Override
	public DataResult<List<JobSeekerCVExperience>> getAll() {
		return new SuccessDataResult<List<JobSeekerCVExperience>>(jobSeekerCVExperienceDao.findAll(),"Job Seeker CV Experiences listed");
	}

	@Override
	public DataResult<JobSeekerCVExperience> getById(int id) {
		return new SuccessDataResult<JobSeekerCVExperience>(jobSeekerCVExperienceDao.findById(id).get());
	}

	@Override
	public Result update(JobSeekerCVExperience jobSeekerCVExperience) {
		jobSeekerCVExperienceDao.save(jobSeekerCVExperience);
		return new SuccessResult("Job Seeker CV Experience updated");
	}

	@Override
	public DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_Id(int jobSeekerCVId) {
		final List<JobSeekerCVExperience> jobSeekerCVExperiences = jobSeekerCVExperienceDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVExperiences);
	}

	@Override
	public DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_IdOrderByQuitDate(int jobSeekerCVId,
			Direction direction) {
		final List<JobSeekerCVExperience> jobSeekerEducations = direction.isAscending()
				? jobSeekerCVExperienceDao.findAllByJobSeekerCV_IdOrderByQuitDate(jobSeekerCVId)
				: jobSeekerCVExperienceDao.findAllByJobSeekerCV_IdOrderByQuitDateDesc(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerEducations);
	}

}
