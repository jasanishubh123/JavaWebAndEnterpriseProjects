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
@Table(name = "VehicleColorTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleColorTB.findAll", query = "SELECT v FROM VehicleColorTB v"),
    @NamedQuery(name = "VehicleColorTB.findByVehicleColorId", query = "SELECT v FROM VehicleColorTB v WHERE v.vehicleColorId = :vehicleColorId"),
    @NamedQuery(name = "VehicleColorTB.findByVehicleColor", query = "SELECT v FROM VehicleColorTB v WHERE v.vehicleColor = :vehicleColor"),
    @NamedQuery(name = "VehicleColorTB.findByIsActive", query = "SELECT v FROM VehicleColorTB v WHERE v.isActive = :isActive"),
    @NamedQuery(name = "VehicleColorTB.findByIsDelete", query = "SELECT v FROM VehicleColorTB v WHERE v.isDelete = :isDelete"),
    @NamedQuery(name = "VehicleColorTB.findByAddedOn", query = "SELECT v FROM VehicleColorTB v WHERE v.addedOn = :addedOn"),
    @NamedQuery(name = "VehicleColorTB.findByModifiedOn", query = "SELECT v FROM VehicleColorTB v WHERE v.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "VehicleColorTB.findByEnteredTerminal", query = "SELECT v FROM VehicleColorTB v WHERE v.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "VehicleColorTB.findByUpdatedTerminal", query = "SELECT v FROM VehicleColorTB v WHERE v.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "VehicleColorTB.findByTimeStamp", query = "SELECT v FROM VehicleColorTB v WHERE v.timeStamp = :timeStamp")})
public class VehicleColorTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VehicleColorId")
    private Integer vehicleColorId;
    @Basic(optional = false)
    @Column(name = "VehicleColor")
    private String vehicleColor;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicleColorId")
    private Collection<VehicleDetailsTB> vehicleDetailsTBCollection;

    public VehicleColorTB() {
    }

    public VehicleColorTB(Integer vehicleColorId) {
        this.vehicleColorId = vehicleColorId;
    }

    public VehicleColorTB(Integer vehicleColorId, String vehicleColor, boolean isActive, boolean isDelete) {
        this.vehicleColorId = vehicleColorId;
        this.vehicleColor = vehicleColor;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getVehicleColorId() {
        return vehicleColorId;
    }

    public void setVehicleColorId(Integer vehicleColorId) {
        this.vehicleColorId = vehicleColorId;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
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
        hash += (vehicleColorId != null ? vehicleColorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehicleColorTB)) {
            return false;
        }
        VehicleColorTB other = (VehicleColorTB) object;
        if ((this.vehicleColorId == null && other.vehicleColorId != null) || (this.vehicleColorId != null && !this.vehicleColorId.equals(other.vehicleColorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.VehicleColorTB[ vehicleColorId=" + vehicleColorId + " ]";
    }
    
}
