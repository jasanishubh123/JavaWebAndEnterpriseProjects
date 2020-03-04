/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.EmployeeBeanLocal;
import entity.EmployeeCustomTag;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author shubham
 */
@Path("Emp")
@RequestScoped
public class EmployeeResource {

    @EJB EmployeeBeanLocal el;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EmployeeResource
     */
    public EmployeeResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<EmployeeCustomTag> getalleemp(){
        return  el.getallemp();
    }
    @POST
    @Path("addEmp/{Ename}/{sal}")        
   public void addEmp(@PathParam("Ename") String Ename,@PathParam("sal") Double sal){
        el.addEmp(Ename, sal);
    }
    @POST
            @Path("updateEmp/{id}/{Ename}/{sal}")
    public void updateEmp(@PathParam("id") int EmpId,@PathParam("Ename") String Ename,@PathParam("sal") Double sal){
        el.updateEmp(EmpId, Ename, sal);
    }
    @DELETE
    @Path("remooveEmp/{id}") 
   public void remooveEmp(@PathParam("id") int EmpId){
        
        el.remooveBook(EmpId);
    }
}
