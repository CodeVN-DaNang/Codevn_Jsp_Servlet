/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

/**
 *
 * @author codevn
 */
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class RequestCountFilter implements Filter {
    private int count;

    public void init(FilterConfig config) throws ServletException {
        // Initialize count to 0 when the filter is first created.
        count = 0;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Increment count for each request
        count++;

        // Pass request along the filter chain
        chain.doFilter(request, response);
    }

    public void destroy() {
        // Output the count when the filter is destroyed.
        System.out.println("Total Requests: " + count);
    }
}

