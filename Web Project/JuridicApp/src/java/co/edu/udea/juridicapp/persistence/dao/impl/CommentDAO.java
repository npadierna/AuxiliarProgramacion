package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.ICommentDAO;
import co.edu.udea.juridicapp.persistence.entity.Comment;
import co.edu.udea.juridicapp.persistence.entity.CommentPK;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO extends AbstractEntityDAO implements ICommentDAO {

    public CommentDAO() {
        super();
    }

    @Override()
    public Comment deleteComment(Comment comment) {

        return ((Comment) super.delete(comment));
    }

    @Override()
    public List<Comment> findAllComments() {

        return ((List<Comment>) super.findAll(Comment.class));
    }

    @Override()
    public List<Comment> findCommentsByAttributes(Object... attributes) {

        return ((List<Comment>) super.findByAttributes(Comment.class,
                attributes));
    }

    @Override()
    public Comment findComment(CommentPK key) {

        return ((Comment) super.find(Comment.class, key));
    }

    @Override()
    public CommentPK saveComment(Comment comment) {

        return ((CommentPK) super.save(comment));
    }

    @Override()
    public Comment updateComment(Comment comment) {
        return ((Comment) super.update(comment));
    }

    @Override()
    public long countComments() {
        return (super.count(Comment.class));
    }

    @Override()
    public List<Comment> executeNamedQueryForComments(String namedQuery,
            String parameterName, Object parameterValue) {
        List<Comment> commentsFound = new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            commentsFound.add((Comment) o);
        }

        return (commentsFound);
    }
}