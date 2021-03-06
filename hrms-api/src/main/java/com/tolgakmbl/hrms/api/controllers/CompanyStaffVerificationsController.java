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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tolgakmbl.hrms.business.abstracts.CompanyStaffVerificationService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.CompanyStaffVerification;

@RestController
@RequestMapping("/api/companystaffverifications")
@CrossOrigin
public class CompanyStaffVerificationsController {

	private CompanyStaffVerificationService companyStaffVerificationService;

	@Autowired
	public CompanyStaffVerificationsController(CompanyStaffVerificationService companyStaffVerificationService) {
		super();
		this.companyStaffVerificationService = companyStaffVerificationService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<CompanyStaffVerification>> getAll(){
  	  return companyStaffVerificationService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<CompanyStaffVerification> getById(@PathVariable int id){
  	  return companyStaffVerificationService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody CompanyStaffVerification companyStaffVerification){
  	  return companyStaffVerificationService.add(companyStaffVerification);
    }
    @PutMapping("/update")
    public Result update(@RequestBody CompanyStaffVerification companyStaffVerification){
  	  return companyStaffVerificationService.update(companyStaffVerification);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return companyStaffVerificationService.delete(id);
    }
	@GetMapping("/verify")
	public Result verify(@RequestParam final int userId) {
		return companyStaffVerificationService.verify(userId);

	}
}
