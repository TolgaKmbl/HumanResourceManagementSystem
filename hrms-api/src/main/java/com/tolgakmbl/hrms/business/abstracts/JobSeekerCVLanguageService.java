package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVLanguage;

public interface JobSeekerCVLanguageService {

	Result add(JobSeekerCVLanguage jobSeekerCVLanguage);

	Result delete(int id);

	DataResult<List<JobSeekerCVLanguage>> getAll();

	DataResult<JobSeekerCVLanguage> getById(int id);

	Result update(JobSeekerCVLanguage jobSeekerCVLanguage);
	
	DataResult<List<JobSeekerCVLanguage>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
