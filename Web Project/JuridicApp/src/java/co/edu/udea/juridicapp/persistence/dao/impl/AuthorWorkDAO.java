package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IAuthorWorkDAO;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorWork;
import co.edu.udea.juridicapp.persistence.entity.AuthorWorkPK;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class AuthorWorkDAO extends AbstractEntityDAO implements IAuthorWorkDAO {

    public AuthorWorkDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public AuthorWork deleteAuthorWork(AuthorWork authorWork) {

        return ((AuthorWork) super.delete(authorWork));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<AuthorWork> findAllAuthorsWorks() {

        return ((List<AuthorWork>) super.findAll(AuthorWork.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<AuthorWork> findAuthorWorksByAttributes(Object... attributes) {

        return ((List<AuthorWork>) super.findByAttributes(AuthorWork.class,
                attributes));
    }

    @Override()
    public AuthorWork findAuthorWork(AuthorWorkPK key) {

        return ((AuthorWork) super.find(AuthorWork.class, key));
    }

    @Override()
    public List<AuthorWork> findAuthorsWorksByAuthor(Author author) {
        List<AuthorWork> authorWorksFound = null;

        if ((author != null) && (author.getKey() != null)) {
            authorWorksFound = this.findAuthorWorksByAttributes(
                    "authorWorkPK.idNumber", author.getPersonPK().getIdNumber(),
                    "authorWorkPK.documentType",
                    author.getPersonPK().getDocumentType());
        }

        return (authorWorksFound);
    }

    @Override()
    public List<AuthorWork> findAuthorsWorksByWorkId(Long workId) {

        return (this.executeNamedQueryForAuthorsWorks(
                "AuthorWork.findByWorkTypeId", "workTypeId", workId));
    }

    @Override()
    public AuthorWorkPK saveAuthorWorkUsingNativeQuery(AuthorWork authorWork) {
        Query query = super.getEntityManager().createNativeQuery("insert into AUTHOR_WORK (delivering, role, starting, support_type, contract, document_type, id_number, work_type_id, work_type_name) values ("
                + authorWork.getDelivering() + ", "
                + authorWork.getRole().getProfile() + ", "
                + authorWork.getStarting() + ", "
                + authorWork.getSupportType().getType() + ", "
                + authorWork.getContract1().getId() + ", "
                + authorWork.getAuthorWorkPK().getDocumentType() + ", "
                + authorWork.getAuthorWorkPK().getIdNumber() + ", "
                + authorWork.getAuthorWorkPK().getWorkTypeId() + ", "
                + authorWork.getAuthorWorkPK().getWorkTypeName() + ")", AuthorWork.class);
//        query.setParameter("delivering", authorWork.getDelivering());
//        query.setParameter("role", authorWork.getRole().getProfile());
//        query.setParameter("starting", authorWork.getStarting());
//        query.setParameter("support_type", authorWork.getSupportType().getType());
//        query.setParameter("contract", authorWork.getContract1().getId());
//        query.setParameter("document_type", authorWork.getAuthorWorkPK().getDocumentType());
//        query.setParameter("id_number", authorWork.getAuthorWorkPK().getIdNumber());
//        query.setParameter("work_type_id", authorWork.getAuthorWorkPK().getWorkTypeId());
//        query.setParameter("work_type_name", authorWork.getAuthorWorkPK().getWorkTypeName());

        return (((AuthorWork) query.getResultList().get(0)).getAuthorWorkPK());
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public AuthorWorkPK saveAuthorWork(AuthorWork authorWork) {

        return ((AuthorWorkPK) super.save(authorWork));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public AuthorWork updateAuthorWork(AuthorWork authorWork) {
        return ((AuthorWork) super.update(authorWork));
    }

    @Override()
    public long countAuthorsWorks() {
        return (super.count(AuthorWork.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<AuthorWork> executeNamedQueryForAuthorsWorks(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<AuthorWork>) super.executeNamedQuery(namedQuery,
                parameterName, parameterValue));
    }
}