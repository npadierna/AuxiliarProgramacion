package co.edu.udea.obras.persistence.dao.impl;

import co.edu.udea.obras.persistence.dao.IEntityDAO;
import co.edu.udea.obras.persistence.entity.IEntityContext;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public abstract class AbstractEntityDAO implements IEntityDAO {

    private static final Logger LOG = Logger.getLogger(AbstractEntityDAO.class.
            getSimpleName());
    @PersistenceContext(unitName = "ObrasPU")
    protected EntityManager entityManager;

    public AbstractEntityDAO() {
        super();
    }

    public EntityManager getEntityManager() {

        return (this.entityManager);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override()
    public IEntityContext delete(IEntityContext entity) {
        IEntityContext found = null;
        try {
            found = this.find(entity.getClass(),
                    entity.getKey());

            if (found != null) {
                this.getEntityManager().remove(found);
            }
            this.getEntityManager().flush();
        } catch (Exception e) {
            AbstractEntityDAO.LOG.logp(Level.SEVERE,
                    AbstractEntityDAO.class.getName(),
                    "public IEntityContext delete(IEntityContext entity)",
                    "Fatal error while the DAO was trying delete a entity.", e);
        }

        return (found);
    }

    @Override()
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Object findAll(Class clazz) {
        Query query;
        List<IEntityContext> entities = null;

        try {
            query = this.getEntityManager().createQuery("FROM "
                    + clazz.getSimpleName());
            entities = (List<IEntityContext>) query.getResultList();
        } catch (Exception e) {
            AbstractEntityDAO.LOG.logp(Level.SEVERE,
                    AbstractEntityDAO.class.getName(),
                    "public Object findAll(Class clazz)",
                    "Fatal error while the DAO was trying to recover a list of entities from Data Base.",
                    e);
        }

        return (entities);
    }

    @Override()
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Object findByAttributes(Class clazz, Object... attributes) {
        if (attributes.length % 2 != 0) {
            throw new IllegalArgumentException(
                    "The number of the arguments for attributes is incorrect: "
                    + attributes.length);
        }

        StringBuilder queryDetail = new StringBuilder();
        for (int pos = 0; pos < attributes.length; pos += 2) {
            if (pos >= 2) {
                queryDetail.append(" AND ");
            } else {
                queryDetail.append(" WHERE ");
            }

            queryDetail.append("o.").append(attributes[pos]);
            if (attributes[pos + 1] instanceof Boolean) {
                queryDetail.append(" = :");
            } else {
                queryDetail.append(" LIKE :");
            }
            queryDetail.append(this.removeDot((String) attributes[pos]));
        }

        Query query = this.getEntityManager().createQuery("FROM "
                + clazz.getSimpleName() + " AS o" + queryDetail.toString());

        for (int pos = 0; pos < attributes.length; pos += 2) {
            query.setParameter(this.removeDot((String) attributes[pos]),
                    attributes[pos + 1]);
        }

        return (query.getResultList());
    }

    @Override()
    @SuppressWarnings({"rawtypes", "unchecked"})
    public IEntityContext find(Class clazz, Object key) {
        IEntityContext entity = null;
        try {
            if (key != null) {
                entity = (IEntityContext) this.getEntityManager().find(clazz,
                        key);
            }
        } catch (IllegalArgumentException e) {
            AbstractEntityDAO.LOG.logp(Level.SEVERE,
                    AbstractEntityDAO.class.getName(),
                    "public IEntityContext find(Class clazz, Object key)",
                    "Fatal error while the DAO was trying to find or search an entity.",
                    e);
        }

        return (entity);
    }

    @Override()
    public Object save(IEntityContext entity) {
        try {
            this.getEntityManager().persist(entity);
            this.getEntityManager().flush();
        } catch (Exception e) {
            AbstractEntityDAO.LOG.logp(Level.SEVERE,
                    AbstractEntityDAO.class.getName(),
                    "public Object save(IEntityContext entity)",
                    "Fatal error while the DAO was trying to persist or save a entity.",
                    e);
        }

        return (entity.getKey());
    }

    @Override()
    public IEntityContext update(IEntityContext entity) {
        try {
            this.getEntityManager().merge(entity);
            this.getEntityManager().flush();
        } catch (Exception e) {
            AbstractEntityDAO.LOG.logp(Level.SEVERE,
                    AbstractEntityDAO.class.getName(),
                    "public IEntityContext update(IEntityContext entity)",
                    "Fatal error while the DAO was trying to update or refresh a entity.",
                    e);
        }

        return (entity);
    }

    @Override()
    @SuppressWarnings({"rawtypes", "unchecked"})
    public long count(Class clazz) {
        CriteriaQuery criteriaQuery = this.getEntityManager()
                .getCriteriaBuilder().createQuery();
        Root<IEntityContext> root = criteriaQuery.from(clazz);
        criteriaQuery.select(this.getEntityManager().getCriteriaBuilder()
                .count(root));
        Query query = this.getEntityManager().createQuery(criteriaQuery);

        return (((Long) query.getSingleResult()).longValue());
    }

    @Override()
    @SuppressWarnings("unchecked")
    public Object executeNamedQuery(String namedQuery,
            String paramName, Object paramValue) {
        Query query;
        List<IEntityContext> entities = null;

        try {
            query = this.getEntityManager().createNamedQuery(namedQuery);
            query.setParameter(paramName, paramValue);
            entities = (List<IEntityContext>) query.getResultList();
        } catch (IllegalArgumentException e) {
            AbstractEntityDAO.LOG.logp(Level.SEVERE,
                    AbstractEntityDAO.class.getName(),
                    "public Object executeNamedQuery(String namedQuery, String paramName, Object paramValue)",
                    "Fatal error while the DAO was trying to execute the named query.",
                    e);
        }

        return (entities);
    }

    private String removeDot(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        int index = stringBuilder.indexOf(".");

        while (index > -1) {
            stringBuilder.deleteCharAt(index);
            index = stringBuilder.indexOf(".");
        }

        return (stringBuilder.toString());
    }
}