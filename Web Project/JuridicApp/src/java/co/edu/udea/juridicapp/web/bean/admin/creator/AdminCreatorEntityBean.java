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

    private static final long serialVersionUID = 1938227488649633792L;
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
            case ("newClientMenuItem"):
                this.setDirection("../../client/registration/registerclient.xhtml");
                break;

            case ("updateClientMenuItem"):
                this.setDirection("../../client/update/updateinfoclient.xhtml");
                break;

            case ("deleteClientMenuItem"):
                this.setDirection("../../client/delete/deleteclient.xhtml");
                break;

            case ("newDependencyMenuItem"):
                this.setDirection("dependenciescreator.xhtml");
                break;

            case ("updateDependencyMenuItem"):
//                this.setDirection("http://192.168.0.197:8080/Juridicapp/faces/co/edu/udea/juridicapp/web/admin/creator/creator.xhtml");
                break;

            case ("newTitleMenuItem"):
                this.setDirection("titlescreator.xhtml");
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