package co.edu.udea.juridicapp.web.bean.authoroeuvre;

import co.edu.udea.juridicapp.persistence.dao.IAuthorOeuvreDAO;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvre;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
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
public final class AuthorOeuvreListBean implements Serializable {

    private static final long serialVersionUID = 2915088641135538176L;
    @Autowired()
    private IAuthorOeuvreDAO authorOeuvreDAO;
    private List<AuthorOeuvre> authorOeuvres;
    private List<AuthorOeuvre> authorsOeuvresFiltered;
    private AuthorOeuvre selectedAuthorOeuvre;

    public AuthorOeuvreListBean() {
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

    public void preProcessForPDFFile(Object document) {
        Document pdfDocument = (Document) document;

        pdfDocument.open();
        pdfDocument.setPageSize(PageSize.LETTER.rotate());
        pdfDocument.setMargins(10.0F, 10.0F, 20.0F, 20.0F);
        pdfDocument.newPage();
    }

    @PostConstruct()
    private void createFields() {
        this.setAuthorOeuvres(this.authorOeuvreDAO.findAllAuthorsOeuvres());
    }
}