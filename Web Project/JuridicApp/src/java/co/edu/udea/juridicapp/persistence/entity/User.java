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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity()
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByDocumentType",
            query = "SELECT u FROM User u WHERE u.personPK.documentType = :documentType"),
    @NamedQuery(name = "User.findByIdNumber",
            query = "SELECT u FROM User u WHERE u.personPK.idNumber = :idNumber"),
    @NamedQuery(name = "User.findByUserName",
            query = "SELECT u FROM User u WHERE u.userName = :userName"),
    @NamedQuery(name = "User.findByPassword",
            query = "SELECT u FROM User u WHERE u.password = :password")})
@Table(name = "USER")
@XmlRootElement()
public class User implements IEntityContext, Serializable {

    private static final long serialVersionUID = 2453343269715335168L;
    @EmbeddedId()
    protected PersonPK personPK;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 25)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 25)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "dependency", referencedColumnName = "name")
    @ManyToOne(optional = false)
    private Dependency dependency;
    @JoinColumn(name = "role", referencedColumnName = "role")
    @ManyToOne(optional = false)
    private Profile role;
    @JoinColumns({
        @JoinColumn(name = "document_type",
                referencedColumnName = "document_type", insertable = false,
                updatable = false),
        @JoinColumn(name = "id_number", referencedColumnName = "id_number",
                insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Person person;

    public User() {
        super();
    }

    public User(PersonPK personPK) {
        this.personPK = personPK;
    }

    public User(PersonPK personPK, String userName, String password) {
        this.personPK = personPK;
        this.userName = userName;
        this.password = password;
    }

    public User(String documentType, String idNumber) {
        this.personPK = new PersonPK(documentType, idNumber);
    }

    public PersonPK getPersonPK() {

        return (this.personPK);
    }

    public void setPersonPK(PersonPK personPK) {
        this.personPK = personPK;
    }

    public String getUserName() {

        return (this.userName);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {

        return (this.password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Dependency getDependency() {

        return (this.dependency);
    }

    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    public Profile getRole() {

        return (this.role);
    }

    public void setRole(Profile role) {
        this.role = role;
    }

    public Person getPerson() {

        return (this.person);
    }

    public void setPerson(Person person) {
        this.person = person;
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
        if (!(object instanceof User)) {

            return (false);
        }

        User other = (User) object;
        if (((this.personPK == null) && (other.personPK != null))
                || ((this.personPK != null)
                && !(this.personPK.equals(other.personPK)))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.User[ userPK="
                + this.getPersonPK() + " ]");
    }
}