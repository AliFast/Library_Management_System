/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.validation;

import java.util.List;

import com.lms.controllers.HoldBookFunctions;
import com.lms.modals.*;

/**
 *
 * @author wmall
 */
public class LoanValidation {

    public static String validate(Lmsuser userList, Book bookList) {

        HoldBookFunctions hb = new HoldBookFunctions();
        List<Holdbook> holdBooksList = null;

        if (bookList.getAvailability()) {

            if (!hb.findHoldBookByBookId(bookList.getId())) {

                holdBooksList = hb.findHoldBook(userList.getId(), bookList.getId());
                if (!holdBooksList.isEmpty()) {
                    HoldbookPK hbp = holdBooksList.get(0).getHoldbookPK();

                    if (hbp.getUserid() == userList.getId() && hbp.getBookid() == bookList.getId()) {
                        return "1";

                    } else {
                        return "Book on hold for someone else";

                    }

                } else {
                    return "Book on hold for someone else";

                }

            } else {
                return "2"; // not hold condition

            }

        } else {

            return "Book is not Available";

        }

    }

}
