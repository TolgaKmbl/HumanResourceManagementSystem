package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.WorkingTime;

public interface WorkingTimeService {

	Result add(WorkingTime workingTime);

	Result delete(int id);

	DataResult<List<WorkingTime>> getAll();

	DataResult<WorkingTime> getById(int id);

	Result update(WorkingTime workingTime);
}
