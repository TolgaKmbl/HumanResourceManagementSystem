package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVSkill;

public interface JobSeekerCVSkillService {

	Result add(JobSeekerCVSkill jobSeekerCVSkill);

	Result delete(int id);

	DataResult<List<JobSeekerCVSkill>> getAll();

	DataResult<JobSeekerCVSkill> getById(int id);

	Result update(JobSeekerCVSkill jobSeekerCVSkill);
	
	DataResult<List<JobSeekerCVSkill>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
