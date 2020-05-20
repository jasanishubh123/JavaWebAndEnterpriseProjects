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
@Table(name = "TransactionOfPolicyTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionOfPolicyTB.findAll", query = "SELECT t FROM TransactionOfPolicyTB t"),
    @NamedQuery(name = "TransactionOfPolicyTB.findByTransactionOfPolicyId", query = "SELECT t FROM TransactionOfPolicyTB t WHERE t.transactionOfPolicyId = :transactionOfPolicyId"),
    @NamedQuery(name = "TransactionOfPolicyTB.findByPolicyFromDate", query = "SELECT t FROM TransactionOfPolicyTB t WHERE t.policyFromDate = :policyFromDate"),
    @NamedQuery(name = "TransactionOfPolicyTB.findByPolicyToDate", query = "SELECT t FROM TransactionOfPolicyTB t WHERE t.policyToDate = :policyToDate"),
    @NamedQuery(name = "TransactionOfPolicyTB.findByIsTakenHYPO", query = "SELECT t FROM TransactionOfPolicyTB t WHERE t.isTakenHYPO = :isTakenHYPO"),
    @NamedQuery(name = "TransactionOfPolicyTB.findByIsPaymentByCheque", query = "SELECT t FROM TransactionOfPolicyTB t WHERE t.isPaymentByCheque = :isPaymentByCheque"),
    @NamedQuery(name = "TransactionOfPolicyTB.findByRecievedAmount", query = "SELECT t FROM TransactionOfPolicyTB t WHERE t.recievedAmount = :recievedAmount"),
    @NamedQuery(name = "TransactionOfPolicyTB.findBySortPrem", query = "SELECT t FROM TransactionOfPolicyTB t WHERE t.sortPrem = :sortPrem"),
    @NamedQuery(name = "TransactionOfPolicyTB.findByEndoresment", query = "SELECT t FROM TransactionOfPolicyTB t WHERE t.endoresment = :endoresment"),
    @NamedQuery(name = "TransactionOfPolicyTB.findByRemark", query = "SELECT t FROM TransactionOfPolicyTB t WHERE t.remark = :remark"),
    @NamedQuery(name = "TransactionOfPolicyTB.findByIsActive", query = "SELECT t FROM TransactionOfPolicyTB t WHERE t.isActive = :isActive"),
    @NamedQuery(name = "TransactionOfPolicyTB.findByIsDelete", query = "SELECT t FROM TransactionOfPolicyTB t WHERE t.isDelete = :isDelete"),
    @NamedQuery(name = "TransactionOfPolicyTB.findByAddedOn", query = "SELECT t FROM TransactionOfPolicyTB t WHERE t.addedOn = :addedOn"),
    @NamedQuery(name = "TransactionOfPolicyTB.findByModifiedOn", query = "SELECT t FROM TransactionOfPolicyTB t WHERE t.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "TransactionOfPolicyTB.findByEnteredTerminal", query = "SELECT t FROM TransactionOfPolicyTB t WHERE t.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "TransactionOfPolicyTB.findByUpdatedTerminal", query = "SELECT t FROM TransactionOfPolicyTB t WHERE t.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "TransactionOfPolicyTB.findByTimeStamp", query = "SELECT t FROM TransactionOfPolicyTB t WHERE t.timeStamp = :timeStamp")})
public class TransactionOfPolicyTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TransactionOfPolicyId")
    private Integer transactionOfPolicyId;
    @Basic(optional = false)
    @Column(name = "PolicyFromDate")
    @Temporal(TemporalType.DATE)
    private Date policyFromDate;
    @Basic(optional = false)
    @Column(name = "PolicyToDate")
    @Temporal(TemporalType.DATE)
    private Date policyToDate;
    @Basic(optional = false)
    @Column(name = "IsTakenHYPO")
    private short isTakenHYPO;
    @Basic(optional = false)
    @Column(name = "IsPaymentByCheque")
    private short isPaymentByCheque;
    @Basic(optional = false)
    @Column(name = "RecievedAmount")
    private String recievedAmount;
    @Basic(optional = false)
    @Column(name = "SortPrem")
    private int sortPrem;
    @Basic(optional = false)
    @Column(name = "Endoresment")
    private String endoresment;
    @Basic(optional = false)
    @Column(name = "Remark")
    private String remark;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionOfPolicyId")
    private Collection<DocumentsOfTOPTB> documentsOfTOPTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionOfPolicyId")
    private Collection<HYPODetailsTB> hYPODetailsTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionOfPolicyId")
    private Collection<ChequePaymentDetailsTB> chequePaymentDetailsTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionOfPolicyId")
    private Collection<PremiumDetailsOfVehicleTB> premiumDetailsOfVehicleTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionOfPolicyId")
    private Collection<VehicleIDVDetailsTB> vehicleIDVDetailsTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionOfPolicyId")
    private Collection<VehicleDetailsTB> vehicleDetailsTBCollection;
    @JoinColumn(name = "AgentId", referencedColumnName = "AgentId")
    @ManyToOne(optional = false)
    private AgentTB agentId;
    @JoinColumn(name = "InsuredId", referencedColumnName = "InsuredId")
    @ManyToOne(optional = false)
    private InsuredTB insuredId;
    @JoinColumn(name = "PaymentTypeId", referencedColumnName = "PaymentTypeId")
    @ManyToOne(optional = false)
    private PaymentTypeTB paymentTypeId;
    @JoinColumn(name = "PolicyStatusId", referencedColumnName = "PolicyStatusId")
    @ManyToOne(optional = false)
    private PolicyStatusTB policyStatusId;
    @JoinColumn(name = "PolicyId", referencedColumnName = "PolicyId")
    @ManyToOne(optional = false)
    private PolicyTB policyId;

    public TransactionOfPolicyTB() {
    }

    public TransactionOfPolicyTB(Integer transactionOfPolicyId) {
        this.transactionOfPolicyId = transactionOfPolicyId;
    }

    public TransactionOfPolicyTB(Integer transactionOfPolicyId, Date policyFromDate, Date policyToDate, short isTakenHYPO, short isPaymentByCheque, String recievedAmount, int sortPrem, String endoresment, String remark, boolean isActive, boolean isDelete) {
        this.transactionOfPolicyId = transactionOfPolicyId;
        this.policyFromDate = policyFromDate;
        this.policyToDate = policyToDate;
        this.isTakenHYPO = isTakenHYPO;
        this.isPaymentByCheque = isPaymentByCheque;
        this.recievedAmount = recievedAmount;
        this.sortPrem = sortPrem;
        this.endoresment = endoresment;
        this.remark = remark;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getTransactionOfPolicyId() {
        return transactionOfPolicyId;
    }

    public void setTransactionOfPolicyId(Integer transactionOfPolicyId) {
        this.transactionOfPolicyId = transactionOfPolicyId;
    }

    public Date getPolicyFromDate() {
        return policyFromDate;
    }

    public void setPolicyFromDate(Date policyFromDate) {
        this.policyFromDate = policyFromDate;
    }

    public Date getPolicyToDate() {
        return policyToDate;
    }

    public void setPolicyToDate(Date policyToDate) {
        this.policyToDate = policyToDate;
    }

    public short getIsTakenHYPO() {
        return isTakenHYPO;
    }

    public void setIsTakenHYPO(short isTakenHYPO) {
        this.isTakenHYPO = isTakenHYPO;
    }

    public short getIsPaymentByCheque() {
        return isPaymentByCheque;
    }

    public void setIsPaymentByCheque(short isPaymentByCheque) {
        this.isPaymentByCheque = isPaymentByCheque;
    }

    public String getRecievedAmount() {
        return recievedAmount;
    }

    public void setRecievedAmount(String recievedAmount) {
        this.recievedAmount = recievedAmount;
    }

    public int getSortPrem() {
        return sortPrem;
    }

    public void setSortPrem(int sortPrem) {
        this.sortPrem = sortPrem;
    }

    public String getEndoresment() {
        return endoresment;
    }

    public void setEndoresment(String endoresment) {
        this.endoresment = endoresment;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
    public Collection<DocumentsOfTOPTB> getDocumentsOfTOPTBCollection() {
        return documentsOfTOPTBCollection;
    }

    public void setDocumentsOfTOPTBCollection(Collection<DocumentsOfTOPTB> documentsOfTOPTBCollection) {
        this.documentsOfTOPTBCollection = documentsOfTOPTBCollection;
    }

    @XmlTransient
    public Collection<HYPODetailsTB> getHYPODetailsTBCollection() {
        return hYPODetailsTBCollection;
    }

    public void setHYPODetailsTBCollection(Collection<HYPODetailsTB> hYPODetailsTBCollection) {
        this.hYPODetailsTBCollection = hYPODetailsTBCollection;
    }

    @XmlTransient
    public Collection<ChequePaymentDetailsTB> getChequePaymentDetailsTBCollection() {
        return chequePaymentDetailsTBCollection;
    }

    public void setChequePaymentDetailsTBCollection(Collection<ChequePaymentDetailsTB> chequePaymentDetailsTBCollection) {
        this.chequePaymentDetailsTBCollection = chequePaymentDetailsTBCollection;
    }

    @XmlTransient
    public Collection<PremiumDetailsOfVehicleTB> getPremiumDetailsOfVehicleTBCollection() {
        return premiumDetailsOfVehicleTBCollection;
    }

    public void setPremiumDetailsOfVehicleTBCollection(Collection<PremiumDetailsOfVehicleTB> premiumDetailsOfVehicleTBCollection) {
        this.premiumDetailsOfVehicleTBCollection = premiumDetailsOfVehicleTBCollection;
    }

    @XmlTransient
    public Collection<VehicleIDVDetailsTB> getVehicleIDVDetailsTBCollection() {
        return vehicleIDVDetailsTBCollection;
    }

    public void setVehicleIDVDetailsTBCollection(Collection<VehicleIDVDetailsTB> vehicleIDVDetailsTBCollection) {
        this.vehicleIDVDetailsTBCollection = vehicleIDVDetailsTBCollection;
    }

    @XmlTransient
    public Collection<VehicleDetailsTB> getVehicleDetailsTBCollection() {
        return vehicleDetailsTBCollection;
    }

    public void setVehicleDetailsTBCollection(Collection<VehicleDetailsTB> vehicleDetailsTBCollection) {
        this.vehicleDetailsTBCollection = vehicleDetailsTBCollection;
    }

    public AgentTB getAgentId() {
        return agentId;
    }

    public void setAgentId(AgentTB agentId) {
        this.agentId = agentId;
    }

    public InsuredTB getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(InsuredTB insuredId) {
        this.insuredId = insuredId;
    }

    public PaymentTypeTB getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(PaymentTypeTB paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public PolicyStatusTB getPolicyStatusId() {
        return policyStatusId;
    }

    public void setPolicyStatusId(PolicyStatusTB policyStatusId) {
        this.policyStatusId = policyStatusId;
    }

    public PolicyTB getPolicyId() {
        return policyId;
    }

    public void setPolicyId(PolicyTB policyId) {
        this.policyId = policyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionOfPolicyId != null ? transactionOfPolicyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionOfPolicyTB)) {
            return false;
        }
        TransactionOfPolicyTB other = (TransactionOfPolicyTB) object;
        if ((this.transactionOfPolicyId == null && other.transactionOfPolicyId != null) || (this.transactionOfPolicyId != null && !this.transactionOfPolicyId.equals(other.transactionOfPolicyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TransactionOfPolicyTB[ transactionOfPolicyId=" + transactionOfPolicyId + " ]";
    }
    
}
