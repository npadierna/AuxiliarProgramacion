package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Entity()
@NamedQueries({
    @NamedQuery(name = "Contract.findAll", query = "SELECT c FROM Contract c"),
    @NamedQuery(name = "Contract.findById",
            query = "SELECT c FROM Contract c WHERE c.id = :id"),
    @NamedQuery(name = "Contract.findByRoute",
            query = "SELECT c FROM Contract c WHERE c.route = :route"),
    @NamedQuery(name = "Contract.findByBeginning",
            query = "SELECT c FROM Contract c WHERE c.beginning = :beginning"),
    @NamedQuery(name = "Contract.findByDelivering",
            query = "SELECT c FROM Contract c WHERE c.delivering = :delivering")})
@Table(name = "CONTRACT")
@XmlRootElement()
public class Contract implements IEntityContext, Serializable {

    private static final long serialVersionUID = 3782084044581242880L;
    @Id()
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 30)
    @Column(name = "id")
    private String id;
    @Size(max = 200)
    @Column(name = "route")
    private String route;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "beginning")
    @Temporal(TemporalType.DATE)
    private Date beginning;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "delivering")
    @Temporal(TemporalType.DATE)
    private Date delivering;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contract1")
    private List<AuthorOeuvre> authorOeuvreList;
    @JoinColumn(name = "dnda", referencedColumnName = "number")
    @ManyToOne()
    private Dnda dnda;
    @Transient()
    private UploadedFile contractFile;

    public Contract() {
        super();
    }

    public Contract(String id) {
        this.id = id;
    }

    public Contract(String id, Date beginning, Date delivering) {
        this.id = id;
        this.beginning = beginning;
        this.delivering = delivering;
    }

    public String getId() {

        return (this.id);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoute() {

        return (this.route);
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Date getBeginning() {

        return (this.beginning);
    }

    public void setBeginning(Date beginning) {
        this.beginning = beginning;
    }

    public Date getDelivering() {

        return (this.delivering);
    }

    public void setDelivering(Date delivering) {
        this.delivering = delivering;
    }

    @XmlTransient()
    public List<AuthorOeuvre> getAuthorOeuvreList() {
        
        return (this.authorOeuvreList);
    }

    public void setAuthorOeuvreList(List<AuthorOeuvre> authorOeuvreList) {
        this.authorOeuvreList = authorOeuvreList;
    }

    public Dnda getDnda() {

        return (this.dnda);
    }

    public void setDnda(Dnda dnda) {
        this.dnda = dnda;
    }

    public UploadedFile getContractFile() {

        return (this.contractFile);
    }

    public void setContractFile(UploadedFile contractFile) {
        this.contractFile = contractFile;
    }

    @Override()
    public String getKey() {

        return (this.getId());
    }

    @Override()
    public void setKey(Object key) {
        if (key instanceof String) {
            this.setId((String) key);
        } else {
            throw new IllegalArgumentException("The key is not valid. Required: "
                    + String.class.getSimpleName() + ", received: "
                    + key.getClass().getSimpleName());
        }
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        
        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Contract)) {
            
            return (false);
        }
        
        Contract other = (Contract) object;
        if (((this.getId() == null) && (other.getId() != null))
                || ((this.getId() != null)
                && !(this.getId().equals(other.getId())))) {
        
            return (false);
        }
        
        return (true);
    }

    @Override()
    public String toString() {
        
        return ("co.edu.udea.juridicapp.persistence.entity.Contract[ id="
                + this.getId() + " ]");
    }
}