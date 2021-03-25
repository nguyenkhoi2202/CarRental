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
import khoi.dto.RentalDTO;
import khoi.dto.RentalDetailDTO;

/**
 *
 * @author Administrator
 */
public class RentalDAO implements Serializable {

    public static int updateQuantity(String carName, int quantity) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "update tblCars set quantity = ? where carName = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, quantity);
                ps.setString(2, carName);
                int result = ps.executeUpdate();
                return result;
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

    public int createCarRental(String username, float totalPrice, String DateBegin, String DateEnd, long totalDate) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "INSERT INTO [dbo].[tblRentals]\n"
                        + "           ([userName]\n"
                        + "           ,[totalPrice]\n"
                        + "           ,[checkin]\n"
                        + "           ,[checkout]\n"
                        + "           ,[bookDate]\n"
                        + "           ,[status])\n"
                        + "     VALUES\n"
                        + "           (?,?,?,?,?,1)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setFloat(2, totalPrice);
                ps.setString(3, DateBegin);
                ps.setString(4, DateEnd);
                ps.setLong(5, totalDate);
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

    public static int getOrderid(String username) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "SELECT TOP 1 * FROM tblRentals where userName = ? ORDER BY [rentalID] DESC ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                rs = ps.executeQuery();
                if (rs.next()) {
                    int orderid = rs.getInt("rentalID");
                    return orderid;
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

    public List<RentalDTO> getAllRental(String username) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "SELECT [rentalID]\n"
                        + "      ,[userName]\n"
                        + "      ,[totalPrice]\n"
                        + "      ,[checkin]\n"
                        + "      ,[checkout]\n"
                        + "      ,[bookDate]\n"
                        + "  FROM [dbo].[tblRentals]\n"
                        + "  where userName = ? and status = 1";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                rs = ps.executeQuery();
                List<RentalDTO> list = new ArrayList<>();
                while (rs.next()) {
                    RentalDTO dto = new RentalDTO(rs.getString("rentalID"), rs.getString("userName"), rs.getFloat("totalPrice"), rs.getString("checkin"),
                            rs.getString("checkout"), rs.getInt("bookDate"));
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

    public static List<RentalDTO> searchHistoryByDate(String username, String dateSearch) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "SELECT [rentalID]\n"
                        + "      ,[userName]\n"
                        + "      ,[totalPrice]\n"
                        + "      ,[checkin]\n"
                        + "      ,[checkout]\n"
                        + "      ,[bookDate]\n"
                        + "  FROM [dbo].[tblRentals]\n"
                        + "  where userName = ? and checkin = ? and status = 1";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, dateSearch);
                rs = ps.executeQuery();
                List<RentalDTO> list = new ArrayList<>();
                while (rs.next()) {
                    RentalDTO dto = new RentalDTO(rs.getString("rentalID"), rs.getString("userName"), rs.getFloat("totalPrice"), rs.getString("checkin"),
                            rs.getString("checkout"), rs.getInt("bookDate"));
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

    public static List<RentalDetailDTO> searchHistoryByNameCar(String nameCar) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "SELECT [detailID]\n"
                        + "      ,[rentalID]\n"
                        + "      ,[carID]\n"
                        + "      ,[carName]\n"
                        + "      ,[quantity]\n"
                        + "      ,[price]\n"
                        + "  FROM [dbo].[tblRentalDetails]\n"
                        + "  where carName like ? and status = 1";
                ps = conn.prepareStatement(sql);
                ps.setString(1, nameCar);
                rs = ps.executeQuery();
                List<RentalDetailDTO> list = new ArrayList<>();
                while (rs.next()) {
                    RentalDetailDTO dto = new RentalDetailDTO(rs.getInt("rentalID"), rs.getString("carID"), rs.getString("carName"), rs.getInt("quantity"), rs.getFloat("price"));
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

    public static String getDiscount(String discount) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "SELECT [discount]\n"
                        + "      ,[dateEnd]\n"
                        + "  FROM [dbo].[tblDiscounts]\n"
                        + "  where discount = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, discount);
                rs = ps.executeQuery();
                String discountDB = "";
                if (rs.next()) {
                    discountDB = rs.getString("discount");
                }
                return discountDB;
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

    public int deleteHistory(String username, String rentalID) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "DELETE FROM [dbo].[tblRentals]\n"
                        + "   WHERE userName = ? and rentalID = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, rentalID);
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

    public int deleteHistoryDetail(String rentalID) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "DELETE FROM [dbo].[tblRentalDetails]\n"
                        + "      WHERE rentalID = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, rentalID);
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
