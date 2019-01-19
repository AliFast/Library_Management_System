/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.modals;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;


/**
 *
 * @author wmall
 */

@Entity
@DiscriminatorValue("clerk")
public class clerk extends Lmsuser {
 
	@Transient
	private static final long serialVersionUID = 1L;
    
}
