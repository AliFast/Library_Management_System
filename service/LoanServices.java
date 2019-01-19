package com.lms.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lms.modals.Book;
import com.lms.modals.Lmsuser;
import com.lms.modals.Loan;

/**
 * Session Bean implementation class LoanServices
 */
@Stateless
@LocalBean
public class LoanServices {

	EntityManager em = PersistenceObject.getInstance();

	/**
	 * Default constructor.
	 */
	public LoanServices() {
		// TODO Auto-generated constructor stub
	}

	public void addLoan(Loan loan) {
		em.persist(loan);

	}

	public void updateActualReturnDate(int loanIdObject) {

		Loan b1 = em.find(Loan.class, loanIdObject);
		Date d = new Date();
		Date oldDate = b1.getReturndate();

		if (d.after(oldDate)) {
			b1.setFineFlag(true);
		}
		b1.setActualreturndate(d);

	}

	public void updateReturnDate(Integer loanIdObject) {

		Loan b1 = em.find(Loan.class, loanIdObject);
		Date d = b1.getReturndate();

		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		d = cal.getTime();

		b1.setReturndate(d);

	}

	List<Loan> loanList;

	@SuppressWarnings("unchecked")
	public List<Loan> findBooksBorrowed(Lmsuser userIdObject) {

		loanList = em.createNamedQuery("Loan.findByNull").setParameter("userId", userIdObject).getResultList();
		return loanList;

	}

	@SuppressWarnings("unchecked")
	public List<Loan> findLoanList(Lmsuser userIdObject, Book bookIdObject) {

		loanList = em.createNamedQuery("Loan.findLoanObject").setParameter("userId", userIdObject)
				.setParameter("bookId", bookIdObject).getResultList();
		return loanList;
	}

	@SuppressWarnings("unchecked")
	public List<Loan> findLoanListWithFine(int userIdObject, int bookIdObject) {

		loanList = em.createNamedQuery("Loan.findLoanFine").setParameter("userId", userIdObject)
				.setParameter("bookId", bookIdObject).getResultList();
		return loanList;
	}

	@SuppressWarnings("unchecked")
	public List<Loan> findBookInLoan(Book bookIdObject) {

		loanList = em.createNamedQuery("Loan.findLoanedBook").setParameter("bookId", bookIdObject).getResultList();
		return loanList;
	}

	@SuppressWarnings("unchecked")
	public List<Loan> findNullActualReturnDate() {

		loanList = em.createNamedQuery("Loan.findByNullActualreturndate").getResultList();
		return loanList;

	}

}
