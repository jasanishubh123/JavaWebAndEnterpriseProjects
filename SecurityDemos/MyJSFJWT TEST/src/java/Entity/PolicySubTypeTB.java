/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author snehal
 */
@Entity
@Table(name = "PolicySubTypeTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PolicySubTypeTB.findAll", query = "SELECT p FROM PolicySubTypeTB p"),
    @NamedQuery(name = "PolicySubTypeTB.findByPolicySubTypeId", query = "SELECT p FROM PolicySubTypeTB p WHERE p.policySubTypeId = :policySubTypeId"),
    @NamedQuery(name = "PolicySubTypeTB.findByPolicySubType", query = "SELECT p FROM PolicySubTypeTB p WHERE p.policySubType = :policySubType"),
    @NamedQuery(name = "PolicySubTypeTB.findByIsActive", query = "SELECT p FROM PolicySubTypeTB p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "PolicySubTypeTB.findByIsDelete", query = "SELECT p FROM PolicySubTypeTB p WHERE p.isDelete = :isDelete"),
    @NamedQuery(name = "PolicySubTypeTB.findByAddedOn", query = "SELECT p FROM PolicySubTypeTB p WHERE p.addedOn = :addedOn"),
    @NamedQuery(name = "PolicySubTypeTB.findByModifiedOn", query = "SELECT p FROM PolicySubTypeTB p WHERE p.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "PolicySubTypeTB.findByEnteredTerminal", query = "SELECT p FROM PolicySubTypeTB p WHERE p.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "PolicySubTypeTB.findByUpdatedTerminal", query = "SELECT p FROM PolicySubTypeTB p WHERE p.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "PolicySubTypeTB.findByTimeStamp", query = "SELECT p FROM PolicySubTypeTB p WHERE p.timeStamp = :timeStamp")})
public class PolicySubTypeTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PolicySubTypeId")
    private Integer policySubTypeId;
    @Basic(optional = false)
    @Column(name = "PolicySubType")
    private String policySubType;
    @Basic(optional = false)
    @Column(name = "IsActive")
    private boolean isActive;
    @Basic(optional = false)
    @Column(name = "IsDelete")
    private boolean isDelete;
    @Column(name = "AddedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedOn;
    @Column(name = "ModifiedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;
    @Column(name = "EnteredTerminal")
    private String enteredTerminal;
    @Column(name = "UpdatedTerminal")
    private String updatedTerminal;
    @Column(name = "TimeStamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "policySubTypeId")
    private Collection<VehicleDetailsTB> vehicleDetailsTBCollection;

    public PolicySubTypeTB() {
    }

    public PolicySubTypeTB(Integer policySubTypeId) {
        this.policySubTypeId = policySubTypeId;
    }

    public PolicySubTypeTB(Integer policySubTypeId, String policySubType, boolean isActive, boolean isDelete) {
        this.policySubTypeId = policySubTypeId;
        this.policySubType = policySubType;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getPolicySubTypeId() {
        return policySubTypeId;
    }

    public void setPolicySubTypeId(Integer policySubTypeId) {
        this.policySubTypeId = policySubTypeId;
    }

    public String getPolicySubType() {
        return policySubType;
    }

    public void setPolicySubType(String policySubType) {
        this.policySubType = policySubType;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getEnteredTerminal() {
        return enteredTerminal;
    }

    public void setEnteredTerminal(String enteredTerminal) {
        this.enteredTerminal = enteredTerminal;
    }

    public String getUpdatedTerminal() {
        return updatedTerminal;
    }

    public void setUpdatedTerminal(String updatedTerminal) {
        this.updatedTerminal = updatedTerminal;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @XmlTransient
    public Collection<VehicleDetailsTB> getVehicleDetailsTBCollection() {
        return vehicleDetailsTBCollection;
    }

    public void setVehicleDetailsTBCollection(Collection<VehicleDetailsTB> vehicleDetailsTBCollection) {
        this.vehicleDetailsTBCollection = vehicleDetailsTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (policySubTypeId != null ? policySubTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PolicySubTypeTB)) {
            return false;
        }
        PolicySubTypeTB other = (PolicySubTypeTB) object;
        if ((this.policySubTypeId == null && other.policySubTypeId != null) || (this.policySubTypeId != null && !this.policySubTypeId.equals(other.policySubTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PolicySubTypeTB[ policySubTypeId=" + policySubTypeId + " ]";
    }
    
}
