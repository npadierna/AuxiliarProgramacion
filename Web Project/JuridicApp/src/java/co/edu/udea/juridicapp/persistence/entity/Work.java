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

@Entity()
@NamedQueries({
    @NamedQuery(name = "Work.findAll", query = "SELECT w FROM Work w"),
    @NamedQuery(name = "Work.findById",
            query = "SELECT w FROM Work w WHERE w.id = :id"),
    @NamedQuery(name = "Work.findByTitle",
            query = "SELECT w FROM Work w WHERE w.title = :title"),
    @NamedQuery(name = "Work.findByDescription",
            query = "SELECT w FROM Work w WHERE w.description = :description")})
@Table(name = "WORK")
@XmlRootElement()
public class Work implements IEntityContext, Serializable {

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
    @Size(max = 150)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "work")
    private List<Comment> commentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "work")
    private List<WorkType> workTypeList;
    @JoinColumn(name = "dependency", referencedColumnName = "name")
    @ManyToOne(optional = false)
    private Dependency dependency;

    public Work() {
        super();
    }

    public Work(Long id) {
        this.id = id;
    }

    public Work(String title) {
        this.title = title;
    }

    public Work(Long id, String title) {
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
    public List<Comment> getCommentList() {

        return (this.commentList);
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @XmlTransient()
    public List<WorkType> getWorkTypeList() {

        return (this.workTypeList);
    }

    public void setWorkTypeList(List<WorkType> workTypeList) {
        this.workTypeList = workTypeList;
    }

    public Dependency getDependency() {

        return (this.dependency);
    }

    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    @Override()
    public Object getKey() {

        return (this.getId());
    }

    @Override()
    public void setKey(Object key) {
        this.setId((Long) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Work)) {

            return (false);
        }

        Work other = (Work) object;
        if (((this.id == null) && (other.id != null)) || ((this.id != null)
                && !(this.id.equals(other.id)))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.Work[ id="
                + this.getId() + " ]");
    }
}