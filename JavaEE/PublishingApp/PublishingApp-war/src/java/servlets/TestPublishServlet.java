/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.PublishingBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "TestPublishServlet", urlPatterns = {"/TestPublishServlet"})
public class TestPublishServlet extends HttpServlet {
    
    @EJB PublishingBeanLocal pbl;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestPublishServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
         
            Collection<Customer> customers = pbl.getAllCustomers();
             out.println("<h2>");
            
             for(Customer c : customers)
             {
               out.println("<br/>id = "+ c.getCustomerID()+ " "+ c.getFirstName()+ "  "+ c.getLastName());
                
               Collection<Address> addresses = pbl.getAllAddressesOfCustomer(c.getCustomerID());
               for(Address a : addresses)
               {
                      out.println("<br/>id = "+ a.getAddressId()+ " "+ a.getCity()+ "  "+ a.getState());                    
               }
               Collection<Subscription> subs = pbl.getAllSubscriptionsOfCustomer(c.getCustomerID());
                 
               for(Subscription s : subs)
               {
                              out.println("<br/>id = "+ s.getSubscriptionId()+ " "+ s.getTitle()+ "  "+ s.getType());                    
           
               }
               
               out.println("<hr/>");
             }
             out.println("</h2>");
            
            
            
            out.println("<h1>Servlet TestPublishServlet at " + request.getContextPath() + "</h1>");
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
