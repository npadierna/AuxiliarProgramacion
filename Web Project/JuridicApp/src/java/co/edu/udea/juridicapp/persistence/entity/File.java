package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity()
@NamedQueries({
    @NamedQuery(name = "File.findAll", query = "SELECT f FROM File f"),
    @NamedQuery(name = "File.findByPath",
            query = "SELECT f FROM File f WHERE f.path = :path")})
@Table(name = "FILE")
@XmlRootElement()
public class File implements IEntityContext, Serializable {

    private static final long serialVersionUID = 5624738972218021888L;
    @Id()
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 150)
    @Column(name = "path")
    private String path;
    @ManyToMany(mappedBy = "fileList")
    private List<AuthorWorkAcquisition> authorWorkAcquisitionList;

    public File() {
        super();
    }

    public File(String path) {
        this.path = path;
    }

    public String getPath() {

        return (this.path);
    }

    public void setPath(String path) {
        this.path = path;
    }

    @XmlTransient()
    public List<AuthorWorkAcquisition> getAuthorWorkAcquisitionList() {

        return (this.authorWorkAcquisitionList);
    }

    public void setAuthorWorkAcquisitionList(
            List<AuthorWorkAcquisition> authorWorkAcquisitionList) {
        this.authorWorkAcquisitionList = authorWorkAcquisitionList;
    }

    @Override()
    public Object getKey() {

        return (this.getPath());
    }

    @Override()
    public void setKey(Object key) {
        this.setPath((String) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (path != null ? path.hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof File)) {

            return (false);
        }

        File other = (File) object;
        if (((this.path == null) && (other.path != null)) || ((this.path != null)
                && !(this.path.equals(other.path)))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.File[ path="
                + this.getPath() + " ]");
    }
}