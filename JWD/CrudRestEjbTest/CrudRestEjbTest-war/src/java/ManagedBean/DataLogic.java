/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import client.restclient;
import entity.DeptTB;
import entity.EmpTB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Tuple;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author shubham
 */
@Named(value = "dataLogic")
@RequestScoped

public class DataLogic {
    HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

    HttpSession session = req.getSession();
    String username = (String)session.getAttribute("username");
    String passwrod = (String)session.getAttribute("password");
    GenericType<Collection<DeptTB>> gdepts;
    Collection<EmpTB> emps;
    Response res;
    restclient client;
    GenericType<Collection<EmpTB>> gemps;
    
    String Ename,Pass;
    int Eid,Did,Sal;

    
    public Collection<DeptTB> getDepartments(){

       Collection<Department> myd = new ArrayList<Department>();
         Collection<DeptTB> d;
       
            client= new restclient(username,passwrod);
        gdepts = new GenericType<Collection<DeptTB>>(){};
        res = client.getDepartments(Response.class);
        d=res.readEntity(gdepts);

         return d;
        
    }
    
    public int getEid() {
        return Eid;
    }

    public void setEid(int Eid) {
        this.Eid = Eid;
    }

    public String getEname() {
        return Ename;
    }

    public void setEname(String Ename) {
        this.Ename = Ename;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public int getDid() {
        return Did;
    }

    public void setDid(int Did) {
        this.Did = Did;
    }

    public int getSal() {
        return Sal;
    }

    public void setSal(int Sal) {
        this.Sal = Sal;
    }
    
    public Collection<EmpTB> getEmps(){
        emps= Display();
        return emps;
        
    }

    @RolesAllowed("Admin")
    public Collection<EmpTB> Display(){
        Collection<EmpTB> ee;
        client = new restclient(username,passwrod);
        gemps =  new GenericType<Collection<EmpTB>>(){};
        res= client.getEmps(Response.class);
        ee =  res.readEntity(gemps);
        return ee;

        
    }
    
    public void setEmps(Collection<EmpTB> emps) {
        this.emps = emps;
    }
    
     
     public String AddEmp() {
         
         if(getEid()>0){
                client = new restclient(username,passwrod);
                EmpTB e = new EmpTB();
                DeptTB d = new DeptTB();
                d.setDepartmentID(getDid());
                e.setEmpID(getEid());
                e.setEmployeeName(getEname());
                e.setPassword(getPass());
                e.setSalary(getSal());
                e.setDepartmentID(d);
                client.updateEmp(e);
             
         }
         else
         {
             client = new restclient(username,passwrod);
            EmpTB e = new EmpTB();
            DeptTB d = new DeptTB();
            d.setDepartmentID(getDid());
            e.setEmployeeName(getEname());
            e.setPassword(getPass());
            e.setSalary(getSal());
            e.setDepartmentID(d);
            client.AddEmp(e);
         }
         
         return "index.jsf";
     }
     
     public String removeEmp(int eid){
         client = new restclient(username,passwrod);
         client.removeEmp(String.valueOf(eid));
         return "index.jsf";
     }
     //@RolesAllowed("Admin")
     public String addForm(){
         return "AddEmployee.jsf";
     }
     
     public String EditEmp(int id){
         
         for(EmpTB e:getEmps()){
             
             if(id == e.getEmpID()){
                 this.setEid(e.getEmpID());
                 this.setDid(e.getDepartmentID().getDepartmentID());
                 this.setEname(e.getEmployeeName());
                 this.setPass(e.getPassword());
                 this.setSal((int) e.getSalary());
             }
             
         }
         
         return "AddEmployee.jsf";
         
     }
     
    
    
}
