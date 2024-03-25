/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import entity.Account;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author codevn
 */
public class CheckPermission {

    public boolean checkAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account a = new Account();
        if (session.getAttribute("acc") != null) {
            a = (Account) session.getAttribute("acc");
            if (a.getIsAdmin() == 1) {
                return true;
            }
        }

        return false;
    }
}
