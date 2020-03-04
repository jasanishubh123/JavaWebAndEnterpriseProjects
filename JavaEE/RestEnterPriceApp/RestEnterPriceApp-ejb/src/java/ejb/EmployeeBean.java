/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.EmployeeCustomTag;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author shubham
 */
@Stateless
public class EmployeeBean implements EmployeeBeanLocal {

    @PersistenceContext(unitName = "restpu")
    EntityManager em;
    @Override
    public void addEmp(String Ename, Double sal) {
        
        EmployeeCustomTag e= new EmployeeCustomTag();
        e.setEname(Ename);
        e.setEsal(sal);
        em.persist(e);
        
    }

    @Override
    public void updateEmp(int EmpId, String Ename, Double sal) {
        EmployeeCustomTag e=(EmployeeCustomTag)em.find(EmployeeCustomTag.class, EmpId);
        e.setEname(Ename);
        e.setEsal(sal);
        em.merge(e);
    }

    @Override
    public void remooveBook(int EmpId) {
        EmployeeCustomTag e = (EmployeeCustomTag)em.find(EmployeeCustomTag.class, EmpId);
        em.remove(e);
        
    }

    @Override
    public Collection<EmployeeCustomTag> getallemp() {
        
        return em.createNamedQuery("EmployeeCustomTag.findAll").getResultList();
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
   
}
