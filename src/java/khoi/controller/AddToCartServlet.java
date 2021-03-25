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
import khoi.dao.CarDAO;
import khoi.dao.CartObject;
import khoi.dto.CartDTO;

/**
 *
 * @author Administrator
 */
public class AddToCartServlet extends HttpServlet {

    private final String USER_PAGE = "LoadCarUserServlet";

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
        String url = USER_PAGE;
        try {
            HttpSession session = request.getSession();
            CartObject cart = (CartObject) session.getAttribute("CUSTCART");
            if (cart == null) {
                cart = new CartObject();
            }
            String cusName = request.getParameter("txtCusname");
            String carName = request.getParameter("txtCarName");
            String carID = request.getParameter("txtCarID");
            String lastSearchValue = request.getParameter("lastSearchValue");
            if(lastSearchValue == null){
                lastSearchValue = "";
            }
            float price = Float.parseFloat(request.getParameter("txtPrice"));
            CartDTO item = new CartDTO(cusName,carID, carName, price, 1);
            int quantityDB = CarDAO.getQuantity(carName);
            if (quantityDB > 0) {
                cart.add(item);
                cart.getItem().get(carName).getQuantity();
                session.setAttribute("CUSTCART", cart);
                url = "DispatcherServlet?txtSearchValueByCarName="+lastSearchValue+"&btAction=Find";
            } else {
                CartDTO dto = new CartDTO();
                dto.setQuantity(0);
                request.setAttribute("PRODUCT", "Product empty");
                url = "DispatcherServlet?txtSearchValueByCarName="+lastSearchValue+"&btAction=Find";
            }
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            response.sendRedirect(url);
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
