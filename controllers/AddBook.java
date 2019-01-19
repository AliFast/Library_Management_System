package com.lms.controllers;

import javax.ejb.EJB;
import javax.inject.Inject;

import com.lms.modals.Book;
import com.lms.service.BookService;

public class AddBook {

	@EJB
	private BookService bs;

	public boolean addBook(String isbnAddBookObject, String titleAddBookObject, String authorAddBookObject,
			String subjectAddBookObject, String AvailableObject) {

		try {
			Book b1 = new Book();
			b1.setAuthor(authorAddBookObject.toLowerCase());

			if (AvailableObject.equalsIgnoreCase("yes")) {
				b1.setAvailability(true);
			} else {
				b1.setAvailability(false);
			}

			b1.setBooksubject(subjectAddBookObject.toLowerCase());
			b1.setIsbn(isbnAddBookObject);
			b1.setTitle(titleAddBookObject.toLowerCase());

			bs.addBookInDB(b1);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
