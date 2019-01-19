/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.modals;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wmall
 */
@Entity
@Table(name = "HOLDBOOK")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Holdbook.findAll", query = "SELECT h FROM Holdbook h"),
		@NamedQuery(name = "Holdbook.findByUserid", query = "SELECT h FROM Holdbook h WHERE h.holdbookPK.userid = :userid"),
		@NamedQuery(name = "Holdbook.findByBookid", query = "SELECT h FROM Holdbook h WHERE h.holdbookPK.bookid = :bookid"),
		@NamedQuery(name = "Holdbook.findFirstBookHolder", query = "SELECT h FROM Holdbook h WHERE h.holdbookPK.userid = :userid AND  h.holdbookPK.bookid = :bookid ORDER BY  h.dataandtime ASC "),
		@NamedQuery(name = "Holdbook.findByDataandtime", query = "SELECT h FROM Holdbook h WHERE h.dataandtime = :dataandtime") })
public class Holdbook implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected HoldbookPK holdbookPK;
	@Column(name = "DATAANDTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataandtime;
	@JoinColumn(name = "BOOKID", referencedColumnName = "ID", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Book book;
	@JoinColumn(name = "USERID", referencedColumnName = "ID", insertable = false, updatable = false)
	@ManyToOne(optional = false)
	private Lmsuser lmsuser;

	public Holdbook() {
	}

	public Holdbook(HoldbookPK holdbookPK) {
		this.holdbookPK = holdbookPK;
	}

	public Holdbook(int userid, int bookid) {
		this.holdbookPK = new HoldbookPK(userid, bookid);
	}

	public HoldbookPK getHoldbookPK() {
		return holdbookPK;
	}

	public void setHoldbookPK(HoldbookPK holdbookPK) {
		this.holdbookPK = holdbookPK;
	}

	public Date getDataandtime() {
		return dataandtime;
	}

	public void setDataandtime(Date dataandtime) {
		this.dataandtime = dataandtime;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Lmsuser getLmsuser() {
		return lmsuser;
	}

	public void setLmsuser(Lmsuser lmsuser) {
		this.lmsuser = lmsuser;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (holdbookPK != null ? holdbookPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Holdbook)) {
			return false;
		}
		Holdbook other = (Holdbook) object;
		if ((this.holdbookPK == null && other.holdbookPK != null)
				|| (this.holdbookPK != null && !this.holdbookPK.equals(other.holdbookPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "modals.Holdbook[ holdbookPK=" + holdbookPK + " ]";
	}

}
