package com.tolgakmbl.hrms.business.concretes;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolgakmbl.hrms.business.abstracts.EmailActivationService;
import com.tolgakmbl.hrms.core.utilities.helpers.email.EmailService;
import com.tolgakmbl.hrms.core.utilities.results.*;
import com.tolgakmbl.hrms.dataAccess.abstracts.EmailActivationDao;
import com.tolgakmbl.hrms.entities.concretes.EmailActivation;
import com.tolgakmbl.hrms.entities.concretes.User;
import com.tolgakmbl.hrms.entities.dtos.EmailActivationForVerifyDto;

@Service
public class EmailActivationManager implements EmailActivationService{

	private EmailActivationDao emailActivationDao;
	private final EmailService emailService;	

	@Autowired
	public EmailActivationManager(EmailActivationDao emailActivationDao, EmailService emailService) {
		super();
		this.emailActivationDao = emailActivationDao;
		this.emailService = emailService;
	}

	@Override
	public Result add(EmailActivation emailActivation) {
		emailActivationDao.save(emailActivation);
		return new SuccessResult("Email Activation added");
	}

	@Override
	public Result delete(int id) {
		emailActivationDao.deleteById(id);
		return new SuccessResult("Email Activation deleted");
	}

	@Override
	public DataResult<List<EmailActivation>> getAll() {
		return new SuccessDataResult<List<EmailActivation>>(emailActivationDao.findAll(),"Email Activations listed");
	}

	@Override
	public DataResult<EmailActivation> getById(int id) {
		return new SuccessDataResult<EmailActivation>(emailActivationDao.findById(id).get());
	}

	@Override
	public Result update(EmailActivation emailActivation) {
		emailActivationDao.save(emailActivation);
		return new SuccessResult("Email Activation updated");
	}

	@Override
	public Result createAndSendActivationCodeByMail(User user, String... emails) {
		for (final String email : emails) {
			final EmailActivation emailActivation = EmailActivation.builder()
					.user(user)
					.email(email)
					.activationCode("EmailActivationCodeTEST")
					.expirationDate(LocalDateTime.now().plusMonths(1))
					.build();
			add(emailActivation);
			emailService.send(email,
					"Verify Your Account",
					String.format("%swww.localhost:8080/api/emailactivations/verify?activationCode=%s&email=%s",
							"Welcome to HRMS System. \nYou can verify your membership by clicking the link below. \n",
							emailActivation.getActivationCode(),
							email));
		}

		return new SuccessResult("Email activation code has sent");
	}

	@Override
	public Result verify(EmailActivationForVerifyDto emailActivationForVerifyDto) {
		final Optional<EmailActivation> emailActivation = emailActivationDao.findByEmailAndActivationCode(
				emailActivationForVerifyDto.getEmail(),
				emailActivationForVerifyDto.getActivationCode());

		if (emailActivation.isEmpty())
			return new ErrorResult("No such email");

		emailActivation.get().setActivated(true);
		emailActivationDao.save(emailActivation.get());

		return new SuccessResult("Email has activated");
	}

}
