/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.validation;

import java.util.List;

import com.lms.controllers.LoanQueries;
import com.lms.modals.*;


/**
 *
 * @author wmall
 */
public class BorrowedBooksValidation {
 
    public static String validate(Lmsuser userId){
        LoanQueries l1 = new LoanQueries();
        
        List<Loan> loanList = l1.findBooksBorrowed(userId);
        if(!loanList.isEmpty()){
            if(loanList.size() == 2){
                return "Borrower Already has 2 Borrowed Books";
            }else{
                return "1";
            }
        
        
        }else{
            return "1";
        
        }
    
    }
    
}
