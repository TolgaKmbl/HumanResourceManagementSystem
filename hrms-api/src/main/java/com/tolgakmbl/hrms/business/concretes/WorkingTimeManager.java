package com.tolgakmbl.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.WorkingTimeService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.core.utilities.results.SuccessDataResult;
import com.tolgakmbl.hrms.core.utilities.results.SuccessResult;
import com.tolgakmbl.hrms.dataAccess.abstracts.WorkingTimeDao;
import com.tolgakmbl.hrms.entities.concretes.WorkingTime;

@Service
public class WorkingTimeManager implements WorkingTimeService{
	
	private WorkingTimeDao workingTimeDao;

	@Autowired
	public WorkingTimeManager(WorkingTimeDao workingTimeDao) {
		super();
		this.workingTimeDao = workingTimeDao;
	}

	@Override
	public Result add(WorkingTime workingTime) {
		workingTimeDao.save(workingTime);
		return new SuccessResult("Working Time added");
	}

	@Override
	public Result delete(int id) {
		workingTimeDao.deleteById(id);
		return new SuccessResult("Working Time deleted");
	}

	@Override
	public DataResult<List<WorkingTime>> getAll() {
		return new SuccessDataResult<List<WorkingTime>>(workingTimeDao.findAll(),"Working Times listed");
	}

	@Override
	public DataResult<WorkingTime> getById(int id) {
		return new SuccessDataResult<WorkingTime>(workingTimeDao.findById(id).get());
	}

	@Override
	public Result update(WorkingTime workingTime) {
		workingTimeDao.save(workingTime);
		return new SuccessResult("Working Time updated");
	}

}
