/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shubham
 */
@Entity
@Table(name = "EmployeeCustomTag")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeCustomTag.findAll", query = "SELECT e FROM EmployeeCustomTag e"),
    @NamedQuery(name = "EmployeeCustomTag.findByEid", query = "SELECT e FROM EmployeeCustomTag e WHERE e.eid = :eid"),
    @NamedQuery(name = "EmployeeCustomTag.findByEname", query = "SELECT e FROM EmployeeCustomTag e WHERE e.ename = :ename"),
    @NamedQuery(name = "EmployeeCustomTag.findByEsal", query = "SELECT e FROM EmployeeCustomTag e WHERE e.esal = :esal")})
public class EmployeeCustomTag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Eid")
    private Integer eid;
    @Basic(optional = false)
    @Column(name = "Ename")
    private String ename;
    @Basic(optional = false)
    @Column(name = "Esal")
    private double esal;

    public EmployeeCustomTag() {
    }

    public EmployeeCustomTag(Integer eid) {
        this.eid = eid;
    }

    public EmployeeCustomTag(Integer eid, String ename, double esal) {
        this.eid = eid;
        this.ename = ename;
        this.esal = esal;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getEsal() {
        return esal;
    }

    public void setEsal(double esal) {
        this.esal = esal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eid != null ? eid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeCustomTag)) {
            return false;
        }
        EmployeeCustomTag other = (EmployeeCustomTag) object;
        if ((this.eid == null && other.eid != null) || (this.eid != null && !this.eid.equals(other.eid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EmployeeCustomTag[ eid=" + eid + " ]";
    }
    
}
