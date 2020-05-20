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
@Table(name = "AgentTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgentTB.findAll", query = "SELECT a FROM AgentTB a"),
    @NamedQuery(name = "AgentTB.findByAgentId", query = "SELECT a FROM AgentTB a WHERE a.agentId = :agentId"),
    @NamedQuery(name = "AgentTB.findByAgentName", query = "SELECT a FROM AgentTB a WHERE a.agentName = :agentName"),
    @NamedQuery(name = "AgentTB.findByDob", query = "SELECT a FROM AgentTB a WHERE a.dob = :dob"),
    @NamedQuery(name = "AgentTB.findByContactNo1", query = "SELECT a FROM AgentTB a WHERE a.contactNo1 = :contactNo1"),
    @NamedQuery(name = "AgentTB.findByContactNo2", query = "SELECT a FROM AgentTB a WHERE a.contactNo2 = :contactNo2"),
    @NamedQuery(name = "AgentTB.findByEmailId", query = "SELECT a FROM AgentTB a WHERE a.emailId = :emailId"),
    @NamedQuery(name = "AgentTB.findByCommissionPercentage", query = "SELECT a FROM AgentTB a WHERE a.commissionPercentage = :commissionPercentage"),
    @NamedQuery(name = "AgentTB.findByOpeningBalance", query = "SELECT a FROM AgentTB a WHERE a.openingBalance = :openingBalance"),
    @NamedQuery(name = "AgentTB.findByIsActive", query = "SELECT a FROM AgentTB a WHERE a.isActive = :isActive"),
    @NamedQuery(name = "AgentTB.findByIsDelete", query = "SELECT a FROM AgentTB a WHERE a.isDelete = :isDelete"),
    @NamedQuery(name = "AgentTB.findByAddedOn", query = "SELECT a FROM AgentTB a WHERE a.addedOn = :addedOn"),
    @NamedQuery(name = "AgentTB.findByModifiedOn", query = "SELECT a FROM AgentTB a WHERE a.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "AgentTB.findByEnteredTerminal", query = "SELECT a FROM AgentTB a WHERE a.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "AgentTB.findByUpdatedTerminal", query = "SELECT a FROM AgentTB a WHERE a.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "AgentTB.findByTimeStamp", query = "SELECT a FROM AgentTB a WHERE a.timeStamp = :timeStamp")})
public class AgentTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AgentId")
    private Integer agentId;
    @Basic(optional = false)
    @Column(name = "AgentName")
    private String agentName;
    @Basic(optional = false)
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @Column(name = "ContactNo1")
    private String contactNo1;
    @Column(name = "ContactNo2")
    private String contactNo2;
    @Column(name = "EmailId")
    private String emailId;
    @Basic(optional = false)
    @Column(name = "CommissionPercentage")
    private int commissionPercentage;
    @Basic(optional = false)
    @Column(name = "OpeningBalance")
    private double openingBalance;
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
    @OneToMany(mappedBy = "agentId")
    private Collection<UserTB> userTBCollection;
    @OneToMany(mappedBy = "agentId")
    private Collection<AddressTB> addressTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agentId")
    private Collection<TransactionOfPolicyTB> transactionOfPolicyTBCollection;

    public AgentTB() {
    }

    public AgentTB(Integer agentId) {
        this.agentId = agentId;
    }

    public AgentTB(Integer agentId, String agentName, Date dob, String contactNo1, int commissionPercentage, double openingBalance, boolean isActive, boolean isDelete) {
        this.agentId = agentId;
        this.agentName = agentName;
        this.dob = dob;
        this.contactNo1 = contactNo1;
        this.commissionPercentage = commissionPercentage;
        this.openingBalance = openingBalance;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getContactNo1() {
        return contactNo1;
    }

    public void setContactNo1(String contactNo1) {
        this.contactNo1 = contactNo1;
    }

    public String getContactNo2() {
        return contactNo2;
    }

    public void setContactNo2(String contactNo2) {
        this.contactNo2 = contactNo2;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(int commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(double openingBalance) {
        this.openingBalance = openingBalance;
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
    public Collection<UserTB> getUserTBCollection() {
        return userTBCollection;
    }

    public void setUserTBCollection(Collection<UserTB> userTBCollection) {
        this.userTBCollection = userTBCollection;
    }

    @XmlTransient
    public Collection<AddressTB> getAddressTBCollection() {
        return addressTBCollection;
    }

    public void setAddressTBCollection(Collection<AddressTB> addressTBCollection) {
        this.addressTBCollection = addressTBCollection;
    }

    @XmlTransient
    public Collection<TransactionOfPolicyTB> getTransactionOfPolicyTBCollection() {
        return transactionOfPolicyTBCollection;
    }

    public void setTransactionOfPolicyTBCollection(Collection<TransactionOfPolicyTB> transactionOfPolicyTBCollection) {
        this.transactionOfPolicyTBCollection = transactionOfPolicyTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agentId != null ? agentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgentTB)) {
            return false;
        }
        AgentTB other = (AgentTB) object;
        if ((this.agentId == null && other.agentId != null) || (this.agentId != null && !this.agentId.equals(other.agentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.AgentTB[ agentId=" + agentId + " ]";
    }
    
}
