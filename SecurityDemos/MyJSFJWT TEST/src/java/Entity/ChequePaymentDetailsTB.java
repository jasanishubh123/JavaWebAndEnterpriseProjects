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
@Table(name = "ChequePaymentDetailsTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChequePaymentDetailsTB.findAll", query = "SELECT c FROM ChequePaymentDetailsTB c"),
    @NamedQuery(name = "ChequePaymentDetailsTB.findByChequePaymentDetailsId", query = "SELECT c FROM ChequePaymentDetailsTB c WHERE c.chequePaymentDetailsId = :chequePaymentDetailsId"),
    @NamedQuery(name = "ChequePaymentDetailsTB.findByChequeDate", query = "SELECT c FROM ChequePaymentDetailsTB c WHERE c.chequeDate = :chequeDate"),
    @NamedQuery(name = "ChequePaymentDetailsTB.findByChequeNo", query = "SELECT c FROM ChequePaymentDetailsTB c WHERE c.chequeNo = :chequeNo"),
    @NamedQuery(name = "ChequePaymentDetailsTB.findByIsActive", query = "SELECT c FROM ChequePaymentDetailsTB c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "ChequePaymentDetailsTB.findByIsDelete", query = "SELECT c FROM ChequePaymentDetailsTB c WHERE c.isDelete = :isDelete"),
    @NamedQuery(name = "ChequePaymentDetailsTB.findByAddedOn", query = "SELECT c FROM ChequePaymentDetailsTB c WHERE c.addedOn = :addedOn"),
    @NamedQuery(name = "ChequePaymentDetailsTB.findByModifiedOn", query = "SELECT c FROM ChequePaymentDetailsTB c WHERE c.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "ChequePaymentDetailsTB.findByEnteredTerminal", query = "SELECT c FROM ChequePaymentDetailsTB c WHERE c.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "ChequePaymentDetailsTB.findByUpdatedTerminal", query = "SELECT c FROM ChequePaymentDetailsTB c WHERE c.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "ChequePaymentDetailsTB.findByTimeStamp", query = "SELECT c FROM ChequePaymentDetailsTB c WHERE c.timeStamp = :timeStamp")})
public class ChequePaymentDetailsTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ChequePaymentDetailsId")
    private Integer chequePaymentDetailsId;
    @Basic(optional = false)
    @Column(name = "ChequeDate")
    @Temporal(TemporalType.DATE)
    private Date chequeDate;
    @Basic(optional = false)
    @Column(name = "ChequeNo")
    private String chequeNo;
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

    public ChequePaymentDetailsTB() {
    }

    public ChequePaymentDetailsTB(Integer chequePaymentDetailsId) {
        this.chequePaymentDetailsId = chequePaymentDetailsId;
    }

    public ChequePaymentDetailsTB(Integer chequePaymentDetailsId, Date chequeDate, String chequeNo, boolean isActive, boolean isDelete) {
        this.chequePaymentDetailsId = chequePaymentDetailsId;
        this.chequeDate = chequeDate;
        this.chequeNo = chequeNo;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getChequePaymentDetailsId() {
        return chequePaymentDetailsId;
    }

    public void setChequePaymentDetailsId(Integer chequePaymentDetailsId) {
        this.chequePaymentDetailsId = chequePaymentDetailsId;
    }

    public Date getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(Date chequeDate) {
        this.chequeDate = chequeDate;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
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
        hash += (chequePaymentDetailsId != null ? chequePaymentDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChequePaymentDetailsTB)) {
            return false;
        }
        ChequePaymentDetailsTB other = (ChequePaymentDetailsTB) object;
        if ((this.chequePaymentDetailsId == null && other.chequePaymentDetailsId != null) || (this.chequePaymentDetailsId != null && !this.chequePaymentDetailsId.equals(other.chequePaymentDetailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ChequePaymentDetailsTB[ chequePaymentDetailsId=" + chequePaymentDetailsId + " ]";
    }
    
}
