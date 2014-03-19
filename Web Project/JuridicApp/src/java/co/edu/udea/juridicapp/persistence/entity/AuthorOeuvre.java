package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "AuthorOeuvre.findByIsbn",
            query = "SELECT a FROM AuthorOeuvre a WHERE a.isbn = :isbn"),
    @NamedQuery(name = "AuthorOeuvre.findByStarting",
            query = "SELECT a FROM AuthorOeuvre a WHERE a.beginning = :beginning"),
    @NamedQuery(name = "AuthorOeuvre.findByDelivering",
            query = "SELECT a FROM AuthorOeuvre a WHERE a.delivering = :delivering")})
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
    @Column(name = "beginning")
    @Temporal(TemporalType.DATE)
    private Date beginning;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "delivering")
    @Temporal(TemporalType.DATE)
    private Date delivering;
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
    @ManyToOne
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorOeuvre")
    private List<AuthorOeuvreAcquisitionFile> authorOeuvreAcquisitionFileList;

    public AuthorOeuvre() {
        super();
    }

    public AuthorOeuvre(AuthorOeuvrePK authorOeuvrePK) {
        this.authorOeuvrePK = authorOeuvrePK;
    }

    public AuthorOeuvre(AuthorOeuvrePK authorOeuvrePK, Date beginning,
            Date delivering) {
        this.authorOeuvrePK = authorOeuvrePK;
        this.beginning = beginning;
        this.delivering = delivering;
    }

    public AuthorOeuvre(long oeuvreTypeId, String oeuvreTypeName,
            String documentType, String idNumber, String contract) {
        this.authorOeuvrePK = new AuthorOeuvrePK(oeuvreTypeId, oeuvreTypeName,
                documentType, idNumber, contract);
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

    public Date getBeginning() {

        return (this.beginning);
    }

    public void setBeginning(Date beginning) {
        this.beginning = beginning;
    }

    public Date getDelivering() {

        return (this.delivering);
    }

    public void setDelivering(Date delivering) {
        this.delivering = delivering;
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

    @XmlTransient()
    public List<AuthorOeuvreAcquisitionFile> getAuthorOeuvreAcquisitionFileList() {

        return (this.authorOeuvreAcquisitionFileList);
    }

    public void setAuthorOeuvreAcquisitionFileList(
            List<AuthorOeuvreAcquisitionFile> authorOeuvreAcquisitionFileList) {
        this.authorOeuvreAcquisitionFileList = authorOeuvreAcquisitionFileList;
    }

    @Override()
    public Object getKey() {

        return (this.getAuthorOeuvrePK());
    }

    @Override()
    public void setKey(Object key) {
        this.setAuthorOeuvrePK((AuthorOeuvrePK) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += (this.getAuthorOeuvrePK() != null ? this.getAuthorOeuvrePK()
                .hashCode() : 0);

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

        return ("co.edu.udea.juridicapp.persistence.entity.AuthorOeuvre[ authorOeuvrePK="
                + this.getAuthorOeuvrePK() + " ]");
    }
}