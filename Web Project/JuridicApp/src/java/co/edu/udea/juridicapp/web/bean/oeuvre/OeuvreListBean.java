package co.edu.udea.juridicapp.web.bean.oeuvre;

import co.edu.udea.juridicapp.persistence.dao.IAuthorOeuvreDAO;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvre;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
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
public final class OeuvreListBean implements Serializable {

    private static final long serialVersionUID = 2915088641135538176L;
    @Autowired()
    private IAuthorOeuvreDAO authorOeuvreDAO;
    private List<AuthorOeuvre> authorOeuvres;
    private List<AuthorOeuvre> authorsOeuvresFiltered;
    private AuthorOeuvre selectedAuthorOeuvre;

    public OeuvreListBean() {
        super();
    }

    public List<AuthorOeuvre> getAuthorOeuvres() {
        if (this.authorOeuvreDAO.countAuthorsOeuvres()
                != this.authorOeuvres.size()) {
            this.createFields();
        }

        return (this.authorOeuvres);
    }

    public void setAuthorOeuvres(List<AuthorOeuvre> authorOeuvres) {
        this.authorOeuvres = authorOeuvres;
    }

    public List<AuthorOeuvre> getAuthorsOeuvresFiltered() {

        return (this.authorsOeuvresFiltered);
    }

    public void setAuthorsOeuvresFiltered(
            List<AuthorOeuvre> authorsOeuvresFiltered) {
        this.authorsOeuvresFiltered = authorsOeuvresFiltered;
    }

    public AuthorOeuvre getSelectedAuthorOeuvre() {

        return (this.selectedAuthorOeuvre);
    }

    public void setSelectedAuthorOeuvre(AuthorOeuvre selectedAuthorOeuvre) {
        this.selectedAuthorOeuvre = selectedAuthorOeuvre;
    }

    @PostConstruct()
    private void createFields() {
        this.setAuthorOeuvres(this.authorOeuvreDAO.findAllAuthorsOeuvres());
    }
}