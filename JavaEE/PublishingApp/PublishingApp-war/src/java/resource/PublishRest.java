/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import ejb.PublishingBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("publish")
public class PublishRest {
    @EJB PublishingBeanLocal pbl;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PublishRest
     */
    public PublishRest() {
    }
    
    @POST
    @Path("addcust/{fname}/{lname}")
    public void addCustomer(@PathParam("fname") String firstName, @PathParam("lname") String lastName) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
       pbl.addCustomer(firstName, lastName);
    }

    @PUT
    @Path("updatecust/{id}/{fname}/{lname}")
    public void updateCustomer(@PathParam("id") int custID, @PathParam("fname") String firstName, @PathParam("lname") String lastName) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       pbl.updateCustomer(custID, firstName, lastName);
    
    }

    @DELETE
    @Path("delcust/{id}")
    public void removeCustomer(@PathParam("id") int custID) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     pbl.removeCustomer(custID);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<Customer> getAllCustomers() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     
        return (Collection<Customer>) pbl.getAllCustomers();
     
    }

    
    @GET
    @Path("findbyfname/{fname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Customer> getCustomersByFirstName(@PathParam("fname") String firstName) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
       return pbl.getCustomersByFirstName(firstName);
    }

    @GET
    @Path("findbylname/{lname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Customer> getCustomersByLastName(@PathParam("lname") String lastName) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     
     return   pbl.getCustomersByLastName(lastName);
    
    }

    @GET
    @Path("findcust/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("id") int custID) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
                return pbl.getCustomer(custID);
            }

    @POST
    @Path("addaddress/{street}/{city}/{state}/{zip}/{id}")
    public void addAddressToCustomer(@PathParam("street") String street, @PathParam("city") String city, @PathParam("state") String state, @PathParam("zip") String zip,@PathParam("id") int custID) {
    
            pbl.addAddressToCustomer(street, city, state, zip, custID);
    
    }

//    @POST
//    @Path("addaddress/{street}/{city}/{state}/{zip}/{id}")
//    
//    public void updateAddressToCustomer(int addressID, String street, String city, String state, String zip, int custID) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @DELETE
    @Path("deladd/{aid}/{cid}")
    public void removeAddressFromCustomer(@PathParam("aid") int addressID, @PathParam("cid") int custID) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
          pbl.removeAddressFromCustomer(addressID, custID);
    }

    @GET
    @Path("alladdresses/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Address> getAllAddressesOfCustomer(@PathParam("id") int custID) {
      return pbl.getAllAddressesOfCustomer(custID);
    }

    @POST
    @Path("addsub/{title})/{type}")        
    public void addSubscription(@PathParam("title") String title,@PathParam("type") String type) {
            pbl.addSubscription(title, type);
    }

    @PUT
    @Path("updatesub/{id}/{title})/{type}")
    public void updateSubscription(@PathParam("id") int subID,@PathParam("title")  String title, @PathParam("type") String type) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       pbl.updateSubscription(subID, title, type);
    }

  @DELETE
    @Path("delsub/{id}")
    public void removeSubscription(@PathParam("id") int subID) {
       pbl.removeSubscription(subID);
    }

    @POST
    @Path("addsubcust/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addSubscriptionsToCustomer(@PathParam("id") int custID, Collection<Integer> subids) {
       
           pbl.addSubscriptionsToCustomer(custID, subids);
       }
        
  @POST
    @Path("delsubcust/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeSubscriptionsFromCustomer(@PathParam("id") int custID, Collection<Integer> subids) {
       
         pbl.removeSubscriptionsFromCustomer(custID, subids);
       }
 
    @GET
    @Path("allsubs")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Subscription> getAllSubscriptions() {
            return pbl.getAllSubscriptions();
          }

    @GET
    @Path("allsubcust/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Subscription> getAllSubscriptionsOfCustomer(@PathParam("id") int custID) {
        return pbl.getAllSubscriptionsOfCustomer(custID);
    }

    
//    public Collection<Subscription> getAllSubscriptionsByType(String type) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    
//    public Subscription getAllSubscriptionsByTitle(String title) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
