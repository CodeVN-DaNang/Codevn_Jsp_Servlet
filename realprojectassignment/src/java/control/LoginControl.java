/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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

@WebServlet(name = "LoginControl", urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        Cookie arr[] = request.getCookies();
    	if(arr != null) {
    		for(Cookie o : arr) {
        		if(o.getName().equals("username")) {
        			request.setAttribute("username", o.getValue());
        		}
        		if(o.getName().equals("password")) {
        			request.setAttribute("password", o.getValue());
        		}
        	}
    	}
        if (request.getSession().getAttribute("account") != null) {
            response.sendRedirect("/realgroup2/home");
            return;
        }
        request.getRequestDispatcher("login_register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rem = request.getParameter("rem");

        // Kiểm tra dữ liệu đầu vào
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "Please provide both username and password");
            request.getRequestDispatcher("login_register.jsp").forward(request, response);
            return;
        }

        DAO userDao = new DAO();
        User authenticatedUser = userDao.login(username, password);

        if (authenticatedUser == null) {
            request.setAttribute("error", "Invalid username or password");
            request.getRequestDispatcher("login_register.jsp").forward(request, response);
        } else {
            int userId = authenticatedUser.getUser_id();
            HttpSession session = request.getSession();
            session.setAttribute("account", authenticatedUser);
            session.setAttribute("userId", userId);
            // khởi tạo cookie
            Cookie cuser = new Cookie("username", username);
            Cookie cpass = new Cookie("password", password);
            Cookie crem = new Cookie("rem", rem);
            // set thời gian tồn tại của cookie
            if (rem == null) {
                cuser.setMaxAge(0);
                cpass.setMaxAge(0);
                crem.setMaxAge(0);
            } else {
                cuser.setMaxAge(20); // Số giây tồn tại của cookie
                cpass.setMaxAge(20); // Số giây tồn tại của cookie
                crem.setMaxAge(20); // Số giây tồn tại của cookie
            }
            //add vào browser
            response.addCookie(cuser);
            response.addCookie(cpass);
            response.addCookie(crem);

            response.sendRedirect("/realgroup2/home");
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
    }


}
