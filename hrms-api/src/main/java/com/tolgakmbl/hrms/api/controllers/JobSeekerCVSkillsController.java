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

import com.tolgakmbl.hrms.business.abstracts.JobSeekerCVSkillService;
import com.tolgakmbl.hrms.core.utilities.results.*;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVSkill;

@RestController
@RequestMapping("/api/jobseekercvskills")
@CrossOrigin
public class JobSeekerCVSkillsController {

	private JobSeekerCVSkillService jobSeekerCVSkillService;

	@Autowired
	public JobSeekerCVSkillsController(JobSeekerCVSkillService jobSeekerCVSkillService) {
		super();
		this.jobSeekerCVSkillService = jobSeekerCVSkillService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<JobSeekerCVSkill>> getAll(){
  	  return jobSeekerCVSkillService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<JobSeekerCVSkill> getById(@PathVariable int id){
  	  return jobSeekerCVSkillService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobSeekerCVSkill jobSeekerCVSkill){
  	  return jobSeekerCVSkillService.add(jobSeekerCVSkill);
    }
    @PutMapping("/update")
    public Result update(@RequestBody JobSeekerCVSkill jobSeekerCVSkill){
  	  return jobSeekerCVSkillService.update(jobSeekerCVSkill);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return jobSeekerCVSkillService.delete(id);
    }
	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVSkill>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVSkill>> result = jobSeekerCVSkillService.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}
}
