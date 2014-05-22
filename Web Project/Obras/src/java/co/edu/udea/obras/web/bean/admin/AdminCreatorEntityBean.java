package co.edu.udea.obras.web.bean.admin;

import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.component.menuitem.UIMenuItem;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Component()
@Scope(value = "session")
@SessionScoped()
public final class AdminCreatorEntityBean implements Serializable {

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
        String menuItemId = ((UIMenuItem) actionEvent.getSource()).getId();

        if (menuItemId.equals("newClientMenuItem")) {
            this.setDirection("../../client/registration/registerclient.xhtml");
        } else if (menuItemId.equals("updateClientMenuItem")) {
            this.setDirection("../../client/update/updateinfoclient.xhtml");
        } else if (menuItemId.equals("deleteClientMenuItem")) {
            this.setDirection("../../client/delete/deleteclient.xhtml");
        } else if (menuItemId.equals("newDependencyMenuItem")) {
            this.setDirection("dependenciescreator.xhtml");
        } else if (menuItemId.equals("updateDependencyMenuItem")) {
//                this.setDirection("http://192.168.0.197:8080/obras/faces/co/edu/udea/obras/web/admin/creator/creator.xhtml");
        } else if (menuItemId.equals("newTitleMenuItem")) {
            this.setDirection("titlescreator.xhtml");
        } else if (menuItemId.equals("newSupportMenuItem")) {
            this.setDirection("supportscreator.xhtml");
        } else if (menuItemId.equals("newTypeMenuItem")) {
            this.setDirection("typescreator.xhtml");
        }
    }
}