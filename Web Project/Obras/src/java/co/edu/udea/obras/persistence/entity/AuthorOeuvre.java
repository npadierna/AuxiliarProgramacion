package co.edu.udea.obras.persistence.entity;

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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Entity()
@NamedQueries({
    @NamedQuery(name = "AuthorOeuvre.findAll",
            query = "SELECT a FROM AuthorOeuvre a"),
    @NamedQuery(name = "AuthorOeuvre.findByOeuvreTypeId",
            query = "SELECT a FROM AuthorOeuvre a WHERE a.authorOeuvrePK.oeuvreTypeId = :oeuvreTypeId"),
    @NamedQuery(name = "AuthorOeuvre.findByOeuvreTypeName",
            query = "SELECT a FROM AuthorOeuvre a WHERE a.authorOeuvrePK.oeuvreTypeName = :oeuvreTypeName"),
    @NamedQuery(name = "AuthorOeuvre.findByDocumentType",
            query = "SELECT a FROM AuthorOeuvre a WHERE a.authorOeuvrePK.documentType = :documentType"),
    @NamedQuery(name = "AuthorOeuvre.findByIdNumber",
            query = "SELECT a FROM AuthorOeuvre a WHERE a.authorOeuvrePK.idNumber = :idNumber"),
    @NamedQuery(name = "AuthorOeuvre.findByContract",
            query = "SELECT a FROM AuthorOeuvre a WHERE a.authorOeuvrePK.contract = :contract"),
    @NamedQuery(name = "AuthorOeuvre.findByAcquisition",
            query = "SELECT a FROM AuthorOeuvre a WHERE a.authorOeuvrePK.acquisition = :acquisition"),
    @NamedQuery(name = "AuthorOeuvre.findByIsbn",
            query = "SELECT a FROM AuthorOeuvre a WHERE a.isbn = :isbn"),
    @NamedQuery(name = "AuthorOeuvre.findByRoute",
            query = "SELECT a FROM AuthorOeuvre a WHERE a.route = :route")})
@Table(name = "AUTHOR_OEUVRE")
@XmlRootElement()
public class AuthorOeuvre implements IEntityContext, Serializable {

    private static final long serialVersionUID = 5346671195390452736L;
    @EmbeddedId()
    protected AuthorOeuvrePK authorOeuvrePK;
    @Size(max = 35)
    @Column(name = "isbn")
    private String isbn;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 300)
    @Column(name = "route")
    private String route;
    @JoinColumn(name = "acquisition", referencedColumnName = "type",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Acquisition acquisition1;
    @JoinColumn(name = "contract", referencedColumnName = "id",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Contract contract1;
    @JoinColumn(name = "title", referencedColumnName = "profile")
    @ManyToOne(optional = false)
    private Title title;
    @JoinColumns({
        @JoinColumn(name = "document_type",
                referencedColumnName = "document_type", insertable = false,
                updatable = false),
        @JoinColumn(name = "id_number", referencedColumnName = "id_number",
                insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Author author;
    @JoinColumn(name = "dnda", referencedColumnName = "number")
    @ManyToOne()
    private Dnda dnda;
    @JoinColumn(name = "support_type", referencedColumnName = "type")
    @ManyToOne(optional = false)
    private Support supportType;
    @JoinColumns({
        @JoinColumn(name = "oeuvre_type_id", referencedColumnName = "oeuvre_id",
                insertable = false, updatable = false),
        @JoinColumn(name = "oeuvre_type_name",
                referencedColumnName = "type_name", insertable = false,
                updatable = false)})
    @ManyToOne(optional = false)
    private OeuvreType oeuvreType;
    @Transient()
    private UploadedFile productFile;

    public AuthorOeuvre() {
        super();
    }

    public AuthorOeuvre(AuthorOeuvrePK authorOeuvrePK) {
        this.authorOeuvrePK = authorOeuvrePK;
    }

    public AuthorOeuvre(AuthorOeuvrePK authorOeuvrePK, String route) {
        this.authorOeuvrePK = authorOeuvrePK;
        this.route = route;
    }

    public AuthorOeuvre(long oeuvreTypeId, String oeuvreTypeName,
            String documentType, String idNumber, String contract,
            String acquisition) {
        this.authorOeuvrePK = new AuthorOeuvrePK(oeuvreTypeId, oeuvreTypeName,
                documentType, idNumber, contract, acquisition);
    }

    public AuthorOeuvrePK getAuthorOeuvrePK() {

        return (this.authorOeuvrePK);
    }

    public void setAuthorOeuvrePK(AuthorOeuvrePK authorOeuvrePK) {
        this.authorOeuvrePK = authorOeuvrePK;
    }

    public String getIsbn() {

        return (this.isbn);
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getRoute() {

        return (this.route);
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Acquisition getAcquisition1() {

        return (this.acquisition1);
    }

    public void setAcquisition1(Acquisition acquisition1) {
        this.acquisition1 = acquisition1;
    }

    public Contract getContract1() {

        return (this.contract1);
    }

    public void setContract1(Contract contract1) {
        this.contract1 = contract1;
    }

    public Title getTitle() {

        return (this.title);
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Author getAuthor() {

        return (this.author);
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Dnda getDnda() {

        return (this.dnda);
    }

    public void setDnda(Dnda dnda) {
        this.dnda = dnda;
    }

    public Support getSupportType() {

        return (this.supportType);
    }

    public void setSupportType(Support supportType) {
        this.supportType = supportType;
    }

    public OeuvreType getOeuvreType() {

        return (this.oeuvreType);
    }

    public void setOeuvreType(OeuvreType oeuvreType) {
        this.oeuvreType = oeuvreType;
    }

    public UploadedFile getProductFile() {

        return (this.productFile);
    }

    public void setProductFile(UploadedFile productFile) {
        this.productFile = productFile;
    }

    @Override()
    public AuthorOeuvrePK getKey() {

        return (this.getAuthorOeuvrePK());
    }

    @Override()
    public void setKey(Object key) {
        if (key instanceof String) {
            this.setAuthorOeuvrePK((AuthorOeuvrePK) key);
        } else {
            throw new IllegalArgumentException("The key is not valid. Required: "
                    + AuthorOeuvrePK.class.getSimpleName() + ", received: "
                    + key.getClass().getSimpleName());
        }
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += (this.getAuthorOeuvrePK() != null
                ? this.getAuthorOeuvrePK().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof AuthorOeuvre)) {

            return (false);
        }

        AuthorOeuvre other = (AuthorOeuvre) object;
        if (((this.getAuthorOeuvrePK() == null)
                && (other.getAuthorOeuvrePK() != null))
                || ((this.getAuthorOeuvrePK() != null)
                && !(this.getAuthorOeuvrePK().equals(other.getAuthorOeuvrePK())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.obras.persistence.entity.AuthorOeuvre[ authorOeuvrePK="
                + this.getAuthorOeuvrePK() + " ]");
    }
}