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
@Table(name = "BankBranchAreaTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BankBranchAreaTB.findAll", query = "SELECT b FROM BankBranchAreaTB b"),
    @NamedQuery(name = "BankBranchAreaTB.findByBankBranchAreaId", query = "SELECT b FROM BankBranchAreaTB b WHERE b.bankBranchAreaId = :bankBranchAreaId"),
    @NamedQuery(name = "BankBranchAreaTB.findByBankBranchArea", query = "SELECT b FROM BankBranchAreaTB b WHERE b.bankBranchArea = :bankBranchArea"),
    @NamedQuery(name = "BankBranchAreaTB.findByIFSCCode", query = "SELECT b FROM BankBranchAreaTB b WHERE b.iFSCCode = :iFSCCode"),
    @NamedQuery(name = "BankBranchAreaTB.findByIsActive", query = "SELECT b FROM BankBranchAreaTB b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BankBranchAreaTB.findByIsDelete", query = "SELECT b FROM BankBranchAreaTB b WHERE b.isDelete = :isDelete"),
    @NamedQuery(name = "BankBranchAreaTB.findByAddedOn", query = "SELECT b FROM BankBranchAreaTB b WHERE b.addedOn = :addedOn"),
    @NamedQuery(name = "BankBranchAreaTB.findByModifiedOn", query = "SELECT b FROM BankBranchAreaTB b WHERE b.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "BankBranchAreaTB.findByEnteredTerminal", query = "SELECT b FROM BankBranchAreaTB b WHERE b.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "BankBranchAreaTB.findByUpdatedTerminal", query = "SELECT b FROM BankBranchAreaTB b WHERE b.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "BankBranchAreaTB.findByTimeStamp", query = "SELECT b FROM BankBranchAreaTB b WHERE b.timeStamp = :timeStamp")})
public class BankBranchAreaTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BankBranchAreaId")
    private Integer bankBranchAreaId;
    @Basic(optional = false)
    @Column(name = "BankBranchArea")
    private String bankBranchArea;
    @Column(name = "IFSCCode")
    private String iFSCCode;
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
    @JoinColumn(name = "BankId", referencedColumnName = "BankId")
    @ManyToOne(optional = false)
    private BankTB bankId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankBranchAreaId")
    private Collection<HYPODetailsTB> hYPODetailsTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankBranchAreaId")
    private Collection<ChequePaymentDetailsTB> chequePaymentDetailsTBCollection;

    public BankBranchAreaTB() {
    }

    public BankBranchAreaTB(Integer bankBranchAreaId) {
        this.bankBranchAreaId = bankBranchAreaId;
    }

    public BankBranchAreaTB(Integer bankBranchAreaId, String bankBranchArea, boolean isActive, boolean isDelete) {
        this.bankBranchAreaId = bankBranchAreaId;
        this.bankBranchArea = bankBranchArea;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getBankBranchAreaId() {
        return bankBranchAreaId;
    }

    public void setBankBranchAreaId(Integer bankBranchAreaId) {
        this.bankBranchAreaId = bankBranchAreaId;
    }

    public String getBankBranchArea() {
        return bankBranchArea;
    }

    public void setBankBranchArea(String bankBranchArea) {
        this.bankBranchArea = bankBranchArea;
    }

    public String getIFSCCode() {
        return iFSCCode;
    }

    public void setIFSCCode(String iFSCCode) {
        this.iFSCCode = iFSCCode;
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

    public BankTB getBankId() {
        return bankId;
    }

    public void setBankId(BankTB bankId) {
        this.bankId = bankId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankBranchAreaId != null ? bankBranchAreaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BankBranchAreaTB)) {
            return false;
        }
        BankBranchAreaTB other = (BankBranchAreaTB) object;
        if ((this.bankBranchAreaId == null && other.bankBranchAreaId != null) || (this.bankBranchAreaId != null && !this.bankBranchAreaId.equals(other.bankBranchAreaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.BankBranchAreaTB[ bankBranchAreaId=" + bankBranchAreaId + " ]";
    }
    
}
