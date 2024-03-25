/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Comment;
import model.Post;
import model.User;

@WebServlet(name = "AddReviewControl", urlPatterns = {"/addReview"})
public class AddReviewControl extends HttpServlet {

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
        String url = request.getServletPath();
        HttpSession session = request.getSession();
        User a = (User) session.getAttribute("account");
        if (a == null) {
            response.sendRedirect(url);
            return;
        }
        int accountID = a.getUser_id();
        String contentReview = request.getParameter("contentReview");
        int postId = Integer.parseInt(request.getParameter("post_id"));
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String importDate = localDate.format(formatter);
        DAO dao = new DAO();
        
        Post post = dao.getPostById(postId);
        Comment cmt = new Comment(0, contentReview, importDate, a, post);
        
        dao.addComment(cmt);
        cmt = dao.getCommentLast();
        PrintWriter out = response.getWriter();

        out.println(" <div class=\"media mt-3 mb-4\">\r\n"
                + "              <img class=\"d-flex mr-3 z-depth-1\" src=\"https://mdbootstrap.com/img/Photos/Others/placeholder1.jpg\"\r\n"
                + "                width=\"62\" alt=\"Generic placeholder image\">\r\n"
                + "              <div class=\"media-body\">\r\n"
                + "                <div class=\"d-flex justify-content-between\">\r\n"
                + "                  <p class=\"mt-1 mb-2\">\r\n"
                + "                    <strong>" + a.getUser_fullname() + "</strong>\r\n"
                + "                    <span>� </span><span>" + cmt.getCmt_time() + "</span>\r\n"
                + "                  </p>\r\n"
                + "                </div>\r\n"
                + "                <p class=\"mb-0\">" + cmt.getCmt_content() + "</p>\r\n"
                + "              </div>\r\n"
                + "<c:if test=\"${(sessionScope.account.user_id == cmt.user.user_id) || (sessionScope.account.user_id == post_user_id)}\">\n"
                + "\n"
                + "                                        <div>\n"
                + "                                            <span><a class=\"btn btn-outline-danger\" href=\"http://localhost:8080/demo_manh/deleteComment?cmt_id="+cmt.getCmt_id() +"\">delete</a></span>\n"
                + "                                        </div>\n"
                + "                                    </c:if>"
                + "            </div>\r\n"
                + "            <hr>    ");
        System.out.println("hello");
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
        processRequest(request, response);
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
