/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rebien
 */
@Entity
@Table(name = "AUTHOR_WORK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthorWork.findAll", query = "SELECT a FROM AuthorWork a"),
    @NamedQuery(name = "AuthorWork.findByWorkTypeId", query = "SELECT a FROM AuthorWork a WHERE a.authorWorkPK.workTypeId = :workTypeId"),
    @NamedQuery(name = "AuthorWork.findByWorkTypeName", query = "SELECT a FROM AuthorWork a WHERE a.authorWorkPK.workTypeName = :workTypeName"),
    @NamedQuery(name = "AuthorWork.findByDocumentType", query = "SELECT a FROM AuthorWork a WHERE a.authorWorkPK.documentType = :documentType"),
    @NamedQuery(name = "AuthorWork.findByIdNumber", query = "SELECT a FROM AuthorWork a WHERE a.authorWorkPK.idNumber = :idNumber"),
    @NamedQuery(name = "AuthorWork.findByContract", query = "SELECT a FROM AuthorWork a WHERE a.authorWorkPK.contract = :contract"),
    @NamedQuery(name = "AuthorWork.findByIsbn", query = "SELECT a FROM AuthorWork a WHERE a.isbn = :isbn"),
    @NamedQuery(name = "AuthorWork.findByStarting", query = "SELECT a FROM AuthorWork a WHERE a.starting = :starting"),
    @NamedQuery(name = "AuthorWork.findByDelivering", query = "SELECT a FROM AuthorWork a WHERE a.delivering = :delivering")})
public class AuthorWork implements IEntityContext, Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AuthorWorkPK authorWorkPK;
    @Size(max = 35)
    @Column(name = "isbn")
    private String isbn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "starting")
    @Temporal(TemporalType.DATE)
    private Date starting;
    @Basic(optional = false)
    @NotNull
    @Column(name = "delivering")
    @Temporal(TemporalType.DATE)
    private Date delivering;
    @JoinColumn(name = "contract", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Contract contract1;
    @JoinColumn(name = "role", referencedColumnName = "profile")
    @ManyToOne(optional = false)
    private Role role;
    @JoinColumns({
        @JoinColumn(name = "document_type", referencedColumnName = "document_type", insertable = false, updatable = false),
        @JoinColumn(name = "id_number", referencedColumnName = "id_number", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Author author;
    @JoinColumn(name = "dnda", referencedColumnName = "number")
    @ManyToOne
    private Dnda dnda;
    @JoinColumn(name = "support_type", referencedColumnName = "type")
    @ManyToOne(optional = false)
    private Support supportType;
    @JoinColumns({
        @JoinColumn(name = "work_type_id", referencedColumnName = "work_id", insertable = false, updatable = false),
        @JoinColumn(name = "work_type_name", referencedColumnName = "type_name", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private WorkType workType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorWork")
    private List<AuthorWorkAcquisition> authorWorkAcquisitionList;

    public AuthorWork() {
    }

    public AuthorWork(AuthorWorkPK authorWorkPK) {
        this.authorWorkPK = authorWorkPK;
    }

    public AuthorWork(AuthorWorkPK authorWorkPK, Date starting, Date delivering) {
        this.authorWorkPK = authorWorkPK;
        this.starting = starting;
        this.delivering = delivering;
    }

    public AuthorWork(long workTypeId, String workTypeName, String documentType, String idNumber, String contract) {
        this.authorWorkPK = new AuthorWorkPK(workTypeId, workTypeName, documentType, idNumber, contract);
    }

    public AuthorWorkPK getAuthorWorkPK() {
        return authorWorkPK;
    }

    public void setAuthorWorkPK(AuthorWorkPK authorWorkPK) {
        this.authorWorkPK = authorWorkPK;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getStarting() {
        return starting;
    }

    public void setStarting(Date starting) {
        this.starting = starting;
    }

    public Date getDelivering() {
        return delivering;
    }

    public void setDelivering(Date delivering) {
        this.delivering = delivering;
    }

    public Contract getContract1() {
        return contract1;
    }

    public void setContract1(Contract contract1) {
        this.contract1 = contract1;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Dnda getDnda() {
        return dnda;
    }

    public void setDnda(Dnda dnda) {
        this.dnda = dnda;
    }

    public Support getSupportType() {
        return supportType;
    }

    public void setSupportType(Support supportType) {
        this.supportType = supportType;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }

    @XmlTransient
    public List<AuthorWorkAcquisition> getAuthorWorkAcquisitionList() {
        return authorWorkAcquisitionList;
    }

    public void setAuthorWorkAcquisitionList(List<AuthorWorkAcquisition> authorWorkAcquisitionList) {
        this.authorWorkAcquisitionList = authorWorkAcquisitionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorWorkPK != null ? authorWorkPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthorWork)) {
            return false;
        }
        AuthorWork other = (AuthorWork) object;
        if ((this.authorWorkPK == null && other.authorWorkPK != null) || (this.authorWorkPK != null && !this.authorWorkPK.equals(other.authorWorkPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.juridicapp.persistence.entity.AuthorWork[ authorWorkPK=" + authorWorkPK + " ]";
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
