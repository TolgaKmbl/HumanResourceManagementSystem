package com.tolgakmbl.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.WebSiteService;
import com.tolgakmbl.hrms.core.utilities.results.*;
import com.tolgakmbl.hrms.dataAccess.abstracts.WebSiteDao;
import com.tolgakmbl.hrms.entities.concretes.WebSite;

@Service
public class WebSiteManager implements WebSiteService{
	
	private WebSiteDao webSiteDao;

	@Autowired
	public WebSiteManager(WebSiteDao webSiteDao) {
		super();
		this.webSiteDao = webSiteDao;
	}

	@Override
	public Result add(WebSite webSite) {
		webSiteDao.save(webSite);
		return new SuccessResult("WebSite added");
	}

	@Override
	public Result delete(int id) {
		webSiteDao.deleteById(id);
		return new SuccessResult("WebSite deleted");
	}

	@Override
	public DataResult<List<WebSite>> getAll() {
		return new SuccessDataResult<List<WebSite>>(webSiteDao.findAll(),"WebSites listed");
	}

	@Override
	public DataResult<WebSite> getById(int id) {
		return new SuccessDataResult<WebSite>(webSiteDao.findById(id).get());
	}

	@Override
	public Result update(WebSite webSite) {
		webSiteDao.save(webSite);
		return new SuccessResult("WebSite updated");
	}

	@Override
	public DataResult<WebSite> getByName(String name) {
		final Optional<WebSite> webSite = webSiteDao.findByName(name);

		if (webSite.isEmpty())
			return new ErrorDataResult<>("A user with this mail has not found");

		return new SuccessDataResult<>(webSite.get());
	}

}
