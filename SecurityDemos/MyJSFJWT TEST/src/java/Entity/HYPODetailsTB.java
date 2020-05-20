/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author snehal
 */
@Entity
@Table(name = "HYPODetailsTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HYPODetailsTB.findAll", query = "SELECT h FROM HYPODetailsTB h"),
    @NamedQuery(name = "HYPODetailsTB.findByHYPODetailsId", query = "SELECT h FROM HYPODetailsTB h WHERE h.hYPODetailsId = :hYPODetailsId"),
    @NamedQuery(name = "HYPODetailsTB.findByIsActive", query = "SELECT h FROM HYPODetailsTB h WHERE h.isActive = :isActive"),
    @NamedQuery(name = "HYPODetailsTB.findByIsDelete", query = "SELECT h FROM HYPODetailsTB h WHERE h.isDelete = :isDelete"),
    @NamedQuery(name = "HYPODetailsTB.findByAddedOn", query = "SELECT h FROM HYPODetailsTB h WHERE h.addedOn = :addedOn"),
    @NamedQuery(name = "HYPODetailsTB.findByModifiedOn", query = "SELECT h FROM HYPODetailsTB h WHERE h.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "HYPODetailsTB.findByEnteredTerminal", query = "SELECT h FROM HYPODetailsTB h WHERE h.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "HYPODetailsTB.findByUpdatedTerminal", query = "SELECT h FROM HYPODetailsTB h WHERE h.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "HYPODetailsTB.findByTimeStamp", query = "SELECT h FROM HYPODetailsTB h WHERE h.timeStamp = :timeStamp")})
public class HYPODetailsTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HYPODetailsId")
    private Integer hYPODetailsId;
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
    @JoinColumn(name = "BankBranchAreaId", referencedColumnName = "BankBranchAreaId")
    @ManyToOne(optional = false)
    private BankBranchAreaTB bankBranchAreaId;
    @JoinColumn(name = "TransactionOfPolicyId", referencedColumnName = "TransactionOfPolicyId")
    @ManyToOne(optional = false)
    private TransactionOfPolicyTB transactionOfPolicyId;

    public HYPODetailsTB() {
    }

    public HYPODetailsTB(Integer hYPODetailsId) {
        this.hYPODetailsId = hYPODetailsId;
    }

    public HYPODetailsTB(Integer hYPODetailsId, boolean isActive, boolean isDelete) {
        this.hYPODetailsId = hYPODetailsId;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getHYPODetailsId() {
        return hYPODetailsId;
    }

    public void setHYPODetailsId(Integer hYPODetailsId) {
        this.hYPODetailsId = hYPODetailsId;
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

    public BankBranchAreaTB getBankBranchAreaId() {
        return bankBranchAreaId;
    }

    public void setBankBranchAreaId(BankBranchAreaTB bankBranchAreaId) {
        this.bankBranchAreaId = bankBranchAreaId;
    }

    public TransactionOfPolicyTB getTransactionOfPolicyId() {
        return transactionOfPolicyId;
    }

    public void setTransactionOfPolicyId(TransactionOfPolicyTB transactionOfPolicyId) {
        this.transactionOfPolicyId = transactionOfPolicyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hYPODetailsId != null ? hYPODetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HYPODetailsTB)) {
            return false;
        }
        HYPODetailsTB other = (HYPODetailsTB) object;
        if ((this.hYPODetailsId == null && other.hYPODetailsId != null) || (this.hYPODetailsId != null && !this.hYPODetailsId.equals(other.hYPODetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.HYPODetailsTB[ hYPODetailsId=" + hYPODetailsId + " ]";
    }
    
}
