/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author codevn
 */
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
            // check user
            if (cookie.getName().equals("demo_full_jsp")) {
                if (cookie.getValue().split("-")[0].equals("admin") && cookie.getValue().split("-")[1].equals("hello")) {
                    System.out.println(cookies.length);
                    res.sendRedirect("/codevn5/student/");
                    return;
                }

            }
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // check database user
        if (username.equals("admin") && password.equals("hello")) {
            Cookie newCookie = new Cookie("demo_full_jsp", username + "-" + password);
            newCookie.setMaxAge(20);
            res.addCookie(newCookie);
        }
        doGet(req, res);

    }
}
