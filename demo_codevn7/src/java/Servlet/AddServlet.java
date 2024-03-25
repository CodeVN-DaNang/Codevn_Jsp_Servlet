/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Servlet;

import DAO.HelloDAO;
import Entitites.Hello;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author codevn
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
    
    HelloDAO helloDao = new HelloDAO();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Hello student = new Hello(); 
        request.setAttribute("hello", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String hello_id = request.getParameter("id");
        String hello_name = request.getParameter("name");
        Hello hello = new Hello(hello_id, hello_name);
        helloDao.add(hello);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
//        dispatcher.forward(request, response);
        response.sendRedirect("/demo_codevn7");
    }
}
