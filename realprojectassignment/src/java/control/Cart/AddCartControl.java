/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.Cart;

import dao.DAO;
// import entity.Cart;
import entity.Order;
import entity.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddCartControl", urlPatterns = {"/addCart"})
public class AddCartControl extends HttpServlet {

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
        HttpSession session = request.getSession();
        String productId = request.getParameter("pid");
        String amount = request.getParameter("quantity");
        ArrayList<Order> cart = new ArrayList<>();
        DAO dao = new DAO();
        int quantity = 1;
        if (amount != null) {
            quantity = Integer.parseInt(amount);
        }
        if (session.getAttribute("cart") != null) {
            cart = (ArrayList) session.getAttribute("cart");

        }
        boolean flag = true;
        for (Order order : cart) {
            if (order.getProduct().getId() == Integer.parseInt(productId)) {
                order.setQuantity(order.getQuantity() + quantity);
                flag = false;
            }
        }
        if (flag) {
            cart.add(new Order(0, dao.getProductByID(productId), quantity));
        }
        session.setAttribute("cart", cart);
        System.out.println(cart.toString());
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
        HttpSession session = request.getSession();
        String productId = request.getParameter("pid");
        String amount = request.getParameter("quantity");
        ArrayList<Order> cart = new ArrayList<>();
        DAO dao = new DAO();
        int quantity = 1;
        if (amount != null) {
            quantity = Integer.parseInt(amount);
        }
        if (session.getAttribute("cart") != null) {
            cart = (ArrayList) session.getAttribute("cart");

        }
        boolean flag = true;
        for (Order order : cart) {
            if (order.getProduct().getId() == Integer.parseInt(productId)) {
                order.setQuantity(order.getQuantity() + quantity);
                flag = false;
            }
        }
        if (flag) {
            cart.add(new Order(0, dao.getProductByID(productId), quantity));
        }
        session.setAttribute("cart", cart);
        if (amount == null) {
            response.sendRedirect("/realgroup2/home");
            return;
        }
        response.sendRedirect("/realgroup2/detail?pid=" + productId);
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
