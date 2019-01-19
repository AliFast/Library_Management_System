package com.lms.modals;

import javax.persistence.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wmall
 */
@Entity
@DiscriminatorValue("borrower")
public class borrower extends Lmsuser {
	@Transient
	private static final long serialVersionUID = 1L;

}
