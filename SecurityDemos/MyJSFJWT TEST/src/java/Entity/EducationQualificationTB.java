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
@Table(name = "EducationQualificationTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EducationQualificationTB.findAll", query = "SELECT e FROM EducationQualificationTB e"),
    @NamedQuery(name = "EducationQualificationTB.findByEducationQualificationId", query = "SELECT e FROM EducationQualificationTB e WHERE e.educationQualificationId = :educationQualificationId"),
    @NamedQuery(name = "EducationQualificationTB.findByEducationQualification", query = "SELECT e FROM EducationQualificationTB e WHERE e.educationQualification = :educationQualification"),
    @NamedQuery(name = "EducationQualificationTB.findByIsActive", query = "SELECT e FROM EducationQualificationTB e WHERE e.isActive = :isActive"),
    @NamedQuery(name = "EducationQualificationTB.findByIsDelete", query = "SELECT e FROM EducationQualificationTB e WHERE e.isDelete = :isDelete"),
    @NamedQuery(name = "EducationQualificationTB.findByAddedOn", query = "SELECT e FROM EducationQualificationTB e WHERE e.addedOn = :addedOn"),
    @NamedQuery(name = "EducationQualificationTB.findByModifiedOn", query = "SELECT e FROM EducationQualificationTB e WHERE e.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "EducationQualificationTB.findByEnteredTerminal", query = "SELECT e FROM EducationQualificationTB e WHERE e.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "EducationQualificationTB.findByUpdatedTerminal", query = "SELECT e FROM EducationQualificationTB e WHERE e.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "EducationQualificationTB.findByTimeStamp", query = "SELECT e FROM EducationQualificationTB e WHERE e.timeStamp = :timeStamp")})
public class EducationQualificationTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EducationQualificationId")
    private Integer educationQualificationId;
    @Basic(optional = false)
    @Column(name = "EducationQualification")
    private String educationQualification;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationQualificationId")
    private Collection<InsuredTB> insuredTBCollection;

    public EducationQualificationTB() {
    }

    public EducationQualificationTB(Integer educationQualificationId) {
        this.educationQualificationId = educationQualificationId;
    }

    public EducationQualificationTB(Integer educationQualificationId, String educationQualification, boolean isActive, boolean isDelete) {
        this.educationQualificationId = educationQualificationId;
        this.educationQualification = educationQualification;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getEducationQualificationId() {
        return educationQualificationId;
    }

    public void setEducationQualificationId(Integer educationQualificationId) {
        this.educationQualificationId = educationQualificationId;
    }

    public String getEducationQualification() {
        return educationQualification;
    }

    public void setEducationQualification(String educationQualification) {
        this.educationQualification = educationQualification;
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
    public Collection<InsuredTB> getInsuredTBCollection() {
        return insuredTBCollection;
    }

    public void setInsuredTBCollection(Collection<InsuredTB> insuredTBCollection) {
        this.insuredTBCollection = insuredTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (educationQualificationId != null ? educationQualificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EducationQualificationTB)) {
            return false;
        }
        EducationQualificationTB other = (EducationQualificationTB) object;
        if ((this.educationQualificationId == null && other.educationQualificationId != null) || (this.educationQualificationId != null && !this.educationQualificationId.equals(other.educationQualificationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.EducationQualificationTB[ educationQualificationId=" + educationQualificationId + " ]";
    }
    
}
