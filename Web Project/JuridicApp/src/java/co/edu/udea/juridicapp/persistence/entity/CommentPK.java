package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Embeddable()
public class CommentPK implements Serializable {

    private static final long serialVersionUID = 6482725099022643200L;
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "oeuvre_id")
    private long oeuvreId;

    public CommentPK() {
        super();
    }

    public CommentPK(long id, long oeuvreId) {
        this.id = id;
        this.oeuvreId = oeuvreId;
    }

    public long getId() {

        return (this.id);
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOeuvreId() {

        return (this.oeuvreId);
    }

    public void setOeuvreId(long oeuvreId) {
        this.oeuvreId = oeuvreId;
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += (int) this.getId();
        hash += (int) this.getOeuvreId();

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof CommentPK)) {

            return (false);
        }

        CommentPK other = (CommentPK) object;
        if (this.getId() != other.getId()) {

            return (false);
        }

        if (this.getOeuvreId() != other.getOeuvreId()) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.CommentPK[ id="
                + this.getId() + ", oeuvreId=" + this.getOeuvreId() + " ]");
    }
}