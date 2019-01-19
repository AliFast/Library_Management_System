/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.validation;



import com.lms.controllers.BookQueries;
import com.lms.controllers.LmsuserQueries;
import com.lms.modals.*;

/**
 *
 * @author wmall
 */
public class ExistenseValidation {

	public static String isbnValidate(String isbn) throws Exception {

		Book users = null;
		BookQueries bookObject = new BookQueries();

		users = bookObject.findByIsbn(isbn);

		if (users == null) {
			return "1";
		}

		return "This ISBN Already Exists in Database";

	}

	public static String cnicValidate(String cnic) {

		Lmsuser users = null;
		LmsuserQueries b1 = new LmsuserQueries();

		users = b1.findByCnic(cnic);

		if (users == null) {
			return "1";
		}

		return "This CNIC Already Exists in Database";

	}

	public static String cnicValidateBorrower(String cnic) {

		Lmsuser users = null;
		LmsuserQueries b1 = new LmsuserQueries();

		users = b1.findBorrowerByCnic(cnic);

		if (users == null) {
			return "1";
		}

		return "This CNIC Already Exists in Database";

	}

	public static String validate(String email, String cnic) {
		Lmsuser users = null;

		LmsuserQueries userObject = new LmsuserQueries();

		users = userObject.findByEmail(email);
		if (users == null) {

			users = userObject.findByCnic(cnic);
			if (users == null) {

				return "1";

			} else {

				return "This CNIC Already Exists in Database";

			}

		} else {

			return "This Email ID Already Exists in Database";

		}

	}

	public static String validateUpdate(String newEmail, String newCnic, String email, String cnic) {
		Lmsuser users = null;

		// cnic and email here should be old cnic and email fix it
		LmsuserQueries userObject = new LmsuserQueries();

		users = userObject.findByEmail(newEmail);
		if (users == null || users.getEmail().equalsIgnoreCase(email)) {

			users = null;
			users = userObject.findByCnic(newCnic);
			if (users == null || users.getCnic().equalsIgnoreCase(cnic)) {

				return "1";

			} else {

				return "This CNIC is registered for Another User";

			}

		} else {

			return "This Email is registered for Another User";

		}

	}

	public static String validateUpdateBook(String newIsbn, String oldIsbn) throws Exception {
		Book users = null;

		// cnic and email here should be old cnic and email fix it
		BookQueries bookObject = new BookQueries();

		users = bookObject.findByIsbn(newIsbn);

		if (users == null) {
			return "1";

		}

		if (users.getIsbn().equalsIgnoreCase(oldIsbn)) {

			return "1";

		} else {

			return "This ISBN is registered for Another Book";

		}

	}

}
