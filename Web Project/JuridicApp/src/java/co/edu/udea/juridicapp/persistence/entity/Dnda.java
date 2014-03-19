package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @NamedQuery(name = "Dnda.findAll", query = "SELECT d FROM Dnda d"),
    @NamedQuery(name = "Dnda.findByNumber",
            query = "SELECT d FROM Dnda d WHERE d.number = :number")})
@Table(name = "DNDA")
@XmlRootElement()
public class Dnda implements IEntityContext, Serializable {

    private static final long serialVersionUID = 7128773475845724160L;
    @Id()
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 30)
    @Column(name = "number")
    private String number;
    @OneToMany(mappedBy = "dnda")
    private List<AuthorOeuvre> authorOeuvreList;
    @OneToMany(mappedBy = "dnda")
    private List<Dependency> dependencyList;

    public Dnda() {
        super();
    }

    public Dnda(String number) {
        this.number = number;
    }

    public String getNumber() {

        return (this.number);
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @XmlTransient()
    public List<AuthorOeuvre> getAuthorOeuvreList() {

        return (this.authorOeuvreList);
    }

    public void setAuthorOeuvreList(List<AuthorOeuvre> authorOeuvreList) {
        this.authorOeuvreList = authorOeuvreList;
    }

    @XmlTransient()
    public List<Dependency> getDependencyList() {

        return (this.dependencyList);
    }

    public void setDependencyList(List<Dependency> dependencyList) {
        this.dependencyList = dependencyList;
    }

    @Override()
    public Object getKey() {

        return (this.getNumber());
    }

    @Override()
    public void setKey(Object key) {
        this.setNumber((String) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (this.getNumber() != null ? this.getNumber().hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Dnda)) {

            return (false);
        }

        Dnda other = (Dnda) object;
        if (((this.getNumber() == null) && (other.getNumber() != null))
                || ((this.getNumber() != null)
                && !(this.getNumber().equals(other.getNumber())))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.Dnda[ number="
                + this.getNumber() + " ]");
    }
}