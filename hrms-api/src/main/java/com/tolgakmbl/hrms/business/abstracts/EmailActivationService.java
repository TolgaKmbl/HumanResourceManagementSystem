package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.EmailActivation;
import com.tolgakmbl.hrms.entities.concretes.User;
import com.tolgakmbl.hrms.entities.dtos.EmailActivationForVerifyDto;

public interface EmailActivationService {

	Result add(EmailActivation emailActivation);

	Result delete(int id);

	DataResult<List<EmailActivation>> getAll();

	DataResult<EmailActivation> getById(int id);

	Result update(EmailActivation emailActivation);
	
	Result createAndSendActivationCodeByMail(User user, String... emails);

	Result verify(EmailActivationForVerifyDto emailActivationForVerifyDto);
}
