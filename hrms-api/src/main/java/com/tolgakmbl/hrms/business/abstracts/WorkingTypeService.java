package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.WorkingType;

public interface WorkingTypeService {

	Result add(WorkingType workingType);

	Result delete(int id);

	DataResult<List<WorkingType>> getAll();

	DataResult<WorkingType> getById(int id);

	Result update(WorkingType workingType);
}
