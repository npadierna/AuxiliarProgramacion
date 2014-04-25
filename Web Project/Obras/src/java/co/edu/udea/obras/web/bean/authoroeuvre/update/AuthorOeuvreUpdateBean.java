package co.edu.udea.obras.web.bean.authoroeuvre.update;

import co.edu.udea.obras.persistence.dao.IAuthorOeuvreDAO;
import co.edu.udea.obras.persistence.dao.ICommentDAO;
import co.edu.udea.obras.persistence.dao.IContractDAO;
import co.edu.udea.obras.persistence.dao.IDndaDAO;
import co.edu.udea.obras.persistence.dao.IOeuvreDAO;
import co.edu.udea.obras.persistence.dao.IOeuvreTypeDAO;
import co.edu.udea.obras.persistence.entity.AuthorOeuvre;
import co.edu.udea.obras.persistence.entity.Comment;
import co.edu.udea.obras.persistence.entity.CommentPK;
import co.edu.udea.obras.persistence.entity.Dependency;
import co.edu.udea.obras.persistence.entity.Dnda;
import co.edu.udea.obras.persistence.entity.Oeuvre;
import co.edu.udea.obras.web.bean.authoroeuvre.AuthorOeuvreListBean;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;
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
public final class AuthorOeuvreUpdateBean implements Serializable {

    private static final long serialVersionUID = 4901939557872617472L;
    private static final String ON_EDIT = "onEdit";
    public static final String ON_UPDATE = "onUpdate";
    public static final String FORMAT_FOR_DATE = "yyyy-MM-dd hh:mm aaa";
    @Autowired()
    private AuthorOeuvreListBean authorOeuvreListBean;
    @Autowired()
    private IAuthorOeuvreDAO authorOeuvreDAO;
    @Autowired()
    private IDndaDAO dndaDAO;
    @Autowired()
    private ICommentDAO commentDAO;
    @Autowired()
    private IOeuvreDAO oeuvreDAO;
    private List<AuthorOeuvre> authorsOeuvres;
    private List<Comment> oeuvreComments;
    private List<Comment> oeuvreDeleteComments;
    private AuthorOeuvre selectedAuthorOeuvre;
    private Oeuvre oeuvre;
    private DateFormat dateFormat;
    private String commentText;
    private UploadedFile uploadedFile;
    private boolean onEdit;
    private boolean onUpdate;

    public AuthorOeuvreUpdateBean() {
        super();

        this.onEdit = false;
        this.onUpdate = false;
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

    public List<Comment> getOeuvreDeleteComments() {

        return (this.oeuvreDeleteComments);
    }

    public void setOeuvreDeleteComments(List<Comment> oeuvreDeleteComments) {
        this.oeuvreDeleteComments = oeuvreDeleteComments;
    }

    public Oeuvre getOeuvre() {

        return (this.oeuvre);
    }

    public void setOeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
    }

    public String getCommentText() {

        return (this.commentText);
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public UploadedFile getUploadedFile() {

        return (this.uploadedFile);
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public AuthorOeuvre getSelectedAuthorOeuvre() {

        return (this.selectedAuthorOeuvre);
    }

    public void setSelectedAuthorOeuvre(AuthorOeuvre selectedAuthorOeuvre) {
        this.selectedAuthorOeuvre = selectedAuthorOeuvre;
    }

    public void addComment(ActionEvent actionEvent) {
        this.setCommentText(this.getCommentText().trim());
        if (!this.getCommentText().equals("")) {
            Comment c = new Comment();
            c.setDateTime(new Date());
            c.setText(this.getCommentText());

            this.getOeuvreComments().add(c);

            this.setCommentText("");
        }
    }

    public void removeComment(Comment comment) {
        this.getOeuvreDeleteComments().add(comment);
        this.getOeuvreComments().remove(comment);
    }

    public void onEditAuthorOeuvre(AuthorOeuvre selectedAuthorOeuvre) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;

        if (selectedAuthorOeuvre != null) {
            this.setSelectedAuthorOeuvre(selectedAuthorOeuvre);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargando...",
                    selectedAuthorOeuvre.getAuthorOeuvrePK()
                    .getOeuvreTypeName());

            this.onEdit = true;
            this.setOeuvre(this.getSelectedAuthorOeuvre().getOeuvreType()
                    .getOeuvre());
            this.findAuthorsOeuvres();
            this.findOeuvreComments();
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Datos Inválidos",
                    "Por favor seleccione una Obra válida.");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam(AuthorOeuvreUpdateBean.ON_EDIT,
                this.onEdit);
    }

