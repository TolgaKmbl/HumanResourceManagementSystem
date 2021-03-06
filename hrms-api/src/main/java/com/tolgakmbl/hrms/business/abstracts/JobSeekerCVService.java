package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCV;

public interface JobSeekerCVService {

	Result add(JobSeekerCV jobSeekerCV);

	Result delete(int id);

	DataResult<List<JobSeekerCV>> getAll();

	DataResult<JobSeekerCV> getById(int id);

	Result update(JobSeekerCV jobSeekerCV);
	
	DataResult<JobSeekerCV> getByJobSeeker_Id(int jobSeekerId);
}
