/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import entity.Invoice;
import entity.Product;
import entity.Review;
import entity.Role;
import entity.SoLuongDaBan;
import entity.TongChiTieuBanHang;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SoLuongDaBan> getTop10SanPhamBanChay() {
        List<SoLuongDaBan> list = new ArrayList<>();
        String query = "select top(10) *\r\n"
                + "from SoLuongDaBan\r\n"
                + "order by soLuongDaBan desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SoLuongDaBan(rs.getInt(1),
                        rs.getInt(2)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
//    

    public int countAllProductBySellID(int sell_ID) {
        String query = "select count(*) from Product where sell_ID=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, sell_ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getSellIDByProductID(int productID) {
        String query = "select sell_ID\r\n"
                + "from Product\r\n"
                + "where [id]=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public double totalMoneyDay(int day) {
        String query = "select \r\n"
                + "	SUM(tongGia) \r\n"
                + "from Invoice\r\n"
                + "where DATEPART(dw,[ngayXuat]) = ?\r\n"
                + "Group by ngayXuat ";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, day);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public double totalMoneyMonth(int month) {
        String query = "select SUM(tongGia) from Invoice\r\n"
                + "where MONTH(ngayXuat)=?\r\n"
                + "Group by MONTH(ngayXuat)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, month);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int countAllProduct() {
        String query = "select count(*) from Product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public double sumAllInvoice() {
        String query = "select SUM(tongGia) from Invoice";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int countAllReview() {
        String query = "select count(*) from Review";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getCateIDByProductID(String id) {
        String query = "select [cateID] from Product\r\n"
                + "where [id] =?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public ArrayList<Role> getAllRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        String query = "select * from role";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                roles.add(new Role(rs.getInt(1), rs.getNString(2)));
            }

        } catch (Exception e) {
        }
        return roles;
    }

    public Role getRoleById(int role_id) {

        String query = "select * from role where role_id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, role_id);
            rs = ps.executeQuery();
            rs.next();
            return new Role(rs.getInt(1), rs.getString(2));

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public User login(String user, String pass) {
        String query = "select * from [user]\n"
                + "where username = ?\n"
                + "and password = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        getRoleById(rs.getInt(9)));
            }
            ps.close();
        } catch (Exception e) {
        }
        return null;
    }
//

    public User checkAccountExist(String user) {
        String query = "select * from user\n"
                + "where [username] = ?\n";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        getRoleById(rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return null;
    }
//    

    public User checkAccountExistByUsernameAndEmail(String username, String email) {
        String query = "select * from user where [username]=? and [email]=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        getRoleById(rs.getInt(9)));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<User> getAllAccount() {
        List<User> list = new ArrayList<>();
        List<Role> roles = getAllRoles();
        String query = "select * from [user] join [role] on [user].role_id = [role].role_id;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        new Role(rs.getInt(9), rs.getString(11))));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }


    public List<TongChiTieuBanHang> getTop5KhachHang() {
        List<TongChiTieuBanHang> list = new ArrayList<>();
        String query = "select top(5) *\r\n"
                + "from TongChiTieuBanHang\r\n"
                + "order by TongChiTieu desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TongChiTieuBanHang(rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDouble(3)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<TongChiTieuBanHang> getTop5NhanVien() {
        List<TongChiTieuBanHang> list = new ArrayList<>();
        String query = "select top(5) *\r\n"
                + "from TongChiTieuBanHang\r\n"
                + "order by TongBanHang desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TongChiTieuBanHang(rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDouble(3)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getTop3() {
        List<Product> list = new ArrayList<>();
        String query = "select top 3 * from Product";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getNext3Product(int amount) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT *\n"
                + "  FROM Product\n"
                + " ORDER BY id\n"
                + "OFFSET ? ROWS\n"
                + " FETCH NEXT 3 ROWS ONLY";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, amount);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getNext4NikeProduct(int amount) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\r\n"
                + "where cateID=2\r\n"
                + "order by id desc\r\n"
                + "offset ? rows\r\n"
                + "fetch next 4 rows only";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, amount);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getNext4AdidasProduct(int amount) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\r\n"
                + "where cateID=1\r\n"
                + "order by id desc\r\n"
                + "offset ? rows\r\n"
                + "fetch next 4 rows only";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, amount);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\n"
                + "where cateID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductBySellIDAndIndex(int id, int indexPage) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product \r\n"
                + "where sell_ID = ?\r\n"
                + "order by [id]\r\n"
                + "offset ? rows\r\n"
                + "fetch next 5 rows only";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, (indexPage - 1) * 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByIndex(int indexPage) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product \r\n"
                + "order by [id]\r\n"
                + "offset ? rows\r\n"
                + "fetch next 9 rows only";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, (indexPage - 1) * 9);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\n"
                + "where [name] like ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Invoice> searchByNgayXuat(String ngayXuat) {
        List<Invoice> list = new ArrayList<>();
        String query = "select * from Invoice\r\n"
                + "where [ngayXuat] ='" + ngayXuat + "'";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
