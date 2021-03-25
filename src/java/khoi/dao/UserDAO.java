/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoi.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.naming.NamingException;
import khoi.connection.DBContext;
import khoi.dto.UserDTO;

/**
 *
 * @author Administrator
 */
public class UserDAO implements Serializable {

    public UserDTO checkLogin(String username, String password) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "select userName, password, email, name,phone, address, status, roleID,createDate \n"
                        + "from tblUsers where userName = ? and password = ? and status = 1";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    UserDTO dto = new UserDTO(rs.getString("userName"), rs.getString("password"), rs.getString("email"),
                            rs.getString("name"), rs.getString("phone"), rs.getString("address"), rs.getInt("status"), rs.getString("roleID"), rs.getDate("createDate"));
                    return dto;
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
        return null;
    }

    public static void checkExist(String userName) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "select userName from tblUsers where userName = ? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, userName);
                rs = ps.executeQuery();
                if (rs.next()) {
                    ps.close();
                    conn.close();
                } else {
                    String insert = "INSERT INTO [dbo].[tblUsers]\n"
                            + "           ([userName]\n"
                            + "           ,[name]\n"
                            + "           ,[status]\n"
                            + "           ,[roleID]\n"
                            + "           ,[createDate])\n"
                            + "     VALUES\n"
                            + "           (?,?,?,?,?)";
                    ps = conn.prepareStatement(insert);
                    ps.setString(1, userName);
                    ps.setString(2, userName);
                    ps.setInt(3, 1);
                    ps.setString(4, "user");
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    ps.setString(5, sdf.format(date));
                    ps.executeUpdate();
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

    }

    public static boolean createAccount(String username, String password, String phone, String email, String name, String address) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBContext.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO [dbo].[tblUsers]\n"
                        + "           ([userName]\n"
                        + "           ,[password]\n"
                        + "           ,[email]\n"
                        + "           ,[name]\n"
                        + "           ,[phone]\n"
                        + "           ,[address]\n"
                        + "           ,[status]\n"
                        + "           ,[roleID]\n"
                        + "           ,[createDate])\n"
                        + "     VALUES\n"
                        + "           (?,?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, email);
                ps.setString(4, name);
                ps.setString(5, phone);
                ps.setString(6, address);
                ps.setInt(7, 0);
                ps.setString(8, "user");
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                ps.setString(9, sdf.format(date));
                int row = ps.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public static boolean changeStatus(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBContext.makeConnection();
            if (con != null) {
                String sql = "UPDATE [dbo].[tblUsers]\n"
                        + "   SET [status] = 1\n"
                        + "      \n"
                        + " WHERE userName = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, username);
                int row = ps.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }

        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
