/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author rebien
 */
@Entity
@Table(name = "DNDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dnda.findAll", query = "SELECT d FROM Dnda d"),
    @NamedQuery(name = "Dnda.findByNumber", query = "SELECT d FROM Dnda d WHERE d.number = :number")})
public class Dnda implements IEntityContext, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "number")
    private String number;
    @OneToMany(mappedBy = "dnda")
    private List<AuthorWork> authorWorkList;
    @OneToMany(mappedBy = "dnda")
    private List<Dependency> dependencyList;

    public Dnda() {
    }

    public Dnda(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @XmlTransient
    public List<AuthorWork> getAuthorWorkList() {
        return authorWorkList;
    }

    public void setAuthorWorkList(List<AuthorWork> authorWorkList) {
        this.authorWorkList = authorWorkList;
    }

    @XmlTransient
    public List<Dependency> getDependencyList() {
        return dependencyList;
    }

    public void setDependencyList(List<Dependency> dependencyList) {
        this.dependencyList = dependencyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (number != null ? number.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dnda)) {
            return false;
        }
        Dnda other = (Dnda) object;
        if ((this.number == null && other.number != null) || (this.number != null && !this.number.equals(other.number))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.juridicapp.persistence.entity.Dnda[ number=" + number + " ]";
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
