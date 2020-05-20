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
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PublishingBeanLocal {
    
    //===  Customer ===
    
    void addCustomer(String firstName, String lastName);
    void updateCustomer(int custID,String firstName, String lastName);
    void removeCustomer(int custID);
    Collection<Customer> getAllCustomers();
    Collection<Customer> getCustomersByFirstName(String firstName);
    Collection<Customer> getCustomersByLastName(String lastName);
    Customer getCustomer(int custID);
    
    //=== Address ===
    
    void addAddressToCustomer(String street, String city, String state, String zip, int custID);
    void updateAddressToCustomer(int addressID, String street, String city, String state, String zip, int custID);    
    void removeAddressFromCustomer(int addressID, int custID);
    Collection<Address> getAllAddressesOfCustomer(int custID);
    Collection<Address> getAddressesOfCity(String city);
    Collection<Address> getAddressesOfState(String state);
    Collection<Address> getAddressesOfZip(String zip);
    
    //== Subscription

    void addSubscription(String title, String type);
    void updateSubscription(int subID, String title, String type);
    void removeSubscription(int subID);
    void addSubscriptionsToCustomer(int custID, Collection<Integer> subids);
    void removeSubscriptionsFromCustomer(int custID, Collection<Integer> subids);
    Collection<Subscription> getAllSubscriptions();
    Collection<Subscription> getAllSubscriptionsOfCustomer(int custID);
    Collection<Subscription> getAllSubscriptionsByType(String type);
    Subscription getAllSubscriptionsByTitle(String title);
    
      
    
    
    
    
    
    
    
    
    
    
}
