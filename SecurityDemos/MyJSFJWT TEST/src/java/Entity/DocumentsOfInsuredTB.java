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
@Table(name = "DocumentsOfInsuredTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentsOfInsuredTB.findAll", query = "SELECT d FROM DocumentsOfInsuredTB d"),
    @NamedQuery(name = "DocumentsOfInsuredTB.findByDocumentsOfInsuredId", query = "SELECT d FROM DocumentsOfInsuredTB d WHERE d.documentsOfInsuredId = :documentsOfInsuredId"),
    @NamedQuery(name = "DocumentsOfInsuredTB.findByDocumentPath", query = "SELECT d FROM DocumentsOfInsuredTB d WHERE d.documentPath = :documentPath"),
    @NamedQuery(name = "DocumentsOfInsuredTB.findByInsuredMasterId", query = "SELECT d FROM DocumentsOfInsuredTB d WHERE d.insuredMasterId = :insuredMasterId"),
    @NamedQuery(name = "DocumentsOfInsuredTB.findByIsActive", query = "SELECT d FROM DocumentsOfInsuredTB d WHERE d.isActive = :isActive"),
    @NamedQuery(name = "DocumentsOfInsuredTB.findByIsDelete", query = "SELECT d FROM DocumentsOfInsuredTB d WHERE d.isDelete = :isDelete"),
    @NamedQuery(name = "DocumentsOfInsuredTB.findByAddedOn", query = "SELECT d FROM DocumentsOfInsuredTB d WHERE d.addedOn = :addedOn"),
    @NamedQuery(name = "DocumentsOfInsuredTB.findByModifiedOn", query = "SELECT d FROM DocumentsOfInsuredTB d WHERE d.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "DocumentsOfInsuredTB.findByEnteredTerminal", query = "SELECT d FROM DocumentsOfInsuredTB d WHERE d.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "DocumentsOfInsuredTB.findByUpdatedTerminal", query = "SELECT d FROM DocumentsOfInsuredTB d WHERE d.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "DocumentsOfInsuredTB.findByTimeStamp", query = "SELECT d FROM DocumentsOfInsuredTB d WHERE d.timeStamp = :timeStamp")})
public class DocumentsOfInsuredTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DocumentsOfInsuredId")
    private Integer documentsOfInsuredId;
    @Basic(optional = false)
    @Column(name = "DocumentPath")
    private String documentPath;
    @Basic(optional = false)
    @Column(name = "InsuredMasterId")
    private int insuredMasterId;
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
    @JoinColumn(name = "DocumentTypeId", referencedColumnName = "DocumentTypeId")
    @ManyToOne(optional = false)
    private DocumentTypeTB documentTypeId;

    public DocumentsOfInsuredTB() {
    }

    public DocumentsOfInsuredTB(Integer documentsOfInsuredId) {
        this.documentsOfInsuredId = documentsOfInsuredId;
    }

    public DocumentsOfInsuredTB(Integer documentsOfInsuredId, String documentPath, int insuredMasterId, boolean isActive, boolean isDelete) {
        this.documentsOfInsuredId = documentsOfInsuredId;
        this.documentPath = documentPath;
        this.insuredMasterId = insuredMasterId;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getDocumentsOfInsuredId() {
        return documentsOfInsuredId;
    }

    public void setDocumentsOfInsuredId(Integer documentsOfInsuredId) {
        this.documentsOfInsuredId = documentsOfInsuredId;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public int getInsuredMasterId() {
        return insuredMasterId;
    }

    public void setInsuredMasterId(int insuredMasterId) {
        this.insuredMasterId = insuredMasterId;
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

    public DocumentTypeTB getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(DocumentTypeTB documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentsOfInsuredId != null ? documentsOfInsuredId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentsOfInsuredTB)) {
            return false;
        }
        DocumentsOfInsuredTB other = (DocumentsOfInsuredTB) object;
        if ((this.documentsOfInsuredId == null && other.documentsOfInsuredId != null) || (this.documentsOfInsuredId != null && !this.documentsOfInsuredId.equals(other.documentsOfInsuredId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DocumentsOfInsuredTB[ documentsOfInsuredId=" + documentsOfInsuredId + " ]";
    }
    
}
