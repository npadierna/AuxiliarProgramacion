package co.edu.udea.juridicapp.web.bean.type;

import co.edu.udea.juridicapp.persistence.dao.ITypeDAO;
import co.edu.udea.juridicapp.persistence.entity.Type;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Component()
@Scope(value = "request")
@RequestScoped()
public final class TypeCreatorBean implements Serializable {

    private static final long serialVersionUID = 4874667164696649728L;
    @Autowired()
    private ITypeDAO typeDAO;
    private Type newType;

    public TypeCreatorBean() {
        super();
    }

    public Type getNewType() {

        return (this.newType);
    }

    public void setNewType(Type newType) {
        this.newType = newType;
    }

    public void saveType(ActionEvent actionEvent) {
        FacesMessage msg;

        if (this.getNewType().getName() != null) {
            this.getNewType().setName(this.getNewType().getName().trim());

            Type t = this.typeDAO.findType(this.getNewType().getKey());
            if (t == null) {
                this.typeDAO.saveType(this.getNewType());
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado!!",
                        "Se ha guardado exitosamente el Tipo de Obra: "
                        + this.getNewType().getName() + ".");
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Datos Inválidos", "Ya existe un Tipo de Obra: "
                        + this.getNewType().getName() + ".");
            }

            this.getNewType().setDescription("");
            this.getNewType().setName("");
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Datos Inválidos",
                    "Hay campos obligatorios y requeridos que están vacíos.");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    @PostConstruct()
    private void createFields() {
        this.setNewType(new Type());
    }
}