package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable()
public class PeoplePK implements Serializable {

    private static final long serialVersionUID = 4593290196698966016L;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 45)
    @Column(name = "document_type")
    private String documentType;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 20)
    @Column(name = "id_number")
    private String idNumber;

    public PeoplePK() {
        super();
    }

    public PeoplePK(String documentType, String idNumber) {
        this.documentType = documentType;
        this.idNumber = idNumber;
    }

    public String getDocumentType() {

        return (this.documentType);
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getIdNumber() {

        return (this.idNumber);
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (this.getDocumentType() != null ? this.getDocumentType()
                .hashCode() : 0);
        hash += (this.getIdNumber() != null ? this.getIdNumber().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof PeoplePK)) {

            return (false);
        }

        PeoplePK other = (PeoplePK) object;
        if (((this.getDocumentType() == null)
                && (other.getDocumentType() != null))
                || ((this.getDocumentType() != null)
                && !(this.getDocumentType().equals(other.getDocumentType())))) {

            return (false);
        }

        if (((this.getIdNumber() == null) && (other.getIdNumber() != null))
                || ((this.getIdNumber() != null)
                && !(this.getIdNumber().equals(other.getIdNumber())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.PeoplePK[ documentType="
                + this.getDocumentType() + ", idNumber=" + this.getIdNumber()
                + " ]");
    }
}