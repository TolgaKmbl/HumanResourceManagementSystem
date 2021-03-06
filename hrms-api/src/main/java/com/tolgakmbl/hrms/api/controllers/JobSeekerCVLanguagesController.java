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

import com.tolgakmbl.hrms.business.abstracts.JobSeekerCVLanguageService;
import com.tolgakmbl.hrms.core.utilities.results.*;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVLanguage;

@RestController
@RequestMapping("/api/jobseekercvlanguages")
@CrossOrigin
public class JobSeekerCVLanguagesController {

	private JobSeekerCVLanguageService jobSeekerCVLanguageService;
	
	@Autowired
	public JobSeekerCVLanguagesController(JobSeekerCVLanguageService jobSeekerCVLanguageService) {
		super();
		this.jobSeekerCVLanguageService = jobSeekerCVLanguageService;
	}

	@GetMapping("/getall")
    public DataResult<List<JobSeekerCVLanguage>> getAll(){
  	  return jobSeekerCVLanguageService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<JobSeekerCVLanguage> getById(@PathVariable int id){
  	  return jobSeekerCVLanguageService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobSeekerCVLanguage jobSeekerCVLanguage){
  	  return jobSeekerCVLanguageService.add(jobSeekerCVLanguage);
    }
    @PutMapping("/update")
    public Result update(@RequestBody JobSeekerCVLanguage jobSeekerCVLanguage){
  	  return jobSeekerCVLanguageService.update(jobSeekerCVLanguage);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return jobSeekerCVLanguageService.delete(id);
    }
	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVLanguage>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVLanguage>> result = jobSeekerCVLanguageService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

}
