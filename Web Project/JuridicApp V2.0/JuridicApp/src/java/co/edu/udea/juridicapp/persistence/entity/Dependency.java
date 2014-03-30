package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Dependency.findAll", query = "SELECT d FROM Dependency d"),
    @NamedQuery(name = "Dependency.findByName",
            query = "SELECT d FROM Dependency d WHERE d.name = :name"),
    @NamedQuery(name = "Dependency.findByDescription",
            query = "SELECT d FROM Dependency d WHERE d.description = :description")})
@Table(name = "DEPENDENCY")
@XmlRootElement()
public class Dependency implements IEntityContext, Serializable {

    private static final long serialVersionUID = 3817477884820840448L;
    @Id()
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 35)
    @Column(name = "name")
    private String name;
    @Size(max = 150)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dependency")
    private List<Client> clientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dependency")
    private List<Oeuvre> oeuvreList;

    public Dependency() {
        super();
    }

    public Dependency(String name) {
        this.name = name;
    }

    public String getName() {

        return (this.name);
    }

    public void setName(String name) {
        this.name = name;
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

    @XmlTransient()
    public List<Oeuvre> getOeuvreList() {

        return (this.oeuvreList);
    }

    public void setOeuvreList(List<Oeuvre> oeuvreList) {
        this.oeuvreList = oeuvreList;
    }

    @Override()
    public String getKey() {

        return (this.getName());
    }

    @Override()
    public void setKey(Object key) {
        if (key instanceof String) {
            this.setName((String) key);
        } else {
            throw new IllegalArgumentException("The key is not valid. Required: "
                    + String.class.getSimpleName() + ", received: "
                    + key.getClass().getSimpleName());
        }
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (this.getName() != null ? this.getName().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Dependency)) {

            return (false);
        }

        Dependency other = (Dependency) object;
        if (((this.getName() == null) && (other.getName() != null))
                || ((this.getName() != null)
                && !(this.getName().equals(other.getName())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.Dependency[ name="
                + this.getName() + " ]");
    }
}