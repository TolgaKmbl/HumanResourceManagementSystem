package com.tolgakmbl.hrms.core.utilities.helpers.email;

import com.tolgakmbl.hrms.core.utilities.results.Result;

public interface EmailService {
	Result send(String to, String title, String body);
}
