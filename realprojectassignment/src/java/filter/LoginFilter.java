/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import entity.User;
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
import utils.CheckPermission;

/**
 *
 * @author codevn
 */
//Addaccount
//Add
//Deleteaccount
//Delete
//Doanhthutheothang
//
//Doanhthutheothu
//Edit
//Manageraccount
//Manager
//Admin
//Top10
//Top5khachhang
//Top5nhanvien
@WebFilter({"/admin", "/addAccount", "/add", "/deleteAccount", "/delete", "/doanhThuTheoThang", "/doanhThuTheoThu", "/edit", "/managerAccount", "/manager", "/top10", "/top5KhachHang", "/top5NhanVien"})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (new CheckPermission().checkAdmin((HttpServletRequest) request)) {
            ((HttpServletResponse) response).sendRedirect("/realgroup2/deny");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
