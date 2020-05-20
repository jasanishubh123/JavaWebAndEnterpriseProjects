/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Rest.GenericResource;
import client.restclient;
import ejb.EmployeeBeanLocal;
import entity.DeptTB;
import entity.EmpTB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author shubham
 */
@WebServlet(name = "ttp", urlPatterns = {"/ttp"})
//@DeclareRoles({"Admin","Employee"})
//@ServletSecurity(@HttpConstraint(rolesAllowed = "Admin"))
public class ttp extends HttpServlet {
//
//    @EJB EmployeeBeanLocal ebl;
//    restclient r;
//     Response res;
//    Collection<EmpTB> emps;
//    GenericType<Collection<EmpTB>> gemps;
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
            out.println("<title>Servlet ttp</title>");            
            out.println("</head>");
            out.println("<body>");
            //ebl.updateEmp(45,"LOLO DOLO", "tanethodokevay",1,9000);
            
//            String Ename = request.getParameter("Ename");
//            String Epass = request.getParameter("Epass");
//            int Edid =Integer.parseInt(request.getParameter("Edid"));
//            int Esal = Integer.parseInt(request.getParameter("Esal"));
            
//            DeptTB d = new DeptTB();
//            d.setDepartmentID(3);
//            EmpTB ee=new EmpTB();
//            ee.setEmpID(57);
//            ee.setEmployeeName("Shree Ram");
//            ee.setPassword("Sita");
//            ee.setSalary(10000);
//           
//            ee.setDepartmentID(d);
//             r = new restclient();
//             r.updateEmp(ee);
    
             
            
           // r.AddEmp("ggdg","fgdfg",  1,323);
            
//            Collection<EmpTB> emps = ebl.getEmps();
      
//  HttpSession session = request.getSession();
//            String username = (String)session.getAttribute("username");
//            String passwrod = (String)session.getAttribute("password");
//     r=new restclient(username,passwrod);
//    
//                 //r.removeEmp("56");
//                 gemps= new GenericType<Collection<EmpTB>>(){};
//                 res= r.getEmps(Response.class);
//           
//            emps= res.readEntity(gemps);
//            for(EmpTB e :emps){
//                out.println("<h1>" + e.getEmployeeName() +"  >>>>  " +e.getDepartmentID().getDepartmentName() +"</h1>");
//
//            }
            out.println("Hello Admin");
            
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
