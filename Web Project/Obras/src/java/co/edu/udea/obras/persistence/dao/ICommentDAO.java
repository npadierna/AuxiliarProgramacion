package co.edu.udea.obras.persistence.dao;

import co.edu.udea.obras.persistence.entity.Comment;
import co.edu.udea.obras.persistence.entity.CommentPK;
import java.util.List;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public interface ICommentDAO {

    public Comment deleteComment(Comment comment);

    public List<Comment> findAllComments();

    public List<Comment> findCommentsByAttributes(Object... attributes);
    
    public List<Comment> findCommnetsByOeuvreId(Long oeuvreId);

    public Comment findComment(CommentPK key);

    public CommentPK saveComment(Comment comment);

    public Comment updateComment(Comment comment);

    public long countComments();

    public List<Comment> executeNamedQueryForComments(String namedQuery,
            String parameterName, Object parameterValue);
}