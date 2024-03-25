package control;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author miulan
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/signup"})
public class SignUpServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        }
        
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
//        processRequest(request, response);
        request.getRequestDispatcher("login_register.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String fullname = request.getParameter("fullname");
        String user_dob = request.getParameter("user_dob");
        String user_about = "";
        String user_website = request.getParameter("user_website");
        String user_country = request.getParameter("user_country");
        String user_gender = request.getParameter("user_gender");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
       
        // Nếu password và repassword trùng khớp, tiếp tục thực hiện lệnh sign up
        DAO dao = new DAO();
        if (dao.checkExist(username) && password.equals(repassword)) {
            dao.signUp(new User(0, fullname, user_dob, user_about, user_website, user_country, user_gender, username, password));
            request.setAttribute("message", "Account registration success");
            System.out.println(new User(0, fullname, user_dob, user_about, user_website, user_country, user_gender, username, password).toString());
            request.getRequestDispatcher("login_register.jsp").forward(request, response);
            return;
        }
            request.setAttribute("fullname", fullname);
            request.setAttribute("user_dob", user_dob);
            
            request.setAttribute("user_website", user_website);
            request.setAttribute("user_country", user_country);
            request.setAttribute("user_gender", user_gender);
            request.setAttribute("username", username);
            request.setAttribute("password", repassword);
            request.setAttribute("message", "Account registration failed");
            request.getRequestDispatcher("login_register.jsp").forward(request, response);
        
        
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
