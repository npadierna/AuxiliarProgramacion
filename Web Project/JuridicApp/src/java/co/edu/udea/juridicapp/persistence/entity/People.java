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

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Entity()
@NamedQueries({
    @NamedQuery(name = "People.findAll", query = "SELECT p FROM People p"),
    @NamedQuery(name = "People.findByDocumentType",
            query = "SELECT p FROM People p WHERE p.peoplePK.documentType = :documentType"),
    @NamedQuery(name = "People.findByIdNumber",
            query = "SELECT p FROM People p WHERE p.peoplePK.idNumber = :idNumber"),
    @NamedQuery(name = "People.findByFirstNames",
            query = "SELECT p FROM People p WHERE p.firstNames = :firstNames"),
    @NamedQuery(name = "People.findByLastNames",
            query = "SELECT p FROM People p WHERE p.lastNames = :lastNames"),
    @NamedQuery(name = "People.findByEmail",
            query = "SELECT p FROM People p WHERE p.email = :email")})
@Table(name = "PEOPLE")
@XmlRootElement()
public class People implements IEntityContext, Serializable {

    private static final long serialVersionUID = 1620927707102707712L;
    @EmbeddedId()
    protected PeoplePK peoplePK;
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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "people")
    private Author author;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "people")
    private Client client;

    public People() {
        super();
    }

    public People(PeoplePK peoplePK) {
        this.peoplePK = peoplePK;
    }

    public People(PeoplePK peoplePK, String firstNames, String lastNames,
            String email) {
        this.peoplePK = peoplePK;
        this.firstNames = firstNames;
        this.lastNames = lastNames;
        this.email = email;
    }

    public People(String documentType, String idNumber) {
        this.peoplePK = new PeoplePK(documentType, idNumber);
    }

    public PeoplePK getPeoplePK() {

        return (this.peoplePK);
    }

    public void setPeoplePK(PeoplePK peoplePK) {
        this.peoplePK = peoplePK;
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

    public Client getClient() {

        return (this.client);
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override()
    public Object getKey() {

        return (this.getPeoplePK());
    }

    @Override()
    public void setKey(Object key) {
        this.setPeoplePK((PeoplePK) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (this.getPeoplePK() != null ? this.getPeoplePK().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof People)) {

            return (false);
        }

        People other = (People) object;
        if (((this.getPeoplePK() == null) && (other.getPeoplePK() != null))
                || ((this.getPeoplePK() != null)
                && !(this.getPeoplePK().equals(other.getPeoplePK())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.People[ peoplePK="
                + this.getPeoplePK() + " ]");
    }
}