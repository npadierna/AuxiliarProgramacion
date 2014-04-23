package co.edu.udea.obras.web.bean.type;

import co.edu.udea.obras.persistence.dao.ITypeDAO;
import co.edu.udea.obras.persistence.entity.Type;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
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
@Scope(value = "singleton")
@ApplicationScoped()
public final class TypeBean implements Serializable {

    private static final long serialVersionUID = 1080319077051732992L;
    @Autowired()
    private ITypeDAO typeDAO;
    private List<SelectItem> typesSelectItems;
    private List<String> typesNames;

    public TypeBean() {
        super();
    }

    public List<SelectItem> getTypesSelectItems() {
        if (this.typeDAO.countTypes() != (this.typesSelectItems.size() + 1)) {
            this.createFields();
        }

        return (this.typesSelectItems);
    }

    public void setTypesSelectItems(List<SelectItem> typesSelectItems) {
        this.typesSelectItems = typesSelectItems;
    }

    public List<String> getTypesNames() {
        if (this.typeDAO.countTypes() != this.typesNames.size()) {
            this.createFields();
        }

        return (this.typesNames);
    }

    public void setTypesNames(List<String> typesNames) {
        this.typesNames = typesNames;
    }

    @PostConstruct()
    private void createFields() {
        this.setTypesNames(new ArrayList<String>());
        this.setTypesSelectItems(new ArrayList<SelectItem>());

        List<Type> supportsFoud = this.typeDAO.findAllTypes();
        this.typesSelectItems.add(new SelectItem("", "Seleccione"));
        for (Type t : supportsFoud) {
            this.typesSelectItems.add(new SelectItem(t.getName(),
                    t.getName()));

            this.typesNames.add(t.getName());
        }
    }
}