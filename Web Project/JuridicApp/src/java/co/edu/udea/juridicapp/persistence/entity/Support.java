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
    @NamedQuery(name = "Support.findAll", query = "SELECT s FROM Support s"),
    @NamedQuery(name = "Support.findByType",
            query = "SELECT s FROM Support s WHERE s.type = :type"),
    @NamedQuery(name = "Support.findByDescription",
            query = "SELECT s FROM Support s WHERE s.description = :description")})
@Table(name = "SUPPORT")
@XmlRootElement()
public class Support implements IEntityContext, Serializable {

    private static final long serialVersionUID = 9137829237445768192L;
    @Id()
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 25)
    @Column(name = "type")
    private String type;
    @Size(max = 150)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supportType")
    private List<AuthorOeuvre> authorOeuvreList;

    public Support() {
        super();
    }

    public Support(String type) {
        this.type = type;
    }

    public String getType() {

        return (this.type);
    }

    public void setType(String type) {
        this.type = type;
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
    public Object getKey() {

        return (this.getType());
    }

    @Override()
    public void setKey(Object key) {
        this.setType((String) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (this.getType() != null ? this.getType().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Support)) {

            return (false);
        }

        Support other = (Support) object;
        if (((this.getType() == null) && (other.getType() != null))
                || ((this.getType() != null)
                && !(this.getType().equals(other.getType())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.Support[ type="
                + this.getType() + " ]");
    }
}