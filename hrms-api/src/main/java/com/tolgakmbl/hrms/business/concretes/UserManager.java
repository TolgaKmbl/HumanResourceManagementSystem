package com.tolgakmbl.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.UserService;
import com.tolgakmbl.hrms.core.utilities.results.*;
import com.tolgakmbl.hrms.dataAccess.abstracts.UserDao;
import com.tolgakmbl.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<User> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		final Optional<User> user = userDao.findByEmail(email);

		if (user.isEmpty())
			return new ErrorDataResult<>("User with this mail has not found");

		return new SuccessDataResult<>(user.get());
	}

	@Override
	public Result isNotEmailExist(String email) {
		return userDao.findByEmail(email).isEmpty() ? new SuccessResult()
				: new ErrorResult("The mail does not exist");
	}

}
