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

import com.tolgakmbl.hrms.business.abstracts.WebSiteService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.WebSite;

@RestController
@RequestMapping("/api/websites")
@CrossOrigin
public class WebSitesController {
	
	private WebSiteService webSiteService;

	@Autowired
	public WebSitesController(WebSiteService webSiteService) {
		super();
		this.webSiteService = webSiteService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<WebSite>> getAll(){
  	  return webSiteService.getAll();
    }
	
	@GetMapping("/getbyid/{id}")
    public DataResult<WebSite> getById(@PathVariable int id){
  	  return webSiteService.getById(id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody WebSite webSite){
  	  return webSiteService.add(webSite);
    }
    @PutMapping("/update")
    public Result update(@RequestBody WebSite webSite){
  	  return webSiteService.update(webSite);
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id){
  	  return webSiteService.delete(id);
    }


}
