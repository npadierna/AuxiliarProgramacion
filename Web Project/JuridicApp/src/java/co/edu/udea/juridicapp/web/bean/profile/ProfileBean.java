package co.edu.udea.juridicapp.web.bean.profile;

import co.edu.udea.juridicapp.persistence.dao.IProfileDAO;
import co.edu.udea.juridicapp.persistence.entity.Profile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Component()
@SessionScoped()
public final class ProfileBean implements Serializable {

    private static final long serialVersionUID = 8232630815530828800L;
    @Autowired()
    private IProfileDAO profileDAO;
    private List<String> profilesNames;

    public ProfileBean() {
        super();
    }

    public List<String> getProfilesNames() {
        if (this.profileDAO.countProfiles() != this.profilesNames.size()) {
            this.createFields();
        }

        return (this.profilesNames);
    }

    public void setProfilesNames(List<String> profilesNames) {
        this.profilesNames = profilesNames;
    }

    @PostConstruct()
    private void createFields() {
        this.setProfilesNames(new ArrayList<String>());

        List<Profile> profilesFound = this.profileDAO.findAllProfiles();
        for (Profile profile : profilesFound) {
            this.profilesNames.add(profile.getTitle());
        }
    }
}