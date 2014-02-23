/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 *
 * @author rebien
 */
@Entity
@Table(name = "DEPENDENCY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependency.findAll", query = "SELECT d FROM Dependency d"),
    @NamedQuery(name = "Dependency.findByName", query = "SELECT d FROM Dependency d WHERE d.name = :name"),
    @NamedQuery(name = "Dependency.findByDescription", query = "SELECT d FROM Dependency d WHERE d.description = :description")})
public class Dependency implements IEntityContext, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "name")
    private String name;
    @Size(max = 75)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dependency")
    private List<User> userList;
    @JoinColumn(name = "dnda", referencedColumnName = "number")
    @ManyToOne
    private Dnda dnda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dependency")
    private List<Work> workList;

    public Dependency() {
    }

    public Dependency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Dnda getDnda() {
        return dnda;
    }

    public void setDnda(Dnda dnda) {
        this.dnda = dnda;
    }

    @XmlTransient
    public List<Work> getWorkList() {
        return workList;
    }

    public void setWorkList(List<Work> workList) {
        this.workList = workList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dependency)) {
            return false;
        }
        Dependency other = (Dependency) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.juridicapp.persistence.entity.Dependency[ name=" + name + " ]";
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
