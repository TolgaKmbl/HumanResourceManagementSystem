package com.tolgakmbl.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.JobPositionService;
import com.tolgakmbl.hrms.core.utilities.business.BusinessRules;
import com.tolgakmbl.hrms.core.utilities.results.*;
import com.tolgakmbl.hrms.dataAccess.abstracts.JobPositionDao;
import com.tolgakmbl.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public Result isNotExistsJobPosition(String title) {
		return jobPositionDao.findByTitle(title).isEmpty() ? new SuccessResult() : new ErrorResult("Job position does not exist");
	}
	
	@Override
	public Result add(JobPosition jobPosition) {
		final Result businessRulesResult = BusinessRules.run(isNotExistsJobPosition(jobPosition.getTitle()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;
		jobPositionDao.save(jobPosition);
		return new SuccessResult("Job Position added");
	}

	@Override
	public Result delete(int id) {
		jobPositionDao.deleteById(id);
		return new SuccessResult("Job Position deleted");
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(),"Job Positions listed");
	}

	@Override
	public DataResult<JobPosition> getById(int id) {
		return new SuccessDataResult<JobPosition>(jobPositionDao.findById(id).get());
	}

	@Override
	public Result update(JobPosition jobPosition) {
		jobPositionDao.save(jobPosition);
		return new SuccessResult("Job Position updated");
	}

}
