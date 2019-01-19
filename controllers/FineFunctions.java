package com.lms.controllers;

import javax.ejb.EJB;

import com.lms.modals.Fine;
import com.lms.modals.Lmsuser;
import com.lms.service.FineServices;

public class FineFunctions {

	@EJB
	FineServices fs;

	public boolean AddFine(Lmsuser userId, int amount) {

		try {
			Fine f1 = new Fine();
			f1.setAmount(amount);
			f1.setUserid(userId);
			fs.addFine(f1);
			return true;

		} catch (Exception e) {

			return false;
		}

	}

	public String calculateTotalFine() {

		return fs.calculateTotalFine();

	}

}
