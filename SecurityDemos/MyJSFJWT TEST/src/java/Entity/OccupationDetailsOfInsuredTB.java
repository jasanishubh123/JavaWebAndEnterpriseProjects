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
@Table(name = "OccupationDetailsOfInsuredTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OccupationDetailsOfInsuredTB.findAll", query = "SELECT o FROM OccupationDetailsOfInsuredTB o"),
    @NamedQuery(name = "OccupationDetailsOfInsuredTB.findByOccupationDetailsOfInsuredId", query = "SELECT o FROM OccupationDetailsOfInsuredTB o WHERE o.occupationDetailsOfInsuredId = :occupationDetailsOfInsuredId"),
    @NamedQuery(name = "OccupationDetailsOfInsuredTB.findByDesignation", query = "SELECT o FROM OccupationDetailsOfInsuredTB o WHERE o.designation = :designation"),
    @NamedQuery(name = "OccupationDetailsOfInsuredTB.findByGrossIncome", query = "SELECT o FROM OccupationDetailsOfInsuredTB o WHERE o.grossIncome = :grossIncome"),
    @NamedQuery(name = "OccupationDetailsOfInsuredTB.findByNameOfEmployeer", query = "SELECT o FROM OccupationDetailsOfInsuredTB o WHERE o.nameOfEmployeer = :nameOfEmployeer"),
    @NamedQuery(name = "OccupationDetailsOfInsuredTB.findByIsActive", query = "SELECT o FROM OccupationDetailsOfInsuredTB o WHERE o.isActive = :isActive"),
    @NamedQuery(name = "OccupationDetailsOfInsuredTB.findByIsDelete", query = "SELECT o FROM OccupationDetailsOfInsuredTB o WHERE o.isDelete = :isDelete"),
    @NamedQuery(name = "OccupationDetailsOfInsuredTB.findByAddedOn", query = "SELECT o FROM OccupationDetailsOfInsuredTB o WHERE o.addedOn = :addedOn"),
    @NamedQuery(name = "OccupationDetailsOfInsuredTB.findByModifiedOn", query = "SELECT o FROM OccupationDetailsOfInsuredTB o WHERE o.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "OccupationDetailsOfInsuredTB.findByEnteredTerminal", query = "SELECT o FROM OccupationDetailsOfInsuredTB o WHERE o.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "OccupationDetailsOfInsuredTB.findByUpdatedTerminal", query = "SELECT o FROM OccupationDetailsOfInsuredTB o WHERE o.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "OccupationDetailsOfInsuredTB.findByTimeStamp", query = "SELECT o FROM OccupationDetailsOfInsuredTB o WHERE o.timeStamp = :timeStamp")})
public class OccupationDetailsOfInsuredTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OccupationDetailsOfInsuredId")
    private Integer occupationDetailsOfInsuredId;
    @Basic(optional = false)
    @Column(name = "Designation")
    private String designation;
    @Basic(optional = false)
    @Column(name = "GrossIncome")
    private String grossIncome;
    @Basic(optional = false)
    @Column(name = "NameOfEmployeer")
    private String nameOfEmployeer;
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
    @JoinColumn(name = "InsuredId", referencedColumnName = "InsuredId")
    @ManyToOne(optional = false)
    private InsuredTB insuredId;
    @JoinColumn(name = "OccupationTypeId", referencedColumnName = "OccupationTypeId")
    @ManyToOne(optional = false)
    private OccupationTypeTB occupationTypeId;

    public OccupationDetailsOfInsuredTB() {
    }

    public OccupationDetailsOfInsuredTB(Integer occupationDetailsOfInsuredId) {
        this.occupationDetailsOfInsuredId = occupationDetailsOfInsuredId;
    }

    public OccupationDetailsOfInsuredTB(Integer occupationDetailsOfInsuredId, String designation, String grossIncome, String nameOfEmployeer, boolean isActive, boolean isDelete) {
        this.occupationDetailsOfInsuredId = occupationDetailsOfInsuredId;
        this.designation = designation;
        this.grossIncome = grossIncome;
        this.nameOfEmployeer = nameOfEmployeer;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getOccupationDetailsOfInsuredId() {
        return occupationDetailsOfInsuredId;
    }

    public void setOccupationDetailsOfInsuredId(Integer occupationDetailsOfInsuredId) {
        this.occupationDetailsOfInsuredId = occupationDetailsOfInsuredId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(String grossIncome) {
        this.grossIncome = grossIncome;
    }

    public String getNameOfEmployeer() {
        return nameOfEmployeer;
    }

    public void setNameOfEmployeer(String nameOfEmployeer) {
        this.nameOfEmployeer = nameOfEmployeer;
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

    public InsuredTB getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(InsuredTB insuredId) {
        this.insuredId = insuredId;
    }

    public OccupationTypeTB getOccupationTypeId() {
        return occupationTypeId;
    }

    public void setOccupationTypeId(OccupationTypeTB occupationTypeId) {
        this.occupationTypeId = occupationTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (occupationDetailsOfInsuredId != null ? occupationDetailsOfInsuredId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OccupationDetailsOfInsuredTB)) {
            return false;
        }
        OccupationDetailsOfInsuredTB other = (OccupationDetailsOfInsuredTB) object;
        if ((this.occupationDetailsOfInsuredId == null && other.occupationDetailsOfInsuredId != null) || (this.occupationDetailsOfInsuredId != null && !this.occupationDetailsOfInsuredId.equals(other.occupationDetailsOfInsuredId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.OccupationDetailsOfInsuredTB[ occupationDetailsOfInsuredId=" + occupationDetailsOfInsuredId + " ]";
    }
    
}
