package co.edu.udea.juridicapp.web.bean.role;

import co.edu.udea.juridicapp.persistence.dao.IRoleDAO;
import co.edu.udea.juridicapp.persistence.entity.Role;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
@SessionScoped()
public class RoleBean implements Serializable {

    private static final long serialVersionUID = 4651738957089294336L;
    @Autowired()
    private IRoleDAO roleDAO;
    private Role role;

    public RoleBean() {
        super();
    }

    public Role getRole() {

        return (this.role);
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void save(ActionEvent actionEvent) {
        if (this.getRole().getProfile() != null) {
            this.getRole().setProfile(this.getRole().getProfile().trim());

            Role r = this.roleDAO.findRole(this.getRole().getProfile());
            if (r == null) {
                this.roleDAO.saveRole(this.getRole());
            } else {
                // Errroooooooooooorrrrrrrrrrrrrr. Ya existe un role con ese nombre.
            }
        } else {
            // Errrrrrrrrrrrrrrrroooooooooooooorrrrrrrrr. El nombre no puede ser nulo.
        }

        this.getRole().setDescription("");
        this.getRole().setProfile("");
    }

    @PostConstruct()
    private void createFields() {
        this.setRole(new Role());
    }
}