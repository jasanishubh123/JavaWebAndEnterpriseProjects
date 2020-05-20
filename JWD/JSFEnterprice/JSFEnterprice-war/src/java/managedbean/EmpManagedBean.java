/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;


import ejb.EmpBeanLocal;
import entity.EmpTB;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


/**
 *
 * @author shubham
 */
@Named(value = "empManagedBean")
@RequestScoped

public class EmpManagedBean {

   
   
    @EJB EmpBeanLocal el;
    Collection<EmpTB> Emps;
    private String EmployeeName;
    private int EmpId;

    public int getEmpId() {
        return EmpId;
    }

    public void setEmpId(int EmpId) {
        this.EmpId = EmpId;
    }
    private String Password;
    private int Salary;
    
    @Inject DataLogic dl;

    
    public Collection<EmpTB> getEmps() {
        Emps=dl.showData();
        return Emps;
    }

    public void setEmps(Collection<EmpTB> Emps) {
        this.Emps = Emps;
    }
    
    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String EmployeeName) {
        this.EmployeeName = EmployeeName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }
  
   public String addEmployee(){
//       rs =  new restclient();
   
        if(getEmpId()>0){
            el.updateEmp(getEmpId(),getEmployeeName(), getPassword(),1,getSalary());
        }
        else{
        el.addEmp(getEmployeeName(), getPassword(),1,getSalary());

        }
        
        return "/faces/index.xhtml";
       
   }
   public String DeleteEmp(int id){
       
       el.remove(id);
       return "/faces/index.xhtml";
   }
   public String EditEmp(int id){
      EmpTB t= el.getSingleEmployee(id);
      this.setEmpId(t.getEmpID());
      this.setEmployeeName(t.getEmployeeName());
      this.setPassword(t.getPassword());
      this.setSalary((int) t.getSalary());
      
      return "/faces/AddEmp.xhtml";
      
   }
    
}
