package com.tolgakmbl.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tolgakmbl.hrms.business.abstracts.JobSeekerCVService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCV;

@RestController
@RequestMapping("/api/jobseekercvs")
@CrossOrigin
public class JobSeekerCVsController {
	
	private JobSeekerCVService jobSeekerCVService;
	
	@Autowired
	public JobSeekerCVsController(JobSeekerCVService jobSeekerCVService) {
		super();
		this.jobSeekerCVService = jobSeekerCVService;
	}

	@GetMapping("/getall")
    public DataResult<List<JobSeekerCV>> getAll(){
  	  return jobSeekerCVService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<JobSeekerCV> getById(@PathVariable int id){
  	  return jobSeekerCVService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobSeekerCV jobSeekerCV){
  	  return jobSeekerCVService.add(jobSeekerCV);
    }
    @PutMapping("/update")
    public Result update(@RequestBody JobSeekerCV jobSeekerCV){
  	  return jobSeekerCVService.update(jobSeekerCV);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return jobSeekerCVService.delete(id);
    }
	@GetMapping("/byjobseekerid")
	public ResponseEntity<DataResult<JobSeekerCV>> getByJobSeeker_Id(final int jobSeekerId) {
		final DataResult<JobSeekerCV> result = jobSeekerCVService.getByJobSeeker_Id(jobSeekerId);

		return ResponseEntity.ok(result);
	}
}
