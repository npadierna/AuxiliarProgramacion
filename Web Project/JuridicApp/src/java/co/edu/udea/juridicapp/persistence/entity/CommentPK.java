/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rebien
 */
@Embeddable
public class CommentPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "work_id")
    private long workId;

    public CommentPK() {
    }

    public CommentPK(long id, long workId) {
        this.id = id;
        this.workId = workId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getWorkId() {
        return workId;
    }

    public void setWorkId(long workId) {
        this.workId = workId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) workId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentPK)) {
            return false;
        }
        CommentPK other = (CommentPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.workId != other.workId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udea.juridicapp.persistence.entity.CommentPK[ id=" + id + ", workId=" + workId + " ]";
    }
    
}
