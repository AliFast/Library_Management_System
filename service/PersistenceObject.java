package com.lms.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PersistenceObject {

	@PersistenceContext(name = "LMS")
	private static EntityManager em;
	
	 private PersistenceObject() {

	        //Prevent form the reflection api.
	        if (em != null) {
	            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
	        }
	    }
	
	
	public static EntityManager getInstance() {
        

        return em;
    }
	
}
