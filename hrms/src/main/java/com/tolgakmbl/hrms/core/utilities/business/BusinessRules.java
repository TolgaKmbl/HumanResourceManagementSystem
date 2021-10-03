package com.tolgakmbl.hrms.core.utilities.business;

import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.core.utilities.results.SuccessResult;

public class BusinessRules {
	public static Result run(final Result... logics) {
		for (final Result logic : logics)
			if (!logic.isSuccess())
				return logic;
		return new SuccessResult();
	}
}