//            ps.setString(1,ngayXuat);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Invoice(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchPriceUnder100() {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\r\n"
                + "where [price] < 30.0";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchPrice100To200() {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\r\n"
                + "where [price] >= 30.0 and [price]<=50.0";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchColorWhite() {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\r\n"
                + "where color = '%TRẮNG%'";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchColorGray() {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\r\n"
                + "where color = '%XÁM%'";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchColorBlack() {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\r\n"
                + "where color = '%ĐEN%'";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchColorYellow() {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\r\n"
                + "where color = '%VÀNG%'";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchByPriceMinToMax(String priceMin, String priceMax) {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\r\n"
                + "where [price] >= ? and [price]<=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, priceMin);
            ps.setString(2, priceMax);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchPriceAbove200() {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\r\n"
                + "where [price] > 50.0";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getRelatedProduct(int cateIDProductDetail) {
        List<Product> list = new ArrayList<>();
        String query = "select top 4 * from product\r\n"
                + "where [cateID] =?\r\n"
                + "order by id desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, cateIDProductDetail);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Review> getAllReviewByProductID(String productId) {
        List<Review> list = new ArrayList<>();
        String query = "select * from Review\r\n"
                + "where [productID] =?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Review(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductByID(String id) {
        String query = "select * from Product\n"
                + "where id = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14));
            }
        } catch (Exception e) {
        }
        return null;
    }

//    
    public int checkRoleUser(int userID) {

        String query = "select role_id from user where [userId]=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);

            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }
//    

    public TongChiTieuBanHang checkTongChiTieuBanHangExist(int userID) {

        String query = "select * from TongChiTieuBanHang where [userID]=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new TongChiTieuBanHang(rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDouble(3)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }
//    

    public SoLuongDaBan checkSoLuongDaBanExist(int productID) {

        String query = "select * from SoLuongDaBan where productID = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, productID);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new SoLuongDaBan(rs.getInt(1),
                        rs.getInt(2)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }
//    
//    
//    

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
//    
//

    public Product getLast() {
        String query = "select top 1 * from Product\n"
                + "order by id desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Product> get8Last() {
        List<Product> list = new ArrayList<>();
        String query = "select top 8 * from Product order by id desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> get4MotorHondaLast() {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\r\n"
                + "where model like 'HD%'\r\n"
                + "order by id desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> get4MotorYamahaLast() {
        List<Product> list = new ArrayList<>();
        String query = "select * from Product\r\n"
                + "where model like 'YMH%'\r\n"
                + "order by id desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

//    
    public Review getNewReview(int accountID, int productID) {
        String query = "select top 1 * from Review\r\n"
                + "where accountID = ? and productID = ?\r\n"
                + "order by maReview desc";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Review(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDate(4));
            }
        } catch (Exception e) {
        }
        return null;
    }
//

    public void singup(User user) {
        String query = "insert into [User](fullname, user_phone, user_email, user_identity, user_address, username, password, role_id) values(?,?,?,?,?,?,?,3)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getUser_phone());
            ps.setString(3, user.getUser_email());
            ps.setString(4, user.getUser_identity());
            ps.setString(5, user.getUser_address());
            ps.setString(6, user.getUsername());
            ps.setString(7, user.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//

    public void deleteInvoiceByAccountId(String id) {
        String query = "delete from Invoice\n"
                + "where [userid] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//    

    public void deleteTongChiTieuBanHangByUserID(String id) {
        String query = "delete from TongChiTieuBanHang\n"
                + "where [userID] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//    
//    

    public void deleteProduct(String pid) {
        String query = "delete from Product\n"
                + "where [id] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//    

    public void deleteProductBySellID(String id) {
        String query = "delete from Product\n"
                + "where [sell_ID] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//    

//    
//    
    public void deleteSoLuongDaBanByProductID(String productID) {
        String query = "delete from SoLuongDaBan where [productID]=?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//    

    public void deleteReviewByProductID(String productID) {
        String query = "delete from Review where [productID] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, productID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//    

    public void deleteReviewByAccountID(String id) {
        String query = "delete from Review where [accountID] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//    

    public void deleteAccount(String id) {
        String query = "delete from User where userId= ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//      

//
    public void insertProduct(String name, String image, String price,
            String title, String description, String category, int sid, String model, String color, String delivery, String image2, String image3, String image4) {
        String query = "insert Product([name],[image],[price],[title],\r\n"
                + "[description],[cateID],[sell_ID],[model],\r\n"
                + "[color],[delivery],[image2],[image3],[image4])\r\n"
                + "values(N'" + name + "','" + image + "','" + price + "',N'" + title + "',N'" + description + "','" + category + "','" + sid + "',N'" + model + "',N'" + color + "',N'" + delivery + "','" + image2 + "','" + image3 + "','" + image4 + "')";
        try {

            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            /*
			 * ps.setString(1, name); ps.setString(2, image); ps.setString(3, price);
			 * ps.setString(4, title); ps.setString(5, description); ps.setString(6,
			 * category); ps.setInt(7, sid); ps.setString(8, model); ps.setString(9, color);
			 * ps.setString(10, delivery); ps.setString(11, image2); ps.setString(12,
			 * image3); ps.setString(13, image4);
             */
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
//    

    public void insertAccount(User user) {
        String query = "insert user\n"
                + "values(?,?,?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getUser_phone());
            ps.setString(3, user.getUser_email());
            ps.setString(4, user.getUser_identity());
            ps.setString(5, user.getUser_address());
            ps.setString(6, user.getUsername());
            ps.setString(7, user.getPassword());
            ps.setInt(8, user.getRole_id().getRole_id());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//    

    public void insertTongChiTieuBanHang(int userID, double tongChiTieu, double tongBanHang) {
        String query = "insert TongChiTieuBanHang(userID,TongChiTieu,TongBanHang)\r\n"
                + "values(?,?,?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setDouble(2, tongChiTieu);
            ps.setDouble(3, tongBanHang);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//    

    public void insertSoLuongDaBan(int productID, int soLuongDaBan) {
        String query = "insert SoLuongDaBan(productID,soLuongDaBan)\r\n"
                + "values(?,?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, productID);
            ps.setInt(2, soLuongDaBan);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//    
 

    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
//  

    public void insertReview(int accountID, int productID, String contentReview) {
        String query = "insert Review(accountID, productID, contentReview, dateReview)\r\n"
                + "values(?,?,?,?)";

        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setInt(2, productID);
            ps.setString(3, contentReview);
            ps.setDate(4, getCurrentDate());
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }
//    

    public void insertInvoice(int accountID, double tongGia) {
        String query = "insert Invoice(accountID,tongGia,ngayXuat)\r\n"
                + "values(?,?,?)";

        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setDouble(2, tongGia);
            ps.setDate(3, getCurrentDate());
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
//    

//
    public void editProduct(String pname, String pimage, String pprice, String ptitle, String pdescription, String pcategory,
            String pmodel, String pcolor,
            String pdelivery, String pimage2, String pimage3, String pimage4, String pid) {
        String query = "update Product\r\n"
                + "set [name] = ?,\r\n"
                + "[image] = ?,\r\n"
                + "price = ?,\r\n"
                + "title = ?,\r\n"
                + "[description] = ?,\r\n"
                + "cateID = ?,\r\n"
                + "model= ?,\r\n"
                + "color= ?,\r\n"
                + "delivery=?,\r\n"
                + "image2=?,\r\n"
                + "image3=?,\r\n"
                + "image4=?\r\n"
                + "where [id] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, pname);
            ps.setString(2, pimage);
            ps.setString(3, pprice);
            ps.setString(4, ptitle);
            ps.setString(5, pdescription);
            ps.setString(6, pcategory);
            ps.setString(7, pmodel);
            ps.setString(8, pcolor);
            ps.setString(9, pdelivery);
            ps.setString(10, pimage2);
            ps.setString(11, pimage3);
            ps.setString(12, pimage4);
            ps.setString(13, pid);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }

    public List<String> getAllCategories() throws SQLException {
        List<String> categories = new ArrayList<>();
        String sql = "SELECT category_name FROM category";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            categories.add(result.getString("category_name"));
        }
        return categories;
    }

    public String getCategoryNameById(int id) throws SQLException {
        String sql = "SELECT category_name FROM category WHERE category_id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return result.getString("category_name");
        } else {
            throw new SQLException("No category found with id " + id);
        }
    }

    public int getCategoryIdByName(String name) throws SQLException {
        String sql = "SELECT category_id FROM category WHERE category_name = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, name);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return result.getInt("category_id");
        } else {
            throw new SQLException("No category found with name " + name);
        }
    }

    public void createCategory(String name) throws SQLException {
        String sql = "INSERT INTO category (category_name) VALUES (?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, name);
        statement.executeUpdate();
    }

    public void updateCategory(int id, String newName) throws SQLException {
        String sql = "UPDATE category SET category_name = ? WHERE category_id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, newName);
        statement.setInt(2, id);
        statement.executeUpdate();
    }

    public void deleteCategory(int id) throws SQLException {
        String sql = "DELETE FROM category WHERE category_id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
//    
//    

    public void editProfile(User user) {
        String query = "update [user] set fullname=?,"
                + "user_email=?,"
                + "user_address = ?,"
                + "user_identity=?,"
                + "user_phone=?,"
                + "username=?,\n"
                + "password=?,\r\n"
                + "role_id=?\r\n"
                + "where [user_ID] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, user.getFullname());
            ps.setString(2, user.getUser_email());
            ps.setString(3, user.getUser_address());
            ps.setString(4, user.getUser_identity());
            ps.setString(5, user.getUser_phone());
            ps.setString(6, user.getUsername());
            ps.setString(7, user.getPassword());
            ps.setInt(8, user.getRole_id().getRole_id());
            ps.setInt(9, user.getUser_id());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
//    

    public void editTongChiTieu(int accountID, double totalMoneyVAT) {
        String query = "exec dbo.proc_CapNhatTongChiTieu ?,?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountID);
            ps.setDouble(2, totalMoneyVAT);

            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
//    

    public void editSoLuongDaBan(int productID, int soLuongBanThem) {
        String query = "exec dbo.proc_CapNhatSoLuongDaBan ?,?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, productID);
            ps.setInt(2, soLuongBanThem);

            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
//    

    public void editTongBanHang(int sell_ID, double tongTienBanHangThem) {
        String query = "exec dbo.proc_CapNhatTongBanHang ?,?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, sell_ID);
            ps.setDouble(2, tongTienBanHangThem);

            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
//    

    public List<Invoice> getAllInvoice() {
        List<Invoice> list = new ArrayList<>();
        String query = "select * from Invoice";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Invoice(rs.getInt(1),
                        rs.getInt(2),
                        rs.getDouble(3),
                        rs.getDate(4)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
//    

    public ArrayList<Product> getTopSale() {
        ArrayList<Product> list = new ArrayList<>();
        String query = "SELECT TOP 10 p.*, COUNT(r.productID) AS TotalReviews\n"
                + "FROM Product p\n"
                + "LEFT JOIN Review r ON p.id = r.productID\n"
                + "GROUP BY p.id, p.name, p.image, p.price, p.title, p.description, p.cateID, p.sell_ID, p.model, p.color, p.delivery, p.image2, p.image3, p.image4\n"
                + "ORDER BY TotalReviews DESC;";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

}
