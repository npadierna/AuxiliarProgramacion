package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable()
public class WorkTypePK implements Serializable {

    private static final long serialVersionUID = 1761685017608673280L;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "work_id")
    private long workId;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 45)
    @Column(name = "type_name")
    private String typeName;

    public WorkTypePK() {
        super();
    }

    public WorkTypePK(long workId, String typeName) {
        this.workId = workId;
        this.typeName = typeName;
    }

    public long getWorkId() {

        return (this.workId);
    }

    public void setWorkId(long workId) {
        this.workId = workId;
    }

    public String getTypeName() {

        return (this.typeName);
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (int) workId;
        hash += (typeName != null ? typeName.hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof WorkTypePK)) {

            return (false);
        }

        WorkTypePK other = (WorkTypePK) object;
        if (this.workId != other.workId) {

            return (false);
        }

        if (((this.typeName == null) && (other.typeName != null))
                || ((this.typeName != null)
                && !(this.typeName.equals(other.typeName)))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.WorkTypePK[ workId="
                + this.getWorkId() + ", typeName=" + this.getTypeName() + " ]");
    }
}