package co.edu.udea.juridicapp.web.bean.type;

import co.edu.udea.juridicapp.persistence.dao.ITypeDAO;
import co.edu.udea.juridicapp.persistence.entity.Type;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
@SessionScoped()
public class TypeBean implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Autowired()
    private ITypeDAO typeDAO;
    private Type type;

    public TypeBean() {
        super();
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
    }

    @PostConstruct()
    private void createFields() {
        this.setType(new Type());
    }
}