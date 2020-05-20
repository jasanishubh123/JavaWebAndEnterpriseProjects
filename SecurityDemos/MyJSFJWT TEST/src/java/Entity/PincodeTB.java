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
@Table(name = "PincodeTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PincodeTB.findAll", query = "SELECT p FROM PincodeTB p"),
    @NamedQuery(name = "PincodeTB.findByPincodeId", query = "SELECT p FROM PincodeTB p WHERE p.pincodeId = :pincodeId"),
    @NamedQuery(name = "PincodeTB.findByPincode", query = "SELECT p FROM PincodeTB p WHERE p.pincode = :pincode"),
    @NamedQuery(name = "PincodeTB.findByIsActive", query = "SELECT p FROM PincodeTB p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "PincodeTB.findByIsDelete", query = "SELECT p FROM PincodeTB p WHERE p.isDelete = :isDelete"),
    @NamedQuery(name = "PincodeTB.findByAddedOn", query = "SELECT p FROM PincodeTB p WHERE p.addedOn = :addedOn"),
    @NamedQuery(name = "PincodeTB.findByModifiedOn", query = "SELECT p FROM PincodeTB p WHERE p.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "PincodeTB.findByEnteredTerminal", query = "SELECT p FROM PincodeTB p WHERE p.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "PincodeTB.findByUpdatedTerminal", query = "SELECT p FROM PincodeTB p WHERE p.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "PincodeTB.findByTimestamp", query = "SELECT p FROM PincodeTB p WHERE p.timestamp = :timestamp")})
public class PincodeTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PincodeId")
    private Integer pincodeId;
    @Basic(optional = false)
    @Column(name = "Pincode")
    private int pincode;
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
    @Basic(optional = false)
    @Column(name = "Timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @JoinColumn(name = "CityId", referencedColumnName = "CityId")
    @ManyToOne(optional = false)
    private CityTB cityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pincodeId")
    private Collection<AreaTB> areaTBCollection;

    public PincodeTB() {
    }

    public PincodeTB(Integer pincodeId) {
        this.pincodeId = pincodeId;
    }

    public PincodeTB(Integer pincodeId, int pincode, boolean isActive, boolean isDelete, Date timestamp) {
        this.pincodeId = pincodeId;
        this.pincode = pincode;
        this.isActive = isActive;
        this.isDelete = isDelete;
        this.timestamp = timestamp;
    }

    public Integer getPincodeId() {
        return pincodeId;
    }

    public void setPincodeId(Integer pincodeId) {
        this.pincodeId = pincodeId;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public CityTB getCityId() {
        return cityId;
    }

    public void setCityId(CityTB cityId) {
        this.cityId = cityId;
    }

    @XmlTransient
    public Collection<AreaTB> getAreaTBCollection() {
        return areaTBCollection;
    }

    public void setAreaTBCollection(Collection<AreaTB> areaTBCollection) {
        this.areaTBCollection = areaTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pincodeId != null ? pincodeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PincodeTB)) {
            return false;
        }
        PincodeTB other = (PincodeTB) object;
        if ((this.pincodeId == null && other.pincodeId != null) || (this.pincodeId != null && !this.pincodeId.equals(other.pincodeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PincodeTB[ pincodeId=" + pincodeId + " ]";
    }
    
}
