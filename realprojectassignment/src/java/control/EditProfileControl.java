/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;
import entity.Category;
import entity.Product;
import entity.Role;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "EditProfileControl", urlPatterns = {"/editProfile"})
public class EditProfileControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User a = (User) session.getAttribute("account");
      
        if(a == null) {
        	response.sendRedirect("login");
        	return;
        }
        int id = a.getUser_id();
        String fullname = request.getParameter("fullname");
        String user_phone = request.getParameter("phone");
        String user_email = request.getParameter("email");
        String user_identity = a.getUser_identity();
        String user_address = a.getUser_address();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        
        DAO dao = new DAO();
        
        dao.editProfile(new User(id, fullname, user_phone, user_email, user_identity, user_address, username, password, a.getRole_id()));
        
        request.setAttribute("mess", "Cap nhat tai khoan thanh cong! Hay dang nhap bang tai khoan moi!");

        request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User a = (User) session.getAttribute("account");
      
        if(a == null) {
        	response.sendRedirect("login");
        	return;
        }
        int id = a.getUser_id();
        request.getRequestDispatcher("EditProfile.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
