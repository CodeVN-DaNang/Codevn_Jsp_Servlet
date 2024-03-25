/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package filter;

import dao.DAO;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Comment;
import model.User;

/**
 *
 * @author codevn
 */
@WebFilter({"/deleteComment"})
public class CommentFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        if (session.getAttribute("account") == null) {
            ((HttpServletResponse) response).sendRedirect("DenyAccess.jsp");
            return;
        }
        User user = (User) session.getAttribute("account");
        int cmt_id = 0;
        try {
            cmt_id = Integer.parseInt(((HttpServletRequest) request).getParameter("cmt_id"));
        } catch (Exception e) {
        }
        Comment cmt = (new DAO()).getCommentById(cmt_id);
        if (user.getUser_id() != cmt.getUser().getUser_id() && user.getUser_id() != cmt.getPost().getUser().getUser_id()) {
            ((HttpServletResponse) response).sendRedirect("DenyAccess.jsp");
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
