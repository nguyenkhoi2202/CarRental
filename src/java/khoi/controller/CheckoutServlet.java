/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoi.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import java.util.concurrent.TimeUnit;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khoi.dao.RentalDAO;
import khoi.dao.RentalDetailDAO;
import org.apache.log4j.Logger;

/**
 *
 * @author Administrator
 */
public class CheckoutServlet extends HttpServlet {

    private final String HOME_PAGE = "LoadCarUserServlet";
    private final String PAYMENT_PAGE = "payment.jsp";
    private final String VIEWCART_PAGE = "viewCart.jsp";

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
        response.setContentType("text/html;charset=UTF-8");
        String url = PAYMENT_PAGE;
        try {
            HttpSession session = request.getSession(false);
            
            String cusName = request.getParameter("txtCusName");
            float totalprice = Float.parseFloat(request.getParameter("txtTotalPrice"));
            RentalDAO dao = new RentalDAO();
            int result = 0;
            int result1 = 0;
            String[] listCarName = request.getParameterValues("txtCarName");
            String[] listCarID = request.getParameterValues("txtCarID");
            String DateBegin = request.getParameter("txtDateBegin");
            String DateEnd = request.getParameter("txtDateEnd");
            Date date1 =  Date.valueOf(DateBegin);
            Date date2 = Date.valueOf(DateEnd);
            long daysDiff = date2.getTime() - date1.getTime();
            long totalDate = TimeUnit.MILLISECONDS.toDays(daysDiff);
            String[] listQuantity = request.getParameterValues("txtquantity");
            String[] listPrice = request.getParameterValues("txtPrice");
            result = dao.createCarRental(cusName, totalprice, DateBegin, DateEnd, totalDate);
            for (int i = 0; i < listCarName.length; i++) {
                int rentalID = RentalDAO.getOrderid(cusName);
                String carName = listCarName[i];
                String carID = listCarID[i];
                int quantity = Integer.parseInt(listQuantity[i]);
                float price = Float.parseFloat(listPrice[i]);
                int quantityKho = RentalDAO.getQuantity(carName);
                if (quantityKho >= quantity) {
                    RentalDAO.updateQuantity(carName,RentalDAO.getQuantity(carName)- quantity);
                    result1 = RentalDetailDAO.createCarRentalDetail(rentalID,carID, carName, quantity, price);
                    if (result > 0 && result1 > 0) {
                        url = HOME_PAGE;
                        session.removeAttribute("CUSTCART");
                    }
                } else {
                    request.setAttribute("OVER", "The product is out of stock. You must be buy less than " + (quantityKho + 1));
                    url = VIEWCART_PAGE;
                }
            }
        }catch (SQLException | NamingException ex) {
            Logger.getLogger(CheckoutServlet.class).error("Error at CheckoutServlet " + ex.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
