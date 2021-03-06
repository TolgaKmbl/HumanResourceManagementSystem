package com.tolgakmbl.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.WorkingTypeService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.core.utilities.results.SuccessDataResult;
import com.tolgakmbl.hrms.core.utilities.results.SuccessResult;
import com.tolgakmbl.hrms.dataAccess.abstracts.WorkingTypeDao;
import com.tolgakmbl.hrms.entities.concretes.WorkingType;

@Service
public class WorkingTypeManager implements WorkingTypeService{
	
	private WorkingTypeDao workingTypeDao;

	@Autowired
	public WorkingTypeManager(WorkingTypeDao workingTypeDao) {
		super();
		this.workingTypeDao = workingTypeDao;
	}

	@Override
	public Result add(WorkingType workingType) {
		workingTypeDao.save(workingType);
		return new SuccessResult("Working Type added");
	}

	@Override
	public Result delete(int id) {
		workingTypeDao.deleteById(id);
		return new SuccessResult("Working Type deleted");
	}

	@Override
	public DataResult<List<WorkingType>> getAll() {
		return new SuccessDataResult<List<WorkingType>>(workingTypeDao.findAll(),"Working Types listed");
	}

	@Override
	public DataResult<WorkingType> getById(int id) {
		return new SuccessDataResult<WorkingType>(workingTypeDao.findById(id).get());
	}

	@Override
	public Result update(WorkingType workingType) {
		workingTypeDao.save(workingType);
		return new SuccessResult("Working Type updated");
	}

}
