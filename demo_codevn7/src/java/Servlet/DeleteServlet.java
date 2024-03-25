/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Servlet;

import DAO.HelloDAO;
import Entitites.Hello;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    HelloDAO helloDao = new HelloDAO();
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        helloDao.delete(id);
//        ArrayList<Hello> list = helloDao.getAll();
//        request.setAttribute("list", list);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("hello.jsp");
//        dispatcher.forward(request, response);
        response.sendRedirect("/demo_codevn7/");
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
    }
}
