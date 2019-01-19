/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.validation;



import com.lms.controllers.LmsuserQueries;
import com.lms.modals.*;

/**
 *
 * @author wmall
 */
public class LoginValidation {
   
    public static String validateAdmin(String email,String password){
        Lmsuser users = null;
        LmsuserQueries a1 = new LmsuserQueries();
        users = a1.loginCredential(email, password,"admin");
        if(users == null){
            return "Incorrect Username or Password";
        }
        
        return "1";
        
     }
    
     public static String validateBorrower(String email,String password){
    	 Lmsuser users = null;
        LmsuserQueries b1 = new LmsuserQueries();
        users = b1.loginCredential(email, password,"borrower");
        if(users == null){
            return "Incorrect Username or Password";
        }
        
        return "1";
        
     }
     
     public static String validateLibrariyan(String email,String password){
    	 Lmsuser users = null;
    	 LmsuserQueries l1 = new LmsuserQueries();
        users = l1.loginCredential(email, password,"librariyan");
        if(users == null){
            return "Incorrect Username or Password";
        }
        
        return "1";
        
     }
     
     public static String validateClerk(String email,String password){
    	 Lmsuser users = null;
        LmsuserQueries c1 = new LmsuserQueries();
        users = c1.loginCredential(email, password,"clerk");
        if(users==null){
            return "Incorrect Username or Password";
        }
        
        return "1";
        
     }
}
