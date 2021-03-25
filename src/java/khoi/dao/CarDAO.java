/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoi.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import khoi.connection.DBContext;
import khoi.dto.CarDTO;
import khoi.dto.CategoryDTO;

/**
 *
 * @author Administrator
 */
public class CarDAO implements Serializable {

    public static List<CarDTO> getListCarPaing(int pageIndex, int pageSize) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "SELECT [carID]\n"
                        + "      ,[carName]\n"
                        + "      ,[imageSrc]\n"
                        + "      ,[color]\n"
                        + "      ,[year]\n"
                        + "      ,[categoryID]\n"
                        + "      ,[price]\n"
                        + "      ,[quantity]\n"
                        + "      ,[description]\n"
                        + "  FROM [dbo].[tblCars] ORDER BY carID "
                        + "OFFSET (?*?-?) ROWS FETCH NEXT ? ROWS ONLY";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, pageIndex);
                ps.setInt(2, pageSize);
                ps.setInt(3, pageSize);
                ps.setInt(4, pageSize);
                rs = ps.executeQuery();
                List<CarDTO> list = new ArrayList<>();
                while (rs.next()) {
                    CarDTO car = new CarDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                            rs.getString(5), rs.getString(6), rs.getFloat(7), rs.getInt(8), rs.getString(9));
                    list.add(car);
                }
                return list;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    public static int countPage(int pageSize) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "select Count(*) from tblCars";

            conn = new DBContext().makeConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }
            int numOfPage = count / pageSize;
            if (count % pageSize != 0) {
                numOfPage++;
            }
            return numOfPage;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static List<CategoryDTO> getAllCategory() throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "SELECT [categoryID]\n"
                        + "      ,[categoryName]\n"
                        + "  FROM [dbo].[tblCategoris]";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                List<CategoryDTO> list = new ArrayList<>();
                while (rs.next()) {
                    CategoryDTO dto = new CategoryDTO(rs.getString(1), rs.getString(2));
                    list.add(dto);
                }
                return list;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    public static List<CarDTO> searchCarByName(String searchValue, int pageIndex, int PAGE_SIZE) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBContext.makeConnection();
            if (con != null) {
                String sql = "SELECT [carID]\n"
                        + "      ,[carName]\n"
                        + "      ,[imageSrc]\n"
                        + "      ,[color]\n"
                        + "      ,[year]\n"
                        + "      ,[categoryID]\n"
                        + "      ,[price]\n"
                        + "      ,[quantity]\n"
                        + "      ,[description]\n"
                        + "  FROM [dbo].[tblCars]\n"
                        + "  where carName like  ?  ORDER BY carID \n"
                        + "                         OFFSET (?*?-?) ROWS FETCH NEXT ? ROWS ONLY";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + searchValue + "%");
                ps.setInt(2, pageIndex);
                ps.setInt(3, PAGE_SIZE);
                ps.setInt(4, PAGE_SIZE);
                ps.setInt(5, PAGE_SIZE);
                rs = ps.executeQuery();
                List<CarDTO> list = new ArrayList<>();
                while (rs.next()) {
                    CarDTO car = new CarDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                            rs.getString(5), rs.getString(6), rs.getFloat(7), rs.getInt(8), rs.getString(9));
                    list.add(car);
                }
                return list;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public List<CarDTO> searchCarByCategory(String categoryCar, int pageIndex, int PAGE_SIZE) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBContext.makeConnection();
            if (con != null) {
                String sql = "SELECT [carID]\n"
                        + "      ,[carName]\n"
                        + "      ,[imageSrc]\n"
                        + "      ,[color]\n"
                        + "      ,[year]\n"
                        + "      ,[categoryID]\n"
                        + "      ,[price]\n"
                        + "      ,[quantity]\n"
                        + "      ,[description]\n"
                        + "  FROM [dbo].[tblCars]\n"
                        + "  where categoryID like ? ORDER BY carID "
                        + "OFFSET (?*?-?) ROWS FETCH NEXT ? ROWS ONLY";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + categoryCar + "%");
                ps.setInt(2, pageIndex);
                ps.setInt(3, PAGE_SIZE);
                ps.setInt(4, PAGE_SIZE);
                ps.setInt(5, PAGE_SIZE);
                rs = ps.executeQuery();
                List<CarDTO> list = new ArrayList<>();
                while (rs.next()) {
                    CarDTO car = new CarDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                            rs.getString(5), rs.getString(6), rs.getFloat(7), rs.getInt(8), rs.getString(9));
                    list.add(car);
                }
                return list;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public List<CarDTO> searchCarByAll(String categoryCar, String searchValue) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBContext.makeConnection();
            if (con != null) {
                String sql = "SELECT [carID]\n"
                        + "      ,[carName]\n"
                        + "      ,[imageSrc]\n"
                        + "      ,[color]\n"
                        + "      ,[year]\n"
                        + "      ,[categoryID]\n"
                        + "      ,[price]\n"
                        + "      ,[quantity]\n"
                        + "      ,[description]\n"
                        + "  FROM [dbo].[tblCars]\n"
                        + "  where categoryID like ? and carName like ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + categoryCar + "%");
                ps.setString(2, "%" + searchValue + "%");
                rs = ps.executeQuery();
                List<CarDTO> list = new ArrayList<>();
                while (rs.next()) {
                    CarDTO car = new CarDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                            rs.getString(5), rs.getString(6), rs.getFloat(7), rs.getInt(8), rs.getString(9));
                    list.add(car);
                }
                return list;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public static int getQuantity(String name) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "select quantity from tblCars where carName = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                rs = ps.executeQuery();

                while (rs.next()) {
                    int result = rs.getInt("quantity");
                    return result;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return 0;
    }

    public static int rateCar(String username, String carName, String rate) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "INSERT INTO [dbo].[tblRates]\n"
                        + "           ([userName]\n"
                        + "           ,[carName]\n"
                        + "           ,[rate])\n"
                        + "     VALUES\n"
                        + "           (?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, carName);
                ps.setString(3, rate);
                return ps.executeUpdate();
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return 0;
    }
}
