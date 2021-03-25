/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoi.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import khoi.dao.CarDAO;
import khoi.dto.CarDTO;

/**
 *
 * @author Administrator
 */
public class SearchCarServlet extends HttpServlet {

    private final String ADMIN_PAGE = "admin.jsp";
    private final String USER_PAGE = "user.jsp";

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
        String SearchValue = request.getParameter("txtSearchValueByQuestionName");
        String categoryCar = request.getParameter("categoryCar");
        String url = ADMIN_PAGE;
        try {
            int pageIndex = 1;
            final int PAGE_SIZE = 3;
            String raw_page = request.getParameter("pageIndex");
            if (raw_page != null) {
                pageIndex = Integer.parseInt(raw_page);
            }
            CarDAO dao = new CarDAO();
            List<CarDTO> list = new ArrayList<>();
            if (!SearchValue.isEmpty()) {
                list = dao.searchCarByName(SearchValue, pageIndex, PAGE_SIZE);
                int totalPage = CarDAO.countPage(PAGE_SIZE);
                request.setAttribute("totalPage", totalPage);
                request.setAttribute("pageIndex", pageIndex);
                request.setAttribute("SEARCHNAME", list);
                url = ADMIN_PAGE;
            } else if (SearchValue.isEmpty() && !categoryCar.isEmpty()) {
                list = dao.searchCarByCategory(categoryCar, pageIndex, PAGE_SIZE);
                int totalPage = CarDAO.countPage(PAGE_SIZE);
                request.setAttribute("totalPage", totalPage);
                request.setAttribute("pageIndex", pageIndex);
                request.setAttribute("SEARCHNAME", list);
                url = ADMIN_PAGE;
            } else if (!SearchValue.isEmpty() && !categoryCar.isEmpty()) {
                list = dao.searchCarByAll(categoryCar, SearchValue);
                request.setAttribute("SEARCHNAME", list);
                url = ADMIN_PAGE;
            }

        } catch (NamingException | SQLException ex) {
            Logger.getLogger(SearchCarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
