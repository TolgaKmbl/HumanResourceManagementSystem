package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVImage;

public interface JobSeekerCVImageService {
	
	Result add(JobSeekerCVImage jobSeekerCVImage);

	Result delete(int id);

	DataResult<List<JobSeekerCVImage>> getAll();

	DataResult<JobSeekerCVImage> getById(int id);

	Result update(JobSeekerCVImage jobSeekerCVImage);
	
	Result addAndSave(JobSeekerCVImage jobSeekerCVImage, MultipartFile file);

	DataResult<List<JobSeekerCVImage>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
