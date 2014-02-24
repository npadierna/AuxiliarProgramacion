package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity()
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
    @NamedQuery(name = "Author.findByDocumentType",
            query = "SELECT a FROM Author a WHERE a.authorPK.documentType = :documentType"),
    @NamedQuery(name = "Author.findByIdNumber",
            query = "SELECT a FROM Author a WHERE a.authorPK.idNumber = :idNumber"),
    @NamedQuery(name = "Author.findByFirstNames",
            query = "SELECT a FROM Author a WHERE a.firstNames = :firstNames"),
    @NamedQuery(name = "Author.findByLastNames",
            query = "SELECT a FROM Author a WHERE a.lastNames = :lastNames"),
    @NamedQuery(name = "Author.findByPhoneNumber",
            query = "SELECT a FROM Author a WHERE a.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Author.findByMobileNumber",
            query = "SELECT a FROM Author a WHERE a.mobileNumber = :mobileNumber"),
    @NamedQuery(name = "Author.findByEmail",
            query = "SELECT a FROM Author a WHERE a.email = :email")})
@Table(name = "AUTHOR")
@XmlRootElement()
public class Author implements IEntityContext, Serializable {

    private static final long serialVersionUID = 7906012567735675008L;
    @EmbeddedId()
    protected AuthorPK authorPK;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 25)
    @Column(name = "first_names")
    private String firstNames;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 25)
    @Column(name = "last_names")
    private String lastNames;
    @Size(max = 10)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Size(max = 12)
    @Column(name = "mobile_number")
    private String mobileNumber;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 25)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<AuthorWork> authorWorkList;

    public Author() {
        super();
    }

    public Author(AuthorPK authorPK) {
        this.authorPK = authorPK;
    }

    public Author(AuthorPK authorPK, String firstNames, String lastNames,
            String email) {
        this.authorPK = authorPK;
        this.firstNames = firstNames;
        this.lastNames = lastNames;
        this.email = email;
    }

    public Author(String documentType, String idNumber) {
        this.authorPK = new AuthorPK(documentType, idNumber);
    }

    public AuthorPK getAuthorPK() {

        return (this.authorPK);
    }

    public void setAuthorPK(AuthorPK authorPK) {
        this.authorPK = authorPK;
    }

    public String getFirstNames() {

        return (this.firstNames);
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getLastNames() {

        return (this.lastNames);
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getPhoneNumber() {

        return (this.phoneNumber);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobileNumber() {

        return (this.mobileNumber);
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {

        return (this.email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient()
    public List<AuthorWork> getAuthorWorkList() {

        return (this.authorWorkList);
    }

    public void setAuthorWorkList(List<AuthorWork> authorWorkList) {
        this.authorWorkList = authorWorkList;
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (authorPK != null ? authorPK.hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Author)) {

            return (false);
        }

        Author other = (Author) object;
        if (((this.authorPK == null) && (other.authorPK != null))
                || ((this.authorPK != null)
                && !(this.authorPK.equals(other.authorPK)))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.Author[ authorPK="
                + this.getAuthorPK() + " ]");
    }

    @Override()
    public Object getKey() {

        return (this.getAuthorPK());
    }

    @Override
    public void setKey(Object key) {
        this.setAuthorPK((AuthorPK) key);
    }
}