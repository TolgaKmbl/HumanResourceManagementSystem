package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	Result add(JobPosition jobPosition);

	Result delete(int id);

	DataResult<List<JobPosition>> getAll();

	DataResult<JobPosition> getById(int id);

	Result update(JobPosition jobPosition);
	
	Result isNotExistsJobPosition(final String title);
}
