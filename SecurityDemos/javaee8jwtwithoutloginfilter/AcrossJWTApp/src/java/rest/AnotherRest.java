/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author root
 */
@DeclareRoles({"Admin","Supervisor"})
@Path("generic")
public class AnotherRest {

    @Context
    private UriInfo context;
 //   @Inject SecurityContext ctx;

    /**
     * Creates a new instance of AnotherRest
     */
    public AnotherRest() {
    }

    /**
     * Retrieves representation of an instance of rest.AnotherRest
     * @return an instance of java.lang.String
     */
    @RolesAllowed("Admin")
   // @PermitAll
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHello() {
     // System.out.println("Principal "+ctx.getCallerPrincipal());
        //TODO return proper representation object
        return "Hello Another Rest App";
    }

    /**
     * PUT method for updating or creating an instance of AnotherRest
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
