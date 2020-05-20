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
@Table(name = "AdminTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminTB.findAll", query = "SELECT a FROM AdminTB a"),
    @NamedQuery(name = "AdminTB.findByAdminId", query = "SELECT a FROM AdminTB a WHERE a.adminId = :adminId"),
    @NamedQuery(name = "AdminTB.findByFullName", query = "SELECT a FROM AdminTB a WHERE a.fullName = :fullName"),
    @NamedQuery(name = "AdminTB.findByEmailId", query = "SELECT a FROM AdminTB a WHERE a.emailId = :emailId"),
    @NamedQuery(name = "AdminTB.findByMobileNo", query = "SELECT a FROM AdminTB a WHERE a.mobileNo = :mobileNo"),
    @NamedQuery(name = "AdminTB.findByIsActive", query = "SELECT a FROM AdminTB a WHERE a.isActive = :isActive"),
    @NamedQuery(name = "AdminTB.findByIsDelete", query = "SELECT a FROM AdminTB a WHERE a.isDelete = :isDelete"),
    @NamedQuery(name = "AdminTB.findByAddedOn", query = "SELECT a FROM AdminTB a WHERE a.addedOn = :addedOn"),
    @NamedQuery(name = "AdminTB.findByModifiedOn", query = "SELECT a FROM AdminTB a WHERE a.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "AdminTB.findByEnteredTerminal", query = "SELECT a FROM AdminTB a WHERE a.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "AdminTB.findByUpdatedTerminal", query = "SELECT a FROM AdminTB a WHERE a.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "AdminTB.findByTimeStamp", query = "SELECT a FROM AdminTB a WHERE a.timeStamp = :timeStamp")})
public class AdminTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AdminId")
    private Integer adminId;
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
    @OneToMany(mappedBy = "adminId")
    private Collection<UserTB> userTBCollection;

    public AdminTB() {
    }

    public AdminTB(Integer adminId) {
        this.adminId = adminId;
    }

    public AdminTB(Integer adminId, String fullName, String emailId, String mobileNo, boolean isActive, boolean isDelete) {
        this.adminId = adminId;
        this.fullName = fullName;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
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
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminTB)) {
            return false;
        }
        AdminTB other = (AdminTB) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.AdminTB[ adminId=" + adminId + " ]";
    }
    
}
