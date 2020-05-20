/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import ejb.EmployeeBeanLocal;
import entity.DeptTB;
import entity.EmpTB;
import java.util.Collection;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author shubham
 */
@Path("generic")
@DeclareRoles({"Admin","Employee"})
@RequestScoped
public class GenericResource {

  
     @EJB EmployeeBeanLocal  ebl;
    @Context
    private UriInfo context;

    
    
     @GET
     @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteEmp")
     @RolesAllowed("Admin")
    public String removeEmp(@QueryParam("eid")int EmployeeId){
        ebl.remove(EmployeeId);
        return "Ok";
    }
    
        
    
    @GET
    @Path("/getEmp")
    //@RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<EmpTB> getEmps(){
        return ebl.getEmps();
    }
    
    @POST
    @Path("/AddEmp")
    @RolesAllowed("Admin")
    @Consumes(MediaType.APPLICATION_JSON)
    public void AddEmp(EmpTB e)
    {
        ebl.addEmp(e.getEmployeeName(),e.getPassword(),e.getDepartmentID().getDepartmentID(), (int) e.getSalary());
    }
    
    @PUT
    @Path("/UpdateEmp")
    @Consumes(MediaType.APPLICATION_JSON)
      @RolesAllowed("Admin")
    public void  updateEmp(EmpTB e){
        
        ebl.updateEmp(e.getEmpID(),e.getEmployeeName(),e.getPassword(),e.getDepartmentID().getDepartmentID(),(int)e.getSalary());
        
    }
    
    @GET
    @Path("/getDepts")
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Collection<DeptTB> getDepartments(){
        return ebl.getDepartments();
    }
    
//    @RolesAllowed("Employee")
    @GET
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello(){
        return "Hello";
        
    }
}
