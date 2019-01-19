package com.lms.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lms.modals.Fine;

/**
 * Session Bean implementation class FineServices
 */
@Stateless
@LocalBean
public class FineServices {

	
	EntityManager em = PersistenceObject.getInstance();

	/**
	 * Default constructor.
	 */
	public FineServices() {
		// TODO Auto-generated constructor stub
	}

	public void addFine(Fine fine) {

		em.persist(fine);
	}

	public String calculateTotalFine() {

		return (String) em.createNamedQuery("Fine.getSum").getSingleResult();

	}

}
