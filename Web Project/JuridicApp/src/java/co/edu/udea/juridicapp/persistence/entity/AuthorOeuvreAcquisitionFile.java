package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Entity()
@NamedQueries({
    @NamedQuery(name = "AuthorOeuvreAcquisitionFile.findAll",
            query = "SELECT a FROM AuthorOeuvreAcquisitionFile a"),
    @NamedQuery(name = "AuthorOeuvreAcquisitionFile.findByAcquisition",
            query = "SELECT a FROM AuthorOeuvreAcquisitionFile a WHERE a.authorOeuvreAcquisitionFilePK.acquisition = :acquisition"),
    @NamedQuery(name = "AuthorOeuvreAcquisitionFile.findByOeuvreTypeId",
            query = "SELECT a FROM AuthorOeuvreAcquisitionFile a WHERE a.authorOeuvreAcquisitionFilePK.oeuvreTypeId = :oeuvreTypeId"),
    @NamedQuery(name = "AuthorOeuvreAcquisitionFile.findByOeuvreTypeName",
            query = "SELECT a FROM AuthorOeuvreAcquisitionFile a WHERE a.authorOeuvreAcquisitionFilePK.oeuvreTypeName = :oeuvreTypeName"),
    @NamedQuery(name = "AuthorOeuvreAcquisitionFile.findByDocumentType",
            query = "SELECT a FROM AuthorOeuvreAcquisitionFile a WHERE a.authorOeuvreAcquisitionFilePK.documentType = :documentType"),
    @NamedQuery(name = "AuthorOeuvreAcquisitionFile.findByIdNumber",
            query = "SELECT a FROM AuthorOeuvreAcquisitionFile a WHERE a.authorOeuvreAcquisitionFilePK.idNumber = :idNumber"),
    @NamedQuery(name = "AuthorOeuvreAcquisitionFile.findByContract",
            query = "SELECT a FROM AuthorOeuvreAcquisitionFile a WHERE a.authorOeuvreAcquisitionFilePK.contract = :contract"),
    @NamedQuery(name = "AuthorOeuvreAcquisitionFile.findByRoute",
            query = "SELECT a FROM AuthorOeuvreAcquisitionFile a WHERE a.route = :route")})
@Table(name = "AUTHOR_OEUVRE_ACQUISITION_FILE")
@XmlRootElement()
public class AuthorOeuvreAcquisitionFile implements IEntityContext, Serializable {

    private static final long serialVersionUID = 2345966883812343808L;
    @EmbeddedId()
    protected AuthorOeuvreAcquisitionFilePK authorOeuvreAcquisitionFilePK;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 300)
    @Column(name = "route")
    private String route;
    @JoinColumns({
        @JoinColumn(name = "oeuvre_type_id",
                referencedColumnName = "oeuvre_type_id", insertable = false,
                updatable = false),
        @JoinColumn(name = "oeuvre_type_name",
                referencedColumnName = "oeuvre_type_name", insertable = false,
                updatable = false),
        @JoinColumn(name = "document_type",
                referencedColumnName = "document_type", insertable = false,
                updatable = false),
        @JoinColumn(name = "id_number", referencedColumnName = "id_number",
                insertable = false, updatable = false),
        @JoinColumn(name = "contract", referencedColumnName = "contract",
                insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private AuthorOeuvre authorOeuvre;
    @JoinColumn(name = "acquisition", referencedColumnName = "type",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Acquisition acquisition1;

    public AuthorOeuvreAcquisitionFile() {
        super();
    }

    public AuthorOeuvreAcquisitionFile(
            AuthorOeuvreAcquisitionFilePK authorOeuvreAcquisitionFilePK) {
        this.authorOeuvreAcquisitionFilePK = authorOeuvreAcquisitionFilePK;
    }

    public AuthorOeuvreAcquisitionFile(
            AuthorOeuvreAcquisitionFilePK authorOeuvreAcquisitionFilePK,
            String route) {
        this.authorOeuvreAcquisitionFilePK = authorOeuvreAcquisitionFilePK;
        this.route = route;
    }

    public AuthorOeuvreAcquisitionFile(String acquisition, long oeuvreTypeId,
            String oeuvreTypeName, String documentType, String idNumber,
            String contract) {
        this.authorOeuvreAcquisitionFilePK = new AuthorOeuvreAcquisitionFilePK(
                acquisition, oeuvreTypeId, oeuvreTypeName, documentType,
                idNumber, contract);
    }

    public AuthorOeuvreAcquisitionFilePK getAuthorOeuvreAcquisitionFilePK() {

        return (this.authorOeuvreAcquisitionFilePK);
    }

    public void setAuthorOeuvreAcquisitionFilePK(
            AuthorOeuvreAcquisitionFilePK authorOeuvreAcquisitionFilePK) {
        this.authorOeuvreAcquisitionFilePK = authorOeuvreAcquisitionFilePK;
    }

    public String getRoute() {

        return (this.route);
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public AuthorOeuvre getAuthorOeuvre() {

        return (this.authorOeuvre);
    }

    public void setAuthorOeuvre(AuthorOeuvre authorOeuvre) {
        this.authorOeuvre = authorOeuvre;
    }

    public Acquisition getAcquisition1() {

        return (this.acquisition1);
    }

    public void setAcquisition1(Acquisition acquisition1) {
        this.acquisition1 = acquisition1;
    }

    @Override()
    public AuthorOeuvreAcquisitionFilePK getKey() {

        return (this.getAuthorOeuvreAcquisitionFilePK());
    }

    @Override()
    public void setKey(Object key) {
        if (key instanceof String) {
            this.setAuthorOeuvreAcquisitionFilePK(
                    (AuthorOeuvreAcquisitionFilePK) key);
        } else {
            throw new IllegalArgumentException("The key is not valid. Required: "
                    + AuthorOeuvreAcquisitionFilePK.class.getSimpleName()
                    + ", received: " + key.getClass().getSimpleName());
        }
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += (this.getAuthorOeuvreAcquisitionFilePK() != null
                ? this.getAuthorOeuvreAcquisitionFilePK().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof AuthorOeuvreAcquisitionFile)) {

            return (false);
        }

        AuthorOeuvreAcquisitionFile other = (AuthorOeuvreAcquisitionFile) object;
        if (((this.getAuthorOeuvreAcquisitionFilePK() == null)
                && (other.getAuthorOeuvreAcquisitionFilePK() != null))
                || ((this.getAuthorOeuvreAcquisitionFilePK() != null)
                && !(this.getAuthorOeuvreAcquisitionFilePK().equals(other.getAuthorOeuvreAcquisitionFilePK())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.AuthorOeuvreAcquisitionFile[ authorOeuvreAcquisitionFilePK="
                + this.getAuthorOeuvreAcquisitionFilePK() + " ]");
    }
}