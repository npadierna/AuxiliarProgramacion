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

@Entity
@Table(name = "WORK_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkType.findAll", query = "SELECT w FROM WorkType w"),
    @NamedQuery(name = "WorkType.findByWorkId", query = "SELECT w FROM WorkType w WHERE w.workTypePK.workId = :workId"),
    @NamedQuery(name = "WorkType.findByTypeName", query = "SELECT w FROM WorkType w WHERE w.workTypePK.typeName = :typeName")})
public class WorkType implements IEntityContext, Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WorkTypePK workTypePK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workType")
    private List<AuthorWork> authorWorkList;
    @JoinColumn(name = "type_name", referencedColumnName = "name", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Type type;
    @JoinColumn(name = "work_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Work work;

    public WorkType() {
    }

    public WorkType(WorkTypePK workTypePK) {
        this.workTypePK = workTypePK;
    }

    public WorkType(long workId, String typeName) {
        this.workTypePK = new WorkTypePK(workId, typeName);
    }

    public WorkTypePK getWorkTypePK() {
        return workTypePK;
    }

    public void setWorkTypePK(WorkTypePK workTypePK) {
        this.workTypePK = workTypePK;
    }

    @XmlTransient
    public List<AuthorWork> getAuthorWorkList() {
        return authorWorkList;
    }

    public void setAuthorWorkList(List<AuthorWork> authorWorkList) {
        this.authorWorkList = authorWorkList;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workTypePK != null ? workTypePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkType)) {
            return false;
        }
        WorkType other = (WorkType) object;
        if ((this.workTypePK == null && other.workTypePK != null) || (this.workTypePK != null && !this.workTypePK.equals(other.workTypePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.juridicapp.persistence.entity.WorkType[ workTypePK=" + workTypePK + " ]";
    }

    @Override
    public Object getKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
