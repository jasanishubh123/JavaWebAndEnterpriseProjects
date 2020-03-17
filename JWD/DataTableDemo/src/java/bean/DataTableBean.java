/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.DeptTB;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author shubham
 */
@Named(value = "dataTableBean")
@Dependent
public class DataTableBean {

    EntityManager em;
    /**
     * Creates a new instance of DataTableBean
     */
    public DataTableBean() {
        em = Persistence.createEntityManagerFactory("mypu").createEntityManager();
        
        
    }
    public Collection<DeptTB> getDept(){
        return em.createNamedQuery("DeptTB.findAll").getResultList();
    }
}
