	package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import com.tolgakmbl.hrms.business.adapters.mernisService.PersonForValidateFromMernisService;
import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.MernisActivation;

public interface MernisActivationService {

	Result add(MernisActivation mernisActivation);

	Result delete(MernisActivation mernisActivation);

	DataResult<List<MernisActivation>> getAll();

	DataResult<MernisActivation> getById(int id);

	Result update(MernisActivation mernisActivation);
	
	Result check(PersonForValidateFromMernisService personForValidateFromMernisService);
	
}
