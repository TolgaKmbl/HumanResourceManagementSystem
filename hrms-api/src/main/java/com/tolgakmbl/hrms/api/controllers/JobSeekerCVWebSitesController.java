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

import com.tolgakmbl.hrms.business.abstracts.JobSeekerCVWebSiteService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobSeekerCVWebSite;

@RestController
@RequestMapping("/api/jobseekercvwebsites")
@CrossOrigin
public class JobSeekerCVWebSitesController {
	
	private JobSeekerCVWebSiteService jobSeekerCVWebSiteService;

	@Autowired
	public JobSeekerCVWebSitesController(JobSeekerCVWebSiteService jobSeekerCVWebSiteService) {
		super();
		this.jobSeekerCVWebSiteService = jobSeekerCVWebSiteService;
	}

	@GetMapping("/getall")
    public DataResult<List<JobSeekerCVWebSite>> getAll(){
  	  return jobSeekerCVWebSiteService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<JobSeekerCVWebSite> getById(@PathVariable int id){
  	  return jobSeekerCVWebSiteService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobSeekerCVWebSite jobSeekerCVWebSite){
  	  return jobSeekerCVWebSiteService.add(jobSeekerCVWebSite);
    }
    @PutMapping("/update")
    public Result update(@RequestBody JobSeekerCVWebSite jobSeekerCVWebSite){
  	  return jobSeekerCVWebSiteService.update(jobSeekerCVWebSite);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return jobSeekerCVWebSiteService.delete(id);
    }
	@GetMapping("/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVWebSite>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVWebSite>> result = jobSeekerCVWebSiteService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}
}
