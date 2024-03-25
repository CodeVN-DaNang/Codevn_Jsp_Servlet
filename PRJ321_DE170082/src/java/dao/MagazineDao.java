/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.Magazine;
import java.sql.*;

public class MagazineDao {

    DBContext db = new DBContext();

    public ArrayList<Magazine> getAll() {
        ArrayList<Magazine> mazList = new ArrayList<>();
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from PRJ321_DE170082");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maz_id = rs.getString("maz_id");
                String magazine_title = rs.getString("magazine_title");
                String publisher = rs.getString("publisher");
                double price = rs.getDouble("price");
                mazList.add(new Magazine(maz_id, magazine_title, publisher, price));
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return mazList;
    }

    public void newMagazine(Magazine magazine) {
        try {
            Connection conn = db.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into PRJ321_DE170082 values (?, ?, ?, ?)");
            ps.setString(1, magazine.getMaz_id());
            ps.setString(2, magazine.getMagazine_title());
            ps.setString(3, magazine.getPublisher());
            ps.setDouble(4, magazine.getPrice());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
