package co.edu.udea.juridicapp.persistence.dao;

import co.edu.udea.juridicapp.persistence.entity.Profile;
import java.util.List;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public interface IProfileDAO {

    public Profile deleteProfile(Profile profile);

    public List<Profile> findAllProfiles();

    public List<Profile> findProfilesByAttributes(Object... attributes);

    public Profile findProfile(String key);

    public String saveProfile(Profile profile);

    public Profile updateProfile(Profile profile);

    public long countProfiles();

    public List<Profile> executeNamedQueryForProfiles(String namedQuery,
            String parameterName, Object parameterValue);
}