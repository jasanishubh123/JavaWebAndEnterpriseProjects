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
@Table(name = "ZoneOfIDV_VehicleTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZoneOfIDVVehicleTB.findAll", query = "SELECT z FROM ZoneOfIDVVehicleTB z"),
    @NamedQuery(name = "ZoneOfIDVVehicleTB.findByZoneOfIDVVehicleId", query = "SELECT z FROM ZoneOfIDVVehicleTB z WHERE z.zoneOfIDVVehicleId = :zoneOfIDVVehicleId"),
    @NamedQuery(name = "ZoneOfIDVVehicleTB.findByZoneOfIDVVehicle", query = "SELECT z FROM ZoneOfIDVVehicleTB z WHERE z.zoneOfIDVVehicle = :zoneOfIDVVehicle"),
    @NamedQuery(name = "ZoneOfIDVVehicleTB.findByIsActive", query = "SELECT z FROM ZoneOfIDVVehicleTB z WHERE z.isActive = :isActive"),
    @NamedQuery(name = "ZoneOfIDVVehicleTB.findByIsDelete", query = "SELECT z FROM ZoneOfIDVVehicleTB z WHERE z.isDelete = :isDelete"),
    @NamedQuery(name = "ZoneOfIDVVehicleTB.findByAddedOn", query = "SELECT z FROM ZoneOfIDVVehicleTB z WHERE z.addedOn = :addedOn"),
    @NamedQuery(name = "ZoneOfIDVVehicleTB.findByModifiedOn", query = "SELECT z FROM ZoneOfIDVVehicleTB z WHERE z.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "ZoneOfIDVVehicleTB.findByEnteredTerminal", query = "SELECT z FROM ZoneOfIDVVehicleTB z WHERE z.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "ZoneOfIDVVehicleTB.findByUpdatedTerminal", query = "SELECT z FROM ZoneOfIDVVehicleTB z WHERE z.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "ZoneOfIDVVehicleTB.findByTimeStamp", query = "SELECT z FROM ZoneOfIDVVehicleTB z WHERE z.timeStamp = :timeStamp")})
public class ZoneOfIDVVehicleTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ZoneOfIDV_VehicleId")
    private Integer zoneOfIDVVehicleId;
    @Basic(optional = false)
    @Column(name = "ZoneOfIDV_Vehicle")
    private String zoneOfIDVVehicle;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zoneOfIDVId")
    private Collection<VehicleIDVDetailsTB> vehicleIDVDetailsTBCollection;

    public ZoneOfIDVVehicleTB() {
    }

    public ZoneOfIDVVehicleTB(Integer zoneOfIDVVehicleId) {
        this.zoneOfIDVVehicleId = zoneOfIDVVehicleId;
    }

    public ZoneOfIDVVehicleTB(Integer zoneOfIDVVehicleId, String zoneOfIDVVehicle, boolean isActive, boolean isDelete) {
        this.zoneOfIDVVehicleId = zoneOfIDVVehicleId;
        this.zoneOfIDVVehicle = zoneOfIDVVehicle;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getZoneOfIDVVehicleId() {
        return zoneOfIDVVehicleId;
    }

    public void setZoneOfIDVVehicleId(Integer zoneOfIDVVehicleId) {
        this.zoneOfIDVVehicleId = zoneOfIDVVehicleId;
    }

    public String getZoneOfIDVVehicle() {
        return zoneOfIDVVehicle;
    }

    public void setZoneOfIDVVehicle(String zoneOfIDVVehicle) {
        this.zoneOfIDVVehicle = zoneOfIDVVehicle;
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
    public Collection<VehicleIDVDetailsTB> getVehicleIDVDetailsTBCollection() {
        return vehicleIDVDetailsTBCollection;
    }

    public void setVehicleIDVDetailsTBCollection(Collection<VehicleIDVDetailsTB> vehicleIDVDetailsTBCollection) {
        this.vehicleIDVDetailsTBCollection = vehicleIDVDetailsTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zoneOfIDVVehicleId != null ? zoneOfIDVVehicleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZoneOfIDVVehicleTB)) {
            return false;
        }
        ZoneOfIDVVehicleTB other = (ZoneOfIDVVehicleTB) object;
        if ((this.zoneOfIDVVehicleId == null && other.zoneOfIDVVehicleId != null) || (this.zoneOfIDVVehicleId != null && !this.zoneOfIDVVehicleId.equals(other.zoneOfIDVVehicleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ZoneOfIDVVehicleTB[ zoneOfIDVVehicleId=" + zoneOfIDVVehicleId + " ]";
    }
    
}
