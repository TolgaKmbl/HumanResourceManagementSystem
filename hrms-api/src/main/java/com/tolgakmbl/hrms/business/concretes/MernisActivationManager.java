package com.tolgakmbl.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.MernisActivationService;
import com.tolgakmbl.hrms.business.adapters.mernisService.PersonForValidateFromMernisService;
import com.tolgakmbl.hrms.core.utilities.results.*;
import com.tolgakmbl.hrms.entities.concretes.MernisActivation;

@Service
public class MernisActivationManager implements MernisActivationService{

	@Override
	public Result add(MernisActivation mernisActivation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(MernisActivation mernisActivation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<MernisActivation>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<MernisActivation> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(MernisActivation mernisActivation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result check(PersonForValidateFromMernisService personForValidateFromMernisService) {
		return new SuccessResult("Mernis activation has succeeded");
	}

}
