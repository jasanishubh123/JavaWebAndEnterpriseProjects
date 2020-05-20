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
@Table(name = "InsuranceTypeTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InsuranceTypeTB.findAll", query = "SELECT i FROM InsuranceTypeTB i"),
    @NamedQuery(name = "InsuranceTypeTB.findByInsuranceTypeId", query = "SELECT i FROM InsuranceTypeTB i WHERE i.insuranceTypeId = :insuranceTypeId"),
    @NamedQuery(name = "InsuranceTypeTB.findByInsuranceType", query = "SELECT i FROM InsuranceTypeTB i WHERE i.insuranceType = :insuranceType"),
    @NamedQuery(name = "InsuranceTypeTB.findByIsActive", query = "SELECT i FROM InsuranceTypeTB i WHERE i.isActive = :isActive"),
    @NamedQuery(name = "InsuranceTypeTB.findByIsDelete", query = "SELECT i FROM InsuranceTypeTB i WHERE i.isDelete = :isDelete"),
    @NamedQuery(name = "InsuranceTypeTB.findByAddedOn", query = "SELECT i FROM InsuranceTypeTB i WHERE i.addedOn = :addedOn"),
    @NamedQuery(name = "InsuranceTypeTB.findByModifiedOn", query = "SELECT i FROM InsuranceTypeTB i WHERE i.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "InsuranceTypeTB.findByEnteredTerminal", query = "SELECT i FROM InsuranceTypeTB i WHERE i.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "InsuranceTypeTB.findByUpdatedTerminal", query = "SELECT i FROM InsuranceTypeTB i WHERE i.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "InsuranceTypeTB.findByTimeStamp", query = "SELECT i FROM InsuranceTypeTB i WHERE i.timeStamp = :timeStamp")})
public class InsuranceTypeTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "InsuranceTypeId")
    private Integer insuranceTypeId;
    @Basic(optional = false)
    @Column(name = "InsuranceType")
    private String insuranceType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insuranceTypeId")
    private Collection<PolicyTB> policyTBCollection;

    public InsuranceTypeTB() {
    }

    public InsuranceTypeTB(Integer insuranceTypeId) {
        this.insuranceTypeId = insuranceTypeId;
    }

    public InsuranceTypeTB(Integer insuranceTypeId, String insuranceType, boolean isActive, boolean isDelete) {
        this.insuranceTypeId = insuranceTypeId;
        this.insuranceType = insuranceType;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getInsuranceTypeId() {
        return insuranceTypeId;
    }

    public void setInsuranceTypeId(Integer insuranceTypeId) {
        this.insuranceTypeId = insuranceTypeId;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
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
    public Collection<PolicyTB> getPolicyTBCollection() {
        return policyTBCollection;
    }

    public void setPolicyTBCollection(Collection<PolicyTB> policyTBCollection) {
        this.policyTBCollection = policyTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (insuranceTypeId != null ? insuranceTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InsuranceTypeTB)) {
            return false;
        }
        InsuranceTypeTB other = (InsuranceTypeTB) object;
        if ((this.insuranceTypeId == null && other.insuranceTypeId != null) || (this.insuranceTypeId != null && !this.insuranceTypeId.equals(other.insuranceTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.InsuranceTypeTB[ insuranceTypeId=" + insuranceTypeId + " ]";
    }
    
}
