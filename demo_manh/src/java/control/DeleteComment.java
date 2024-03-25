/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.DAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Comment;
import model.User;

/**
 *
 * @author codevn
 */
@WebServlet("/deleteComment")
public class DeleteComment extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String url = request.getServletPath();
        User user = null;
        if (session.getAttribute("account") != null) {
            user = (User) session.getAttribute("account");
        }
        
        int cmt_id = Integer.parseInt(request.getParameter("cmt_id"));
        
        DAO dao = new DAO();
        int post_id = dao.getCommentById(cmt_id).getPost().getPost_id();
        System.out.println(dao.getCommentById(cmt_id).toString());
        dao.deleteComment(cmt_id);
        
        response.sendRedirect("/demo_manh/post?post_id=" + post_id);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}