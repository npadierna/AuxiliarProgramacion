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

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Entity()
@NamedQueries({
    @NamedQuery(name = "Title.findAll", query = "SELECT t FROM Title t"),
    @NamedQuery(name = "Title.findByProfile",
            query = "SELECT t FROM Title t WHERE t.profile = :profile"),
    @NamedQuery(name = "Title.findByDescription",
            query = "SELECT t FROM Title t WHERE t.description = :description")})
@Table(name = "TITLE")
@XmlRootElement()
public class Title implements IEntityContext, Serializable {

    private static final long serialVersionUID = 3753879352471195648L;
    @Id()
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 35)
    @Column(name = "profile")
    private String profile;
    @Size(max = 150)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "title")
    private List<AuthorOeuvre> authorOeuvreList;

    public Title() {
        super();
    }

    public Title(String profile) {
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
    public List<AuthorOeuvre> getAuthorOeuvreList() {

        return (this.authorOeuvreList);
    }

    public void setAuthorOeuvreList(List<AuthorOeuvre> authorOeuvreList) {
        this.authorOeuvreList = authorOeuvreList;
    }

    @Override()
    public String getKey() {

        return (this.getProfile());
    }

    @Override()
    public void setKey(Object key) {
        if (key instanceof String) {
            this.setProfile((String) key);
        } else {
            throw new IllegalArgumentException("The key is not valid. Required: "
                    + String.class.getSimpleName() + ", received: "
                    + key.getClass().getSimpleName());
        }
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += (this.getProfile() != null ? this.getProfile().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Title)) {

            return (false);
        }

        Title other = (Title) object;
        if (((this.getProfile() == null) && (other.getProfile() != null))
                || ((this.getProfile() != null)
                && !(this.getProfile().equals(other.getProfile())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.Title[ profile="
                + this.getProfile() + " ]");
    }
}