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
@Table(name = "FuelTypeTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuelTypeTB.findAll", query = "SELECT f FROM FuelTypeTB f"),
    @NamedQuery(name = "FuelTypeTB.findByFuelTypeId", query = "SELECT f FROM FuelTypeTB f WHERE f.fuelTypeId = :fuelTypeId"),
    @NamedQuery(name = "FuelTypeTB.findByFuelType", query = "SELECT f FROM FuelTypeTB f WHERE f.fuelType = :fuelType"),
    @NamedQuery(name = "FuelTypeTB.findByIsActive", query = "SELECT f FROM FuelTypeTB f WHERE f.isActive = :isActive"),
    @NamedQuery(name = "FuelTypeTB.findByIsDelete", query = "SELECT f FROM FuelTypeTB f WHERE f.isDelete = :isDelete"),
    @NamedQuery(name = "FuelTypeTB.findByAddedOn", query = "SELECT f FROM FuelTypeTB f WHERE f.addedOn = :addedOn"),
    @NamedQuery(name = "FuelTypeTB.findByModifiedOn", query = "SELECT f FROM FuelTypeTB f WHERE f.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "FuelTypeTB.findByEnteredTerminal", query = "SELECT f FROM FuelTypeTB f WHERE f.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "FuelTypeTB.findByUpdatedTerminal", query = "SELECT f FROM FuelTypeTB f WHERE f.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "FuelTypeTB.findByTimeStamp", query = "SELECT f FROM FuelTypeTB f WHERE f.timeStamp = :timeStamp")})
public class FuelTypeTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FuelTypeId")
    private Integer fuelTypeId;
    @Basic(optional = false)
    @Column(name = "FuelType")
    private String fuelType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fuelTypeId")
    private Collection<VehicleDetailsTB> vehicleDetailsTBCollection;

    public FuelTypeTB() {
    }

    public FuelTypeTB(Integer fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public FuelTypeTB(Integer fuelTypeId, String fuelType, boolean isActive, boolean isDelete) {
        this.fuelTypeId = fuelTypeId;
        this.fuelType = fuelType;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getFuelTypeId() {
        return fuelTypeId;
    }

    public void setFuelTypeId(Integer fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
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
    public Collection<VehicleDetailsTB> getVehicleDetailsTBCollection() {
        return vehicleDetailsTBCollection;
    }

    public void setVehicleDetailsTBCollection(Collection<VehicleDetailsTB> vehicleDetailsTBCollection) {
        this.vehicleDetailsTBCollection = vehicleDetailsTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fuelTypeId != null ? fuelTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuelTypeTB)) {
            return false;
        }
        FuelTypeTB other = (FuelTypeTB) object;
        if ((this.fuelTypeId == null && other.fuelTypeId != null) || (this.fuelTypeId != null && !this.fuelTypeId.equals(other.fuelTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.FuelTypeTB[ fuelTypeId=" + fuelTypeId + " ]";
    }
    
}
