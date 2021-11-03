package com.tolgakmbl.hrms.core.utilities.helpers.email;

import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.core.utilities.results.*;

@Service
public class EmailManager implements EmailService{

	@Override
	public Result send(String to, String title, String body) {
		return new SuccessResult("Email has send.");
	}

}
