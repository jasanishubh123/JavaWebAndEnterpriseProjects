/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shubham
 */
@Entity
@Table(name = "DeptTB")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeptTB.findAll", query = "SELECT d FROM DeptTB d"),
    @NamedQuery(name = "DeptTB.findByDepartmentID", query = "SELECT d FROM DeptTB d WHERE d.departmentID = :departmentID"),
    @NamedQuery(name = "DeptTB.findByDepartmentName", query = "SELECT d FROM DeptTB d WHERE d.departmentName = :departmentName")})
public class DeptTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DepartmentID")
    private Integer departmentID;
    @Basic(optional = false)
    @Column(name = "DepartmentName")
    private String departmentName;
  //  @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentID")
   // private Collection<EmpTB> empTBCollection;

    public DeptTB() {
    }

    public DeptTB(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public DeptTB(Integer departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    //@XmlTransient
//    @JsonbTransient
//    public Collection<EmpTB> getEmpTBCollection() {
//        return empTBCollection;
//    }
//
//    public void setEmpTBCollection(Collection<EmpTB> empTBCollection) {
//        this.empTBCollection = empTBCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentID != null ? departmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeptTB)) {
            return false;
        }
        DeptTB other = (DeptTB) object;
        if ((this.departmentID == null && other.departmentID != null) || (this.departmentID != null && !this.departmentID.equals(other.departmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DeptTB[ departmentID=" + departmentID + " ]";
    }
    
}
