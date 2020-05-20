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
@Table(name = "DocumentsOfTOPTB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentsOfTOPTB.findAll", query = "SELECT d FROM DocumentsOfTOPTB d"),
    @NamedQuery(name = "DocumentsOfTOPTB.findByDocumentsOfTOPId", query = "SELECT d FROM DocumentsOfTOPTB d WHERE d.documentsOfTOPId = :documentsOfTOPId"),
    @NamedQuery(name = "DocumentsOfTOPTB.findByDocumentPath", query = "SELECT d FROM DocumentsOfTOPTB d WHERE d.documentPath = :documentPath"),
    @NamedQuery(name = "DocumentsOfTOPTB.findBySizeOfDoc", query = "SELECT d FROM DocumentsOfTOPTB d WHERE d.sizeOfDoc = :sizeOfDoc"),
    @NamedQuery(name = "DocumentsOfTOPTB.findByIsActive", query = "SELECT d FROM DocumentsOfTOPTB d WHERE d.isActive = :isActive"),
    @NamedQuery(name = "DocumentsOfTOPTB.findByIsDelete", query = "SELECT d FROM DocumentsOfTOPTB d WHERE d.isDelete = :isDelete"),
    @NamedQuery(name = "DocumentsOfTOPTB.findByAddedOn", query = "SELECT d FROM DocumentsOfTOPTB d WHERE d.addedOn = :addedOn"),
    @NamedQuery(name = "DocumentsOfTOPTB.findByModifiedOn", query = "SELECT d FROM DocumentsOfTOPTB d WHERE d.modifiedOn = :modifiedOn"),
    @NamedQuery(name = "DocumentsOfTOPTB.findByEnteredTerminal", query = "SELECT d FROM DocumentsOfTOPTB d WHERE d.enteredTerminal = :enteredTerminal"),
    @NamedQuery(name = "DocumentsOfTOPTB.findByUpdatedTerminal", query = "SELECT d FROM DocumentsOfTOPTB d WHERE d.updatedTerminal = :updatedTerminal"),
    @NamedQuery(name = "DocumentsOfTOPTB.findByTimeStamp", query = "SELECT d FROM DocumentsOfTOPTB d WHERE d.timeStamp = :timeStamp")})
public class DocumentsOfTOPTB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DocumentsOfTOPId")
    private Integer documentsOfTOPId;
    @Basic(optional = false)
    @Column(name = "DocumentPath")
    private String documentPath;
    @Basic(optional = false)
    @Column(name = "SizeOfDoc")
    private String sizeOfDoc;
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
    @JoinColumn(name = "TransactionOfPolicyId", referencedColumnName = "TransactionOfPolicyId")
    @ManyToOne(optional = false)
    private TransactionOfPolicyTB transactionOfPolicyId;

    public DocumentsOfTOPTB() {
    }

    public DocumentsOfTOPTB(Integer documentsOfTOPId) {
        this.documentsOfTOPId = documentsOfTOPId;
    }

    public DocumentsOfTOPTB(Integer documentsOfTOPId, String documentPath, String sizeOfDoc, boolean isActive, boolean isDelete) {
        this.documentsOfTOPId = documentsOfTOPId;
        this.documentPath = documentPath;
        this.sizeOfDoc = sizeOfDoc;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public Integer getDocumentsOfTOPId() {
        return documentsOfTOPId;
    }

    public void setDocumentsOfTOPId(Integer documentsOfTOPId) {
        this.documentsOfTOPId = documentsOfTOPId;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public String getSizeOfDoc() {
        return sizeOfDoc;
    }

    public void setSizeOfDoc(String sizeOfDoc) {
        this.sizeOfDoc = sizeOfDoc;
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

    public TransactionOfPolicyTB getTransactionOfPolicyId() {
        return transactionOfPolicyId;
    }

    public void setTransactionOfPolicyId(TransactionOfPolicyTB transactionOfPolicyId) {
        this.transactionOfPolicyId = transactionOfPolicyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentsOfTOPId != null ? documentsOfTOPId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentsOfTOPTB)) {
            return false;
        }
        DocumentsOfTOPTB other = (DocumentsOfTOPTB) object;
        if ((this.documentsOfTOPId == null && other.documentsOfTOPId != null) || (this.documentsOfTOPId != null && !this.documentsOfTOPId.equals(other.documentsOfTOPId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DocumentsOfTOPTB[ documentsOfTOPId=" + documentsOfTOPId + " ]";
    }
    
}
