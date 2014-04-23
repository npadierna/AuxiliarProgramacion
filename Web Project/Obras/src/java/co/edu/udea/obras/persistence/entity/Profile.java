package co.edu.udea.obras.persistence.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
    @NamedQuery(name = "Profile.findByTitle",
            query = "SELECT p FROM Profile p WHERE p.title = :title"),
    @NamedQuery(name = "Profile.findByDescription",
            query = "SELECT p FROM Profile p WHERE p.description = :description")})
@Table(name = "PROFILE")
@XmlRootElement()
public class Profile implements IEntityContext, Serializable {

    private static final long serialVersionUID = 6781430206875302912L;
    @Id()
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 25)
    @Column(name = "title")
    private String title;
    @Size(max = 150)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "title")
    private List<Client> clientList;

    public Profile() {
        super();
    }

    public Profile(String title) {
        this.title = title;
    }

    public String getTitle() {

        return (this.title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {

        return (this.description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient()
    public List<Client> getClientList() {

        return (this.clientList);
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override()
    public String getKey() {

        return (this.getTitle());
    }

    @Override()
    public void setKey(Object key) {
        if (key instanceof String) {
            this.setTitle((String) key);
        } else {
            throw new IllegalArgumentException("The key is not valid. Required: "
                    + String.class.getSimpleName() + ", received: "
                    + key.getClass().getSimpleName());
        }
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += (this.getTitle() != null ? this.getTitle().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Profile)) {

            return (false);
        }

        Profile other = (Profile) object;
        if (((this.getTitle() == null) && (other.getTitle() != null))
                || ((this.getTitle() != null)
                && !(this.getTitle().equals(other.getTitle())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.obras.persistence.entity.Profile[ title="
                + this.getTitle() + " ]");
    }
}