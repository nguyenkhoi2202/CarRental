/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoi.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khoi.dao.RentalDAO;

/**
 *
 * @author Administrator
 */
public class PayMentServlet extends HttpServlet {

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
        String url = VIEWCART_PAGE;
        try {
             String discount = request.getParameter("txtDiscount");
            String DateBegin = request.getParameter("txtDateBegin");
            String DateEnd = request.getParameter("txtDateEnd");
            Date date1 = Date.valueOf(DateBegin);
            Date date2 = Date.valueOf(DateEnd);
            long daysDiff = date2.getTime() - date1.getTime();
            long totalDate = TimeUnit.MILLISECONDS.toDays(daysDiff);
            
            HttpSession session = request.getSession();
            String[] listCarName = request.getParameterValues("txtCarName");
            String[] listCarID = request.getParameterValues("txtCarID");
            String[] listQuantity = request.getParameterValues("txtquantity");
            String[] listPrice = request.getParameterValues("txtPrice");        
            session.setAttribute("DATEBEGIN", DateBegin);
            session.setAttribute("DATEEND", DateEnd);
            session.setAttribute("TOTALDATE1", totalDate);
            session.setAttribute("LISTCAR", listCarName);
            session.setAttribute("LISTCARID", listCarID);
            session.setAttribute("LISTQUANTITY", listQuantity);
            session.setAttribute("LISTPRICE", listPrice);
            if (discount.isEmpty()) {
                request.setAttribute("TOTALDATE", totalDate);
                request.setAttribute("NOTDISCOUNT", "NOTDISCOUNT");
                url = PAYMENT_PAGE;
            } else {
                String discountDB = RentalDAO.getDiscount(discount);
                if (!discountDB.isEmpty()) {
                    request.setAttribute("TOTALDATE", totalDate);
                    url = PAYMENT_PAGE;
                } else {
                    request.setAttribute("DISCOUNTERR", "Discount of you not invalid!!!");
                    url = VIEWCART_PAGE;
                }
            }
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(PayMentServlet.class.getName()).log(Level.SEVERE, null, ex);
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
