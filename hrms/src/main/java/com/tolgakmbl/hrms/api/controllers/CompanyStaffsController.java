package com.tolgakmbl.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.tolgakmbl.hrms.business.abstracts.CompanyStaffService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.CompanyStaff;
import com.tolgakmbl.hrms.entities.dtos.CompanyStaffForUpdateDto;

@RestController
@RequestMapping("/api/companystaffs")
@CrossOrigin
public class CompanyStaffsController {

	private CompanyStaffService companyStaffService;

	@Autowired
	public CompanyStaffsController(CompanyStaffService companyStaffService) {
		super();
		this.companyStaffService = companyStaffService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<CompanyStaff>> getAll(){
  	  return companyStaffService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<CompanyStaff> getById(@PathVariable int id){
  	  return companyStaffService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody CompanyStaff companyStaff){
  	  return companyStaffService.add(companyStaff);
    }
    @PutMapping("/update")
    public Result update(@RequestBody CompanyStaff companyStaff){
  	  return companyStaffService.update(companyStaff);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return companyStaffService.delete(id);
    }
    @PutMapping("/updatebyuser")
	public Result updateByUser(@Valid @RequestBody final CompanyStaffForUpdateDto employerForUpdateDto) {
		return companyStaffService.updateByUser(employerForUpdateDto);
	}
    
}
