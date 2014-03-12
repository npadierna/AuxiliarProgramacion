package co.edu.udea.juridicapp.web.bean.tester;

import co.edu.udea.juridicapp.persistence.dao.IAuthorDAO;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.PersonPK;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
@SessionScoped()
public class AuthorFinderTesterBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Autowired()
    private IAuthorDAO authorDAO;
    private String documentType;
    private String idNumber;
    private List<Author> authorFound;

    public AuthorFinderTesterBean() {
        super();
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

    public List<Author> getAuthorFound() {

        return (this.authorFound);
    }

    public void setAuthorFound(List<Author> authorFound) {
        this.authorFound = authorFound;
    }

    public void findAuthor(ActionEvent actionEvent) {
        if ((this.getDocumentType() != null) && (this.getIdNumber() != null)) {
            this.getAuthorFound().clear();
            this.getAuthorFound().add(this.authorDAO.findAuthor(
                    new PersonPK(this.getDocumentType(), this.getIdNumber())));
        }
    }

    @PostConstruct()
    private void createFields() {
        this.setAuthorFound(new ArrayList<Author>());
    }
}