package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity()
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByDocumentType",
            query = "SELECT p FROM Person p WHERE p.personPK.documentType = :documentType"),
    @NamedQuery(name = "Person.findByIdNumber",
            query = "SELECT p FROM Person p WHERE p.personPK.idNumber = :idNumber"),
    @NamedQuery(name = "Person.findByFirstNames",
            query = "SELECT p FROM Person p WHERE p.firstNames = :firstNames"),
    @NamedQuery(name = "Person.findByLastNames",
            query = "SELECT p FROM Person p WHERE p.lastNames = :lastNames"),
    @NamedQuery(name = "Person.findByEmail",
            query = "SELECT p FROM Person p WHERE p.email = :email")})
@Table(name = "PERSON")
@XmlRootElement()
public class Person implements IEntityContext, Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId()
    protected PersonPK personPK;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 35)
    @Column(name = "first_names")
    private String firstNames;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 35)
    @Column(name = "last_names")
    private String lastNames;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 35)
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Author author;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private User user;

    public Person() {
        super();
    }

    public Person(PersonPK personPK) {
        this.personPK = personPK;
    }

    public Person(PersonPK personPK, String firstNames, String lastNames, String email) {
        this.personPK = personPK;
        this.firstNames = firstNames;
        this.lastNames = lastNames;
        this.email = email;
    }

    public Person(String documentType, String idNumber) {
        this.personPK = new PersonPK(documentType, idNumber);
    }

    public PersonPK getPersonPK() {

        return (this.personPK);
    }

    public void setPersonPK(PersonPK personPK) {
        this.personPK = personPK;
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

    public String getEmail() {

        return (this.email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Author getAuthor() {

        return (this.author);
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public User getUser() {

        return (this.user);
    }

    public void setUser(User user) {
        this.user = user;
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
        if (!(object instanceof Person)) {

            return (false);
        }

        Person other = (Person) object;
        if (((this.personPK == null) && (other.personPK != null))
                || ((this.personPK != null)
                && !(this.personPK.equals(other.personPK)))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.Person[ personPK="
                + this.getPersonPK() + " ]");
    }
}