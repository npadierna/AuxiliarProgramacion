package co.edu.udea.obras.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
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
    @NamedQuery(name = "AuthorOeuvre.findById",
            query = "SELECT a FROM AuthorOeuvre a WHERE a.id = :id"),
    @NamedQuery(name = "AuthorOeuvre.findByIsbn",
            query = "SELECT a FROM AuthorOeuvre a WHERE a.isbn = :isbn"),
    @NamedQuery(name = "AuthorOeuvre.findByRoute",
            query = "SELECT a FROM AuthorOeuvre a WHERE a.route = :route"),
    @NamedQuery(name = "AuthorOeuvre.findByLocationSupport",
            query = "SELECT a FROM AuthorOeuvre a WHERE a.locationSupport = :locationSupport")})
@Table(name = "AUTHOR_OEUVRE")
@XmlRootElement()
public class AuthorOeuvre implements IEntityContext, Serializable {

    private static final long serialVersionUID = 5346671195390452736L;
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 35)
    @Column(name = "isbn")
    private String isbn;
    @Size(max = 100)
    @Column(name = "route")
    private String route;
    @Size(max = 300)
    @Column(name = "location_support")
    private String locationSupport;
    @JoinColumn(name = "acquisition", referencedColumnName = "type")
    @ManyToOne(optional = false)
    private Acquisition acquisition;
    @JoinColumn(name = "contract", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Contract contract;
    @JoinColumn(name = "title", referencedColumnName = "profile")
    @ManyToOne(optional = false)
    private Title title;
    @JoinColumns({
        @JoinColumn(name = "document_type",
                referencedColumnName = "document_type"),
        @JoinColumn(name = "id_number", referencedColumnName = "id_number")})
    @ManyToOne(optional = false)
    private Author author;
    @JoinColumn(name = "dnda", referencedColumnName = "number")
    @ManyToOne()
    private Dnda dnda;
    @JoinColumn(name = "support_type", referencedColumnName = "type")
    @ManyToOne(optional = false)
    private Support supportType;
    @JoinColumns({
        @JoinColumn(name = "oeuvre_type_id",
                referencedColumnName = "oeuvre_id"),
        @JoinColumn(name = "oeuvre_type_name",
                referencedColumnName = "type_name")})
    @ManyToOne(optional = false)
    private OeuvreType oeuvreType;
    @Transient()
    private UploadedFile productFile;
    @Transient()
    private String dndaNumber;

    public AuthorOeuvre() {
        super();
    }

    public AuthorOeuvre(Long id) {
        this.id = id;
    }

    public Long getId() {

        return (this.id);
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLocationSupport() {

        return (this.locationSupport);
    }

    public void setLocationSupport(String locationSupport) {
        this.locationSupport = locationSupport;
    }

    public Acquisition getAcquisition() {

        return (this.acquisition);
    }

    public void setAcquisition(Acquisition acquisition) {
        this.acquisition = acquisition;
    }

    public Contract getContract() {

        return (this.contract);
    }

    public void setContract(Contract contract) {
        this.contract = contract;
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

    public String getDndaNumber() {

        return (this.dndaNumber);
    }

    public void setDndaNumber(String dndaNumber) {
        this.dndaNumber = dndaNumber;
    }

    @Override()
    public Long getKey() {

        return (this.getId());
    }

    @Override()
    public void setKey(Object key) {
        if (key instanceof Long) {
            this.setId((Long) key);
        } else {
            throw new IllegalArgumentException("The key is not valid. Required: "
                    + Long.class.getSimpleName() + ", received: "
                    + key.getClass().getSimpleName());
        }
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += (this.getId() != null ? getId().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof AuthorOeuvre)) {

            return (false);
        }

        AuthorOeuvre other = (AuthorOeuvre) object;
        if (((this.getId() == null) && (other.getId() != null))
                || ((this.getId() != null)
                && !(this.getId().equals(other.getId())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.obras.persistence.entity.AuthorOeuvre[ id="
                + this.getId() + " ]");
    }
}