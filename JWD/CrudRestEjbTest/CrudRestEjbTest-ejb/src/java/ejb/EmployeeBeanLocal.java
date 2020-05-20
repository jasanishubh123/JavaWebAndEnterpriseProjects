/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.DeptTB;
import entity.EmpTB;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author shubham
 */
@Local
public interface EmployeeBeanLocal {
     
    public Collection<EmpTB> getEmps();
     public void addEmp(String EmployeeName,String Password,int DepartmentId,int Salary);
    public void updateEmp(int EmployeeId,String EmployeeName,String Password,int DepartmentId,int Salary);
    public void remove(int EmployeeId);
  
    public EmpTB getSingleEmployee(int EmployeeId); 
    public Collection<DeptTB> getDepartments(); 
}
