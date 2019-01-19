/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.service;

import java.io.Serializable;

/**
 *
 * @author wmall
 */

    public class SessionService implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static volatile String instance;

    //private constructor.
    private SessionService() {

        //Prevent form the reflection api.
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static String getInstance() {
        if (instance == null) { //if there is no instance available... create new one
            synchronized (SessionService.class) {
                if (instance == null) {
                    instance = new String();
                }
            }
        }

        return instance;
    }

    public synchronized static void setInstance(String obj) {
        if (instance == null) {

            instance = new String();

        }

        instance = obj;

    }

}
