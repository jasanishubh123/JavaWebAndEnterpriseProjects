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
@Table(name = "BankTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BankTB.findAll", query = "SELECT b FROM BankTB b"),
    @NamedQuery(name = "BankTB.findByBankId", query = "SELECT b FROM BankTB b WHERE b.bankId = :bankId"),
    @NamedQuery(name = "BankTB.findByBankName", query = "SELECT b FROM BankTB b WHERE b.bankName = :bankName"),
    @NamedQuery(name = "BankTB.findByIsActive", query = "SELECT b FROM BankTB b WHERE b.isActive = :isActive"),
    @NamedQuery(name = "BankTB.findByIsDelete", query = "SELECT b FROM BankTB b WHERE b.isDelete = :isDelete"),
    @NamedQuery(name = "BankTB.findByAddedOn", query = "SELECT b FROM BankTB b WHERE b.addedOn = :addedOn"),
    @NamedQuery(name = "BankTB.findByModifiedOn", query = "SELECT b FROM BankTB b WHERE b.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "BankTB.findByEnteredTerminal", query = "SELECT b FROM BankTB b WHERE b.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "BankTB.findByUpdatedTerminal", query = "SELECT b FROM BankTB b WHERE b.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "BankTB.findByTimeStamp", query = "SELECT b FROM BankTB b WHERE b.timeStamp = :timeStamp")})
public class BankTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BankId")
    private Integer bankId;
    @Basic(optional = false)
    @Column(name = "BankName")
    private String bankName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankId")
    private Collection<BankBranchAreaTB> bankBranchAreaTBCollection;

    public BankTB() {
    }

    public BankTB(Integer bankId) {
        this.bankId = bankId;
    }

    public BankTB(Integer bankId, String bankName, boolean isActive, boolean isDelete) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
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
    public Collection<BankBranchAreaTB> getBankBranchAreaTBCollection() {
        return bankBranchAreaTBCollection;
    }

    public void setBankBranchAreaTBCollection(Collection<BankBranchAreaTB> bankBranchAreaTBCollection) {
        this.bankBranchAreaTBCollection = bankBranchAreaTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankId != null ? bankId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BankTB)) {
            return false;
        }
        BankTB other = (BankTB) object;
        if ((this.bankId == null && other.bankId != null) || (this.bankId != null && !this.bankId.equals(other.bankId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.BankTB[ bankId=" + bankId + " ]";
    }
    
}
