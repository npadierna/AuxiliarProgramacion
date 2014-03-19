package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable()
public class CommentPK implements Serializable {

    private static final long serialVersionUID = 6482725099022643200L;
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "oeuvre_id")
    private Long oeuvreId;

    public CommentPK() {
        super();
    }

    public CommentPK(Long id, Long oeuvreId) {
        this.id = id;
        this.oeuvreId = oeuvreId;
    }

    public Long getId() {

        return (this.id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOeuvreId() {

        return (this.oeuvreId);
    }

    public void setOeuvreId(Long oeuvreId) {
        this.oeuvreId = oeuvreId;
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (int) this.getId().longValue();
        hash += (int) this.getOeuvreId().longValue();

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