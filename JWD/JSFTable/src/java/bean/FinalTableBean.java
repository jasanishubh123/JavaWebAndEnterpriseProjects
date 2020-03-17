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
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author shubham
 */
@Named(value = "finalTableBean")
@RequestScoped
public class FinalTableBean {

    @Inject DataTableBean d;
     Collection<DeptTB> deps;

    public Collection<DeptTB> getDeps() {
        deps=d.getDept();
        
        for(DeptTB db:deps){
            System.out.println(db.getDepartmentName());
        }
        return deps;
    }

    public void setDeps(Collection<DeptTB> deps) {
        
        this.deps = deps;
    }
    /**
     * Creates a new instance of FinalTableBean
     */
    public FinalTableBean() {
    }
    
}
