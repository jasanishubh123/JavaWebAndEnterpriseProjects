<%-- 
    Document   : Publish
    Created on : 6 Feb, 2020, 12:19:24 PM
    Author     : root
--%>

<%@page contentType="text/html" import="java.util.*, ejb.*, javax.naming.*,entity.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!
            PublishingBeanLocal pbl=null;
            
           public void jspInit()
            { 
                try{
                InitialContext ic = new InitialContext();
                
                pbl = (PublishingBeanLocal) ic.lookup("java:global/PublishingApp/PublishingApp-ejb/PublishingBean!ejb.PublishingBeanLocal");
                
                }
             
                catch(NamingException e)
                {
                    e.printStackTrace();
                }
            }
            
           public  void jspDestroy()
             {
                 pbl=null;
             }


        %>
        
        <h2>
            <%
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



                
                %>
            
            
            
        </h2>
        
        
        
        <h1>Hello World!</h1>
    </body>
</html>
