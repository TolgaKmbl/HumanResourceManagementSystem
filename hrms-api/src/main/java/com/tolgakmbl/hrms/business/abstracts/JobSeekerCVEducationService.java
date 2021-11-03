package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVEducation;

public interface JobSeekerCVEducationService {

	Result add(JobSeekerCVEducation jobSeekerCVEducation);

	Result delete(int id);

	DataResult<List<JobSeekerCVEducation>> getAll();

	DataResult<JobSeekerCVEducation> getById(int id);

	Result update(JobSeekerCVEducation jobSeekerCVEducation);
	
	DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

	DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_IdOrderByGraduationDate(int jobSeekerCVId,
			Direction direction);
}

