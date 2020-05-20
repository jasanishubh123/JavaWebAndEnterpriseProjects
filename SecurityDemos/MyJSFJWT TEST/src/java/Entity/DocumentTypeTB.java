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
@Table(name = "DocumentTypeTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentTypeTB.findAll", query = "SELECT d FROM DocumentTypeTB d"),
    @NamedQuery(name = "DocumentTypeTB.findByDocumentTypeId", query = "SELECT d FROM DocumentTypeTB d WHERE d.documentTypeId = :documentTypeId"),
    @NamedQuery(name = "DocumentTypeTB.findByDocumentType", query = "SELECT d FROM DocumentTypeTB d WHERE d.documentType = :documentType"),
    @NamedQuery(name = "DocumentTypeTB.findByIsActive", query = "SELECT d FROM DocumentTypeTB d WHERE d.isActive = :isActive"),
    @NamedQuery(name = "DocumentTypeTB.findByIsDelete", query = "SELECT d FROM DocumentTypeTB d WHERE d.isDelete = :isDelete"),
    @NamedQuery(name = "DocumentTypeTB.findByAddedOn", query = "SELECT d FROM DocumentTypeTB d WHERE d.addedOn = :addedOn"),
    @NamedQuery(name = "DocumentTypeTB.findByModifiedOn", query = "SELECT d FROM DocumentTypeTB d WHERE d.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "DocumentTypeTB.findByEnteredTerminal", query = "SELECT d FROM DocumentTypeTB d WHERE d.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "DocumentTypeTB.findByUpdatedTerminal", query = "SELECT d FROM DocumentTypeTB d WHERE d.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "DocumentTypeTB.findByTimeStamp", query = "SELECT d FROM DocumentTypeTB d WHERE d.timeStamp = :timeStamp")})
public class DocumentTypeTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DocumentTypeId")
    private Integer documentTypeId;
    @Basic(optional = false)
    @Column(name = "DocumentType")
    private String documentType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentTypeId")
    private Collection<DocumentsOfTOPTB> documentsOfTOPTBCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentTypeId")
    private Collection<DocumentsOfInsuredTB> documentsOfInsuredTBCollection;

    public DocumentTypeTB() {
    }

    public DocumentTypeTB(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public DocumentTypeTB(Integer documentTypeId, String documentType, boolean isActive, boolean isDelete) {
        this.documentTypeId = documentTypeId;
        this.documentType = documentType;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Integer documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
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
    public Collection<DocumentsOfTOPTB> getDocumentsOfTOPTBCollection() {
        return documentsOfTOPTBCollection;
    }

    public void setDocumentsOfTOPTBCollection(Collection<DocumentsOfTOPTB> documentsOfTOPTBCollection) {
        this.documentsOfTOPTBCollection = documentsOfTOPTBCollection;
    }

    @XmlTransient
    public Collection<DocumentsOfInsuredTB> getDocumentsOfInsuredTBCollection() {
        return documentsOfInsuredTBCollection;
    }

    public void setDocumentsOfInsuredTBCollection(Collection<DocumentsOfInsuredTB> documentsOfInsuredTBCollection) {
        this.documentsOfInsuredTBCollection = documentsOfInsuredTBCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentTypeId != null ? documentTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentTypeTB)) {
            return false;
        }
        DocumentTypeTB other = (DocumentTypeTB) object;
        if ((this.documentTypeId == null && other.documentTypeId != null) || (this.documentTypeId != null && !this.documentTypeId.equals(other.documentTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DocumentTypeTB[ documentTypeId=" + documentTypeId + " ]";
    }
    
}
