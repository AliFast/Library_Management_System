/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.modals;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wmall
 */
@Entity
@Table(name = "BOOK")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
		@NamedQuery(name = "Book.findById", query = "SELECT b FROM Book b WHERE b.id = :id"),
		@NamedQuery(name = "Book.findByIsbn", query = "SELECT b FROM Book b WHERE b.isbn = :isbn"),
		@NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
		@NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author"),
		@NamedQuery(name = "Book.findByBooksubject", query = "SELECT b FROM Book b WHERE b.booksubject = :booksubject"),
		@NamedQuery(name = "Book.findByAvailability", query = "SELECT b FROM Book b WHERE b.availability = :availability") })
public class Book implements Serializable {

	@Transient
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "ISBN")
	private String isbn;
	@Basic(optional = false)
	@Column(name = "TITLE")
	private String title;
	@Basic(optional = false)
	@Column(name = "AUTHOR")
	private String author;
	@Basic(optional = false)
	@Column(name = "BOOKSUBJECT")
	private String booksubject;
	@Basic(optional = false)
	@Column(name = "AVAILABILITY")
	private Boolean availability;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
	private Collection<Holdbook> holdbookCollection;
	@OneToMany(mappedBy = "bookid")
	private Collection<Loan> loanCollection;

	public Book() {
	}

	public Book(Integer id) {
		this.id = id;
	}

	public Book(Integer id, String title, String author, String booksubject, Boolean availability) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.booksubject = booksubject;
		this.availability = availability;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		Integer oldId = this.id;
		this.id = id;
		changeSupport.firePropertyChange("id", oldId, id);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		String oldIsbn = this.isbn;
		this.isbn = isbn;
		changeSupport.firePropertyChange("isbn", oldIsbn, isbn);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		String oldTitle = this.title;
		this.title = title;
		changeSupport.firePropertyChange("title", oldTitle, title);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		String oldAuthor = this.author;
		this.author = author;
		changeSupport.firePropertyChange("author", oldAuthor, author);
	}

	public String getBooksubject() {
		return booksubject;
	}

	public void setBooksubject(String booksubject) {
		String oldBooksubject = this.booksubject;
		this.booksubject = booksubject;
		changeSupport.firePropertyChange("booksubject", oldBooksubject, booksubject);
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		Boolean oldAvailability = this.availability;
		this.availability = availability;
		changeSupport.firePropertyChange("availability", oldAvailability, availability);
	}

	@XmlTransient
	public Collection<Holdbook> getHoldbookCollection() {
		return holdbookCollection;
	}

	public void setHoldbookCollection(Collection<Holdbook> holdbookCollection) {
		this.holdbookCollection = holdbookCollection;
	}

	@XmlTransient
	public Collection<Loan> getLoanCollection() {
		return loanCollection;
	}

	public void setLoanCollection(Collection<Loan> loanCollection) {
		this.loanCollection = loanCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Book)) {
			return false;
		}
		Book other = (Book) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "modals.Book[ id=" + id + " ]";
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

}
