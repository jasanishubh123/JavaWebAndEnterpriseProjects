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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PolicyTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PolicyTB.findAll", query = "SELECT p FROM PolicyTB p"),
    @NamedQuery(name = "PolicyTB.findByPolicyId", query = "SELECT p FROM PolicyTB p WHERE p.policyId = :policyId"),
    @NamedQuery(name = "PolicyTB.findByPolicyName", query = "SELECT p FROM PolicyTB p WHERE p.policyName = :policyName"),
    @NamedQuery(name = "PolicyTB.findByPolicyCode", query = "SELECT p FROM PolicyTB p WHERE p.policyCode = :policyCode"),
    @NamedQuery(name = "PolicyTB.findByIsActive", query = "SELECT p FROM PolicyTB p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "PolicyTB.findByIsDelete", query = "SELECT p FROM PolicyTB p WHERE p.isDelete = :isDelete"),
    @NamedQuery(name = "PolicyTB.findByAddedOn", query = "SELECT p FROM PolicyTB p WHERE p.addedOn = :addedOn"),
    @NamedQuery(name = "PolicyTB.findByModifiedOn", query = "SELECT p FROM PolicyTB p WHERE p.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "PolicyTB.findByEnteredTerminal", query = "SELECT p FROM PolicyTB p WHERE p.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "PolicyTB.findByUpdatedTerminal", query = "SELECT p FROM PolicyTB p WHERE p.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "PolicyTB.findByTimeStamp", query = "SELECT p FROM PolicyTB p WHERE p.timeStamp = :timeStamp")})
public class PolicyTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PolicyId")
    private Integer policyId;
    @Basic(optional = false)
    @Column(name = "PolicyName")
    private String policyName;
    @Basic(optional = false)
    @Column(name = "PolicyCode")
    private String policyCode;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "policyId")
    private Collection<TransactionOfPolicyTB> transactionOfPolicyTBCollection;
    @JoinColumn(name = "CompanyId", referencedColumnName = "CompanyId")
    @ManyToOne(optional = false)
    private CompanyTB companyId;
    @JoinColumn(name = "InsuranceTypeId", referencedColumnName = "InsuranceTypeId")
    @ManyToOne(optional = false)
    private InsuranceTypeTB insuranceTypeId;

    public PolicyTB() {
    }

    public PolicyTB(Integer policyId) {
        this.policyId = policyId;
    }

    public PolicyTB(Integer policyId, String policyName, String policyCode, boolean isActive, boolean isDelete) {
        this.policyId = policyId;
        this.policyName = policyName;
        this.policyCode = policyCode;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
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
    public Collection<TransactionOfPolicyTB> getTransactionOfPolicyTBCollection() {
        return transactionOfPolicyTBCollection;
    }

    public void setTransactionOfPolicyTBCollection(Collection<TransactionOfPolicyTB> transactionOfPolicyTBCollection) {
        this.transactionOfPolicyTBCollection = transactionOfPolicyTBCollection;
    }

    public CompanyTB getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyTB companyId) {
        this.companyId = companyId;
    }

    public InsuranceTypeTB getInsuranceTypeId() {
        return insuranceTypeId;
    }

    public void setInsuranceTypeId(InsuranceTypeTB insuranceTypeId) {
        this.insuranceTypeId = insuranceTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (policyId != null ? policyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PolicyTB)) {
            return false;
        }
        PolicyTB other = (PolicyTB) object;
        if ((this.policyId == null && other.policyId != null) || (this.policyId != null && !this.policyId.equals(other.policyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PolicyTB[ policyId=" + policyId + " ]";
    }
    
}
