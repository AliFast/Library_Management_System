/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.modals;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wmall
 */
@Entity
@Table(name = "FINE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Fine.findAll", query = "SELECT f FROM Fine f"),
		@NamedQuery(name = "Fine.findByFineid", query = "SELECT f FROM Fine f WHERE f.fineid = :fineid"),
		@NamedQuery(name = "Fine.getSum", query = "SELECT SUM(f.amount) FROM Fine f"),
		@NamedQuery(name = "Fine.findByAmount", query = "SELECT f FROM Fine f WHERE f.amount = :amount") })
public class Fine implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "FINEID")
	private Integer fineid;
	@Column(name = "AMOUNT")
	private Integer amount;
	@JoinColumn(name = "USERID", referencedColumnName = "ID")
	@ManyToOne
	private Lmsuser userid;

	public Fine() {
	}

	public Fine(Integer fineid) {
		this.fineid = fineid;
	}

	public Integer getFineid() {
		return fineid;
	}

	public void setFineid(Integer fineid) {
		this.fineid = fineid;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Lmsuser getUserid() {
		return userid;
	}

	public void setUserid(Lmsuser userid) {
		this.userid = userid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (fineid != null ? fineid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Fine)) {
			return false;
		}
		Fine other = (Fine) object;
		if ((this.fineid == null && other.fineid != null)
				|| (this.fineid != null && !this.fineid.equals(other.fineid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "modals.Fine[ fineid=" + fineid + " ]";
	}

}
