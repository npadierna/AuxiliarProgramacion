package co.edu.udea.juridicapp.web.bean.oeuvre;

import co.edu.udea.juridicapp.persistence.dao.IAuthorOeuvreDAO;
import co.edu.udea.juridicapp.persistence.dao.ICommentDAO;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvre;
import co.edu.udea.juridicapp.persistence.entity.Comment;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
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
public final class OeuvreSelectorBean implements Serializable {

    private static final long serialVersionUID = 3054628927294284800L;
    public static final String FORMAT_FOR_DATE = "yyyy-MM-dd hh:mm aaa";
    @Autowired()
    private IAuthorOeuvreDAO authorOeuvreDAO;
    @Autowired()
    private ICommentDAO commentDAO;
    private boolean onSelected;
    private AuthorOeuvre selectedAuthorOeuvre;
    private List<AuthorOeuvre> authorsOeuvres;
    private List<Comment> oeuvreComments;
    private DateFormat dateFormat;

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
            this.setSelectedAuthorOeuvre(selectedAuthorOeuvre);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargando...",
                    selectedAuthorOeuvre.getAuthorOeuvrePK()
                    .getOeuvreTypeName());
            this.onSelected = true;

            this.findAuthorsOeuvres();
            this.findOeuvreComments();
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Datos Inválidos",
                    "Por favor seleccione una obra Valida.");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam("onSelected", this.onSelected);
    }

    public String applyFormatForDate(Date date) {

        return (this.dateFormat.format(date));
    }

    private void findAuthorsOeuvres() {
        this.setAuthorsOeuvres(this.authorOeuvreDAO.findAuthorsOeuvresByOeuvreId(
                this.getSelectedAuthorOeuvre().getAuthorOeuvrePK()
                .getOeuvreTypeId()));
    }

    private void findOeuvreComments() {
        this.setOeuvreComments(this.commentDAO.findCommnetsByOeuvreId(
                this.getSelectedAuthorOeuvre().getAuthorOeuvrePK()
                .getOeuvreTypeId()));
    }

    @PostConstruct()
    private void createFields() {
        this.onSelected = false;
        this.dateFormat = new SimpleDateFormat(
                OeuvreSelectorBean.FORMAT_FOR_DATE);

        this.setAuthorsOeuvres(new ArrayList<AuthorOeuvre>());
        this.setOeuvreComments(new ArrayList<Comment>());
    }
}