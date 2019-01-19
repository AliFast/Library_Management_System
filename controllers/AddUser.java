package com.lms.controllers;

import javax.ejb.EJB;
import com.lms.modals.*;
import com.lms.service.UserService;

public class AddUser {

	@EJB
	private UserService us;
	
	public boolean addLmsuser(String name,String gender,String cnic,String phone,String address,String city,String email,String password,String userType) {
		
		try {
		Lmsuser lmu = null;
		if(userType.equals("borrower")) {
			lmu = new borrower();
			
		}else if(userType.equals("clerk")) {
			lmu = new clerk();
			
		}else if(userType.equals("librariyan")) {
			
			lmu = new librariyan();
		}
		
		 lmu.setCity(city.toLowerCase());
         lmu.setAddress(address.toLowerCase());
         lmu.setCnic(cnic);
         lmu.setEmail(email.toLowerCase());
         lmu.setGender(gender);


         lmu.setPhone(phone);
         lmu.setUsername(name.toLowerCase());
         lmu.setUserpassword(password);
         us.addUserToDB(lmu);
         
         return true;
		}catch(Exception e) {
			
			return false;
		}
	}  
}
