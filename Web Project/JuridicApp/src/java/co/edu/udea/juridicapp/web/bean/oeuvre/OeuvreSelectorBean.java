package co.edu.udea.juridicapp.web.bean.oeuvre;

import co.edu.udea.juridicapp.persistence.dao.IAuthorOeuvreDAO;
import co.edu.udea.juridicapp.persistence.dao.ICommentDAO;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvre;
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
public final class OeuvreSelectorBean {

    private static final long serialVersionUID = 3054628927294284800L;
    @Autowired()
    private IAuthorOeuvreDAO authorOeuvreDAO;
    @Autowired()
    private ICommentDAO commentDAO;
    private boolean onSelected;
    private AuthorOeuvre selectedAuthorOeuvre;
    private List<AuthorOeuvre> authorsOeuvres;
    private List<Comment> oeuvreComments;

    public OeuvreSelectorBean() {
        super();
    }

    public AuthorOeuvre getSelectedAuthorOeuvre() {

        return (this.selectedAuthorOeuvre);
    }

    public void setSelectedAuthorOeuvre(AuthorOeuvre selectedAuthorOeuvre) {
        this.selectedAuthorOeuvre = selectedAuthorOeuvre;
    }

    public List<AuthorOeuvre> getAuthorsOeuvres() {

        return (this.authorsOeuvres);
    }

    public void setAuthorsOeuvres(List<AuthorOeuvre> authorsOeuvres) {
        this.authorsOeuvres = authorsOeuvres;
    }

    public List<Comment> getOeuvreComments() {

        return (this.oeuvreComments);
    }

    public void setOeuvreComments(List<Comment> oeuvreComments) {
        this.oeuvreComments = oeuvreComments;
    }

    public void onSelectedAuthorOeuvre(AuthorOeuvre selectedAuthorOeuvre) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;

        if (selectedAuthorOeuvre != null) {
            this.selectedAuthorOeuvre = selectedAuthorOeuvre;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargando...",
                    selectedAuthorOeuvre.getAuthorOeuvrePK().getOeuvreTypeName());
            this.onSelected = true;

            this.findAuthorsOeuvres();
            this.findOeuvreComments();
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

        this.setAuthorsOeuvres(new ArrayList<AuthorOeuvre>());
        this.setOeuvreComments(new ArrayList<Comment>());
    }

    private void findAuthorsOeuvres() {
        this.setAuthorsOeuvres(this.authorOeuvreDAO.findAuthorsOeuvresByOeuvreId(
                this.getSelectedAuthorOeuvre().getAuthorOeuvrePK().getOeuvreTypeId()));
    }

    private void findOeuvreComments() {
        this.setOeuvreComments(this.commentDAO.findCommnetsByOeuvreId(
                this.getSelectedAuthorOeuvre().getAuthorOeuvrePK().getOeuvreTypeId()));
    }
}