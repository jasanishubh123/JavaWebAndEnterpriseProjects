/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.UserTransaction;

/**
 *
 * @author root
 */
@TransactionManagement(TransactionManagementType.BEAN)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Startup
@Singleton
@LocalBean
@AccessTimeout(value=20, unit= TimeUnit.SECONDS )
@DependsOn({"FirstBean","SecondBean"})
public class SingleBean {
    
    @Resource UserTransaction utx;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private String firstName;
    private String lastName;
    
@PostConstruct
public void initialize()
{
    this.firstName="MSc";
    this.lastName="IT";
    System.out.println("SingleBean instantiated ..... ");
}

    @Lock(LockType.READ)
    public String getFirstName() {
        return firstName;
    }
    @Lock(LockType.WRITE)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Lock(LockType.READ)
    public String getLastName() {
        return lastName;
    }

    @Lock(LockType.WRITE)
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String join_names()
    {
        String fullname ="";
        try{
        
        try{
            utx.begin();
         fullname = firstName+" "+ lastName;
        utx.commit();
        }
        catch(Exception e1)
        {
          utx.rollback();
        }
        }
        catch(Exception e)
        {
            
        }
        return fullname;
    }


}
