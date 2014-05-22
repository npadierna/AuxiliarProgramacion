package co.edu.udea.obras.persistence.entity;

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

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Entity()
@NamedQueries({
    @NamedQuery(name = "OeuvreType.findAll",
            query = "SELECT o FROM OeuvreType o"),
    @NamedQuery(name = "OeuvreType.findByOeuvreId",
            query = "SELECT o FROM OeuvreType o WHERE o.oeuvreTypePK.oeuvreId = :oeuvreId"),
    @NamedQuery(name = "OeuvreType.findByTypeName",
            query = "SELECT o FROM OeuvreType o WHERE o.oeuvreTypePK.typeName = :typeName")})
@Table(name = "OEUVRE_TYPE")
@XmlRootElement()
public class OeuvreType implements IEntityContext, Serializable {

    private static final long serialVersionUID = 5359015147593081856L;
    @EmbeddedId()
    protected OeuvreTypePK oeuvreTypePK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oeuvreType")
    private List<AuthorOeuvre> authorOeuvreList;
    @JoinColumn(name = "type_name", referencedColumnName = "name",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Type type;
    @JoinColumn(name = "oeuvre_id", referencedColumnName = "id",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Oeuvre oeuvre;

    public OeuvreType() {
        super();
    }

    public OeuvreType(OeuvreTypePK oeuvreTypePK) {
        this.oeuvreTypePK = oeuvreTypePK;
    }

    public OeuvreType(long oeuvreId, String typeName) {
        this.oeuvreTypePK = new OeuvreTypePK(oeuvreId, typeName);
    }

    public OeuvreTypePK getOeuvreTypePK() {

        return (this.oeuvreTypePK);
    }

    public void setOeuvreTypePK(OeuvreTypePK oeuvreTypePK) {
        this.oeuvreTypePK = oeuvreTypePK;
    }

    @XmlTransient()
    public List<AuthorOeuvre> getAuthorOeuvreList() {

        return (this.authorOeuvreList);
    }

    public void setAuthorOeuvreList(List<AuthorOeuvre> authorOeuvreList) {
        this.authorOeuvreList = authorOeuvreList;
    }

    public Type getType() {

        return (this.type);
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Oeuvre getOeuvre() {

        return (this.oeuvre);
    }

    public void setOeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
    }

    @Override()
    public OeuvreTypePK getKey() {

        return (this.getOeuvreTypePK());
    }

    @Override()
    public void setKey(Object key) {
        if (key instanceof OeuvreTypePK) {
            this.setOeuvreTypePK((OeuvreTypePK) key);
        } else {
            throw new IllegalArgumentException("The key is not valid. Required: "
                    + OeuvreTypePK.class.getSimpleName() + ", received: "
                    + key.getClass().getSimpleName());
        }
    }

    @Override()
    public int hashCode() {
        int hash = 0;

        hash += (this.getOeuvreTypePK() != null
                ? this.getOeuvreTypePK().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof OeuvreType)) {

            return (false);
        }

        OeuvreType other = (OeuvreType) object;
        if (((this.getOeuvreTypePK() == null)
                && (other.getOeuvreTypePK() != null))
                || ((this.getOeuvreTypePK() != null)
                && !(this.getOeuvreTypePK().equals(other.getOeuvreTypePK())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.obras.persistence.entity.OeuvreType[ oeuvreTypePK="
                + this.getOeuvreTypePK() + " ]");
    }
}