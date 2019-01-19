package com.lms.controllers;

import javax.ejb.EJB;


import com.lms.modals.Lmsuser;
import com.lms.service.UserService;

public class LmsuserQueries {

	@EJB
	UserService us;

	Lmsuser lmu;

	public Lmsuser findByEmail(String emailObject) {

		lmu = us.findByEmail(emailObject);

		return lmu;
	}

	public Lmsuser findByCnic(String cnicObject) {

		lmu = us.findByCnic(cnicObject);
		return lmu;
	}

	public Lmsuser findByCnicUser(String cnicObject) {

		lmu = us.findByCnicUser(cnicObject);
		return lmu;
	}

	public Lmsuser findBorrowerByCnic(String cnicObject) {

		lmu = us.findBorrowerByCnic(cnicObject);
		return lmu;
	}

	public Lmsuser findById(Integer userId) {

		lmu = us.findById(userId);
		return lmu;
	}

	public Lmsuser loginCredential(String emailObject, String passwordObject, String userTypeObject) {

		lmu = us.loginCredential(emailObject, passwordObject, userTypeObject);
		return lmu;
	}

}
