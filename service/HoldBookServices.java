package com.lms.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lms.modals.Holdbook;

/**
 * Session Bean implementation class HoldBookServices
 */
@Stateless
@LocalBean
public class HoldBookServices {

	/**
	 * Default constructor.
	 */
	public HoldBookServices() {
		// TODO Auto-generated constructor stub
	}

	EntityManager em = PersistenceObject.getInstance();

	public void reserveBookInDB(Holdbook hb) {
		em.persist(hb);
	}

	List<Holdbook> holdBooksList;

	@SuppressWarnings("unchecked")
	public List<Holdbook> findHoldBook(int userIdObject, int bookIdObject) {

		holdBooksList = em.createNamedQuery("Holdbook.findFirstBookHolder").setParameter("userid", userIdObject)
				.setParameter("bookid", bookIdObject).getResultList();
		return holdBooksList;
	}

	@SuppressWarnings("unchecked")
	public List<Holdbook> findHoldBookByBookId(int bookIdObject) {

		holdBooksList = em.createNamedQuery("Holdbook.findByBookid").setParameter("bookid", bookIdObject)
				.getResultList();
		return holdBooksList;
	}

	@SuppressWarnings("unchecked")
	public void deleteHoldBook(int userIdObject, int bookIdObject) {

		List<Holdbook> bookList = em.createNamedQuery("Holdbook.findFirstBookHolder")
				.setParameter("userid", userIdObject).setParameter("bookid", bookIdObject).getResultList();
		Holdbook hb = bookList.get(0);

		em.remove(hb);

	}

}
