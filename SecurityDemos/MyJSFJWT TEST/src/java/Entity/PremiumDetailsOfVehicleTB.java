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
@Table(name = "PremiumDetailsOfVehicleTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PremiumDetailsOfVehicleTB.findAll", query = "SELECT p FROM PremiumDetailsOfVehicleTB p"),
    @NamedQuery(name = "PremiumDetailsOfVehicleTB.findByPremiumDetailsOfVehicleId", query = "SELECT p FROM PremiumDetailsOfVehicleTB p WHERE p.premiumDetailsOfVehicleId = :premiumDetailsOfVehicleId"),
    @NamedQuery(name = "PremiumDetailsOfVehicleTB.findByTotalIDV", query = "SELECT p FROM PremiumDetailsOfVehicleTB p WHERE p.totalIDV = :totalIDV"),
    @NamedQuery(name = "PremiumDetailsOfVehicleTB.findByNetPremium", query = "SELECT p FROM PremiumDetailsOfVehicleTB p WHERE p.netPremium = :netPremium"),
    @NamedQuery(name = "PremiumDetailsOfVehicleTB.findByDiscount", query = "SELECT p FROM PremiumDetailsOfVehicleTB p WHERE p.discount = :discount"),
    @NamedQuery(name = "PremiumDetailsOfVehicleTB.findByGst", query = "SELECT p FROM PremiumDetailsOfVehicleTB p WHERE p.gst = :gst"),
    @NamedQuery(name = "PremiumDetailsOfVehicleTB.findByTotalPrem", query = "SELECT p FROM PremiumDetailsOfVehicleTB p WHERE p.totalPrem = :totalPrem"),
    @NamedQuery(name = "PremiumDetailsOfVehicleTB.findByIsActive", query = "SELECT p FROM PremiumDetailsOfVehicleTB p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "PremiumDetailsOfVehicleTB.findByIsDelete", query = "SELECT p FROM PremiumDetailsOfVehicleTB p WHERE p.isDelete = :isDelete"),
    @NamedQuery(name = "PremiumDetailsOfVehicleTB.findByAddedOn", query = "SELECT p FROM PremiumDetailsOfVehicleTB p WHERE p.addedOn = :addedOn"),
    @NamedQuery(name = "PremiumDetailsOfVehicleTB.findByModifiedOn", query = "SELECT p FROM PremiumDetailsOfVehicleTB p WHERE p.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "PremiumDetailsOfVehicleTB.findByEnteredTerminal", query = "SELECT p FROM PremiumDetailsOfVehicleTB p WHERE p.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "PremiumDetailsOfVehicleTB.findByUpdatedTerminal", query = "SELECT p FROM PremiumDetailsOfVehicleTB p WHERE p.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "PremiumDetailsOfVehicleTB.findByTimeStamp", query = "SELECT p FROM PremiumDetailsOfVehicleTB p WHERE p.timeStamp = :timeStamp")})
public class PremiumDetailsOfVehicleTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PremiumDetailsOfVehicleId")
    private Integer premiumDetailsOfVehicleId;
    @Basic(optional = false)
    @Column(name = "TotalIDV")
    private String totalIDV;
    @Basic(optional = false)
    @Column(name = "NetPremium")
    private String netPremium;
    @Basic(optional = false)
    @Column(name = "Discount")
    private int discount;
    @Basic(optional = false)
    @Column(name = "GST")
    private int gst;
    @Basic(optional = false)
    @Column(name = "TotalPrem")
    private String totalPrem;
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
    @JoinColumn(name = "TransactionOfPolicyId", referencedColumnName = "TransactionOfPolicyId")
    @ManyToOne(optional = false)
    private TransactionOfPolicyTB transactionOfPolicyId;

    public PremiumDetailsOfVehicleTB() {
    }

    public PremiumDetailsOfVehicleTB(Integer premiumDetailsOfVehicleId) {
        this.premiumDetailsOfVehicleId = premiumDetailsOfVehicleId;
    }

    public PremiumDetailsOfVehicleTB(Integer premiumDetailsOfVehicleId, String totalIDV, String netPremium, int discount, int gst, String totalPrem, boolean isActive, boolean isDelete) {
        this.premiumDetailsOfVehicleId = premiumDetailsOfVehicleId;
        this.totalIDV = totalIDV;
        this.netPremium = netPremium;
        this.discount = discount;
        this.gst = gst;
        this.totalPrem = totalPrem;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getPremiumDetailsOfVehicleId() {
        return premiumDetailsOfVehicleId;
    }

    public void setPremiumDetailsOfVehicleId(Integer premiumDetailsOfVehicleId) {
        this.premiumDetailsOfVehicleId = premiumDetailsOfVehicleId;
    }

    public String getTotalIDV() {
        return totalIDV;
    }

    public void setTotalIDV(String totalIDV) {
        this.totalIDV = totalIDV;
    }

    public String getNetPremium() {
        return netPremium;
    }

    public void setNetPremium(String netPremium) {
        this.netPremium = netPremium;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getGst() {
        return gst;
    }

    public void setGst(int gst) {
        this.gst = gst;
    }

    public String getTotalPrem() {
        return totalPrem;
    }

    public void setTotalPrem(String totalPrem) {
        this.totalPrem = totalPrem;
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

    public TransactionOfPolicyTB getTransactionOfPolicyId() {
        return transactionOfPolicyId;
    }

    public void setTransactionOfPolicyId(TransactionOfPolicyTB transactionOfPolicyId) {
        this.transactionOfPolicyId = transactionOfPolicyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (premiumDetailsOfVehicleId != null ? premiumDetailsOfVehicleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PremiumDetailsOfVehicleTB)) {
            return false;
        }
        PremiumDetailsOfVehicleTB other = (PremiumDetailsOfVehicleTB) object;
        if ((this.premiumDetailsOfVehicleId == null && other.premiumDetailsOfVehicleId != null) || (this.premiumDetailsOfVehicleId != null && !this.premiumDetailsOfVehicleId.equals(other.premiumDetailsOfVehicleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PremiumDetailsOfVehicleTB[ premiumDetailsOfVehicleId=" + premiumDetailsOfVehicleId + " ]";
    }
    
}
