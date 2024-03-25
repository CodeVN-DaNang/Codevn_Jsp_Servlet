/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.DAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Post;
import model.User;

/**
 *
 * @author codevn
 */
@WebServlet("/profile")
public class ProfileControl extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        DAO dao = new DAO();
        int user_id = 0;
        
        try {
            user_id = Integer.parseInt(request.getParameter("user_id"));
        } catch (Exception e) {
            System.out.println(e);
        }
        User user = dao.getUserById(user_id);
        request.setAttribute("user_id", user_id);
        request.setAttribute("fullname", user.getUser_fullname());
        request.setAttribute("username", user.getUsername());
        request.setAttribute("user_about", user.getUser_about());
        request.setAttribute("user_website", user.getUser_website());
        request.setAttribute("user_country", user.getUser_country());
        
        
        
        request.getRequestDispatcher("Profile.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
