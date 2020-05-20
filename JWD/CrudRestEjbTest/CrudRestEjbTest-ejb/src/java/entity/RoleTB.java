/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
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
@Table(name = "RoleTB")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleTB.findAll", query = "SELECT r FROM RoleTB r"),
    @NamedQuery(name = "RoleTB.findByRoleId", query = "SELECT r FROM RoleTB r WHERE r.roleId = :roleId"),
    @NamedQuery(name = "RoleTB.findByRoleName", query = "SELECT r FROM RoleTB r WHERE r.roleName = :roleName")})
public class RoleTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RoleId")
    private Integer roleId;
    @Basic(optional = false)
    @Column(name = "RoleName")
    private String roleName;
    @OneToMany(mappedBy = "roleId")
    private Collection<EmpTB> empTBCollection;

    public RoleTB() {
    }

    public RoleTB(Integer roleId) {
        this.roleId = roleId;
    }

    public RoleTB(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    //@XmlTransient
    @JsonbTransient
    public Collection<EmpTB> getEmpTBCollection() {
        return empTBCollection;
    }

    public void setEmpTBCollection(Collection<EmpTB> empTBCollection) {
        this.empTBCollection = empTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleTB)) {
            return false;
        }
        RoleTB other = (RoleTB) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RoleTB[ roleId=" + roleId + " ]";
    }
    
}
