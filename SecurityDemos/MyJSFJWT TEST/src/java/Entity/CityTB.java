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
@Table(name = "CityTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CityTB.findAll", query = "SELECT c FROM CityTB c"),
    @NamedQuery(name = "CityTB.findByCityId", query = "SELECT c FROM CityTB c WHERE c.cityId = :cityId"),
    @NamedQuery(name = "CityTB.findByCity", query = "SELECT c FROM CityTB c WHERE c.city = :city"),
    @NamedQuery(name = "CityTB.findByIsActive", query = "SELECT c FROM CityTB c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "CityTB.findByIsDelete", query = "SELECT c FROM CityTB c WHERE c.isDelete = :isDelete"),
    @NamedQuery(name = "CityTB.findByAddedOn", query = "SELECT c FROM CityTB c WHERE c.addedOn = :addedOn"),
    @NamedQuery(name = "CityTB.findByModifiedOn", query = "SELECT c FROM CityTB c WHERE c.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "CityTB.findByEnteredTerminal", query = "SELECT c FROM CityTB c WHERE c.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "CityTB.findByUpdatedTerminal", query = "SELECT c FROM CityTB c WHERE c.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "CityTB.findByTimestamp", query = "SELECT c FROM CityTB c WHERE c.timestamp = :timestamp")})
public class CityTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CityId")
    private Integer cityId;
    @Basic(optional = false)
    @Column(name = "City")
    private String city;
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
    @JoinColumn(name = "StateId", referencedColumnName = "StateId")
    @ManyToOne(optional = false)
    private StateTB stateId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityId")
    private Collection<PincodeTB> pincodeTBCollection;

    public CityTB() {
    }

    public CityTB(Integer cityId) {
        this.cityId = cityId;
    }

    public CityTB(Integer cityId, String city, boolean isActive, boolean isDelete, Date timestamp) {
        this.cityId = cityId;
        this.city = city;
        this.isActive = isActive;
        this.isDelete = isDelete;
        this.timestamp = timestamp;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public StateTB getStateId() {
        return stateId;
    }

    public void setStateId(StateTB stateId) {
        this.stateId = stateId;
    }

    @XmlTransient
    public Collection<PincodeTB> getPincodeTBCollection() {
        return pincodeTBCollection;
    }

    public void setPincodeTBCollection(Collection<PincodeTB> pincodeTBCollection) {
        this.pincodeTBCollection = pincodeTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityTB)) {
            return false;
        }
        CityTB other = (CityTB) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.CityTB[ cityId=" + cityId + " ]";
    }
    
}
