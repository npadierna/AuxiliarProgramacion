package co.edu.udea.juridicapp.persistence.dao.impl;

import co.edu.udea.juridicapp.persistence.dao.IRoleDAO;
import co.edu.udea.juridicapp.persistence.entity.Role;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO extends AbstractEntityDAO implements IRoleDAO {

    public RoleDAO() {
        super();
    }

    @Override()
    public Role deleteRole(Role role) {

        return ((Role) super.delete(role));
    }

    @Override()
    public List<Role> findAllRoles() {

        return ((List<Role>) super.findAll(Role.class));
    }

    @Override()
    public List<Role> findRolesByAttributes(Object... attributes) {

        return ((List<Role>) super.findByAttributes(Role.class,
                attributes));
    }

    @Override()
    public Role findRole(String key) {

        return ((Role) super.find(Role.class, key));
    }

    @Override()
    public String saveRole(Role role) {

        return ((String) super.save(role));
    }

    @Override()
    public Role updateRole(Role role) {
        return ((Role) super.update(role));
    }

    @Override()
    public long countRoles() {
        return (super.count(Role.class));
    }

    @Override()
    public List<Role> executeNamedQueryForRoles(String namedQuery,
            String parameterName, Object parameterValue) {

        List<Role> rolesFound = new ArrayList<>();

        for (Object o : super.executeNamedQuery(namedQuery, parameterName,
                parameterValue)) {
            rolesFound.add((Role) o);
        }

        return (rolesFound);
    }
}
