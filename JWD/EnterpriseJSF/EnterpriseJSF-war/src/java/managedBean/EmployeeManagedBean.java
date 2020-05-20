/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import bean.EmployeeBeanLocal;

import entity.EmpTB;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author shubham
 */
@Named(value = "employeeManagedBean")
@RequestScoped
public class EmployeeManagedBean {
//    Response res;
//    EmpClient e;
//    Collection<EmpTB> Emps;
  ///EmployeeBeanLocal ebl;
//    GenericType<Collection<EmpTB>> gemps;
    /**
     * Creates a new instance of EmployeeManagedBean
     */
//    public <T>T GetData() {
//        e = new EmpClient();
//        Emps=new ArrayList<EmpTB>();
//        gemps= new GenericType<Collection<EmpTB>>(){};
//         res = e.getAllEmps(Response.class);
//           Emps= res.readEntity(gemps);
//       return (T) Emps;
//    }
    
    private String ename;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
//    public ArrayList GetData(){
//        
//        
//          Collection<EmpTB> e =  ebl.getAllEmp();
//       
//          for(EmpTB eee:e){
//              System.out.println("myname "+eee.getEmployeeName());
//          }
//          
//          EmployeeManagedBean mbean = new EmployeeManagedBean();
//        for (EmpTB ee : e) {
//            mbean.setEname(ee.getEmployeeName());
//            emplist.add(mbean);
//        }
//          return emplist;     
//    }
//    
}
