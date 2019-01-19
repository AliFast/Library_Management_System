package com.lms.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lms.modals.Book;

/**
 * Session Bean implementation class BookService
 */
@Stateless
@LocalBean
public class BookService {

	
	EntityManager em = PersistenceObject.getInstance();
	

	/**
	 * Default constructor.
	 */
	public BookService() {
		// TODO Auto-generated constructor stub
	}

	public void addBookInDB(Book book) {

		em.persist(book);
		
	}

	public void updateBookInDB(Book book) {
		Book b1 = (Book) em.createNamedQuery("Book.findByIsbn").setParameter("isbn", book.getIsbn()).getSingleResult();

		b1.setAuthor(book.getAuthor().toLowerCase());
		if (book.getAvailability()) {
			b1.setAvailability(true);
		} else {
			b1.setAvailability(false);

		}

		b1.setBooksubject(book.getBooksubject().toLowerCase());
		b1.setIsbn(book.getIsbn());
		b1.setTitle(book.getTitle().toLowerCase());

	}

	public void updateBookAvailabilityInDB(int boodId, boolean availaibilityObject) {
		Book b1 = em.find(Book.class, boodId);

		b1.setAvailability(availaibilityObject);

	}

	public void deleteBookFromDB(String isbnObj) {

		Book book = (Book) em.createNamedQuery("Book.findByIsbn").setParameter("isbn", isbnObj).getSingleResult();
		em.remove(book);

	}

	List<Book> booksList;

	public Book findByIsbn(String isbnObject) {

		Book b2 = (Book) em.createNamedQuery("Book.findByIsbn").setParameter("isbn", isbnObject).getSingleResult();
		return b2;
	}

	
	@SuppressWarnings("unchecked")
	public List<Book> findByAuthor(String authorName) {

		booksList = em.createNamedQuery("Book.findByAuthor").setParameter("author", authorName).getResultList();

		return booksList;
	}

	@SuppressWarnings("unchecked")
	public List<Book> findByTitle(String titleName) {

		booksList = em.createNamedQuery("Book.findByTitle").setParameter("title", titleName).getResultList();

		return booksList;
	}

	@SuppressWarnings("unchecked")
	public List<Book> findBySubject(String subjectName) {

		booksList = em.createNamedQuery("Book.findByBooksubject").setParameter("booksubject", subjectName)
				.getResultList();

		return booksList;
	}

}
