package com.lms.controllers;

import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;

import com.lms.modals.Book;
import com.lms.modals.Lmsuser;
import com.lms.modals.Loan;
import com.lms.service.LoanServices;

public class AddLoan {

	@EJB
	LoanServices ls;

	public boolean addLoan(Lmsuser userObject, Book bookObject) {

		try {
			Date issueDateObject = new Date();
			Date returnDateObject = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(returnDateObject);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			cal.add(Calendar.DAY_OF_MONTH, 7);
			returnDateObject = cal.getTime();

			Loan l1 = new Loan();
			l1.setIssuedate(issueDateObject);
			l1.setReturndate(returnDateObject);
			l1.setUserid(userObject);
			l1.setBookid(bookObject);
			l1.setFineFlag(false);

			ls.addLoan(l1);
			return true;

		} catch (Exception e) {

			return false;
		}

	}

}
