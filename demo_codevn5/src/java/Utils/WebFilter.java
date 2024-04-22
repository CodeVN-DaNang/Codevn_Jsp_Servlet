/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author codevn
 */
@javax.servlet.annotation.WebFilter("/hello")
public class WebFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpSession session = ((HttpServletRequest) request).getSession();

//        if (session.getAttribute("hello") == null) {
//            RequestDispatcher dispatcher = request.getRequestDispatcher("Hello1.jsp");
//            dispatcher.forward(request, response);
//            return;
//        }
        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        for (Cookie cooky : cookies) {
            if (cooky.getName().equals("hello")) {
                chain.doFilter(request, response);
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Hello1.jsp");
        dispatcher.forward(request, response);
    }

}
