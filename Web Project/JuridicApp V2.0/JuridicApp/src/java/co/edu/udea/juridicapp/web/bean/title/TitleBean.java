package co.edu.udea.juridicapp.web.bean.title;

import co.edu.udea.juridicapp.persistence.dao.ITitleDAO;
import co.edu.udea.juridicapp.persistence.entity.Title;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
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
@Scope(value = "session")
@SessionScoped()
public final class TitleBean implements Serializable {

    private static final long serialVersionUID = 4651738957089294336L;
    @Autowired()
    private ITitleDAO titleDAO;
    private List<String> titlesNames;
    private Title title;

    public TitleBean() {
        super();

        this.setTitle(new Title());
    }

    public List<String> getTitlesNames() {
        if (this.titleDAO.countTitles() != this.titlesNames.size()) {
            this.createFields();
        }

        return (this.titlesNames);
    }

    public void setTitlesNames(List<String> titlesNames) {
        this.titlesNames = titlesNames;
    }

    public Title getTitle() {

        return (this.title);
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public void save(ActionEvent actionEvent) {
        FacesMessage msg;
        if (this.getTitle().getProfile() != null) {
            this.getTitle().setProfile(this.getTitle().getProfile().trim());

            Title r = this.titleDAO.findTitle(this.getTitle().getProfile());
            if (r == null) {
                this.titleDAO.saveTitle(this.getTitle());
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado!!",
                        "Se ha guardado exitosamente:"
                        + this.getTitle().getProfile() + ".");
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Datos Inválidos", "Ya existe un Vínculo Universitario: "
                        + this.getTitle().getProfile() + ".");
            }

            this.getTitle().setDescription("");
            this.getTitle().setProfile("");
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Datos Inválidos",
                    "Hay campos obligatorios que están vacíos.");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    @PostConstruct()
    private void createFields() {
        this.setTitlesNames(new ArrayList<String>());

        List<Title> titlesFound = this.titleDAO.findAllTitles();
        for (Title r : titlesFound) {
            this.titlesNames.add(r.getProfile());
        }
    }
}