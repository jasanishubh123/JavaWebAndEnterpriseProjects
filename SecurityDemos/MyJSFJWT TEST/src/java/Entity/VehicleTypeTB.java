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
@Table(name = "VehicleTypeTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleTypeTB.findAll", query = "SELECT v FROM VehicleTypeTB v"),
    @NamedQuery(name = "VehicleTypeTB.findByVehicleTypeId", query = "SELECT v FROM VehicleTypeTB v WHERE v.vehicleTypeId = :vehicleTypeId"),
    @NamedQuery(name = "VehicleTypeTB.findByVehicleType", query = "SELECT v FROM VehicleTypeTB v WHERE v.vehicleType = :vehicleType"),
    @NamedQuery(name = "VehicleTypeTB.findByIsActive", query = "SELECT v FROM VehicleTypeTB v WHERE v.isActive = :isActive"),
    @NamedQuery(name = "VehicleTypeTB.findByIsDelete", query = "SELECT v FROM VehicleTypeTB v WHERE v.isDelete = :isDelete"),
    @NamedQuery(name = "VehicleTypeTB.findByAddedOn", query = "SELECT v FROM VehicleTypeTB v WHERE v.addedOn = :addedOn"),
    @NamedQuery(name = "VehicleTypeTB.findByModifiedOn", query = "SELECT v FROM VehicleTypeTB v WHERE v.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "VehicleTypeTB.findByEnteredTerminal", query = "SELECT v FROM VehicleTypeTB v WHERE v.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "VehicleTypeTB.findByUpdatedTerminal", query = "SELECT v FROM VehicleTypeTB v WHERE v.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "VehicleTypeTB.findByTimeStamp", query = "SELECT v FROM VehicleTypeTB v WHERE v.timeStamp = :timeStamp")})
public class VehicleTypeTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VehicleTypeId")
    private Integer vehicleTypeId;
    @Basic(optional = false)
    @Column(name = "VehicleType")
    private String vehicleType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleTypeId")
    private Collection<ModelOfVehicleTB> modelOfVehicleTBCollection;

    public VehicleTypeTB() {
    }

    public VehicleTypeTB(Integer vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public VehicleTypeTB(Integer vehicleTypeId, String vehicleType, boolean isActive, boolean isDelete) {
        this.vehicleTypeId = vehicleTypeId;
        this.vehicleType = vehicleType;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(Integer vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
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
    public Collection<ModelOfVehicleTB> getModelOfVehicleTBCollection() {
        return modelOfVehicleTBCollection;
    }

    public void setModelOfVehicleTBCollection(Collection<ModelOfVehicleTB> modelOfVehicleTBCollection) {
        this.modelOfVehicleTBCollection = modelOfVehicleTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehicleTypeId != null ? vehicleTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehicleTypeTB)) {
            return false;
        }
        VehicleTypeTB other = (VehicleTypeTB) object;
        if ((this.vehicleTypeId == null && other.vehicleTypeId != null) || (this.vehicleTypeId != null && !this.vehicleTypeId.equals(other.vehicleTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.VehicleTypeTB[ vehicleTypeId=" + vehicleTypeId + " ]";
    }
    
}
