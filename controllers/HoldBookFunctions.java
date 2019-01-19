package com.lms.controllers;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import com.lms.modals.Holdbook;
import com.lms.service.HoldBookServices;

public class HoldBookFunctions {

	@EJB
	HoldBookServices hbs;

	public void reserveBook(int userId, int bookId) {

		Holdbook hb = new Holdbook(userId, bookId);
		Date d = new Date();
		hb.setDataandtime(d);
		hbs.reserveBookInDB(hb);

	}

	List<Holdbook> holdBooksList;

	public List<Holdbook> findHoldBook(int userIdObject, int bookIdObject) {

		return hbs.findHoldBook(userIdObject, bookIdObject);
	}

	public boolean findHoldBookByBookId(int bookIdObject) {

		return hbs.findHoldBookByBookId(bookIdObject).isEmpty();
	}

	public boolean deleteHoldBook(int userIdObject, int bookIdObject) {

		try {
			hbs.deleteHoldBook(userIdObject, bookIdObject);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
