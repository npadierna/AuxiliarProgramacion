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
    @NamedQuery(name = "Type.findAll", query = "SELECT t FROM Type t"),
    @NamedQuery(name = "Type.findByName",
            query = "SELECT t FROM Type t WHERE t.name = :name"),
    @NamedQuery(name = "Type.findByDescription",
            query = "SELECT t FROM Type t WHERE t.description = :description")})
@Table(name = "TYPE")
@XmlRootElement()
public class Type implements IEntityContext, Serializable {

    private static final long serialVersionUID = 4586395163987108864L;
    @Id()
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 75)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private List<WorkType> workTypeList;

    public Type() {
        super();
    }

    public Type(String name) {
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
    public List<WorkType> getWorkTypeList() {

        return (this.workTypeList);
    }

    public void setWorkTypeList(List<WorkType> workTypeList) {
        this.workTypeList = workTypeList;
    }

    @Override()
    public Object getKey() {

        return (this.getName());
    }

    @Override()
    public void setKey(Object key) {
        this.setName((String) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Type)) {

            return (false);
        }

        Type other = (Type) object;
        if (((this.name == null) && (other.name != null)) || ((this.name != null)
                && !(this.name.equals(other.name)))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.Type[ name="
                + this.getName() + " ]");
    }
}