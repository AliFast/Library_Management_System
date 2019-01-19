/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.modals;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wmall
 */
@Entity
@Table(name = "LOAN")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Loan.findAll", query = "SELECT l FROM Loan l"),
		@NamedQuery(name = "Loan.findByLoanid", query = "SELECT l FROM Loan l WHERE l.loanid = :loanid"),
		@NamedQuery(name = "Loan.findByIssuedate", query = "SELECT l FROM Loan l WHERE l.issuedate = :issuedate"),
		@NamedQuery(name = "Loan.findByNull", query = "SELECT l FROM Loan l WHERE l.actualreturndate IS NULL AND l.userid=:userId"),
		@NamedQuery(name = "Loan.findLoanObject", query = "SELECT l FROM Loan l WHERE l.actualreturndate=null AND l.userid=:userId AND l.bookid=:bookId"),
		@NamedQuery(name = "Loan.findLoanedBook", query = "SELECT l FROM Loan l WHERE l.actualreturndate IS NULL  AND l.bookid=:bookId"),
		@NamedQuery(name = "Loan.findByReturndate", query = "SELECT l FROM Loan l WHERE l.returndate = :returndate"),
		@NamedQuery(name = "Loan.findLoanFine", query = "SELECT l FROM Loan l WHERE l.fineFlag=true AND l.userid=:userId AND l.bookid=:bookId"),
		@NamedQuery(name = "Loan.findByNullActualreturndate", query = "SELECT l FROM Loan l WHERE l.actualreturndate IS NULL"),
		@NamedQuery(name = "Loan.findByActualreturndate", query = "SELECT l FROM Loan l WHERE l.actualreturndate = :actualreturndate") })
public class Loan implements Serializable {

	@Transient
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "LOANID")
	private Integer loanid;
	@Column(name = "ISSUEDATE")
	@Temporal(TemporalType.DATE)
	private Date issuedate;
	@Column(name = "RETURNDATE")
	@Temporal(TemporalType.DATE)
	private Date returndate;
	@Column(name = "ACTUALRETURNDATE")
	@Temporal(TemporalType.DATE)
	private Date actualreturndate;
	@Basic(optional = false)
	@Column(name = "FINE")
	private Boolean fineFlag;
	@JoinColumn(name = "BOOKID", referencedColumnName = "ID")
	@ManyToOne
	private Book bookid;
	@JoinColumn(name = "USERID", referencedColumnName = "ID")
	@ManyToOne
	private Lmsuser userid;

	public Loan() {
	}

	public Loan(Integer loanid) {
		this.loanid = loanid;
	}

	public Integer getLoanid() {
		return loanid;
	}

	public void setLoanid(Integer loanid) {
		Integer oldLoanid = this.loanid;
		this.loanid = loanid;
		changeSupport.firePropertyChange("loanid", oldLoanid, loanid);
	}

	public Date getIssuedate() {
		return issuedate;
	}

	public Boolean getFineFlag() {
		return fineFlag;
	}

	public void setFineFlag(Boolean fineFlag) {
		this.fineFlag = fineFlag;
	}

	public void setIssuedate(Date issuedate) {
		Date oldIssuedate = this.issuedate;
		this.issuedate = issuedate;
		changeSupport.firePropertyChange("issuedate", oldIssuedate, issuedate);
	}

	public Date getReturndate() {
		return returndate;
	}

	public void setReturndate(Date returndate) {
		Date oldReturndate = this.returndate;
		this.returndate = returndate;
		changeSupport.firePropertyChange("returndate", oldReturndate, returndate);
	}

	public Date getActualreturndate() {
		return actualreturndate;
	}

	public void setActualreturndate(Date actualreturndate) {
		Date oldActualreturndate = this.actualreturndate;
		this.actualreturndate = actualreturndate;
		changeSupport.firePropertyChange("actualreturndate", oldActualreturndate, actualreturndate);
	}

	public Book getBookid() {
		return bookid;
	}

	public void setBookid(Book bookid) {
		Book oldBookid = this.bookid;
		this.bookid = bookid;
		changeSupport.firePropertyChange("bookid", oldBookid, bookid);
	}

	public Lmsuser getUserid() {
		return userid;
	}

	public void setUserid(Lmsuser userid) {
		Lmsuser oldUserid = this.userid;
		this.userid = userid;
		changeSupport.firePropertyChange("userid", oldUserid, userid);
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (loanid != null ? loanid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Loan)) {
			return false;
		}
		Loan other = (Loan) object;
		if ((this.loanid == null && other.loanid != null)
				|| (this.loanid != null && !this.loanid.equals(other.loanid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "modals.Loan[ loanid=" + loanid + " ]";
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

}
