package co.edu.udea.obras.persistence.entity;

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

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Entity()
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
    @NamedQuery(name = "Author.findByDocumentType",
            query = "SELECT a FROM Author a WHERE a.peoplePK.documentType = :documentType"),
    @NamedQuery(name = "Author.findByIdNumber",
            query = "SELECT a FROM Author a WHERE a.peoplePK.idNumber = :idNumber"),
    @NamedQuery(name = "Author.findByPhoneNumber",
            query = "SELECT a FROM Author a WHERE a.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Author.findByMobileNumber",
            query = "SELECT a FROM Author a WHERE a.mobileNumber = :mobileNumber")})
@Table(name = "AUTHOR")
@XmlRootElement()
public class Author implements IEntityContext, Serializable {

    private static final long serialVersionUID = 7906012567735675008L;
    @EmbeddedId()
    protected PeoplePK peoplePK;
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
    private People people;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<AuthorOeuvre> authorOeuvreList;

    public Author() {
        super();
    }

    public Author(PeoplePK peoplePK) {
        this.peoplePK = peoplePK;
    }

    public Author(String documentType, String idNumber) {
        this.peoplePK = new PeoplePK(documentType, idNumber);
    }

    public PeoplePK getPeoplePK() {

        return (this.peoplePK);
    }

    public void setPeoplePK(PeoplePK peoplePK) {
        this.peoplePK = peoplePK;
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

    public People getPeople() {

        return (this.people);
    }

    public void setPeople(People people) {
        this.people = people;
    }

    @XmlTransient()
    public List<AuthorOeuvre> getAuthorOeuvreList() {

        return (this.authorOeuvreList);
    }

    public void setAuthorOeuvreList(List<AuthorOeuvre> authorOeuvreList) {
        this.authorOeuvreList = authorOeuvreList;
    }

    @Override()
    public PeoplePK getKey() {

        return (this.getPeoplePK());
    }

    @Override()
    public void setKey(Object key) {
        if (key instanceof String) {
            this.setPeoplePK((PeoplePK) key);
        } else {
            throw new IllegalArgumentException("The key is not valid. Required: "
                    + PeoplePK.class.getSimpleName() + ", received: "
                    + key.getClass().getSimpleName());
        }
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += (this.getPeoplePK() != null ? this.getPeoplePK().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Author)) {

            return (false);
        }

        Author other = (Author) object;
        if (((this.getPeoplePK() == null) && (other.getPeoplePK() != null))
                || ((this.getPeoplePK() != null)
                && !(this.getPeoplePK().equals(other.getPeoplePK())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.obras.persistence.entity.Author[ peoplePK="
                + this.getPeoplePK() + " ]");
    }
}