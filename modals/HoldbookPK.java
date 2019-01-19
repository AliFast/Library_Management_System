/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.modals;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 *
 * @author wmall
 */
@Embeddable
public class HoldbookPK implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	
    @Basic(optional = false)
    @Column(name = "USERID")
    private int userid;
    @Basic(optional = false)
    @Column(name = "BOOKID")
    private int bookid;

    public HoldbookPK() {
    }

    public HoldbookPK(int userid, int bookid) {
        this.userid = userid;
        this.bookid = bookid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userid;
        hash += (int) bookid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoldbookPK)) {
            return false;
        }
        HoldbookPK other = (HoldbookPK) object;
        if (this.userid != other.userid) {
            return false;
        }
        if (this.bookid != other.bookid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modals.HoldbookPK[ userid=" + userid + ", bookid=" + bookid + " ]";
    }
    
}
