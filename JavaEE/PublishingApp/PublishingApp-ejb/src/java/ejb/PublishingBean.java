/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PublishingBean implements PublishingBeanLocal {
    @PersistenceContext(unitName = "publishpu")
    EntityManager em;

    @Override
    public void addCustomer(String firstName, String lastName) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Customer c = new Customer();
       c.setFirstName(firstName);
       c.setLastName(lastName);
       em.persist(c);
    
    }

    @Override
    public void updateCustomer(int custID, String firstName, String lastName) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Customer c = (Customer) em.find(Customer.class, custID);
       c.setFirstName(firstName);
       c.setLastName(lastName);
       em.merge(c);
    
    }

    @Override
    public void removeCustomer(int custID) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Customer c = (Customer) em.find(Customer.class, custID);
     em.remove(c);
    
    }

    @Override
    public Collection<Customer> getAllCustomers() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    return em.createNamedQuery("Customer.findAll").getResultList();
    
    }

    @Override
    public Collection<Customer> getCustomersByFirstName(String firstName) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Collection<Customer> customers = em.createNamedQuery("Customer.findByFirstName")
            .setParameter("firstName", firstName)
            .getResultList();
            return customers;
    }

    @Override
    public Collection<Customer> getCustomersByLastName(String lastName) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Collection<Customer> customers = em.createNamedQuery("Customer.findByLastName")
            .setParameter("lastName", lastName)
            .getResultList();
            return customers;
  
    
    }

    @Override
    public Customer getCustomer(int custID) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    return (Customer)em.find(Customer.class, custID);
    }

    @Override
    public void addAddressToCustomer(String street, String city, String state, String zip, int custID) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    Customer c = em.find(Customer.class, custID);
    Collection<Address> addresses = c.getAddressCollection();
    
    Address address = new Address();
    
    address.setStreet(street);
    address.setCity(city);
    address.setState(state);
    address.setZip(zip);
    address.setCustomer(c);
    
    addresses.add(address);
    c.setAddressCollection(addresses);
    
    em.persist(address);
    em.merge(c);
    
    
    
    
    
    }

    @Override
    public void updateAddressToCustomer(int addressID, String street, String city, String state, String zip, int custID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAddressFromCustomer(int addressID, int custID) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Customer c = (Customer) em.find(Customer.class, custID);
         Address a = (Address) em.find(Address.class, addressID);
         
         Collection<Address> addresses = c.getAddressCollection();
         
         if(addresses.contains(a))
         {
             addresses.remove(a);
             c.setAddressCollection(addresses);
            em.remove(a);
         }
  
    
    }

    @Override
    public Collection<Address> getAllAddressesOfCustomer(int custID) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Customer c = em.find(Customer.class, custID);
       
        return c.getAddressCollection();
    }

    @Override
    public Collection<Address> getAddressesOfCity(String city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Address> getAddressesOfState(String state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Address> getAddressesOfZip(String zip) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addSubscription(String title, String type) {
 //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
            Subscription s = new Subscription();
            s.setTitle(title);
            s.setType(type);
            em.persist(s);
    }

    @Override
    public void updateSubscription(int subID, String title, String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeSubscription(int subID) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Subscription s = (Subscription) em.find(Subscription.class, subID);
        em.remove(s);
    }

    @Override
    public void addSubscriptionsToCustomer(int custID, Collection<Integer> subids) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
      Customer c = (Customer) em.find(Customer.class, custID);
      Collection<Subscription> subscriptions = c.getSubscriptionCollection();
      
       for(Integer sid : subids)
       {
           Subscription sub = (Subscription) em.find(Subscription.class, sid);
           if(!subscriptions.contains(sub))
           {
               subscriptions.add(sub);
               Collection<Customer> customers = sub.getCustomerCollection();
               customers.add(c);
               c.setSubscriptionCollection(subscriptions);
               sub.setCustomerCollection(customers);
               
               em.merge(c);
               
           }
           
       }
        
        
        
        
        
        
        
        
        
        
        
    
    }

    @Override
    public void removeSubscriptionsFromCustomer(int custID, Collection<Integer> subids) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Customer c = (Customer) em.find(Customer.class, custID);
      Collection<Subscription> subscriptions = c.getSubscriptionCollection();
      
       for(Integer sid : subids)
       {
           Subscription sub = (Subscription) em.find(Subscription.class, sid);
           if(subscriptions.contains(sub))
           {
               subscriptions.remove(sub);
               Collection<Customer> customers = sub.getCustomerCollection();
               customers.remove(c);
               c.setSubscriptionCollection(subscriptions);
               sub.setCustomerCollection(customers);
               
               em.merge(c);
               
           }
           
       }
        
    
    
    }

    @Override
    public Collection<Subscription> getAllSubscriptions() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        return em.createNamedQuery("Subscriprion.findAll").getResultList();
    }

    @Override
    public Collection<Subscription> getAllSubscriptionsOfCustomer(int custID) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Customer c = (Customer) em.find(Customer.class, custID);
    
    return c.getSubscriptionCollection();
    }

    @Override
    public Collection<Subscription> getAllSubscriptionsByType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Subscription getAllSubscriptionsByTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


}
