package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.ICommentDAO;
import co.edu.udea.juridicapp.persistence.entity.Comment;
import co.edu.udea.juridicapp.persistence.entity.CommentPK;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class CommentDAO extends AbstractEntityDAO implements ICommentDAO {

    public CommentDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Comment deleteComment(Comment comment) {

        return ((Comment) super.delete(comment));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Comment> findAllComments() {

        return ((List<Comment>) super.findAll(Comment.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Comment> findCommentsByAttributes(Object... attributes) {

        return ((List<Comment>) super.findByAttributes(Comment.class,
                attributes));
    }

    @Override()
    public List<Comment> findCommnetsByOeuvreId(Long oeuvreId) {

        return (this.executeNamedQueryForComments("Comment.findByOeuvreId",
                "oeuvreId", oeuvreId));
    }

    @Override()
    public Comment findComment(CommentPK key) {

        return ((Comment) super.find(Comment.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public CommentPK saveComment(Comment comment) {

        return ((CommentPK) super.save(comment));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Comment updateComment(Comment comment) {
        return ((Comment) super.update(comment));
    }

    @Override()
    public long countComments() {
        return (super.count(Comment.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Comment> executeNamedQueryForComments(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<Comment>) super.executeNamedQuery(namedQuery,
                parameterName, parameterValue));
    }
}