    private void findAuthorsOeuvres() {
        this.setAuthorsOeuvres(this.authorOeuvreDAO.findAuthorsOeuvresByOeuvreId(
                this.getSelectedAuthorOeuvre().getAuthorOeuvrePK()
                .getOeuvreTypeId()));

        for (AuthorOeuvre authorOeuvre : this.getAuthorsOeuvres()) {
            if (authorOeuvre.getDnda() != null) {
                authorOeuvre.setDndaNumber(authorOeuvre.getDnda().getNumber());
            }
        }
    }

    private void findOeuvreComments() {
        this.setOeuvreComments(this.commentDAO.findCommnetsByOeuvreId(
                this.getSelectedAuthorOeuvre().getAuthorOeuvrePK()
                .getOeuvreTypeId()));
    }

    public String applyFormatForDate(Date date) {

        return (this.dateFormat.format(date));
    }

    public void updateAuthorsOeuvres(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage m;

        if (this.getAuthorsOeuvres().isEmpty()) {
            m = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "No hay Obras Creadas",
                    "No se ha creado ninguna Obra de ningún tipo asociada a algún Author.");

            FacesContext.getCurrentInstance().addMessage(null, m);

            return;
        }

        m = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Actualizando la Obra",
                "Este proceso puede tardar un momento...");
        this.setOeuvre(this.getSelectedAuthorOeuvre().getOeuvreType()
                .getOeuvre());

        Long idOeuvre = this.oeuvreDAO.updateOeuvre(this.getOeuvre()).getId();

        for (Comment c : this.getOeuvreComments()) {
            if (c.getCommentPK() == null) {
                CommentPK commentPK = new CommentPK();
                commentPK.setOeuvreId(idOeuvre);
                c.setCommentPK(commentPK);

                this.commentDAO.saveComment(c);
            }
        }

        if (this.getOeuvreDeleteComments() != null) {
            for (Comment c : this.getOeuvreDeleteComments()) {
                this.commentDAO.deleteComment(c);
            }
        }

        for (AuthorOeuvre authorOeuvre : this.getAuthorsOeuvres()) {
            Dnda oldDnda = null;
            if (authorOeuvre.getDndaNumber() != null) {
                authorOeuvre.setDndaNumber(authorOeuvre.getDndaNumber().trim());

                if ((authorOeuvre.getDnda() == null)
                        || (!authorOeuvre.getDndaNumber().equals(""))
                        && (!authorOeuvre.getDndaNumber().equals(authorOeuvre
                        .getDnda().getNumber()))) {
                    oldDnda = authorOeuvre.getDnda();
                    Dnda newDnda = new Dnda(authorOeuvre.getDndaNumber());

                    authorOeuvre.setDnda(newDnda);
                    this.dndaDAO.saveDnda(newDnda);
                }
            }

            if (authorOeuvre.getIsbn() != null) {
                authorOeuvre.setIsbn(authorOeuvre.getIsbn().trim());
                if (authorOeuvre.getIsbn().equals("")) {
                    authorOeuvre.setIsbn(null);
                }
            }

            this.authorOeuvreDAO.updateAuthorOeuvre(authorOeuvre);

            if (oldDnda != null) {
                this.dndaDAO.deleteDnda(oldDnda);
            }
        }

        this.authorOeuvreListBean.setMustUpdate(true);
        this.onUpdate = true;

        FacesContext.getCurrentInstance().addMessage(null, m);
        context.addCallbackParam(AuthorOeuvreUpdateBean.ON_UPDATE,
                this.onUpdate);
    }

    @PostConstruct()
    private void createFields() {
        this.setAuthorsOeuvres(new ArrayList<AuthorOeuvre>());
        this.setOeuvreComments(new ArrayList<Comment>());
        this.setOeuvreDeleteComments(new ArrayList<Comment>());
        this.setUploadedFile(null);
        this.setOeuvre(new Oeuvre());
        this.getOeuvre().setDependency(new Dependency());
    }
}