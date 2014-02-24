package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable()
public class AuthorPK implements Serializable {

    private static final long serialVersionUID = 8696583936858317824L;
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

    public AuthorPK() {
        super();
    }

    public AuthorPK(String documentType, String idNumber) {
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
        hash += (documentType != null ? documentType.hashCode() : 0);
        hash += (idNumber != null ? idNumber.hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof AuthorPK)) {

            return (false);
        }

        AuthorPK other = (AuthorPK) object;
        if (((this.documentType == null) && (other.documentType != null))
                || ((this.documentType != null)
                && !(this.documentType.equals(other.documentType)))) {

            return (false);
        }

        if (((this.idNumber == null) && (other.idNumber != null))
                || ((this.idNumber != null)
                && !(this.idNumber.equals(other.idNumber)))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.AuthorPK[ documentType="
                + this.getDocumentType() + ", idNumber=" + this.getIdNumber()
                + " ]");
    }
}