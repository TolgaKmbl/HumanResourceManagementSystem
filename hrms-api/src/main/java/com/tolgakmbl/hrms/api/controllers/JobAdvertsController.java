package com.tolgakmbl.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
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

import com.tolgakmbl.hrms.business.abstracts.JobAdvertService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.JobAdvert;
import com.tolgakmbl.hrms.entities.dtos.JobAdvertForListDto;

@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdvertsController {
	
	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<JobAdvert>> getAll(){
  	  return jobAdvertService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<JobAdvert> getById(@PathVariable int id){
  	  return jobAdvertService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobAdvert jobAdvert){
  	  return jobAdvertService.add(jobAdvert);
    }
    @PutMapping("/update")
    public Result update(@RequestBody JobAdvert jobAdvert){
  	  return jobAdvertService.update(jobAdvert);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return jobAdvertService.delete(id);
    }
    @GetMapping({ "/byisactive" })
	public ResponseEntity<DataResult<Page<JobAdvert>>> getAllByIsActive(
			@RequestParam(defaultValue = "true") final boolean isActive, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "createdAt") String[] sortProperties,
			@RequestParam(defaultValue = "DESC") Sort.Direction sortDirection) {
		DataResult<Page<JobAdvert>> result = this.jobAdvertService
				.getAllByIsActive(isActive, page, size, sortProperties, sortDirection);

		return ResponseEntity.ok(result);
	}

	@GetMapping({ "/forlist/byisactiveandemployercompanyname" })
	public ResponseEntity<DataResult<Page<JobAdvertForListDto>>> getAllByIsActiveAndEmployer_CompanyNameForList(
			@RequestParam(defaultValue = "true") final boolean isActive, @RequestParam final String companyName,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "createdAt") String[] sortProperties,
			@RequestParam(defaultValue = "DESC") Sort.Direction sortDirection) {
		DataResult<Page<JobAdvertForListDto>> result = this.jobAdvertService
				.getAllByIsActiveAndEmployer_CompanyNameForList(isActive,
						companyName,
						page,
						size,
						sortProperties,
						sortDirection);

		return ResponseEntity.ok(result);
	}

	@GetMapping({ "/forlist/byisactive" })
	public ResponseEntity<DataResult<Page<JobAdvertForListDto>>> getAllByIsActiveForList(
			@RequestParam(defaultValue = "true") final boolean isActive, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "createdAt") String[] sortProperties,
			@RequestParam(defaultValue = "DESC") Sort.Direction sortDirection) {
		DataResult<Page<JobAdvertForListDto>> result = this.jobAdvertService
				.getAllByIsActiveForList(isActive, page, size, sortProperties, sortDirection);

		return ResponseEntity.ok(result);
	}

	@GetMapping({ "/forlist/byisactiveandcityandworkingtime" })
	public ResponseEntity<DataResult<Page<JobAdvertForListDto>>> getAllByIsActiveAndCityAndWorkingTimeForList(
			@RequestParam(defaultValue = "true") final boolean isActive, @RequestParam final short cityId,
			@RequestParam final short workingTimeId, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "createdAt") String[] sortProperties,
			@RequestParam(defaultValue = "DESC") Sort.Direction sortDirection) {
		DataResult<Page<JobAdvertForListDto>> result = this.jobAdvertService
				.getAllByIsActiveAndCityAndWorkingTimeForList(isActive,
						cityId,
						workingTimeId,
						page,
						size,
						sortProperties,
						sortDirection);

		return ResponseEntity.ok(result);
	}

	@PutMapping({ "/verify/byid" })
	public ResponseEntity<Result> verifyById(final int id) {
		Result result = this.jobAdvertService.verifyById(id);

		if (!result.isSuccess())
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);

		return ResponseEntity.ok(result);
	}

}
