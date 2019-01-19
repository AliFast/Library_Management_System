/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.validation;



/**
 *
 * @author wmall
 */
public class ISBNValidation {
    
    public static boolean validate(String isbnStr){
        
        String regex = "\\d+";
         
        return isbnStr.matches(regex) && isbnStr.length() == 10;
    
    }
}
