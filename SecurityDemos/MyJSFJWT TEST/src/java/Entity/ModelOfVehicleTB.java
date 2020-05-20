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
@Table(name = "ModelOfVehicleTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModelOfVehicleTB.findAll", query = "SELECT m FROM ModelOfVehicleTB m"),
    @NamedQuery(name = "ModelOfVehicleTB.findByModelOfVehicleId", query = "SELECT m FROM ModelOfVehicleTB m WHERE m.modelOfVehicleId = :modelOfVehicleId"),
    @NamedQuery(name = "ModelOfVehicleTB.findByModelOfVehicle", query = "SELECT m FROM ModelOfVehicleTB m WHERE m.modelOfVehicle = :modelOfVehicle"),
    @NamedQuery(name = "ModelOfVehicleTB.findByIsActive", query = "SELECT m FROM ModelOfVehicleTB m WHERE m.isActive = :isActive"),
    @NamedQuery(name = "ModelOfVehicleTB.findByIsDelete", query = "SELECT m FROM ModelOfVehicleTB m WHERE m.isDelete = :isDelete"),
    @NamedQuery(name = "ModelOfVehicleTB.findByAddedOn", query = "SELECT m FROM ModelOfVehicleTB m WHERE m.addedOn = :addedOn"),
    @NamedQuery(name = "ModelOfVehicleTB.findByModifiedOn", query = "SELECT m FROM ModelOfVehicleTB m WHERE m.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "ModelOfVehicleTB.findByEnteredTerminal", query = "SELECT m FROM ModelOfVehicleTB m WHERE m.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "ModelOfVehicleTB.findByUpdatedTerminal", query = "SELECT m FROM ModelOfVehicleTB m WHERE m.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "ModelOfVehicleTB.findByTimeStamp", query = "SELECT m FROM ModelOfVehicleTB m WHERE m.timeStamp = :timeStamp")})
public class ModelOfVehicleTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ModelOfVehicleId")
    private Integer modelOfVehicleId;
    @Basic(optional = false)
    @Column(name = "ModelOfVehicle")
    private String modelOfVehicle;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modelOfVehicleId")
    private Collection<VehicleIDVDetailsTB> vehicleIDVDetailsTBCollection;
    @JoinColumn(name = "VehicleTypeId", referencedColumnName = "VehicleTypeId")
    @ManyToOne(optional = false)
    private VehicleTypeTB vehicleTypeId;

    public ModelOfVehicleTB() {
    }

    public ModelOfVehicleTB(Integer modelOfVehicleId) {
        this.modelOfVehicleId = modelOfVehicleId;
    }

    public ModelOfVehicleTB(Integer modelOfVehicleId, String modelOfVehicle, boolean isActive, boolean isDelete) {
        this.modelOfVehicleId = modelOfVehicleId;
        this.modelOfVehicle = modelOfVehicle;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getModelOfVehicleId() {
        return modelOfVehicleId;
    }

    public void setModelOfVehicleId(Integer modelOfVehicleId) {
        this.modelOfVehicleId = modelOfVehicleId;
    }

    public String getModelOfVehicle() {
        return modelOfVehicle;
    }

    public void setModelOfVehicle(String modelOfVehicle) {
        this.modelOfVehicle = modelOfVehicle;
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

    public VehicleTypeTB getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(VehicleTypeTB vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modelOfVehicleId != null ? modelOfVehicleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModelOfVehicleTB)) {
            return false;
        }
        ModelOfVehicleTB other = (ModelOfVehicleTB) object;
        if ((this.modelOfVehicleId == null && other.modelOfVehicleId != null) || (this.modelOfVehicleId != null && !this.modelOfVehicleId.equals(other.modelOfVehicleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ModelOfVehicleTB[ modelOfVehicleId=" + modelOfVehicleId + " ]";
    }
    
}
