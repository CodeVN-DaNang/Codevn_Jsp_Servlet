
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author codevn
 */
public class CartServlet extends HttpServlet {
    
    HttpSession session = null;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        session = request.getSession(true);
        String url = request.getServletPath();
        String productId = request.getParameter("productId");
        String str = request.getParameter("quantity");
        int quantity = 1;
        if (str != null) {
            quantity = Integer.parseInt(str);
        }
        ArrayList<Order> cart = (ArrayList) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        cart.add(new Order(cart.size(), false, new Product(productId, productId, 100, 100)));
        session.setAttribute("cart", cart);
        System.out.println(session.getAttribute("cart").toString());
        response.sendRedirect("/demo_cart");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
    }

}
