package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Embeddable()
public class AuthorOeuvreAcquisitionFilePK implements Serializable {

    private static final long serialVersionUID = 8958642437642201088L;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 35)
    @Column(name = "acquisition")
    private String acquisition;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "oeuvre_type_id")
    private Long oeuvreTypeId;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 45)
    @Column(name = "oeuvre_type_name")
    private String oeuvreTypeName;
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
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 30)
    @Column(name = "contract")
    private String contract;

    public AuthorOeuvreAcquisitionFilePK() {
        super();
    }

    public AuthorOeuvreAcquisitionFilePK(String acquisition, Long oeuvreTypeId,
            String oeuvreTypeName, String documentType, String idNumber,
            String contract) {
        this.acquisition = acquisition;
        this.oeuvreTypeId = oeuvreTypeId;
        this.oeuvreTypeName = oeuvreTypeName;
        this.documentType = documentType;
        this.idNumber = idNumber;
        this.contract = contract;
    }

    public String getAcquisition() {

        return (this.acquisition);
    }

    public void setAcquisition(String acquisition) {
        this.acquisition = acquisition;
    }

    public Long getOeuvreTypeId() {

        return (this.oeuvreTypeId);
    }

    public void setOeuvreTypeId(Long oeuvreTypeId) {
        this.oeuvreTypeId = oeuvreTypeId;
    }

    public String getOeuvreTypeName() {

        return (this.oeuvreTypeName);
    }

    public void setOeuvreTypeName(String oeuvreTypeName) {
        this.oeuvreTypeName = oeuvreTypeName;
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

    public String getContract() {

        return (this.contract);
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += (this.getAcquisition() != null ? this.getAcquisition()
                .hashCode() : 0);
        hash += (int) this.getOeuvreTypeId().longValue();
        hash += (this.getOeuvreTypeName() != null ? this.getOeuvreTypeName()
                .hashCode() : 0);
        hash += (this.getDocumentType() != null ? this.getDocumentType()
                .hashCode() : 0);
        hash += (this.getIdNumber() != null ? this.getIdNumber().hashCode() : 0);
        hash += (this.getContract() != null ? this.getContract().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof AuthorOeuvreAcquisitionFilePK)) {

            return (false);
        }

        AuthorOeuvreAcquisitionFilePK other = (AuthorOeuvreAcquisitionFilePK) object;
        if (((this.getAcquisition() == null) && (other.getAcquisition() != null))
                || ((this.getAcquisition() != null)
                && !(this.getAcquisition().equals(other.getAcquisition())))) {

            return (false);
        }

        if (this.getOeuvreTypeId() != other.getOeuvreTypeId()) {

            return (false);
        }

        if (((this.getOeuvreTypeName() == null)
                && (other.getOeuvreTypeName() != null))
                || ((this.getOeuvreTypeName() != null)
                && !(this.getOeuvreTypeName().equals(other.getOeuvreTypeName())))) {

            return (false);
        }

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

        if (((this.getContract() == null) && (other.getContract() != null))
                || ((this.getContract() != null)
                && !(this.getContract().equals(other.getContract())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.AuthorOeuvreAcquisitionFilePK[ acquisition="
                + this.getAcquisition() + ", oeuvreTypeId="
                + this.getOeuvreTypeId() + ", oeuvreTypeName="
                + this.getOeuvreTypeName() + ", documentType="
                + this.getDocumentType() + ", idNumber=" + this.getIdNumber()
                + ", contract=" + this.getContract() + " ]");
    }
}