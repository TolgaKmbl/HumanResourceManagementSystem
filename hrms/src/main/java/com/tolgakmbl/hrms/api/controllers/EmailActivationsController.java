package com.tolgakmbl.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tolgakmbl.hrms.business.abstracts.EmailActivationService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.EmailActivation;
import com.tolgakmbl.hrms.entities.dtos.EmailActivationForVerifyDto;

@RestController
@RequestMapping("/api/emailactivationscontroller")
@CrossOrigin
public class EmailActivationsController {
	
	private EmailActivationService emailActivationService;

	@Autowired
	public EmailActivationsController(EmailActivationService emailActivationService) {
		super();
		this.emailActivationService = emailActivationService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<EmailActivation>> getAll(){
  	  return emailActivationService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<EmailActivation> getById(@PathVariable int id){
  	  return emailActivationService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody EmailActivation emailActivation){
  	  return emailActivationService.add(emailActivation);
    }
    @PostMapping("/update")
    public Result update(@RequestBody EmailActivation emailActivation){
  	  return emailActivationService.update(emailActivation);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return emailActivationService.delete(id);
    }
	@GetMapping("/verify")
	public Result verify(@Valid final EmailActivationForVerifyDto emailActivationForVerifyDto) {
		return emailActivationService.verify(emailActivationForVerifyDto);
	}
}
