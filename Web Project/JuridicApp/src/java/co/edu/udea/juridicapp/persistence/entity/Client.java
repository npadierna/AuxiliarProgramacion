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
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByDocumentType",
            query = "SELECT c FROM Client c WHERE c.peoplePK.documentType = :documentType"),
    @NamedQuery(name = "Client.findByIdNumber",
            query = "SELECT c FROM Client c WHERE c.peoplePK.idNumber = :idNumber"),
    @NamedQuery(name = "Client.findByUserName",
            query = "SELECT c FROM Client c WHERE c.userName = :userName"),
    @NamedQuery(name = "Client.findByPassword",
            query = "SELECT c FROM Client c WHERE c.password = :password")})
@Table(name = "CLIENT")
@XmlRootElement()
public class Client implements IEntityContext, Serializable {

    private static final long serialVersionUID = 2453343269715335168L;
    @EmbeddedId()
    protected PeoplePK peoplePK;
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
    @JoinColumn(name = "title", referencedColumnName = "title")
    @ManyToOne(optional = false)
    private Profile title;
    @JoinColumns({
        @JoinColumn(name = "document_type",
                referencedColumnName = "document_type", insertable = false,
                updatable = false),
        @JoinColumn(name = "id_number", referencedColumnName = "id_number",
                insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private People people;

    public Client() {
        super();
    }

    public Client(PeoplePK peoplePK) {
        this.peoplePK = peoplePK;
    }

    public Client(PeoplePK peoplePK, String userName, String password) {
        this.peoplePK = peoplePK;
        this.userName = userName;
        this.password = password;
    }

    public Client(String documentType, String idNumber) {
        this.peoplePK = new PeoplePK(documentType, idNumber);
    }

    public PeoplePK getPeoplePK() {

        return (this.peoplePK);
    }

    public void setPeoplePK(PeoplePK peoplePK) {
        this.peoplePK = peoplePK;
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

    public Profile getTitle() {

        return (this.title);
    }

    public void setTitle(Profile title) {
        this.title = title;
    }

    public People getPeople() {

        return (this.people);
    }

    public void setPeople(People people) {
        this.people = people;
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
        if (!(object instanceof Client)) {

            return (false);
        }

        Client other = (Client) object;
        if (((this.getPeoplePK() == null) && (other.getPeoplePK() != null))
                || ((this.getPeoplePK() != null)
                && !(this.getPeoplePK().equals(other.getPeoplePK())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.Client[ peoplePK="
                + this.getPeoplePK() + " ]");
    }
}