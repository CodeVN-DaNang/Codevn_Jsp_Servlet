/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author codevn
 */
@WebFilter("/*")
public class JavaFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session  = ((HttpServletRequest) request).getSession();
        int count = 0;
        if (session.getAttribute("count") != null) {
            count = (int) session.getAttribute("count");
            
        }
        count++;
        session.setAttribute("count", count);
        ((HttpServletRequest) request).setAttribute("count", count);
        chain.doFilter(request, response);
    }
    
}
