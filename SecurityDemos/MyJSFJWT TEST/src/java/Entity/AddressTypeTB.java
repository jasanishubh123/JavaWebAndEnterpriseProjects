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
@Table(name = "AddressTypeTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AddressTypeTB.findAll", query = "SELECT a FROM AddressTypeTB a"),
    @NamedQuery(name = "AddressTypeTB.findByAddressTypeId", query = "SELECT a FROM AddressTypeTB a WHERE a.addressTypeId = :addressTypeId"),
    @NamedQuery(name = "AddressTypeTB.findByAddressType", query = "SELECT a FROM AddressTypeTB a WHERE a.addressType = :addressType"),
    @NamedQuery(name = "AddressTypeTB.findByIsActive", query = "SELECT a FROM AddressTypeTB a WHERE a.isActive = :isActive"),
    @NamedQuery(name = "AddressTypeTB.findByIsDelete", query = "SELECT a FROM AddressTypeTB a WHERE a.isDelete = :isDelete"),
    @NamedQuery(name = "AddressTypeTB.findByAddedOn", query = "SELECT a FROM AddressTypeTB a WHERE a.addedOn = :addedOn"),
    @NamedQuery(name = "AddressTypeTB.findByModifiedOn", query = "SELECT a FROM AddressTypeTB a WHERE a.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "AddressTypeTB.findByEnteredTerminal", query = "SELECT a FROM AddressTypeTB a WHERE a.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "AddressTypeTB.findByUpdatedTerminal", query = "SELECT a FROM AddressTypeTB a WHERE a.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "AddressTypeTB.findByTimestamp", query = "SELECT a FROM AddressTypeTB a WHERE a.timestamp = :timestamp")})
public class AddressTypeTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AddressTypeId")
    private Integer addressTypeId;
    @Basic(optional = false)
    @Column(name = "AddressType")
    private String addressType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressTypeId")
    private Collection<AddressTB> addressTBCollection;

    public AddressTypeTB() {
    }

    public AddressTypeTB(Integer addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public AddressTypeTB(Integer addressTypeId, String addressType, boolean isActive, boolean isDelete, Date timestamp) {
        this.addressTypeId = addressTypeId;
        this.addressType = addressType;
        this.isActive = isActive;
        this.isDelete = isDelete;
        this.timestamp = timestamp;
    }

    public Integer getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(Integer addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
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

    @XmlTransient
    public Collection<AddressTB> getAddressTBCollection() {
        return addressTBCollection;
    }

    public void setAddressTBCollection(Collection<AddressTB> addressTBCollection) {
        this.addressTBCollection = addressTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressTypeId != null ? addressTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressTypeTB)) {
            return false;
        }
        AddressTypeTB other = (AddressTypeTB) object;
        if ((this.addressTypeId == null && other.addressTypeId != null) || (this.addressTypeId != null && !this.addressTypeId.equals(other.addressTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.AddressTypeTB[ addressTypeId=" + addressTypeId + " ]";
    }
    
}
