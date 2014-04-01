package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @NamedQuery(name = "Oeuvre.findAll", query = "SELECT o FROM Oeuvre o"),
    @NamedQuery(name = "Oeuvre.findById",
            query = "SELECT o FROM Oeuvre o WHERE o.id = :id"),
    @NamedQuery(name = "Oeuvre.findByTitle",
            query = "SELECT o FROM Oeuvre o WHERE o.title = :title"),
    @NamedQuery(name = "Oeuvre.findByDescription",
            query = "SELECT o FROM Oeuvre o WHERE o.description = :description")})
@Table(name = "OEUVRE")
@XmlRootElement()
public class Oeuvre implements IEntityContext, Serializable {

    private static final long serialVersionUID = 1468388231673335808L;
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 55)
    @Column(name = "title")
    private String title;
    @Size(max = 250)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oeuvre")
    private List<OeuvreType> oeuvreTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oeuvre")
    private List<Comment> commentList;
    @JoinColumn(name = "dependency", referencedColumnName = "name")
    @ManyToOne(optional = false)
    private Dependency dependency;

    public Oeuvre() {
        super();
    }

    public Oeuvre(Long id) {
        this.id = id;
    }

    public Oeuvre(String title) {
        this.title = title;
    }

    public Oeuvre(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {

        return (this.id);
    }

    public void setId(Long id) {
        this.id = id;
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
    public List<OeuvreType> getOeuvreTypeList() {

        return (this.oeuvreTypeList);
    }

    public void setOeuvreTypeList(List<OeuvreType> oeuvreTypeList) {
        this.oeuvreTypeList = oeuvreTypeList;
    }

    @XmlTransient()
    public List<Comment> getCommentList() {

        return (this.commentList);
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Dependency getDependency() {

        return (this.dependency);
    }

    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    @Override()
    public Long getKey() {

        return (this.getId());
    }

    @Override()
    public void setKey(Object key) {
        if (key instanceof String) {
            this.setId((Long) key);
        } else {
            throw new IllegalArgumentException("The key is not valid. Required: "
                    + Long.class.getSimpleName() + ", received: "
                    + key.getClass().getSimpleName());
        }
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += (this.getId() != null ? this.getId().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Oeuvre)) {

            return (false);
        }

        Oeuvre other = (Oeuvre) object;
        if (((this.getId() == null) && (other.getId() != null))
                || ((this.getId() != null)
                && !(this.getId().equals(other.getId())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.Oeuvre[ id="
                + this.getId() + " ]");
    }
}