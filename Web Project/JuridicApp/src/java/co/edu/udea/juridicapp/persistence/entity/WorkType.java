package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity()
@NamedQueries({
    @NamedQuery(name = "WorkType.findAll", query = "SELECT w FROM WorkType w"),
    @NamedQuery(name = "WorkType.findByWorkId",
            query = "SELECT w FROM WorkType w WHERE w.workTypePK.workId = :workId"),
    @NamedQuery(name = "WorkType.findByTypeName",
            query = "SELECT w FROM WorkType w WHERE w.workTypePK.typeName = :typeName")})
@Table(name = "WORK_TYPE")
@XmlRootElement()
public class WorkType implements IEntityContext, Serializable {

    private static final long serialVersionUID = 5359015147593081856L;
    @EmbeddedId()
    protected WorkTypePK workTypePK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workType")
    private List<AuthorWork> authorWorkList;
    @JoinColumn(name = "type_name", referencedColumnName = "name",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Type type;
    @JoinColumn(name = "work_id", referencedColumnName = "id",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Work work;

    public WorkType() {
        super();
    }

    public WorkType(WorkTypePK workTypePK) {
        this.workTypePK = workTypePK;
    }

    public WorkType(long workId, String typeName) {
        this.workTypePK = new WorkTypePK(workId, typeName);
    }

    public WorkTypePK getWorkTypePK() {

        return (this.workTypePK);
    }

    public void setWorkTypePK(WorkTypePK workTypePK) {
        this.workTypePK = workTypePK;
    }

    @XmlTransient()
    public List<AuthorWork> getAuthorWorkList() {

        return (this.authorWorkList);
    }

    public void setAuthorWorkList(List<AuthorWork> authorWorkList) {
        this.authorWorkList = authorWorkList;
    }

    public Type getType() {

        return (this.type);
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Work getWork() {

        return (this.work);
    }

    public void setWork(Work work) {
        this.work = work;
    }

    @Override()
    public Object getKey() {

        return (this.getWorkTypePK());
    }

    @Override()
    public void setKey(Object key) {
        this.setWorkTypePK((WorkTypePK) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (workTypePK != null ? workTypePK.hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof WorkType)) {

            return (false);
        }

        WorkType other = (WorkType) object;
        if (((this.workTypePK == null) && (other.workTypePK != null))
                || ((this.workTypePK != null)
                && !(this.workTypePK.equals(other.workTypePK)))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.WorkType[ workTypePK="
                + this.getWorkTypePK() + " ]");
    }
}