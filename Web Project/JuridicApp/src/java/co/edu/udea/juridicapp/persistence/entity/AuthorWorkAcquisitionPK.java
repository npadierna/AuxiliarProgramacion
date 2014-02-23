/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author rebien
 */
@Embeddable
public class AuthorWorkAcquisitionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "acquisition")
    private String acquisition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "work_type_id")
    private long workTypeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "work_type_name")
    private String workTypeName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "document_type")
    private String documentType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "id_number")
    private String idNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "contract")
    private String contract;

    public AuthorWorkAcquisitionPK() {
    }

    public AuthorWorkAcquisitionPK(String acquisition, long workTypeId, String workTypeName, String documentType, String idNumber, String contract) {
        this.acquisition = acquisition;
        this.workTypeId = workTypeId;
        this.workTypeName = workTypeName;
        this.documentType = documentType;
        this.idNumber = idNumber;
        this.contract = contract;
    }

    public String getAcquisition() {
        return acquisition;
    }

    public void setAcquisition(String acquisition) {
        this.acquisition = acquisition;
    }

    public long getWorkTypeId() {
        return workTypeId;
    }

    public void setWorkTypeId(long workTypeId) {
        this.workTypeId = workTypeId;
    }

    public String getWorkTypeName() {
        return workTypeName;
    }

    public void setWorkTypeName(String workTypeName) {
        this.workTypeName = workTypeName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acquisition != null ? acquisition.hashCode() : 0);
        hash += (int) workTypeId;
        hash += (workTypeName != null ? workTypeName.hashCode() : 0);
        hash += (documentType != null ? documentType.hashCode() : 0);
        hash += (idNumber != null ? idNumber.hashCode() : 0);
        hash += (contract != null ? contract.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthorWorkAcquisitionPK)) {
            return false;
        }
        AuthorWorkAcquisitionPK other = (AuthorWorkAcquisitionPK) object;
        if ((this.acquisition == null && other.acquisition != null) || (this.acquisition != null && !this.acquisition.equals(other.acquisition))) {
            return false;
        }
        if (this.workTypeId != other.workTypeId) {
            return false;
        }
        if ((this.workTypeName == null && other.workTypeName != null) || (this.workTypeName != null && !this.workTypeName.equals(other.workTypeName))) {
            return false;
        }
        if ((this.documentType == null && other.documentType != null) || (this.documentType != null && !this.documentType.equals(other.documentType))) {
            return false;
        }
        if ((this.idNumber == null && other.idNumber != null) || (this.idNumber != null && !this.idNumber.equals(other.idNumber))) {
            return false;
        }
        if ((this.contract == null && other.contract != null) || (this.contract != null && !this.contract.equals(other.contract))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.juridicapp.persistence.entity.AuthorWorkAcquisitionPK[ acquisition=" + acquisition + ", workTypeId=" + workTypeId + ", workTypeName=" + workTypeName + ", documentType=" + documentType + ", idNumber=" + idNumber + ", contract=" + contract + " ]";
    }
    
}
