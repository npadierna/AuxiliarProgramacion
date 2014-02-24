

package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Role;
import java.util.List;


public interface IRoleDAO {
    
    public Role deleteRole(Role role);

    public List<Role> findAllRoles();

    public List<Role> findRolesByAttributes(Object... attributes);

    public Role findRole(String key);

    public String saveRole(Role role);

    public Role updateRole(Role role);

    public long countRoles();

    public List<Role> executeNamedQueryForRoles(String namedQuery,
            String parameterName, Object parameterValue);
}
