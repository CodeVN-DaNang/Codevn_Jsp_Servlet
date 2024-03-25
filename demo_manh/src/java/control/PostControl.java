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
import model.Post;

/**
 *
 * @author codevn
 */
@WebServlet("/post")
public class PostControl extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int post_id = 0;
        Post post = null;
        try {
            post_id = Integer.parseInt(request.getParameter("post_id"));
        } catch (Exception e) {
            post = new Post();
        }
        DAO dao = new DAO();
        post = dao.getPostById(post_id);
        request.setAttribute("post_id", post.getPost_id());
        request.setAttribute("post_title", post.getPost_title());
        request.setAttribute("post_description", post.getPost_description());
        request.setAttribute("post_img", post.getPost_img());
        request.setAttribute("user_fullname", post.getUser().getUsername());
        request.setAttribute("post_user_id", post.getUser().getUser_id());
        request.setAttribute("listAllComment", dao.getAllCommentsByPost(post_id));
        
        request.getRequestDispatcher("Post.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
