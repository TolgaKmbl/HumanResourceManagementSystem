package com.tolgakmbl.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tolgakmbl.hrms.business.abstracts.JobSeekerCVImageService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVImage;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCV;

@RestController
@RequestMapping("/api/jobseekercvimages")
@CrossOrigin
public class JobSeekerCVImagesController {
	
	private JobSeekerCVImageService jobSeekerCVImageService;

	@Autowired
	public JobSeekerCVImagesController(JobSeekerCVImageService jobSeekerCVImageService) {
		super();
		this.jobSeekerCVImageService = jobSeekerCVImageService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<JobSeekerCVImage>> getAll(){
  	  return jobSeekerCVImageService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<JobSeekerCVImage> getById(@PathVariable int id){
  	  return jobSeekerCVImageService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobSeekerCVImage jobSeekerCVImage){
  	  return jobSeekerCVImageService.add(jobSeekerCVImage);
    }
    @PostMapping("/update")
    public Result update(@RequestBody JobSeekerCVImage jobSeekerCVImage){
  	  return jobSeekerCVImageService.update(jobSeekerCVImage);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return jobSeekerCVImageService.delete(id);
    }
	@PostMapping("/addandsave")
	public ResponseEntity<Result> addAndSave(@RequestParam final int jobSeekerCVId,
			@RequestBody final MultipartFile file) {
		final Result result = jobSeekerCVImageService.addAndSave(
				JobSeekerCVImage.builder().jobSeekerCV(JobSeekerCV.builder().id(jobSeekerCVId).build()).build(),
				file);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVImage>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVImage>> result = jobSeekerCVImageService.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

}
