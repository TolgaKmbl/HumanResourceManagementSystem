package com.tolgakmbl.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tolgakmbl.hrms.business.abstracts.JobPositionService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
@CrossOrigin
public class JobPositionsController {
	
	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll(){
  	  return jobPositionService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<JobPosition> getById(@PathVariable int id){
  	  return jobPositionService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobPosition jobPosition){
  	  return jobPositionService.add(jobPosition);
    }
    @PutMapping("/update")
    public Result update(@RequestBody JobPosition jobPosition){
  	  return jobPositionService.update(jobPosition);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return jobPositionService.delete(id);
    }
}
