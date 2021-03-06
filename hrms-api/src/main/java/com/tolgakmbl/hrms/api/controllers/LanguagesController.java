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
import org.springframework.web.bind.annotation.RestController;

import com.tolgakmbl.hrms.business.abstracts.LanguageService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {
	
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<Language>> getAll(){
  	  return languageService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<Language> getById(@PathVariable String id){
  	  return languageService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody Language language){
  	  return languageService.add(language);
    }
    @PutMapping("/update")
    public Result update(@RequestBody Language language){
  	  return languageService.update(language);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable String id){
  	  return languageService.delete(id);
    }

}
