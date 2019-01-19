package com.lms.controllers;

import javax.ejb.EJB;

import com.lms.modals.Lmsuser;
import com.lms.modals.borrower;
import com.lms.service.UserService;

public class UpdateBorrower {

	@EJB
	UserService us;

	public boolean updateBorrower(String nameObj, String cnicObjNew, String addressObj, String emailObj,
			String phoneObj, String cityObj, String passwordObj, String genderObj, String cnicObjOld) {

		try {
			Lmsuser lmu = new borrower();

			lmu.setAddress(addressObj.toLowerCase());
			lmu.setCity(cityObj.toLowerCase());
			lmu.setCnic(cnicObjNew);
			lmu.setEmail(emailObj.toLowerCase());
			lmu.setGender(genderObj);
			lmu.setPhone(phoneObj);
			lmu.setUsername(nameObj.toLowerCase());
			lmu.setUserpassword(passwordObj);

			us.updateUserInDB(lmu);
			return true;
		} catch (Exception e) {

			return false;
		}

	}

	public boolean deleteBorrower(String cnicObj) {

		try {

			us.deleteUserFromDB(cnicObj);
			return true;

		} catch (Exception e) {
			return false;

		}

	}

}
