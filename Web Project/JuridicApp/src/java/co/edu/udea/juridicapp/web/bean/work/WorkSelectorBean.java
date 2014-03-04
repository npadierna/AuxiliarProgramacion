package co.edu.udea.juridicapp.web.bean.work;

import co.edu.udea.juridicapp.persistence.dao.IAuthorWorkDAO;
import co.edu.udea.juridicapp.persistence.entity.AuthorWork;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Component()
@SessionScoped()
public class WorkSelectorBean {

    //    private static final long serialVersionUID = 2915088641135538176L;
    @Autowired()
    private IAuthorWorkDAO authorWorkDAO;
    private AuthorWork selectedAuthorWork;
    private List<AuthorWork> authorsWorks;
    private boolean onSelected;

    public WorkSelectorBean() {
        super();
        this.onSelected = false;
    }

    public AuthorWork getSelectedAuthorWork() {

        return selectedAuthorWork;
    }

    public void setSelectedAuthorWork(AuthorWork selectedAuthorWork) {
        this.selectedAuthorWork = selectedAuthorWork;
    }

    public List<AuthorWork> getAuthorsWorks() {

        return authorsWorks;
    }

    public void setAuthorsWorks(List<AuthorWork> authorsWorks) {
        this.authorsWorks = authorsWorks;
    }

    public void onSelectedAuthorWork(AuthorWork selectedAuthorWork) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        if (selectedAuthorWork != null) {
            this.selectedAuthorWork = selectedAuthorWork;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargando...",
                    selectedAuthorWork.getAuthorWorkPK().getWorkTypeName( ));
            this.onSelected = true;
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Datos Inválidos",
                    "Por favor seleccione una obra Valida.");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("onSelected", onSelected);
    }

    @PostConstruct()
    private void createFields() {
        this.setAuthorsWorks(new ArrayList<AuthorWork>());
    }
}
