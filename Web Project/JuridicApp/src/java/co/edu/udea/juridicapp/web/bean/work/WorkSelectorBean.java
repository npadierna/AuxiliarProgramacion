package co.edu.udea.juridicapp.web.bean.work;

import co.edu.udea.juridicapp.persistence.dao.IAuthorWorkDAO;
import co.edu.udea.juridicapp.persistence.dao.ICommentDAO;
import co.edu.udea.juridicapp.persistence.entity.AuthorWork;
import co.edu.udea.juridicapp.persistence.entity.Comment;
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

    private static final long serialVersionUID = 3054628927294284800L;
    @Autowired()
    private IAuthorWorkDAO authorWorkDAO;
    @Autowired()
    private ICommentDAO commentDAO;
    private boolean onSelected;
    private AuthorWork selectedAuthorWork;
    private List<AuthorWork> authorsWorks;
    private List<Comment> workComments;

    public WorkSelectorBean() {
        super();
    }

    public AuthorWork getSelectedAuthorWork() {

        return (this.selectedAuthorWork);
    }

    public void setSelectedAuthorWork(AuthorWork selectedAuthorWork) {
        this.selectedAuthorWork = selectedAuthorWork;
    }

    public List<AuthorWork> getAuthorsWorks() {

        return (this.authorsWorks);
    }

    public void setAuthorsWorks(List<AuthorWork> authorsWorks) {
        this.authorsWorks = authorsWorks;
    }

    public List<Comment> getWorkComments() {

        return (this.workComments);
    }

    public void setWorkComments(List<Comment> workComments) {
        this.workComments = workComments;
    }

    public void onSelectedAuthorWork(AuthorWork selectedAuthorWork) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;

        if (selectedAuthorWork != null) {
            this.selectedAuthorWork = selectedAuthorWork;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargando...",
                    selectedAuthorWork.getAuthorWorkPK().getWorkTypeName());
            this.onSelected = true;

            this.findAuthorsWorks();
            this.findWorkComments();
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
        this.onSelected = false;

        this.setAuthorsWorks(new ArrayList<AuthorWork>());
        this.setWorkComments(new ArrayList<Comment>());
    }

    private void findAuthorsWorks() {
        this.setAuthorsWorks(this.authorWorkDAO.findAuthorsWorksByWorkId(
                this.getSelectedAuthorWork().getAuthorWorkPK().getWorkTypeId()));
    }

    private void findWorkComments() {
        this.setWorkComments(this.commentDAO.findCommnetsByWorkId(
                this.getSelectedAuthorWork().getAuthorWorkPK().getWorkTypeId()));
    }
}