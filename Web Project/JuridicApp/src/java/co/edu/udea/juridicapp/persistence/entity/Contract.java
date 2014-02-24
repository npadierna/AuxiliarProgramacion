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
    @NamedQuery(name = "Contract.findAll", query = "SELECT c FROM Contract c"),
    @NamedQuery(name = "Contract.findById",
            query = "SELECT c FROM Contract c WHERE c.id = :id")})
@Table(name = "CONTRACT")
@XmlRootElement()
public class Contract implements IEntityContext, Serializable {

    private static final long serialVersionUID = 3782084044581242880L;
    @Id()
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 30)
    @Column(name = "id")
    private String id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contract1")
    private List<AuthorWork> authorWorkList;

    public Contract() {
        super();
    }

    public Contract(String id) {
        this.id = id;
    }

    public String getId() {

        return (this.id);
    }

    public void setId(String id) {
        this.id = id;
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

        return (this.getId());
    }

    @Override()
    public void setKey(Object key) {
        this.setId((String) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Contract)) {

            return (false);
        }

        Contract other = (Contract) object;
        if (((this.id == null) && (other.id != null)) || ((this.id != null)
                && !(this.id.equals(other.id)))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.Contract[ id="
                + this.getId() + " ]");
    }
}