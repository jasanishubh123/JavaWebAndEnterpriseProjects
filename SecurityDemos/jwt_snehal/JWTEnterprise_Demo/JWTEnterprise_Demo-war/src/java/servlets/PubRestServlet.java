/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import client.AnotherRestClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@WebServlet(urlPatterns = "/ttp" )
@DeclareRoles({"AdminAdmin","SupervisorSupervisor"})
@ServletSecurity(
  value = @HttpConstraint(rolesAllowed = {"AdminAdmin","SupervisorSupervisor"}))
public class PubRestServlet extends HttpServlet {


    
    AnotherRestClient ac;
    Response res;
    
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
     ClientRequestContext ctx;
     //ClientRequest cr = new ClientRequest();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PubRestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<hr/><p align='right'><a href='logout.jsp'>Log Out </a></p><hr/>");
          //  HttpSession session = request.getSession();
           
           // Client client = PubRestClient.
            //rs = PubRestClient;
            String token="";
            Cookie cookies[] = request.getCookies();
        for(Cookie c: cookies)
        {
            if(c.getName().equals("JREMEMBERMEID")){
                System.out.println("in servlet cookie");
               token= c.getValue();
               System.out.println("in servlet cookie - token"+token);
            }
        } 
        
        
        
            
            //Customer cust = new Customer(); cust.setFirstName("Shweta"); cust.setLastName("Shah");
           //rs.createCustomer_JSON(cust);
//           Address address = new Address();
//           address.setStreet("Agam Complex"); address.setCity("Aurangabad"); address.setState("Mahashtra");
//           address.setZip("54535");
//           rs.addAddressToCustomer_JSON(address, new Integer(65).toString());

//         ArrayList<Integer> id1 = new ArrayList<Integer>();
//          id1.add(7);
//           id1.add(10);
//           
//         rs.addSubscriptionsToCustomer_JSON(id1, new Integer(44).toString());
  // rs.removeSubscriptionsToCustomer_JSON(id1, "43");
 
   
// Retrieve All data 
           
             System.out.println("in servlet before call constructpor");       
            ac = new AnotherRestClient(token);
            System.out.println("in servlet after call constructpor");       
            out.println("<h3>From Another App : "+ac.getHello()+"</h3>");
                   
            
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
