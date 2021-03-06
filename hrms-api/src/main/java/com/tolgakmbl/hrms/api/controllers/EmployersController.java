package com.tolgakmbl.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tolgakmbl.hrms.business.abstracts.EmployerService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.Employer;
import com.tolgakmbl.hrms.entities.concretes.EmployerUpdate;
import com.tolgakmbl.hrms.entities.dtos.EmployerForRegisterDto;
import com.tolgakmbl.hrms.entities.dtos.EmployerForUpdateDto;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
	
	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){
  	  return employerService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<Employer> getById(@PathVariable int id){
  	  return employerService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody Employer employer){
  	  return employerService.add(employer);
    }
    @PutMapping("/update")
    public Result update(@RequestBody Employer employer){
  	  return employerService.update(employer);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return employerService.delete(id);
    }

    @GetMapping("/update/byuserid/last")
	public DataResult<EmployerUpdate> getLastUpdateByUserId(@RequestParam final int employerId) {
		return employerService.getLastUpdateByUserId(employerId);
	}

	@GetMapping("/update/byisapprovedandisdeleted")
	public DataResult<List<EmployerUpdate>> getAllByIsApprovedAndIsDeleted(@RequestParam final boolean isApproved,@RequestParam final boolean isDeleted) {
		return employerService.getAllByIsApprovedAndIsDeleted(isApproved,isDeleted);
	}

	@PostMapping("/register")
	public Result register(@Valid @RequestBody final EmployerForRegisterDto employerForRegisterDto) {
		return employerService.register(employerForRegisterDto);
	}

	@PutMapping("/byuser")
	public Result updateByUser(@Valid @ModelAttribute EmployerForUpdateDto employerForUpdateDto, @RequestBody MultipartFile companyImage) {
		return employerService.updateByUser(employerForUpdateDto, companyImage);
	}

	@PutMapping("/verify/update")
	public Result verifyUpdate(@RequestParam final int employerUpdateId) {
		return employerService.verifyUpdate(employerUpdateId);
	}

	@PutMapping("/deny/update")
	public Result denyUpdate(@RequestParam final int employerUpdateId) {
		return employerService.denyUpdate(employerUpdateId);
	}
}
