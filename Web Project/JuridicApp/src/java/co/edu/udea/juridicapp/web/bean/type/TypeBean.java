package co.edu.udea.juridicapp.web.bean.type;

import co.edu.udea.juridicapp.persistence.dao.ITypeDAO;
import co.edu.udea.juridicapp.persistence.entity.Type;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
@SessionScoped()
public class TypeBean implements Serializable {

    private static final long serialVersionUID = 1080319077051732992L;
    @Autowired()
    private ITypeDAO typeDAO;
    private List<SelectItem> typessSelectItems;
    private Type type;

    public TypeBean() {
        super();
    }

    public List<SelectItem> getTypessSelectItems() {

        return (this.typessSelectItems);
    }

    public void setTypessSelectItems(List<SelectItem> typessSelectItems) {
        this.typessSelectItems = typessSelectItems;
    }

    public Type getType() {

        return (this.type);
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void save(ActionEvent actionEvent) {
        if (this.getType().getName() != null) {
            this.getType().setName(this.getType().getName().trim());

            Type t = this.typeDAO.findType(this.getType().getName());
            if (t == null) {
                this.typeDAO.saveType(this.getType());
            } else {
                // Error, ya existe alguno en la BD.
            }
        } else {
            // Error, el nombre no puede ser nul.
        }

        this.getType().setDescription("");
        this.getType().setName("");
    }

    @PostConstruct()
    private void createFields() {
        this.setType(new Type());
        this.setTypessSelectItems(new ArrayList<SelectItem>());

        List<Type> supportsFoud = this.typeDAO.findAllTypes();
        this.getTypessSelectItems().add(new SelectItem("", "Seleccione"));
        for (Type t : supportsFoud) {
            this.getTypessSelectItems().add(new SelectItem(t.getName(),
                    t.getName()));
        }
    }
}