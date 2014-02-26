package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IRoleDAO;
import co.edu.udea.juridicapp.persistence.entity.Role;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository()
@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
public class RoleDAO extends AbstractEntityDAO implements IRoleDAO {

    public RoleDAO() {
        super();
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Role deleteRole(Role role) {

        return ((Role) super.delete(role));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Role> findAllRoles() {

        return ((List<Role>) super.findAll(Role.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Role> findRolesByAttributes(Object... attributes) {

        return ((List<Role>) super.findByAttributes(Role.class,
                attributes));
    }

    @Override()
    public Role findRole(String key) {

        return ((Role) super.find(Role.class, key));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public String saveRole(Role role) {

        return ((String) super.save(role));
    }

    @Override()
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public Role updateRole(Role role) {
        return ((Role) super.update(role));
    }

    @Override()
    public long countRoles() {
        return (super.count(Role.class));
    }

    @Override()
    @SuppressWarnings("unchecked")
    public List<Role> executeNamedQueryForRoles(String namedQuery,
            String parameterName, Object parameterValue) {

        return ((List<Role>) super.executeNamedQuery(namedQuery, parameterName,
                parameterValue));
    }
}