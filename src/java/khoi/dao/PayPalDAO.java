/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoi.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import khoi.connection.DBContext;

/**
 *
 * @author Administrator
 */
public class PayPalDAO implements Serializable {

    public static int payPalCarRental(String username, String date, float price) throws SQLException, NamingException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new DBContext().makeConnection();
            if (conn != null) {
                String sql = "INSERT INTO [dbo].[tblPayPal]\n"
                        + "           ([userName]\n"
                        + "           ,[dateBuy]\n"
                        + "           ,[price])\n"
                        + "     VALUES\n"
                        + "           (?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, date);
                ps.setFloat(3, price);
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
