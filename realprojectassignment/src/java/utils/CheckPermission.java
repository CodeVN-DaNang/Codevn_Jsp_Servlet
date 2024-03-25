/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import entity.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author codevn
 */
public class CheckPermission {

    public boolean checkAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User a = new User();
        if (session.getAttribute("account") != null) {
            a = (User) session.getAttribute("account");
            if (a.getRole_id() != null) {
                System.out.println(a.getRole_id().getRole_id());
                if (a.getRole_id().getRole_id() == 1) {
                    return false;
                }
            }

        }

        return true;
    }
}
