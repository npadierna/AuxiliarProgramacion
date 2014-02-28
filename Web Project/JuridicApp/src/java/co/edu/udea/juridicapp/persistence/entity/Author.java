package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity()
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
    @NamedQuery(name = "Author.findByDocumentType",
            query = "SELECT a FROM Author a WHERE a.personPK.documentType = :documentType"),
    @NamedQuery(name = "Author.findByIdNumber",
            query = "SELECT a FROM Author a WHERE a.personPK.idNumber = :idNumber"),
    @NamedQuery(name = "Author.findByPhoneNumber",
            query = "SELECT a FROM Author a WHERE a.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Author.findByMobileNumber",
            query = "SELECT a FROM Author a WHERE a.mobileNumber = :mobileNumber")})
@Table(name = "AUTHOR")
@XmlRootElement()
public class Author implements IEntityContext, Serializable {

    private static final long serialVersionUID = 7906012567735675008L;
    @EmbeddedId()
    protected PersonPK personPK;
    @Size(max = 10)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Size(max = 12)
    @Column(name = "mobile_number")
    private String mobileNumber;
    @JoinColumns({
        @JoinColumn(name = "document_type",
                referencedColumnName = "document_type", insertable = false,
                updatable = false),
        @JoinColumn(name = "id_number", referencedColumnName = "id_number",
                insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Person person;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<AuthorWork> authorWorkList;

    public Author() {
        super();
    }

    public Author(PersonPK personPK) {
        this.personPK = personPK;
    }

    public Author(String documentType, String idNumber) {
        this.personPK = new PersonPK(documentType, idNumber);
    }

    public PersonPK getPersonPK() {

        return (this.personPK);
    }

    public void setPersonPK(PersonPK personPK) {
        this.personPK = personPK;
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

    public Person getPerson() {

        return (this.person);
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @XmlTransient()
    public List<AuthorWork> getAuthorWorkList() {

        return (this.authorWorkList);
    }

    public void setAuthorWorkList(List<AuthorWork> authorWorkList) {
        this.authorWorkList = authorWorkList;
    }

    @Override()
    public Object getKey() {

        return (this.getPersonPK());
    }

    @Override()
    public void setKey(Object key) {
        this.setPersonPK((PersonPK) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (personPK != null ? personPK.hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Author)) {

            return (false);
        }

        Author other = (Author) object;
        if (((this.personPK == null) && (other.personPK != null))
                || ((this.personPK != null)
                && !(this.personPK.equals(other.personPK)))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.Author[ authorPK="
                + this.getPersonPK() + " ]");
    }
}