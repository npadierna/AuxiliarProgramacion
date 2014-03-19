package co.edu.udea.juridicapp.web.bean.support;

import co.edu.udea.juridicapp.persistence.dao.ISupportDAO;
import co.edu.udea.juridicapp.persistence.entity.Support;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Component()
@SessionScoped()
public final class SupportBean implements Serializable {

    private static final long serialVersionUID = 2392665482524712960L;
    @Autowired()
    private ISupportDAO supportDAO;
    private List<SelectItem> supportsSelectItems;
    private List<String> supportsNames;
    private Support support;

    public SupportBean() {
        super();

        this.setSupport(new Support());
    }

    public List<SelectItem> getSupportsSelectItems() {
        if (this.supportDAO.countSupports() != (this.supportsSelectItems.size()
                + 1)) {
            this.createFields();
        }

        return (this.supportsSelectItems);
    }

    public void setSupportsSelectItems(List<SelectItem> supportsSelectItems) {
        this.supportsSelectItems = supportsSelectItems;
    }

    public List<String> getSupportsNames() {
        if (this.supportDAO.countSupports() != this.supportsNames.size()) {
            this.createFields();
        }

        return (this.supportsNames);
    }

    public void setSupportsNames(List<String> supportsNames) {
        this.supportsNames = supportsNames;
    }

    public Support getSupport() {

        return (this.support);
    }

    public void setSupport(Support support) {
        this.support = support;
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
        this.setSupportsNames(new ArrayList<String>());
        this.setSupportsSelectItems(new ArrayList<SelectItem>());

        List<Support> supportsFoud = this.supportDAO.findAllSupports();
        this.supportsSelectItems.add(new SelectItem("", "Seleccione"));
        for (Support s : supportsFoud) {
            this.supportsSelectItems.add(new SelectItem(s.getType(),
                    s.getType()));

            this.supportsNames.add(s.getType());
        }
    }
}