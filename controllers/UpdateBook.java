package com.lms.controllers;



import javax.ejb.EJB;

import com.lms.modals.Book;
import com.lms.service.BookService;

public class UpdateBook {

	@EJB
	BookService bs;

	public boolean updateBook(String isbnObjOld, String titleObj, String authorObj, String subjectObj,
			String availableObj, String isbnObjNew) {

		try {
			Book b1 = new Book();

			b1.setAuthor(authorObj.toLowerCase());
			if (availableObj.equalsIgnoreCase("yes")) {
				b1.setAvailability(true);
			} else {
				b1.setAvailability(false);

			}

			b1.setBooksubject(subjectObj.toLowerCase());
			b1.setIsbn(isbnObjNew);
			b1.setTitle(titleObj.toLowerCase());
			bs.updateBookInDB(b1);

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean updateAvailaibility(int boodId, boolean availaibilityObject) {

		try {
			bs.updateBookAvailabilityInDB(boodId, availaibilityObject);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteBook(String isbnObj) {

		try {
			bs.deleteBookFromDB(isbnObj);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
