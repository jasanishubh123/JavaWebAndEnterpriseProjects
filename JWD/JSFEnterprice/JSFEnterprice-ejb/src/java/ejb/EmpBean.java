/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.DeptTB;
import entity.EmpTB;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author shubham
 */
@Stateless
public class EmpBean implements EmpBeanLocal {

    @PersistenceContext(unitName = "epu")
    EntityManager em;
    @Override
    public Collection<EmpTB> getEmps() {
        return em.createNamedQuery("EmpTB.findAll").getResultList();
    }
     @Override
    public void addEmp(String EmployeeName, String Password, int DepartmentId, int Salary) {
        DeptTB d = em.find(DeptTB.class, DepartmentId);
        Collection<EmpTB> emps = d.getEmpTBCollection();
        EmpTB e= new EmpTB();
        e.setEmployeeName(EmployeeName);
        e.setPassword(Password);
        e.setDepartmentID(d);
        e.setSalary(Salary);
        emps.add(e);
        d.setEmpTBCollection(emps);
        em.persist(e);
        em.merge(d);
    }

    @Override
    public void updateEmp(int EmployeeId, String EmployeeName, String Password, int DepartmentId, int Salary) {
            
        EmpTB e = (EmpTB)em.find(EmpTB.class,EmployeeId);
        DeptTB d = (DeptTB)em.find(DeptTB.class, DepartmentId);
        Collection<EmpTB> emps = d.getEmpTBCollection();
         e.setEmployeeName(EmployeeName);
        e.setPassword(Password);
        e.setDepartmentID(d);
        e.setSalary(Salary);
        emps.add(e);
        d.setEmpTBCollection(emps);
        em.merge(e);
        em.merge(d);
        
        
    }

    @Override
    public void remove(int EmployeeId) {
        EmpTB e = (EmpTB)em.find(EmpTB.class,EmployeeId);
        DeptTB d =e.getDepartmentID();
        int did = d.getDepartmentID();
        DeptTB dd= (DeptTB)em.find(DeptTB.class, did);
        
        Collection<EmpTB> emps = d.getEmpTBCollection();
        if(emps.contains(e)){
            emps.remove(e);
            d.setEmpTBCollection(emps);
            em.remove(e);
        }
        

    }

   

    @Override
    public EmpTB getSingleEmployee(int EmployeeId) {
        return em.find(EmpTB.class, EmployeeId);
        
    }


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
