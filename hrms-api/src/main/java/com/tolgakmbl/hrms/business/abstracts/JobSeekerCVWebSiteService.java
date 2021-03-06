package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVWebSite;

public interface JobSeekerCVWebSiteService {

	Result add(JobSeekerCVWebSite jobSeekerCVWebSite);

	Result delete(int id);

	DataResult<List<JobSeekerCVWebSite>> getAll();

	DataResult<JobSeekerCVWebSite> getById(int id);

	Result update(JobSeekerCVWebSite jobSeekerCVWebSite);
	
	DataResult<List<JobSeekerCVWebSite>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
