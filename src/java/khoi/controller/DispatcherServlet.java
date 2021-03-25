/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class DispatcherServlet extends HttpServlet {

    private final String LOGIN_PAGE = "login.html";
    private final String LOGIN_CONTROLLER = "LoginServlet";
    private final String LOAD_CAR_PAGE = "LoadCarServlet";
    private final String LOGOUT_CONTROLLER = "LogoutServlet";
    private final String SEARCH_CONTROLLER = "SearchCarServlet";
    private final String REGISTER_CONTROLLER = "RegisterServlet";
    private final String SEARCH_CAR_USER = "SearchCarUserServlet";
    private final String ADDTOCART_CONTROLLER = "AddToCartServlet";
    private final String LOAD_CAR_USER_PAGE = "LoadCarUserServlet";
    private final String UPDATE_CART = "UpdateCartServlet";
    private final String DELETE_CART = "DeleteItemCartServlet";
    private final String PAYMENT_PAGE = "PayMentServlet";
    private final String CHECKOUT_CONTROLLER = "CheckoutServlet";
    private final String HISTORY_CONTROLLER = "HistoryServlet";
    private final String HISTORY_DETAIL_PAGE = "HistoryDetailServlet";
    private final String HISTORY_SEARCH_CONTROLLER = "SearchHistoryServlet";
    private final String RATE_CONTROLLER = "RateServlet";
    private final String DELETE_HISTORY = "DeleteHistoryServlet";
    private final String PAYPAL_CONTROLLER = "paypal.jsp";

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
        String button = request.getParameter("btAction");
        String url = LOGIN_PAGE;
        try {
            if (button.equals("Login")) {
                url = LOGIN_CONTROLLER;
            } else if (button.equals("Logout")) {
                url = LOGOUT_CONTROLLER;
            } else if (button.equals("Search")) {
                url = SEARCH_CONTROLLER;
            } else if (button.equals("GetAll")) {
                url = LOAD_CAR_PAGE;
            } else if (button.equals("Register")) {
                url = REGISTER_CONTROLLER;
            } else if (button.equals("login")) {
                url = LOGIN_PAGE;
            } else if (button.equals("Find")) {
                url = SEARCH_CAR_USER;
            } else if (button.equals("AddToCart")) {
                url = ADDTOCART_CONTROLLER;
            } else if (button.equals("Add more item")) {
                url = LOAD_CAR_USER_PAGE;
            } else if (button.equals("Update Quantity")) {
                url = UPDATE_CART;
            } else if (button.equals("Remove Selected")) {
                url = DELETE_CART;
            } else if (button.equals("Checkout")) {
                url = PAYMENT_PAGE;
            } else if (button.equals("Pay Now")) {
                url = CHECKOUT_CONTROLLER;
            } else if (button.equals("History")) {
                url = HISTORY_CONTROLLER;
            } else if (button.equals("ShowOrder")) {
                url = HISTORY_DETAIL_PAGE;
            } else if (button.equals("SearchHistory")) {
                url = HISTORY_SEARCH_CONTROLLER;
            }else if(button.equals("Rate")){
                url = RATE_CONTROLLER;
            }else if(button.equals("DeleteHistory")){
                url = DELETE_HISTORY;
            }else if(button.equals("VN Pay")){
                url = PAYPAL_CONTROLLER;
            }
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
