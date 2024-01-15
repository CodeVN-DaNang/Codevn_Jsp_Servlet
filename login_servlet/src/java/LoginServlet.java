/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vannhat
 */
public class LoginServlet extends HttpServlet {

    User user = new User("admin", "admin");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("user", new User("", ""));
        RequestDispatcher dispatcher = request.getRequestDispatcher("demo_login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals(user.getUsername())) {
            if (password.equals(user.getPassword())) {
                request.setAttribute("msg", "login success!!!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("demo_login.jsp");
        dispatcher.forward(request, response);
                return;
            }
        }
        request.setAttribute("msg", "login fail!!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("demo_login.jsp");
        dispatcher.forward(request, response);
        return;
    }

}
