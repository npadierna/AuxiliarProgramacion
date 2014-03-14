package co.edu.udea.juridicapp.web.bean.work.create;

import co.edu.udea.juridicapp.persistence.dao.IAuthorDAO;
import co.edu.udea.juridicapp.persistence.dao.IAuthorWorkDAO;
import co.edu.udea.juridicapp.persistence.dao.ICommentDAO;
import co.edu.udea.juridicapp.persistence.dao.IDependencyDAO;
import co.edu.udea.juridicapp.persistence.dao.IWorkDAO;
import co.edu.udea.juridicapp.persistence.dao.IWorkTypeDAO;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorWork;
import co.edu.udea.juridicapp.persistence.entity.Comment;
import co.edu.udea.juridicapp.persistence.entity.CommentPK;
import co.edu.udea.juridicapp.persistence.entity.Dependency;
import co.edu.udea.juridicapp.persistence.entity.PersonPK;
import co.edu.udea.juridicapp.persistence.entity.Role;
import co.edu.udea.juridicapp.persistence.entity.Support;
import co.edu.udea.juridicapp.persistence.entity.Work;
import co.edu.udea.juridicapp.persistence.entity.WorkType;
import co.edu.udea.juridicapp.persistence.entity.WorkTypePK;
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
public final class CreatorWorkBean implements Serializable {

    private static final long serialVersionUID = 2901939557872617472L;
    @Autowired()
    private IAuthorDAO authorDAO;
    @Autowired()
    private IAuthorWorkDAO authorWorkDAO;
    @Autowired()
    private ICommentDAO commentDAO;
    @Autowired()
    private IDependencyDAO dependencyDAO;
    @Autowired()
    private IWorkDAO workDAO;
    @Autowired()
    private IWorkTypeDAO workTypeDAO;
    private List<String> dependenciesNames;
    private List<AuthorWork> authorsWorks;
    private List<Author> foundAuthors;
    private List<Comment> comments;
    private String commentText;
    private String documentType;
    private String idNumber;
    private Work work;

    public CreatorWorkBean() {
        super();
    }

    public List<String> getDependenciesNames() {

        return (this.dependenciesNames);
    }

    public void setDependenciesNames(List<String> dependenciesNames) {
        this.dependenciesNames = dependenciesNames;
    }

    public List<AuthorWork> getAuthorsWorks() {

        return (this.authorsWorks);
    }

    public void setAuthorsWorks(List<AuthorWork> authorsWorks) {
        this.authorsWorks = authorsWorks;
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

    public Work getWork() {

        return (this.work);
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public void addAuthor(Author author) {
        AuthorWork authorWork = new AuthorWork(-1L, null,
                author.getPersonPK().getDocumentType(),
                author.getPersonPK().getIdNumber(), null);
        authorWork.setAuthor(author);
        authorWork.setRole(new Role());
        authorWork.setSupportType(new Support());

        this.getAuthorsWorks().add(authorWork);
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
                    new PersonPK(this.getDocumentType(), this.getIdNumber()));
            if (a != null) {
                this.getFoundAuthors().add(a);
            } else {
                // Mostrar mensaje de error.
            }
        }
    }

    public void removeAuthorWork(AuthorWork author) {
        this.getAuthorsWorks().remove(author);
    }

    public void removeComment(Comment comment) {
        this.getComments().remove(comment);
    }

    public void saveAuthorsWorks(ActionEvent actionEvent) {
        Long idWork = this.workDAO.saveWork(this.getWork());

        for (Comment c : this.getComments()) {
            CommentPK commentPK = new CommentPK();
            commentPK.setWorkId(idWork);
            c.setCommentPK(commentPK);

            this.commentDAO.saveComment(c);
        }

        for (AuthorWork authorWork : this.getAuthorsWorks()) {
            WorkTypePK workTypePK = new WorkTypePK(idWork,
                    authorWork.getAuthorWorkPK().getWorkTypeName());
            WorkType workType = new WorkType(workTypePK);

            if (this.workTypeDAO.findWorkType(workTypePK) == null) {
                this.workTypeDAO.saveWorkType(workType);
            }

            authorWork.getAuthorWorkPK().setWorkTypeId(idWork);
            authorWork.setWorkType(workType);

//            this.authorWorkDAO.saveAuthorWork(authorWork);
            this.authorWorkDAO.saveAuthorWorkUsingNativeQuery(authorWork);
        }
    }

    @PostConstruct()
    private void createFields() {
        this.setAuthorsWorks(new ArrayList<AuthorWork>());
        this.setComments(new ArrayList<Comment>());
        this.setDependenciesNames(new ArrayList<String>());
        this.setFoundAuthors(new ArrayList<Author>());
        this.setWork(new Work());
        this.getWork().setDependency(new Dependency());

        List<Dependency> dependenciesFound = this.dependencyDAO
                .findAllDependencies();
        if ((dependenciesFound != null) && !(dependenciesFound.isEmpty())) {
            for (Dependency dependency : dependenciesFound) {
                this.getDependenciesNames().add(dependency.getName());
            }
        }
    }
}