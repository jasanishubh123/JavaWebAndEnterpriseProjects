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
@Table(name = "AreaTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaTB.findAll", query = "SELECT a FROM AreaTB a"),
    @NamedQuery(name = "AreaTB.findByAreaId", query = "SELECT a FROM AreaTB a WHERE a.areaId = :areaId"),
    @NamedQuery(name = "AreaTB.findByAreaName", query = "SELECT a FROM AreaTB a WHERE a.areaName = :areaName"),
    @NamedQuery(name = "AreaTB.findByIsActive", query = "SELECT a FROM AreaTB a WHERE a.isActive = :isActive"),
    @NamedQuery(name = "AreaTB.findByIsDelete", query = "SELECT a FROM AreaTB a WHERE a.isDelete = :isDelete"),
    @NamedQuery(name = "AreaTB.findByAddedOn", query = "SELECT a FROM AreaTB a WHERE a.addedOn = :addedOn"),
    @NamedQuery(name = "AreaTB.findByModifiedOn", query = "SELECT a FROM AreaTB a WHERE a.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "AreaTB.findByEnteredTerminal", query = "SELECT a FROM AreaTB a WHERE a.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "AreaTB.findByUpdatedTerminal", query = "SELECT a FROM AreaTB a WHERE a.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "AreaTB.findByTimeStamp", query = "SELECT a FROM AreaTB a WHERE a.timeStamp = :timeStamp")})
public class AreaTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AreaId")
    private Integer areaId;
    @Basic(optional = false)
    @Column(name = "AreaName")
    private String areaName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaId")
    private Collection<AddressTB> addressTBCollection;
    @JoinColumn(name = "PincodeId", referencedColumnName = "PincodeId")
    @ManyToOne(optional = false)
    private PincodeTB pincodeId;

    public AreaTB() {
    }

    public AreaTB(Integer areaId) {
        this.areaId = areaId;
    }

    public AreaTB(Integer areaId, String areaName, boolean isActive, boolean isDelete) {
        this.areaId = areaId;
        this.areaName = areaName;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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
    public Collection<AddressTB> getAddressTBCollection() {
        return addressTBCollection;
    }

    public void setAddressTBCollection(Collection<AddressTB> addressTBCollection) {
        this.addressTBCollection = addressTBCollection;
    }

    public PincodeTB getPincodeId() {
        return pincodeId;
    }

    public void setPincodeId(PincodeTB pincodeId) {
        this.pincodeId = pincodeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaId != null ? areaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaTB)) {
            return false;
        }
        AreaTB other = (AreaTB) object;
        if ((this.areaId == null && other.areaId != null) || (this.areaId != null && !this.areaId.equals(other.areaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.AreaTB[ areaId=" + areaId + " ]";
    }
    
}
