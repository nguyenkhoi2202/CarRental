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
import khoi.dto.RentalDetailDTO;

/**
 *
 * @author Administrator
 */
public class RentalDetailDAO implements Serializable {

    public static int createCarRentalDetail(int rentalID, String carID,String carName, int quantity, float price) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "INSERT INTO [dbo].[tblRentalDetails]\n"
                        + "           ([rentalID]\n"
                        + "		   ,[carID]\n"
                        + "		   ,[carName]\n"
                        + "           ,[quantity]\n"
                        + "           ,[price])\n"
                        + "     VALUES\n"
                        + "           (?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, rentalID);
                ps.setString(2, carID);
                ps.setString(3, carName);
                ps.setInt(4, quantity);
                ps.setFloat(5, price);
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

    public List<RentalDetailDTO> getAllRentalDetail(int rentalID) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "SELECT [rentalID]\n"
                        + "      ,[carID]\n"
                        + "      ,[carName]\n"
                        + "      ,[quantity]\n"
                        + "      ,[price]\n"
                        + "  FROM [dbo].[tblRentalDetails]\n"
                        + "  where rentalID = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, rentalID);
                rs = ps.executeQuery();
                List<RentalDetailDTO> list = new ArrayList<>();
                while (rs.next()) {
                    RentalDetailDTO dto = new RentalDetailDTO(rs.getInt("rentalID"), rs.getString("carID"),rs.getString("carName"),
                            rs.getInt("quantity"), rs.getFloat("price"));
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
}
