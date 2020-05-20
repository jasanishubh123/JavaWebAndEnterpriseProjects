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
@Table(name = "PaymentTypeTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentTypeTB.findAll", query = "SELECT p FROM PaymentTypeTB p"),
    @NamedQuery(name = "PaymentTypeTB.findByPaymentTypeId", query = "SELECT p FROM PaymentTypeTB p WHERE p.paymentTypeId = :paymentTypeId"),
    @NamedQuery(name = "PaymentTypeTB.findByPaymentType", query = "SELECT p FROM PaymentTypeTB p WHERE p.paymentType = :paymentType"),
    @NamedQuery(name = "PaymentTypeTB.findByIsActive", query = "SELECT p FROM PaymentTypeTB p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "PaymentTypeTB.findByIsDelete", query = "SELECT p FROM PaymentTypeTB p WHERE p.isDelete = :isDelete"),
    @NamedQuery(name = "PaymentTypeTB.findByAddedOn", query = "SELECT p FROM PaymentTypeTB p WHERE p.addedOn = :addedOn"),
    @NamedQuery(name = "PaymentTypeTB.findByModifiedOn", query = "SELECT p FROM PaymentTypeTB p WHERE p.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "PaymentTypeTB.findByEnteredTerminal", query = "SELECT p FROM PaymentTypeTB p WHERE p.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "PaymentTypeTB.findByUpdatedTerminal", query = "SELECT p FROM PaymentTypeTB p WHERE p.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "PaymentTypeTB.findByTimeStamp", query = "SELECT p FROM PaymentTypeTB p WHERE p.timeStamp = :timeStamp")})
public class PaymentTypeTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PaymentTypeId")
    private Integer paymentTypeId;
    @Basic(optional = false)
    @Column(name = "PaymentType")
    private String paymentType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentTypeId")
    private Collection<TransactionOfPolicyTB> transactionOfPolicyTBCollection;

    public PaymentTypeTB() {
    }

    public PaymentTypeTB(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public PaymentTypeTB(Integer paymentTypeId, String paymentType, boolean isActive, boolean isDelete) {
        this.paymentTypeId = paymentTypeId;
        this.paymentType = paymentType;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentTypeId != null ? paymentTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentTypeTB)) {
            return false;
        }
        PaymentTypeTB other = (PaymentTypeTB) object;
        if ((this.paymentTypeId == null && other.paymentTypeId != null) || (this.paymentTypeId != null && !this.paymentTypeId.equals(other.paymentTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PaymentTypeTB[ paymentTypeId=" + paymentTypeId + " ]";
    }
    
}
