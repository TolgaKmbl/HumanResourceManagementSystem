package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.WebSite;

public interface WebSiteService {

	Result add(WebSite webSite);

	Result delete(int id);

	DataResult<List<WebSite>> getAll();

	DataResult<WebSite> getById(int id);

	Result update(WebSite webSite);
	
	DataResult<WebSite> getByName(String name);
	
}
