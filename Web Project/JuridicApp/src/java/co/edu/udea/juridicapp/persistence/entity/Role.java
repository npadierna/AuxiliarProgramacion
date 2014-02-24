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
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByProfile",
            query = "SELECT r FROM Role r WHERE r.profile = :profile"),
    @NamedQuery(name = "Role.findByDescription",
            query = "SELECT r FROM Role r WHERE r.description = :description")})
@Table(name = "ROLE")
@XmlRootElement()
public class Role implements IEntityContext, Serializable {

    private static final long serialVersionUID = 3753879352471195648L;
    @Id()
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 35)
    @Column(name = "profile")
    private String profile;
    @Size(max = 75)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<AuthorWork> authorWorkList;

    public Role() {
        super();
    }

    public Role(String profile) {
        this.profile = profile;
    }

    public String getProfile() {

        return (this.profile);
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {

        return (this.description);
    }

    public void setDescription(String description) {
        this.description = description;
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

        return (this.getProfile());
    }

    @Override()
    public void setKey(Object key) {
        this.setProfile((String) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (profile != null ? profile.hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Role)) {

            return (false);
        }

        Role other = (Role) object;
        if (((this.profile == null) && (other.profile != null))
                || ((this.profile != null)
                && !(this.profile.equals(other.profile)))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.Role[ profile="
                + this.getProfile() + " ]");
    }
}