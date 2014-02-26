package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IUserDAO;
import co.edu.udea.juridicapp.persistence.entity.User;
import co.edu.udea.juridicapp.persistence.entity.UserPK;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class UserDAO extends AbstractEntityDAO implements IUserDAO {

    public UserDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public User deleteUser(User user) {

        return ((User) super.delete(user));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {

        return ((List<User>) super.findAll(User.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<User> findUsersByAttributes(Object... attributes) {

        return ((List<User>) super.findByAttributes(User.class,
                attributes));
    }

    @Override()
    public User findUser(UserPK key) {

        return ((User) super.find(User.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public UserPK saveUser(User user) {

        return ((UserPK) super.save(user));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public User updateUser(User user) {
        return ((User) super.update(user));
    }

    @Override()
    public long countUsers() {
        return (super.count(User.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<User> executeNamedQueryForUsers(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<User>) super.executeNamedQuery(namedQuery, parameterName,
                parameterValue));
    }
}