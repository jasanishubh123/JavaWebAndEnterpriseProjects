/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;


import ejb.EmpBeanLocal;
import entity.EmpTB;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author shubham
 */
@Named(value = "dataLogic")
@Dependent

public class DataLogic {
// Response res;
//    restclient client;
    
    Collection<EmpTB> Emps;
    @EJB EmpBeanLocal el;
//    GenericType<Collection<EmpTB>> gemps;
    /**
     * Creates a new instance of DataLogic
     */
    public DataLogic() {
    }
    
    public Collection<EmpTB> showData(){
//         client=new restclient();
//            Emps=new ArrayList<EmpTB>();
//            
//            gemps= new GenericType<Collection<EmpTB>>(){};
//            
//            res = client.getEmps(Response.class);
//            Emps= res.readEntity(gemps);
            Emps = el.getEmps();
            return Emps;
    }
}
