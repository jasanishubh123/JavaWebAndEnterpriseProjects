/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import client.RestClient;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@WebServlet(urlPatterns = {"/RestServlet"})
public class RestServlet extends HttpServlet {
    
    Response res;
    RestClient cl;
    Collection<Customer> customers;
    GenericType<Collection<Customer>> gcusts;
     Collection<Address> addresses;
    GenericType<Collection<Address>> gaddresses;
    Collection<Subscription> subs;
    GenericType<Collection<Subscription>> gsubs;


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
            out.println("<title>Servlet RestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            cl = new RestClient();
            customers= new ArrayList<Customer>();
            gcusts = new GenericType<Collection<Customer>>(){};
            addresses= new ArrayList<Address>();
            gaddresses = new GenericType<Collection<Address>>(){};
            subs= new ArrayList<Subscription>();
            gsubs = new GenericType<Collection<Subscription>>(){};
           
//           cl.addCustomer("Veena", "Rawat");
//           cl.addAddressToCustomer("Pranjal", "Jammu", "JandK", "102123", "68");
//           cl.removeAddressFromCustomer("89", "68");
//           Collection<Integer> subids = new ArrayList<Integer>();
//           subids.add(7);
//           subids.add(8);
//           subids.add(9);
//           cl.addSubscriptionsToCustomer( subids,"68");
//           cl.removeSubscriptionsFromCustomer(subids,"68");
         
            
            
            res = cl.getAllCustomers(Response.class);
            customers = res.readEntity(gcusts);
            
            
            out.println("<h2>");
            for(Customer c : customers)
            {
                out.println("id ="+ c.getCustomerID()+"  "+ c.getFirstName()+ "   "+ c.getLastName());
               res = cl.getAllAddressesOfCustomer(Response.class, c.getCustomerID().toString());
                Collection<Address> addresses = res.readEntity(gaddresses);
                
                    for(Address a : addresses)
                    {
                           out.println("<br/>id ="+ a.getAddressId()+ " city= " + a.getCity()+ "  state= "+ a.getState());
             
                    }
                    res = cl.getAllSubscriptionsOfCustomer(Response.class, c.getCustomerID().toString());
                    Collection<Subscription> subs = res.readEntity(gsubs);
               
                 
                    for(Subscription s : subs)
                    {
                           out.println("<br/>id ="+ s.getSubscriptionId()+ " title= " + s.getTitle()+ "  state= "+ s.getType());
             
                    }
                    out.println("<hr/>");
            }
            out.println("</h2>");
           
            
            out.println("<h1>Servlet RestServlet at " + request.getContextPath() + "</h1>");
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
