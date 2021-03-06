package com.tolgakmbl.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.tolgakmbl.hrms.business.abstracts.JobSeekerService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobSeeker;
import com.tolgakmbl.hrms.entities.concretes.JobSeekersFavoriteJobAdvert;
import com.tolgakmbl.hrms.entities.dtos.JobSeekerForRegisterDto;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobSeekersController {
	
	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll(){
  	  return jobSeekerService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<JobSeeker> getById(@PathVariable int id){
  	  return jobSeekerService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobSeeker jobSeeker){
  	  return jobSeekerService.add(jobSeeker);
    }
    @PutMapping("/update")
    public Result update(@RequestBody JobSeeker jobSeeker){
  	  return jobSeekerService.update(jobSeeker);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return jobSeekerService.delete(id);
    }
    @PostMapping("/register")
	public ResponseEntity<Result> register(@Valid @RequestBody final JobSeekerForRegisterDto jobSeekerForRegisterDto) {
		final Result result = jobSeekerService.register(jobSeekerForRegisterDto);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@GetMapping({ "/favorite/jobadvert/byjobseekeridandjobadvertid" })
	public ResponseEntity<DataResult<JobSeekersFavoriteJobAdvert>> getByJobSeekerIdAndJobAdvertId(
			@RequestParam final int jobSeekerId, @RequestParam final int jobAdvertId) {
		DataResult<JobSeekersFavoriteJobAdvert> result = this.jobSeekerService
				.getFavoriteByJobSeekerIdAndJobAdvertId(jobSeekerId, jobAdvertId);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@PostMapping({ "/favorite/jobadvert" })
	public ResponseEntity<Result> favoriteJobAdvert(
			@RequestBody final JobSeekersFavoriteJobAdvert jobSeekersFavoriteJobAdvert) {
		Result result = this.jobSeekerService.favoriteJobAdvert(jobSeekersFavoriteJobAdvert);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping({ "/favorite/jobadvert" })
	public ResponseEntity<Result> undoFavoriteJobAdvert(@RequestParam final int jobSeekersFavoriteJobAdvertId) {
		Result result = this.jobSeekerService.undoFavoriteJobAdvert(jobSeekersFavoriteJobAdvertId);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}
}
