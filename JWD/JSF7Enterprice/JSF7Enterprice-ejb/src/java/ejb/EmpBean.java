/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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

    @PersistenceContext(unitName = "jsfepu")
    EntityManager em;
    @Override
    public Collection<EmpTB> getEmps() {
        return em.createNamedQuery("EmpTB.findAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
