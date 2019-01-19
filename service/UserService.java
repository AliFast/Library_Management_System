package com.lms.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lms.modals.Lmsuser;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService {

	/**
	 * Default constructor.
	 */

	EntityManager em = PersistenceObject.getInstance();

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public void addUserToDB(Lmsuser lmu) {
		em.persist(lmu);
	}

	public void updateUserInDB(Lmsuser lmu) throws Exception {

		Lmsuser updateUser = (Lmsuser) em.createNamedQuery("Lmsuser.findByCnic").setParameter("cnic", lmu.getCnic())
				.getSingleResult();

		if (updateUser.getUsertype().equalsIgnoreCase("borrower")) {

			updateUser.setAddress(lmu.getAddress().toLowerCase());
			updateUser.setCity(lmu.getCity().toLowerCase());
			updateUser.setCnic(lmu.getCnic());
			updateUser.setEmail(lmu.getEmail().toLowerCase());
			updateUser.setGender(lmu.getGender());
			updateUser.setPhone(lmu.getPhone());
			updateUser.setUsername(lmu.getUsername().toLowerCase());
			updateUser.setUserpassword(lmu.getUserpassword());

		} else {

			throw new Exception();
		}

	}

	public void deleteUserFromDB(String cnicObj) throws Exception {
		Lmsuser lmu = (Lmsuser) em.createNamedQuery("Lmsuser.findByCnic").setParameter("cnic", cnicObj)
				.getSingleResult();

		if (lmu.getUsertype().equalsIgnoreCase("borrower")) {

			em.remove(lmu);

		} else {

			throw new Exception();
		}

	}

	public Lmsuser findByEmail(String emailObject) {

		Lmsuser lmu = (Lmsuser) em.createNamedQuery("Lmsuser.findByEmail").setParameter("email", emailObject)
				.getSingleResult();

		return lmu;
	}

	public Lmsuser findByCnic(String cnicObject) {

		Lmsuser lmu = (Lmsuser) em.createNamedQuery("Lmsuser.findByCnic").setParameter("cnic", cnicObject)
				.getSingleResult();
		return lmu;
	}

	public Lmsuser findByCnicUser(String cnicObject) {

		Lmsuser lmu = (Lmsuser) em.createNamedQuery("Lmsuser.findByCnic").setParameter("cnic", cnicObject)
				.getSingleResult();
		return lmu;
	}

	public Lmsuser findBorrowerByCnic(String cnicObject) {

		Lmsuser lmu = (Lmsuser) em.createNamedQuery("Lmsuser.findByCnicBorrower").setParameter("cnic", cnicObject)
				.getSingleResult();
		return lmu;
	}

	public Lmsuser findById(Integer userId) {

		Lmsuser lmu = (Lmsuser) em.createNamedQuery("Lmsuser.findById").setParameter("id", userId).getSingleResult();
		return lmu;
	}

	public Lmsuser loginCredential(String emailObject, String passwordObject, String userTypeObject) {

		Lmsuser lmu = (Lmsuser) em.createNamedQuery("Lmsuser.userLogin").setParameter("email", emailObject)
				.setParameter("pass", passwordObject).setParameter("type", userTypeObject).getSingleResult();
		return lmu;
	}

}
