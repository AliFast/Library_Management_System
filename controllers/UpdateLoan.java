package com.lms.controllers;

import javax.ejb.EJB;

import com.lms.service.LoanServices;

public class UpdateLoan {

	@EJB
	LoanServices ls;

	public boolean updateActualReturnDate(int loanIdObject) {

		try {
			ls.updateActualReturnDate(loanIdObject);
			return true;
		} catch (Exception e) {
			return false;

		}

	}

	public boolean updateReturnDate(Integer loanIdObject) {

		try {
			ls.updateReturnDate(loanIdObject);
			;
			return true;
		} catch (Exception e) {
			return false;

		}
	}

}
