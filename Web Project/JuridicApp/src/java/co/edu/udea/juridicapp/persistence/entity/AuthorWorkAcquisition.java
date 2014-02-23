/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rebien
 */
@Entity
@Table(name = "AUTHOR_WORK_ACQUISITION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuthorWorkAcquisition.findAll", query = "SELECT a FROM AuthorWorkAcquisition a"),
    @NamedQuery(name = "AuthorWorkAcquisition.findByAcquisition", query = "SELECT a FROM AuthorWorkAcquisition a WHERE a.authorWorkAcquisitionPK.acquisition = :acquisition"),
    @NamedQuery(name = "AuthorWorkAcquisition.findByWorkTypeId", query = "SELECT a FROM AuthorWorkAcquisition a WHERE a.authorWorkAcquisitionPK.workTypeId = :workTypeId"),
    @NamedQuery(name = "AuthorWorkAcquisition.findByWorkTypeName", query = "SELECT a FROM AuthorWorkAcquisition a WHERE a.authorWorkAcquisitionPK.workTypeName = :workTypeName"),
    @NamedQuery(name = "AuthorWorkAcquisition.findByDocumentType", query = "SELECT a FROM AuthorWorkAcquisition a WHERE a.authorWorkAcquisitionPK.documentType = :documentType"),
    @NamedQuery(name = "AuthorWorkAcquisition.findByIdNumber", query = "SELECT a FROM AuthorWorkAcquisition a WHERE a.authorWorkAcquisitionPK.idNumber = :idNumber"),
    @NamedQuery(name = "AuthorWorkAcquisition.findByContract", query = "SELECT a FROM AuthorWorkAcquisition a WHERE a.authorWorkAcquisitionPK.contract = :contract")})
public class AuthorWorkAcquisition implements IEntityContext, Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AuthorWorkAcquisitionPK authorWorkAcquisitionPK;
    @JoinTable(name = "AUTHOR_WORK_FILE", joinColumns = {
        @JoinColumn(name = "acquisition", referencedColumnName = "acquisition"),
        @JoinColumn(name = "work_type_id", referencedColumnName = "work_type_id"),
        @JoinColumn(name = "work_type_name", referencedColumnName = "work_type_name"),
        @JoinColumn(name = "document_type", referencedColumnName = "document_type"),
        @JoinColumn(name = "id_number", referencedColumnName = "id_number"),
        @JoinColumn(name = "contract", referencedColumnName = "contract")}, inverseJoinColumns = {
        @JoinColumn(name = "file_path", referencedColumnName = "path")})
    @ManyToMany
    private List<File> fileList;
    @JoinColumns({
        @JoinColumn(name = "work_type_id", referencedColumnName = "work_type_id", insertable = false, updatable = false),
        @JoinColumn(name = "work_type_name", referencedColumnName = "work_type_name", insertable = false, updatable = false),
        @JoinColumn(name = "document_type", referencedColumnName = "document_type", insertable = false, updatable = false),
        @JoinColumn(name = "id_number", referencedColumnName = "id_number", insertable = false, updatable = false),
        @JoinColumn(name = "contract", referencedColumnName = "contract", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private AuthorWork authorWork;
    @JoinColumn(name = "acquisition", referencedColumnName = "type", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Acquisition acquisition1;

    public AuthorWorkAcquisition() {
    }

    public AuthorWorkAcquisition(AuthorWorkAcquisitionPK authorWorkAcquisitionPK) {
        this.authorWorkAcquisitionPK = authorWorkAcquisitionPK;
    }

    public AuthorWorkAcquisition(String acquisition, long workTypeId, String workTypeName, String documentType, String idNumber, String contract) {
        this.authorWorkAcquisitionPK = new AuthorWorkAcquisitionPK(acquisition, workTypeId, workTypeName, documentType, idNumber, contract);
    }

    public AuthorWorkAcquisitionPK getAuthorWorkAcquisitionPK() {
        return authorWorkAcquisitionPK;
    }

    public void setAuthorWorkAcquisitionPK(AuthorWorkAcquisitionPK authorWorkAcquisitionPK) {
        this.authorWorkAcquisitionPK = authorWorkAcquisitionPK;
    }

    @XmlTransient
    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public AuthorWork getAuthorWork() {
        return authorWork;
    }

    public void setAuthorWork(AuthorWork authorWork) {
        this.authorWork = authorWork;
    }

    public Acquisition getAcquisition1() {
        return acquisition1;
    }

    public void setAcquisition1(Acquisition acquisition1) {
        this.acquisition1 = acquisition1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorWorkAcquisitionPK != null ? authorWorkAcquisitionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthorWorkAcquisition)) {
            return false;
        }
        AuthorWorkAcquisition other = (AuthorWorkAcquisition) object;
        if ((this.authorWorkAcquisitionPK == null && other.authorWorkAcquisitionPK != null) || (this.authorWorkAcquisitionPK != null && !this.authorWorkAcquisitionPK.equals(other.authorWorkAcquisitionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.juridicapp.persistence.entity.AuthorWorkAcquisition[ authorWorkAcquisitionPK=" + authorWorkAcquisitionPK + " ]";
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
