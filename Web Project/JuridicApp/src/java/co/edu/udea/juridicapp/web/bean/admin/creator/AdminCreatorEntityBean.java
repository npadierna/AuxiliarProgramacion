package co.edu.udea.juridicapp.web.bean.admin.creator;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.component.menuitem.UIMenuItem;
import org.springframework.stereotype.Component;

@Component()
@SessionScoped()
public class AdminCreatorEntityBean implements Serializable {

    //private static final long serialVersionUID = 1L;
    private String direction;

    public AdminCreatorEntityBean() {
        super();
    }

    public String getDirection() {

        return (this.direction);
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void changeDirection(ActionEvent actionEvent) {
        UIMenuItem menuItem = (UIMenuItem) actionEvent.getSource();

        switch (menuItem.getId()) {
            case ("newUserMenuItem"):
                this.setDirection("../../user/registration/registeruser.xhtml");
                break;

            case ("updateUserMenuItem"):
                this.setDirection("../../user/update/updateinfouser.xhtml");
                break;

            case ("deleteUserMenuItem"):
                this.setDirection("../../user/delete/deleteuser.xhtml");
                break;

            case ("newDependencyMenuItem"):
                this.setDirection("dependenciescreator.xhtml");
                break;

            case ("updateDependencyMenuItem"):
//                this.setDirection("http://192.168.0.197:8080/Juridicapp/faces/co/edu/udea/juridicapp/web/admin/creator/creator.xhtml");
                break;

            case ("newRoleMenuItem"):
                this.setDirection("rolescreator.xhtml");
                break;

            case ("newSupportMenuItem"):
                this.setDirection("supportscreator.xhtml");
                break;

            case ("newTypeMenuItem"):
                this.setDirection("typescreator.xhtml");
                break;
        }
    }

    @PostConstruct()
    private void createFields() {
    }
}