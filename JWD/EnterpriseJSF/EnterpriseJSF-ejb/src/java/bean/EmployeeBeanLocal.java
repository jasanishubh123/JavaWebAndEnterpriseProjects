/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.EmpTB;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author shubham
 */
@Local
public interface EmployeeBeanLocal {
    
    public void addEmp(String EmployeeName,String Password,int DepartmentId,int Salary);
    public void updateEmp(int EmployeeId,String EmployeeName,String Password,int DepartmentId,Double Salary);
    public void remove(int EmployeeId);
    public Collection<EmpTB> getAllEmp();
    public EmpTB getSingleEmployee(int EmployeeId);
    
}
