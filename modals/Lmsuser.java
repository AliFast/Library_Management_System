/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.modals;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ali tahir
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "userType")
@Table(name = "LMSUSER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Lmsuser.findAll", query = "SELECT l FROM Lmsuser l"),
		@NamedQuery(name = "Lmsuser.findById", query = "SELECT l FROM Lmsuser l WHERE l.id = :id"),
		@NamedQuery(name = "Lmsuser.userLogin", query = "SELECT l FROM Lmsuser l WHERE l.email = :email AND l.userpassword = :pass AND l.usertype=:type"),
		@NamedQuery(name = "Lmsuser.findByUsername", query = "SELECT l FROM Lmsuser l WHERE l.username = :username"),
		@NamedQuery(name = "Lmsuser.findByEmail", query = "SELECT l FROM Lmsuser l WHERE l.email = :email"),
		@NamedQuery(name = "Lmsuser.findByCnic", query = "SELECT l FROM Lmsuser l WHERE l.cnic = :cnic"),
		@NamedQuery(name = "Lmsuser.findByCnicBorrower", query = "SELECT l FROM Lmsuser l WHERE l.cnic = :cnic AND l.usertype='borrower'"),
		@NamedQuery(name = "Lmsuser.findByAddress", query = "SELECT l FROM Lmsuser l WHERE l.address = :address"),
		@NamedQuery(name = "Lmsuser.findByUserpassword", query = "SELECT l FROM Lmsuser l WHERE l.userpassword = :userpassword"),
		@NamedQuery(name = "Lmsuser.findByGender", query = "SELECT l FROM Lmsuser l WHERE l.gender = :gender"),
		@NamedQuery(name = "Lmsuser.findByCity", query = "SELECT l FROM Lmsuser l WHERE l.city = :city"),

		@NamedQuery(name = "Lmsuser.findByUsertype", query = "SELECT l FROM Lmsuser l WHERE l.usertype = :usertype"),
		@NamedQuery(name = "Lmsuser.findByPhone", query = "SELECT l FROM Lmsuser l WHERE l.phone = :phone") })
public abstract class Lmsuser implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "USERNAME")
	private String username;
	@Basic(optional = false)
	@Column(name = "EMAIL")
	private String email;
	@Basic(optional = false)
	@Column(name = "CNIC")
	private String cnic;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "USERPASSWORD")
	private String userpassword;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "CITY")
	private String city;
	@Column(name = "USERTYPE")
	private String usertype;
	@Column(name = "PHONE")
	private String phone;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "lmsuser")
	private Collection<Holdbook> holdbookCollection;
	@OneToMany(mappedBy = "userid")
	private Collection<Loan> loanCollection;
	@OneToMany(mappedBy = "userid")
	private Collection<Fine> fineCollection;

	public Lmsuser() {
	}

	public Lmsuser(Integer id) {
		this.id = id;
	}

	public Lmsuser(Integer id, String email, String cnic) {
		this.id = id;
		this.email = email;
		this.cnic = cnic;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnic() {
		return cnic;
	}

	public void setCnic(String cnic) {
		this.cnic = cnic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	@XmlTransient
	public Collection<Fine> getFineCollection() {
		return fineCollection;
	}

	public void setFineCollection(Collection<Fine> fineCollection) {
		this.fineCollection = fineCollection;
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
		if (!(object instanceof Lmsuser)) {
			return false;
		}
		Lmsuser other = (Lmsuser) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "modals.Lmsuser[ id=" + id + " ]";
	}

}
