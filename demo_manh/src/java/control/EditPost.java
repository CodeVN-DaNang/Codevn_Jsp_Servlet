package control;

import dao.DAO;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Post;
import model.User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author codevn
 */
@WebServlet("/editPost")
public class EditPost extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int post_id = 0;
        try {
            post_id = Integer.parseInt(request.getParameter("post_id"));
        } catch (Exception e) {
        }
        DAO dao = new DAO();
        Post post = dao.getPostById(post_id);
        request.setAttribute("post_title", post.getPost_title());
        request.setAttribute("post_description", post.getPost_description());
        request.setAttribute("post_tag", post.getPost_tag());
        request.setAttribute("post_img", post.getPost_img());
        request.getRequestDispatcher("EditPost.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = null;
        if (session.getAttribute("account") != null) {
            user = (User) session.getAttribute("account");
        }
        int post_id = Integer.parseInt(request.getParameter("post_id"));
        String postTitle = request.getParameter("post_title");
        String postDescription = request.getParameter("post_description");
        String postTag = request.getParameter("post_tag");
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String importDate = localDate.format(formatter);
        DAO dao = new DAO();
        Post post = new Post(0, postTitle, postDescription, dao.getPostById(post_id).getPost_img(), importDate, postTag, user);
        dao.updatePost(post);
    }
}
