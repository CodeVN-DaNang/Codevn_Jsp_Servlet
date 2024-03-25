/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.MagazineDao;
import model.Magazine;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddMagazineServlet")
public class AddMagazineServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String maz_id = request.getParameter("maz_id");
            String magazine_title = request.getParameter("magazine_title");
            String publisher = request.getParameter("publisher");
            double price = Double.parseDouble(request.getParameter("price"));

            Magazine newMagazine = new Magazine(maz_id, magazine_title, publisher, price);

            MagazineDao magazineDao = new MagazineDao();

            magazineDao.newMagazine(newMagazine);

            response.sendRedirect("/PRJ321_DE170082/");
        } catch (Exception e) {

            request.setAttribute("errorMessage", "An error occurred while adding the magazine.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }
}
