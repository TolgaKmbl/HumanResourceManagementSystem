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

import com.tolgakmbl.hrms.business.abstracts.JobSeekerCVExperienceService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVExperience;

@RestController
@RequestMapping("/api/jobseekercvexperiences")
@CrossOrigin
public class JobSeekerCVExperiencesController {
	
	private JobSeekerCVExperienceService jobSeekerCVExperienceService;

	@Autowired
	public JobSeekerCVExperiencesController(JobSeekerCVExperienceService jobSeekerCVExperienceService) {
		super();
		this.jobSeekerCVExperienceService = jobSeekerCVExperienceService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<JobSeekerCVExperience>> getAll(){
  	  return jobSeekerCVExperienceService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<JobSeekerCVExperience> getById(@PathVariable int id){
  	  return jobSeekerCVExperienceService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobSeekerCVExperience jobSeekerCVExperience){
  	  return jobSeekerCVExperienceService.add(jobSeekerCVExperience);
    }
    @PutMapping("/update")
    public Result update(@RequestBody JobSeekerCVExperience jobSeekerCVExperience){
  	  return jobSeekerCVExperienceService.update(jobSeekerCVExperience);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return jobSeekerCVExperienceService.delete(id);
    }
	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVExperience>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVExperience>> result = jobSeekerCVExperienceService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/byjobseekercvidorderbyquitdate")
	public ResponseEntity<DataResult<List<JobSeekerCVExperience>>> getAllByJobSeekerCV_IdOrderByQuitDate(
			@RequestParam final int jobSeekerCVId, @RequestParam final Direction direction) {
		final DataResult<List<JobSeekerCVExperience>> result = jobSeekerCVExperienceService
				.getAllByJobSeekerCV_IdOrderByQuitDate(jobSeekerCVId, direction);

		return ResponseEntity.ok(result);
	}

}
