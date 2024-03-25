package control;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import Validation.CheckValid;
import dao.DAO;
import entity.User;
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
        String user_phone = request.getParameter("user_phone");
        String user_email = request.getParameter("user_email");
        String user_identity = request.getParameter("user_identity");
        String user_address = request.getParameter("user_address");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        

        if (fullname.isEmpty() || user_phone.isEmpty() || user_email.isEmpty()
                || user_identity.isEmpty() || user_address.isEmpty()
                || username.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
            request.setAttribute("kq", "Please fill in all fields");
            // Chuyển hướng trở lại trang đăng ký
            request.getRequestDispatcher("login_register.jsp").forward(request, response);
            return; // Dừng thực hiện tiếp tục của Servlet
        }

        // Kiểm tra tính hợp lệ của số điện thoại
        if (!CheckValid.isValidPhoneNumber(user_phone)) {
            request.setAttribute("kq", "Invalid Phonenumber! Please enter 10 digits");
            request.getRequestDispatcher("login_register.jsp").forward(request, response);
            return;
        }
        // Kiểm tra tính hợp lệ của CCCD
        if (!CheckValid.isValidCCCD(user_identity)) {
            request.setAttribute("kq", "CCCD invalid!");
            request.getRequestDispatcher("login_register.jsp").forward(request, response);
            return;
        }
        // Kiểm tra tính hợp lệ của email
        if (!CheckValid.isGmailAddress(user_email)) {
            request.setAttribute("kq", "Email not exit!");
            request.getRequestDispatcher("login_register.jsp").forward(request, response);
            return;
        }
        // Kiểm tra tính hợp lệ của mật khẩu
        if (!CheckValid.PasswordValid(password)) {
            request.setAttribute("kq", "Password failed! At least one uppercase letters, one special letters, and is longer than 8 letters");
            request.getRequestDispatcher("login_register.jsp").forward(request, response);
            return;
        }

        // Kiểm tra nếu mật khẩu và mật khẩu nhập lại không khớp và người dùng đã gửi biểu mẫu
        if (!password.equals(repassword) && request.getMethod().equalsIgnoreCase("post")) {
            request.setAttribute("kq", "Password and Confirm Password do not match");
            // Chuyển hướng trở lại trang đăng ký
            request.getRequestDispatcher("login_register.jsp").forward(request, response);
            return; // Dừng thực hiện tiếp tục của Servlet
        } else {
            // Nếu password và repassword trùng khớp, tiếp tục thực hiện lệnh sign up
            DAO dao = new DAO();
            User user = dao.checkAccountExist(username);
            if (user == null) {
                dao.singup(new User(0, fullname, user_phone, user_email, user_identity, user_address, username, password, null));

                response.sendRedirect("login_register.jsp");
            } else {
                request.setAttribute("fullname", fullname);
                request.setAttribute("user_phone", user_phone);
                request.setAttribute("user_email", user_email);
                request.setAttribute("user_identity", user_identity);
                request.setAttribute("user_address", user_address);
                request.setAttribute("username", username);
                request.setAttribute("password", repassword);

                request.setAttribute("kq", "Account registration failed");
                request.getRequestDispatcher("login_register.jsp").forward(request, response);
            }
        }
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
