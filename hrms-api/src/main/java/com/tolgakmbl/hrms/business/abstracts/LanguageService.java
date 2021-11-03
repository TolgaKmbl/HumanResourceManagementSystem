package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.Language;

public interface LanguageService {

	Result add(Language language);

	Result delete(String id);

	DataResult<List<Language>> getAll();

	DataResult<Language> getById(String id);

	Result update(Language language);
}
