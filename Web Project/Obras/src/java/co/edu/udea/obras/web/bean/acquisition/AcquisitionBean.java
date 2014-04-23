package co.edu.udea.obras.web.bean.acquisition;

import co.edu.udea.obras.persistence.dao.IAcquisitionDAO;
import co.edu.udea.obras.persistence.entity.Acquisition;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
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
public final class AcquisitionBean implements Serializable {

    private static final long serialVersionUID = 8958642437642201088L;
    @Autowired()
    private IAcquisitionDAO acquisitionDAO;
    private List<SelectItem> acquisitionsSelectItems;
    private List<String> acquisitionsNames;

    public AcquisitionBean() {
        super();
    }

    public List<SelectItem> getAcquisitionsSelectItems() {
        if (this.acquisitionDAO.countAcquisitions()
                != (this.acquisitionsSelectItems.size() + 1)) {
            this.createFields();
        }

        return (this.acquisitionsSelectItems);
    }

    public void setAcquisitionsSelectItems(
            List<SelectItem> acquisitionsSelectItems) {
        this.acquisitionsSelectItems = acquisitionsSelectItems;
    }

    public List<String> getAcquisitionsNames() {
        if (this.acquisitionDAO.countAcquisitions()
                != this.acquisitionsNames.size()) {
            this.createFields();
        }

        return (this.acquisitionsNames);
    }

    public void setAcquisitionsNames(List<String> acquisitionsNames) {
        this.acquisitionsNames = acquisitionsNames;
    }

    @PostConstruct()
    private void createFields() {
        this.setAcquisitionsNames(new ArrayList<String>());
        this.setAcquisitionsSelectItems(new ArrayList<SelectItem>());

        List<Acquisition> acquisitionsFound = this.acquisitionDAO
                .findAllAcquisitions();
        this.acquisitionsSelectItems.add(new SelectItem("", "Seleccione"));
        for (Acquisition a : acquisitionsFound) {
            this.acquisitionsSelectItems.add(new SelectItem(a.getType(),
                    a.getType()));

            this.acquisitionsNames.add(a.getType());
        }
    }
}