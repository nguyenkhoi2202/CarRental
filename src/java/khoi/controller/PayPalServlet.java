/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoi.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khoi.dao.PayPalDAO;
import khoi.dao.RentalDAO;
import khoi.dao.RentalDetailDAO;
import khoi.dto.UserDTO;

/**
 *
 * @author Administrator
 */
public class PayPalServlet extends HttpServlet {

    private final String USER_PAGE = "LoadCarUserServlet";
    private final String PAY_ERROR = "paypal.jsp";
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
        String url = PAY_ERROR;
        try {
            float priceTotal = Float.parseFloat(request.getParameter("vnp_Amount")) / 2300000;
            String date = request.getParameter("vnp_PayDate");
            HttpSession session = request.getSession();
            String userName = (String) session.getAttribute("USERNAME");

            int result = PayPalDAO.payPalCarRental(userName, date, priceTotal);
            if (result > 0) {
                RentalDAO dao = new RentalDAO();
                String dateBegin = (String) session.getAttribute("DATEBEGIN");
                String dateEnd = (String) session.getAttribute("DATEEND");
                long totalDate = (long) session.getAttribute("TOTALDATE1");
                String[] listCar = (String[]) session.getAttribute("LISTCAR");
                String[] listCarID = (String[]) session.getAttribute("LISTCARID");
                String[] listQuantity = (String[]) session.getAttribute("LISTQUANTITY");
                String[] listPrice = (String[]) session.getAttribute("LISTPRICE");
                int result1 = dao.createCarRental(userName, priceTotal, dateBegin, dateEnd, totalDate);
                for (int i = 0; i < listCar.length; i++) {
                    int rentalID = RentalDAO.getOrderid(userName);
                    String carName = listCar[i];
                    String carID = listCarID[i];
                    int quantity = (int) Float.parseFloat(listQuantity[i]);
                    float price = Float.parseFloat(listPrice[i]);
                    int quantityKho = RentalDAO.getQuantity(carName);
                    if (quantityKho >= quantity) {
                        RentalDAO.updateQuantity(carName, RentalDAO.getQuantity(carName) - quantity);
                        int result2 = RentalDetailDAO.createCarRentalDetail(rentalID, carID, carName, quantity, price);
                        if (result1 > 0 && result2 > 0) {
                            url = USER_PAGE;
//                            UserDTO dto = (UserDTO) session.getAttribute("dto");
//                            UserDTO dto1 = (UserDTO) session.getAttribute("NAME");
//                            session.invalidate();
//                            if(dto!=null){
//                                session.setAttribute("dto", dto);
//                            }else{
//                                session.setAttribute("NAME", dto1);
//                            }
                        }
                    } else {
                        request.setAttribute("OVER", "The product is out of stock. You must be buy less than " + (quantityKho + 1));
                        url = VIEWCART_PAGE;
                    }
                }
                url = USER_PAGE;
            }
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(PayPalServlet.class.getName()).log(Level.SEVERE, null, ex);
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
