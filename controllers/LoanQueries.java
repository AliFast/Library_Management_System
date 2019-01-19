package com.lms.controllers;

import java.util.List;

import javax.ejb.EJB;

import com.lms.modals.Book;
import com.lms.modals.Lmsuser;
import com.lms.modals.Loan;
import com.lms.service.LoanServices;

public class LoanQueries {

	@EJB
	LoanServices ls;

	public List<Loan> findBooksBorrowed(Lmsuser userIdObject) {

		return ls.findBooksBorrowed(userIdObject);
	}

	public List<Loan> findLoanList(Lmsuser userIdObject, Book bookIdObject) {

		return ls.findLoanList(userIdObject, bookIdObject);
	}

	public List<Loan> findLoanListWithFine(int userIdObject, int bookIdObject) {

		return ls.findLoanListWithFine(userIdObject, bookIdObject);
	}

	public List<Loan> findBookInLoan(Book bookIdObject) {

		return ls.findBookInLoan(bookIdObject);
	}

	public List<Loan> findNullActualReturnDate() {

		return ls.findNullActualReturnDate();

	}

}
