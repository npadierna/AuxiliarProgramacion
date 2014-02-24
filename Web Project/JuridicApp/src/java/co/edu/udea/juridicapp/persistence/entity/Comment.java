package co.edu.udea.juridicapp.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity()
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findById",
            query = "SELECT c FROM Comment c WHERE c.commentPK.id = :id"),
    @NamedQuery(name = "Comment.findByWorkId",
            query = "SELECT c FROM Comment c WHERE c.commentPK.workId = :workId"),
    @NamedQuery(name = "Comment.findByText",
            query = "SELECT c FROM Comment c WHERE c.text = :text"),
    @NamedQuery(name = "Comment.findByDateTime",
            query = "SELECT c FROM Comment c WHERE c.dateTime = :dateTime")})
@Table(name = "COMMENT")
@XmlRootElement()
public class Comment implements IEntityContext, Serializable {

    private static final long serialVersionUID = 3933693485501532160L;
    @EmbeddedId()
    protected CommentPK commentPK;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 250)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull()
    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @JoinColumn(name = "work_id", referencedColumnName = "id",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Work work;

    public Comment() {
        super();
    }

    public Comment(CommentPK commentPK) {
        this.commentPK = commentPK;
    }

    public Comment(CommentPK commentPK, String text, Date dateTime) {
        this.commentPK = commentPK;
        this.text = text;
        this.dateTime = dateTime;
    }

    public Comment(long id, long workId) {
        this.commentPK = new CommentPK(id, workId);
    }

    public CommentPK getCommentPK() {

        return (this.commentPK);
    }

    public void setCommentPK(CommentPK commentPK) {
        this.commentPK = commentPK;
    }

    public String getText() {

        return (this.text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateTime() {

        return (this.dateTime);
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Work getWork() {

        return (this.work);
    }

    public void setWork(Work work) {
        this.work = work;
    }

    @Override()
    public Object getKey() {

        return (this.getCommentPK());
    }

    @Override()
    public void setKey(Object key) {
        this.setCommentPK((CommentPK) key);
    }

    @Override()
    public int hashCode() {
        int hash = 0;
        hash += (commentPK != null ? commentPK.hashCode() : 0);

        return (hash);
    }

    @Override()
    public boolean equals(Object object) {
        if (!(object instanceof Comment)) {

            return (false);
        }

        Comment other = (Comment) object;
        if (((this.commentPK == null) && (other.commentPK != null))
                || ((this.commentPK != null)
                && !(this.commentPK.equals(other.commentPK)))) {

            return (false);
        }

        return (true);
    }

    @Override()
    public String toString() {

        return ("co.edu.udea.juridicapp.persistence.entity.Comment[ commentPK="
                + this.getCommentPK() + " ]");
    }
}