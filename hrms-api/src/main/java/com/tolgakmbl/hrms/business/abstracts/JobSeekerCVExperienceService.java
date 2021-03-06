package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVExperience;

public interface JobSeekerCVExperienceService {
	
	Result add(JobSeekerCVExperience jobSeekerCVExperience);

	Result delete(int id);

	DataResult<List<JobSeekerCVExperience>> getAll();

	DataResult<JobSeekerCVExperience> getById(int id);

	Result update(JobSeekerCVExperience jobSeekerCVExperience);
	
	DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

	DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_IdOrderByQuitDate(int jobSeekerCVId,
			Direction direction);
}
