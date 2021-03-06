package com.tolgakmbl.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.JobSeekerCVEducationService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.core.utilities.results.SuccessDataResult;
import com.tolgakmbl.hrms.core.utilities.results.SuccessResult;
import com.tolgakmbl.hrms.dataAccess.abstracts.JobSeekerCVEducationDao;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVEducation;

@Service
public class JobSeekerCVEducationManager implements JobSeekerCVEducationService {

	private JobSeekerCVEducationDao jobSeekerCVEducationDao;
	
	@Autowired
	public JobSeekerCVEducationManager(JobSeekerCVEducationDao jobSeekerCVEducationDao) {
		super();
		this.jobSeekerCVEducationDao = jobSeekerCVEducationDao;
	}

	@Override
	public Result add(JobSeekerCVEducation jobSeekerCVEducation) {
		jobSeekerCVEducationDao.save(jobSeekerCVEducation);
		return new SuccessResult("Job Seeker CV Education added");
	}

	@Override
	public Result delete(int id) {
		jobSeekerCVEducationDao.deleteById(id);
		return new SuccessResult("Job Seeker CV Education deleted");
	}

	@Override
	public DataResult<List<JobSeekerCVEducation>> getAll() {
		return new SuccessDataResult<List<JobSeekerCVEducation>>(jobSeekerCVEducationDao.findAll(),"Job Seeker CV Educations listed");
	}

	@Override
	public DataResult<JobSeekerCVEducation> getById(int id) {
		return new SuccessDataResult<JobSeekerCVEducation>(jobSeekerCVEducationDao.findById(id).get());
	}

	@Override
	public Result update(JobSeekerCVEducation jobSeekerCVEducation) {
		jobSeekerCVEducationDao.save(jobSeekerCVEducation);
		return new SuccessResult("Job Seeker CV Education updated");
	}

	@Override
	public DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_Id(int jobSeekerCVId) {
		final List<JobSeekerCVEducation> jobSeekerCVEducations = jobSeekerCVEducationDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVEducations);
	}

	@Override
	public DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_IdOrderByGraduationDate(int jobSeekerCVId,
			Direction direction) {
		final List<JobSeekerCVEducation> jobSeekerCVEducations = direction.isAscending()
				? jobSeekerCVEducationDao.findAllByJobSeekerCV_IdOrderByGraduationDate(jobSeekerCVId)
				: jobSeekerCVEducationDao.findAllByJobSeekerCV_IdOrderByGraduationDateDesc(jobSeekerCVId);

		return new SuccessDataResult<>(jobSeekerCVEducations);
	}

}
