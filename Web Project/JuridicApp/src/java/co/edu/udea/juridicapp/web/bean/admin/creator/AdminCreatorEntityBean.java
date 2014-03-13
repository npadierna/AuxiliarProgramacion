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
    private String directionIFrame;

    public AdminCreatorEntityBean() {
        super();
    }

    public String getDirectionIFrame() {

        return (this.directionIFrame);
    }

    public void setDirectionIFrame(String directionIFrame) {
        this.directionIFrame = directionIFrame;
    }

    public void changeIFrameDirection(ActionEvent actionEvent) {
        UIMenuItem menuItem = (UIMenuItem) actionEvent.getSource();

        switch (menuItem.getId()) {
            case ("newUserMenuItem"):
                this.setDirectionIFrame("http://192.168.0.197:8080/Juridicapp/faces/co/edu/udea/juridicapp/web/user/registration/registeruser.xhtml");
                break;

            case ("updateUserMenuItem"):
                this.setDirectionIFrame("http://192.168.0.197:8080/Juridicapp/faces/co/edu/udea/juridicapp/web/user/update/updateinfouser.xhtml");
                break;

            case ("deleteUserMenuItem"):
                this.setDirectionIFrame("http://192.168.0.197:8080/Juridicapp/faces/co/edu/udea/juridicapp/web/user/delete/deleteuser.xhtml");
                break;

            case ("newDependencyMenuItem"):
                this.setDirectionIFrame("http://192.168.0.197:8080/Juridicapp/faces/co/edu/udea/juridicapp/web/admin/creator/dependenciescreator.xhtml");
                break;

            case ("updateDependencyMenuItem"):
//                this.setDirectionIFrame("http://192.168.0.197:8080/Juridicapp/faces/co/edu/udea/juridicapp/web/admin/creator/creator.xhtml");
                break;

            case ("newRoleMenuItem"):
                this.setDirectionIFrame("http://192.168.0.197:8080/Juridicapp/faces/co/edu/udea/juridicapp/web/admin/creator/rolescreator.xhtml");
                break;

            case ("newSupportMenuItem"):
                this.setDirectionIFrame("http://192.168.0.197:8080/Juridicapp/faces/co/edu/udea/juridicapp/web/admin/creator/supportscreator.xhtml");
                break;

            case ("newTypeMenuItem"):
                this.setDirectionIFrame("http://192.168.0.197:8080/Juridicapp/faces/co/edu/udea/juridicapp/web/admin/creator/typescreator.xhtml");
                break;
        }
    }

    @PostConstruct()
    private void createFields() {
    }
}