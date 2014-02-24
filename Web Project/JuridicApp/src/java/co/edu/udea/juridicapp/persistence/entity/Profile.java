package co.edu.udea.juridicapp.persistence.entity;

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

@Entity()
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
    @NamedQuery(name = "Profile.findByRole",
            query = "SELECT p FROM Profile p WHERE p.role = :role"),
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
    @Column(name = "role")
    private String role;
    @Size(max = 50)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<User> userList;

    public Profile() {
        super();
    }

    public Profile(String role) {
        this.role = role;
    }

    public String getRole() {

        return (this.role);
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {

        return (this.description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient()
    public List<User> getUserList() {

        return (this.userList);
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override()
    public Object getKey() {

        return (this.getRole());
    }

    @Override()
    public void setKey(Object key) {
        this.setRole((String) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (role != null ? role.hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Profile)) {

            return (false);
        }

        Profile other = (Profile) object;
        if (((this.role == null) && (other.role != null)) || ((this.role != null)
                && !(this.role.equals(other.role)))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.Profile[ role="
                + this.getRole() + " ]");
    }
}