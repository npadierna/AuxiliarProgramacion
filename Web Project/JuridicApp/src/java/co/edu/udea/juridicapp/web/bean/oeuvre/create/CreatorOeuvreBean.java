package co.edu.udea.juridicapp.web.bean.oeuvre.create;

import co.edu.udea.juridicapp.persistence.dao.IAuthorDAO;
import co.edu.udea.juridicapp.persistence.dao.IAuthorOeuvreDAO;
import co.edu.udea.juridicapp.persistence.dao.ICommentDAO;
import co.edu.udea.juridicapp.persistence.dao.IDependencyDAO;
import co.edu.udea.juridicapp.persistence.dao.IOeuvreDAO;
import co.edu.udea.juridicapp.persistence.dao.IOeuvreTypeDAO;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvre;
import co.edu.udea.juridicapp.persistence.entity.Comment;
import co.edu.udea.juridicapp.persistence.entity.CommentPK;
import co.edu.udea.juridicapp.persistence.entity.Dependency;
import co.edu.udea.juridicapp.persistence.entity.PeoplePK;
import co.edu.udea.juridicapp.persistence.entity.Title;
import co.edu.udea.juridicapp.persistence.entity.Support;
import co.edu.udea.juridicapp.persistence.entity.Oeuvre;
import co.edu.udea.juridicapp.persistence.entity.OeuvreType;
import co.edu.udea.juridicapp.persistence.entity.OeuvreTypePK;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
@SessionScoped()
public final class CreatorOeuvreBean implements Serializable {

    private static final long serialVersionUID = 2901939557872617472L;
    @Autowired()
    private IAuthorDAO authorDAO;
    @Autowired()
    private IAuthorOeuvreDAO authorOeuvreDAO;
    @Autowired()
    private ICommentDAO commentDAO;
    @Autowired()
    private IDependencyDAO dependencyDAO;
    @Autowired()
    private IOeuvreDAO oeuvreDAO;
    @Autowired()
    private IOeuvreTypeDAO oeuvreTypeDAO;
    private List<String> dependenciesNames;
    private List<AuthorOeuvre> authorsOeuvres;
    private List<Author> foundAuthors;
    private List<Comment> comments;
    private String commentText;
    private String documentType;
    private String idNumber;
    private Oeuvre oeuvre;

    public CreatorOeuvreBean() {
        super();
    }

    public List<String> getDependenciesNames() {

        return (this.dependenciesNames);
    }

    public void setDependenciesNames(List<String> dependenciesNames) {
        this.dependenciesNames = dependenciesNames;
    }

    public List<AuthorOeuvre> getAuthorsOeuvres() {

        return (this.authorsOeuvres);
    }

    public void setAuthorsOeuvres(List<AuthorOeuvre> authorsOeuvres) {
        this.authorsOeuvres = authorsOeuvres;
    }

    public List<Author> getFoundAuthors() {

        return (this.foundAuthors);
    }

    public void setFoundAuthors(List<Author> foundAuthors) {
        this.foundAuthors = foundAuthors;
    }

    public List<Comment> getComments() {

        return (this.comments);
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getCommentText() {

        return (this.commentText);
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getDocumentType() {

        return (this.documentType);
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getIdNumber() {

        return (this.idNumber);
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Oeuvre getOeuvre() {

        return (this.oeuvre);
    }

    public void setOeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
    }

    public void addAuthor(Author author) {
        AuthorOeuvre authorOeuvre = new AuthorOeuvre(-1L, null,
                author.getPeoplePK().getDocumentType(),
                author.getPeoplePK().getIdNumber(), null);
        authorOeuvre.setAuthor(author);
        authorOeuvre.setTitle(new Title());
        authorOeuvre.setSupportType(new Support());

        this.getAuthorsOeuvres().add(authorOeuvre);
        this.getFoundAuthors().remove(author);

        this.setIdNumber("");
    }

    public void addComment(ActionEvent actionEvent) {
        Comment c = new Comment();
        c.setDateTime(new Date());
        c.setText(this.getCommentText());

        this.getComments().add(c);

        this.setCommentText("");
    }

    public void findAuthor(ActionEvent actionEvent) {
        if ((this.getDocumentType() != null) && (this.getIdNumber() != null)) {
            this.getFoundAuthors().clear();

            Author a = this.authorDAO.findAuthor(
                    new PeoplePK(this.getDocumentType(), this.getIdNumber()));
            if (a != null) {
                this.getFoundAuthors().add(a);
            } else {
                // Mostrar mensaje de error.
            }
        }
    }

    public void removeAuthorOeuvre(AuthorOeuvre author) {
        this.getAuthorsOeuvres().remove(author);
    }

    public void removeComment(Comment comment) {
        this.getComments().remove(comment);
    }

    public void saveAuthorsOeuvres(ActionEvent actionEvent) {
        Long idOeuvre = this.oeuvreDAO.saveOeuvre(this.getOeuvre());

        for (Comment c : this.getComments()) {
            CommentPK commentPK = new CommentPK();
            commentPK.setOeuvreId(idOeuvre);
            c.setCommentPK(commentPK);

            this.commentDAO.saveComment(c);
        }

        for (AuthorOeuvre authorOeuvre : this.getAuthorsOeuvres()) {
            OeuvreTypePK oeuvreTypePK = new OeuvreTypePK(idOeuvre,
                    authorOeuvre.getAuthorOeuvrePK().getOeuvreTypeName());
            OeuvreType oeuvreType = new OeuvreType(oeuvreTypePK);

            if (this.oeuvreTypeDAO.findOeuvreType(oeuvreTypePK) == null) {
                this.oeuvreTypeDAO.saveOeuvreType(oeuvreType);
            }

            authorOeuvre.getAuthorOeuvrePK().setOeuvreTypeId(idOeuvre);
            authorOeuvre.setOeuvreType(oeuvreType);

            this.authorOeuvreDAO.saveAuthorOeuvre(authorOeuvre);
       //     this.authorOeuvreDAO.saveAuthorOeuvreUsingNativeQuery(authorOeuvre);
        }
    }

    @PostConstruct()
    private void createFields() {
        this.setAuthorsOeuvres(new ArrayList<AuthorOeuvre>());
        this.setComments(new ArrayList<Comment>());
        this.setDependenciesNames(new ArrayList<String>());
        this.setFoundAuthors(new ArrayList<Author>());
        this.setOeuvre(new Oeuvre());
        this.getOeuvre().setDependency(new Dependency());

        List<Dependency> dependenciesFound = this.dependencyDAO
                .findAllDependencies();
        if ((dependenciesFound != null) && !(dependenciesFound.isEmpty())) {
            for (Dependency dependency : dependenciesFound) {
                this.getDependenciesNames().add(dependency.getName());
            }
        }
    }
}