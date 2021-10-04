package com.tolgakmbl.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tolgakmbl.hrms.business.abstracts.JobSeekerCVEducationService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVEducation;

@RestController
@RequestMapping("/api/jobseekercveducations")
@CrossOrigin
public class JobSeekerCVEducationsController {
	
	private JobSeekerCVEducationService jobSeekerCVEducationService;

	@Autowired
	public JobSeekerCVEducationsController(JobSeekerCVEducationService jobSeekerCVEducationService) {
		super();
		this.jobSeekerCVEducationService = jobSeekerCVEducationService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<JobSeekerCVEducation>> getAll(){
  	  return jobSeekerCVEducationService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<JobSeekerCVEducation> getById(@PathVariable int id){
  	  return jobSeekerCVEducationService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobSeekerCVEducation jobSeekerCVEducation){
  	  return jobSeekerCVEducationService.add(jobSeekerCVEducation);
    }
    @PutMapping("/update")
    public Result update(@RequestBody JobSeekerCVEducation jobSeekerCVEducation){
  	  return jobSeekerCVEducationService.update(jobSeekerCVEducation);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return jobSeekerCVEducationService.delete(id);
    }
	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVEducation>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVEducation>> result = jobSeekerCVEducationService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/byjobseekercvidorderbygraduationdate")
	public ResponseEntity<DataResult<List<JobSeekerCVEducation>>> getAllByJobSeekerCV_IdOrderByGraduationDate(
			@RequestParam final int jobSeekerCVId, @RequestParam final Direction direction) {
		final DataResult<List<JobSeekerCVEducation>> result = jobSeekerCVEducationService
				.getAllByJobSeekerCV_IdOrderByGraduationDate(jobSeekerCVId, direction);

		return ResponseEntity.ok(result);
	}

}
