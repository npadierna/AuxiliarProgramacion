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
@Table(name = "ACQUISITION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acquisition.findAll", query = "SELECT a FROM Acquisition a"),
    @NamedQuery(name = "Acquisition.findByType", query = "SELECT a FROM Acquisition a WHERE a.type = :type"),
    @NamedQuery(name = "Acquisition.findByDescription", query = "SELECT a FROM Acquisition a WHERE a.description = :description")})
public class Acquisition implements IEntityContext, Serializable {

    private static final long serialVersionUID = 1L;
    @Id()
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 35)
    @Column(name = "type")
    private String type;
    @Size(max = 75)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acquisition1")
    private List<AuthorWorkAcquisition> authorWorkAcquisitionList;

    public Acquisition() {
        super();
    }

    public Acquisition(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient()
    public List<AuthorWorkAcquisition> getAuthorWorkAcquisitionList() {
        return authorWorkAcquisitionList;
    }

    public void setAuthorWorkAcquisitionList(List<AuthorWorkAcquisition> authorWorkAcquisitionList) {
        this.authorWorkAcquisitionList = authorWorkAcquisitionList;
    }

    @Override()
    public void setKey(Object key) {
        this.setType((String) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (type != null ? type.hashCode() : 0);
        return hash;
    }

    @Override()
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acquisition)) {
            return false;
        }
        Acquisition other = (Acquisition) object;
        if ((this.type == null && other.type != null) || (this.type != null && !this.type.equals(other.type))) {
            return false;
        }
        return true;
    }

    @Override()
    public String toString() {
        return "co.edu.udea.juridicapp.persistence.entity.Acquisition[ type=" + type + " ]";
    }

    @Override()
    public Object getKey() {

        return (this.getType());
    }
}