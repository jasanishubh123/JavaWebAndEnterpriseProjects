/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.EmployeeCustomTag;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author shubham
 */
@Local
public interface EmployeeBeanLocal {
    public void addEmp(String Ename,Double sal);
    public   void updateEmp(int EmpId,String Ename,Double sal);
     public void remooveBook(int EmpId);
     public Collection<EmployeeCustomTag> getallemp();
              
}
