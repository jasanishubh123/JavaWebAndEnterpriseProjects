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
@Table(name = "StaffTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StaffTB.findAll", query = "SELECT s FROM StaffTB s"),
    @NamedQuery(name = "StaffTB.findByStaffId", query = "SELECT s FROM StaffTB s WHERE s.staffId = :staffId"),
    @NamedQuery(name = "StaffTB.findByFullName", query = "SELECT s FROM StaffTB s WHERE s.fullName = :fullName"),
    @NamedQuery(name = "StaffTB.findByEmailId", query = "SELECT s FROM StaffTB s WHERE s.emailId = :emailId"),
    @NamedQuery(name = "StaffTB.findByMobileNo", query = "SELECT s FROM StaffTB s WHERE s.mobileNo = :mobileNo"),
    @NamedQuery(name = "StaffTB.findByIsActive", query = "SELECT s FROM StaffTB s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "StaffTB.findByIsDelete", query = "SELECT s FROM StaffTB s WHERE s.isDelete = :isDelete"),
    @NamedQuery(name = "StaffTB.findByAddedOn", query = "SELECT s FROM StaffTB s WHERE s.addedOn = :addedOn"),
    @NamedQuery(name = "StaffTB.findByModifiedOn", query = "SELECT s FROM StaffTB s WHERE s.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "StaffTB.findByEnteredTerminal", query = "SELECT s FROM StaffTB s WHERE s.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "StaffTB.findByUpdatedTerminal", query = "SELECT s FROM StaffTB s WHERE s.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "StaffTB.findByTimeStamp", query = "SELECT s FROM StaffTB s WHERE s.timeStamp = :timeStamp")})
public class StaffTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "StaffId")
    private Integer staffId;
    @Basic(optional = false)
    @Column(name = "FullName")
    private String fullName;
    @Basic(optional = false)
    @Column(name = "EmailId")
    private String emailId;
    @Basic(optional = false)
    @Column(name = "MobileNo")
    private String mobileNo;
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
    @OneToMany(mappedBy = "staffId")
    private Collection<UserTB> userTBCollection;

    public StaffTB() {
    }

    public StaffTB(Integer staffId) {
        this.staffId = staffId;
    }

    public StaffTB(Integer staffId, String fullName, String emailId, String mobileNo, boolean isActive, boolean isDelete) {
        this.staffId = staffId;
        this.fullName = fullName;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
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
    public Collection<UserTB> getUserTBCollection() {
        return userTBCollection;
    }

    public void setUserTBCollection(Collection<UserTB> userTBCollection) {
        this.userTBCollection = userTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffId != null ? staffId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StaffTB)) {
            return false;
        }
        StaffTB other = (StaffTB) object;
        if ((this.staffId == null && other.staffId != null) || (this.staffId != null && !this.staffId.equals(other.staffId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.StaffTB[ staffId=" + staffId + " ]";
    }
    
}
