package com.tolgakmbl.hrms.business.abstracts;

import java.util.List;

import com.tolgakmbl.hrms.core.utilities.results.DataResult;
import com.tolgakmbl.hrms.core.utilities.results.Result;
import com.tolgakmbl.hrms.entities.concretes.User;

public interface UserService {

	Result add(User user);

	Result delete(User user);

	DataResult<List<User>> getAll();

	DataResult<User> getById(int id);

	Result update(User user);
	
	DataResult<User> getByEmail(String email);

	Result isNotEmailExist(final String email);
}
