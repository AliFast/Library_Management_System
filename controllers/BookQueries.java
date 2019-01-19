package com.lms.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import com.lms.modals.Book;
import com.lms.service.BookService;


@Stateless
@LocalBean
public class BookQueries {

	
	private  BookService bs = new BookService();
	
	public BookQueries() {
		
		
		
				

		/*try {
			
			Context context = new InitialContext();			
			Object fObj = context.lookup("java:global/LMS/BookService!com.lms.service.BookService");
			bs=(BookService)fObj;
		}catch(NamingException e) {
			System.out.println("Naming Exception while lookup of bean object");
		}
		*/
	}

	List<Book> booksList;
	
	

	public Book findByIsbn(String isbnObject) {

		
		Book book = bs.findByIsbn(isbnObject);
		return book;
		
		
	}

	public List<Book> findByAuthor(String authorName) {

		booksList = bs.findByAuthor(authorName);

		return booksList;
	}

	public List<Book> findByTitle(String titleName) {

		booksList = bs.findByTitle(titleName);

		return booksList;
	}

	public List<Book> findBySubject(String subjectName) {

		booksList = bs.findBySubject(subjectName);

		return booksList;
	}

}
