package com.tolgakmbl.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.LanguageService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.core.utilities.results.SuccessDataResult;
import com.tolgakmbl.hrms.core.utilities.results.SuccessResult;
import com.tolgakmbl.hrms.dataAccess.abstracts.LanguageDao;
import com.tolgakmbl.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		languageDao.save(language);
		return new SuccessResult("Language added");
	}

	@Override
	public Result delete(String id) {
		languageDao.deleteById(id);
		return new SuccessResult("Language deleted");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(languageDao.findAll(),"Languages listed");
	}

	@Override
	public DataResult<Language> getById(String id) {
		return new SuccessDataResult<Language>(languageDao.findById(id).get());
	}

	@Override
	public Result update(Language language) {
		languageDao.save(language);
		return new SuccessResult("Language updated");
	}

}
