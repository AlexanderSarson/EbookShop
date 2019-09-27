/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.Ebook;
import Business.ShoppingCart;
import Persistence.EbookMapper;
import Persistence.IEbookMapper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alex
 */
@WebServlet(name = "ShoppingCardServlet", urlPatterns = {"/ShoppingCardServlet"})
public class ShoppingCardServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        ShoppingCart cart;
        synchronized (session) {
            cart = (ShoppingCart) session.getAttribute("shoppingCart");
            if (cart == null) {  // No cart, create one.
                cart = new ShoppingCart();
                session.setAttribute("shoppingCart", cart);  // Save it into session
            }
        }
        IEbookMapper mapper = new EbookMapper();
        String[] ids = request.getParameterValues("id");
        if (ids != null) {
            for (String id : ids) {
                int bookid = Integer.parseInt(id);
                String qty = request.getParameter(id + "qty");
                Ebook ebook = mapper.getEbookByID(bookid);
                if(qty.equals("")){
                    ebook.setQty(1);
                } else {
                    ebook.setQty(Integer.parseInt(qty));
                }
                cart.addEbook(ebook);
            }
        }

        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShoppingCardServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShoppingCardServlet at " + request.getContextPath() + "</h1>");
            out.println(cart.toString());
            out.println("</body>");
            out.println("</html>");
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
