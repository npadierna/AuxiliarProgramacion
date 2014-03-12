package co.edu.udea.juridicapp.web.bean.support;

import co.edu.udea.juridicapp.persistence.dao.ISupportDAO;
import co.edu.udea.juridicapp.persistence.entity.Support;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
@SessionScoped()
public class SupportBean implements Serializable {

    private static final long serialVersionUID = 2392665482524712960L;
    @Autowired()
    private ISupportDAO supportDAO;
    private Support support;

    public Support getSupport() {

        return (this.support);
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public SupportBean() {
        super();
    }

    public void save(ActionEvent actionEvent) {
        if (this.getSupport().getType() != null) {
            this.getSupport().setType(this.getSupport().getType().trim());

            Support s = this.supportDAO.findSupport(this.getSupport().getType());
            if (s == null) {
                this.supportDAO.saveSupport(this.getSupport());
            } else {
                // Error ya existe alguno con esos datos.
            }
        } else {
            // Error, el tipo no puede ser nulo.
        }

        this.getSupport().setDescription("");
        this.getSupport().setType("");
    }

    @PostConstruct()
    private void createFields() {
        this.setSupport(new Support());
    }
}