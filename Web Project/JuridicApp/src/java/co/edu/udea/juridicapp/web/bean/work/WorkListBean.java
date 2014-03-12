package co.edu.udea.juridicapp.web.bean.work;

import co.edu.udea.juridicapp.persistence.dao.IAuthorWorkDAO;
import co.edu.udea.juridicapp.persistence.entity.AuthorWork;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@Component()
@SessionScoped()
public final class WorkListBean implements Serializable {

    private static final long serialVersionUID = 2915088641135538176L;
    @Autowired()
    private IAuthorWorkDAO authorWorkDAO;
    private List<AuthorWork> authorWorks;
    private List<AuthorWork> authorsWorksFiltered;
    private AuthorWork selectedAuthorWork;

    public WorkListBean() {
        super();
    }

    public List<AuthorWork> getAuthorWorks() {

        return (this.authorWorks);
    }

    public void setAuthorWorks(List<AuthorWork> authorWorks) {
        this.authorWorks = authorWorks;
    }

    public List<AuthorWork> getAuthorsWorksFiltered() {

        return (this.authorsWorksFiltered);
    }

    public void setAuthorsWorksFiltered(List<AuthorWork> authorsWorksFiltered) {
        this.authorsWorksFiltered = authorsWorksFiltered;
    }

    public AuthorWork getSelectedAuthorWork() {

        return (this.selectedAuthorWork);
    }

    public void setSelectedAuthorWork(AuthorWork selectedAuthorWord) {
        this.selectedAuthorWork = selectedAuthorWord;
    }

    @PostConstruct()
    private void createFields() {
        this.setAuthorWorks(this.authorWorkDAO.findAllAuthorsWorks());
    }
}