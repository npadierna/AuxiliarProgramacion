package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Embeddable()
public class OeuvreTypePK implements Serializable {

    private static final long serialVersionUID = 1761685017608673280L;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "oeuvre_id")
    private long oeuvreId;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 45)
    @Column(name = "type_name")
    private String typeName;

    public OeuvreTypePK() {
        super();
    }

    public OeuvreTypePK(long oeuvreId, String typeName) {
        this.oeuvreId = oeuvreId;
        this.typeName = typeName;
    }

    public long getOeuvreId() {

        return (this.oeuvreId);
    }

    public void setOeuvreId(long oeuvreId) {
        this.oeuvreId = oeuvreId;
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

        hash += (int) this.getOeuvreId();
        hash += (this.getTypeName() != null ? this.getTypeName().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof OeuvreTypePK)) {

            return (false);
        }

        OeuvreTypePK other = (OeuvreTypePK) object;
        if (this.getOeuvreId() != other.getOeuvreId()) {

            return (false);
        }

        if (((this.getTypeName() == null) && (other.getTypeName() != null))
                || ((this.getTypeName() != null)
                && !(this.getTypeName().equals(other.getTypeName())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.OeuvreTypePK[ oeuvreId="
                + this.getOeuvreId() + ", typeName=" + this.getTypeName() + " ]");
    }
}