package co.edu.udea.juridicapp.web.bean.product;

import co.edu.udea.juridicapp.persistence.dao.IAuthorOeuvreAcquisitionFileDAO;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvre;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvreAcquisitionFile;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvrePK;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
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
public class AuthorOeuvreFileBean implements Serializable {

    private static final long serialVersionUID = 8655659063769262608L;
    @Autowired()
    private IAuthorOeuvreAcquisitionFileDAO authorOeuvreAcquisitionFileDAO;
    private AuthorOeuvre authorOeuvre;
    private AuthorOeuvreAcquisitionFile authorOeuvreAcquisitionFileSelected;
    private List<AuthorOeuvreAcquisitionFile> authorOeuvreAcquisitionFiles;
    private StreamedContent file;

    public AuthorOeuvreFileBean() {
        super();
    }

    public AuthorOeuvre getAuthorOeuvre() {

        return (this.authorOeuvre);
    }

    public void setAuthorOeuvre(AuthorOeuvre authorOeuvre) {
        this.authorOeuvre = authorOeuvre;
    }

    public AuthorOeuvreAcquisitionFile getAuthorOeuvreAcquisitionFileSelected() {

        return (this.authorOeuvreAcquisitionFileSelected);
    }

    public void setAuthorOeuvreAcquisitionFileSelected(
            AuthorOeuvreAcquisitionFile authorOeuvreAcquisitionFileSelected) {
        this.authorOeuvreAcquisitionFileSelected = authorOeuvreAcquisitionFileSelected;
    }

    public List<AuthorOeuvreAcquisitionFile> getAuthorOeuvreAcquisitionFiles() {

        return (this.authorOeuvreAcquisitionFiles);
    }

    public void setAuthorOeuvreAcquisitionFiles(
            List<AuthorOeuvreAcquisitionFile> authorOeuvreAcquisitionFiles) {
        this.authorOeuvreAcquisitionFiles = authorOeuvreAcquisitionFiles;
    }

    public StreamedContent getFile() {

        return (this.file);
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

    public void onViewProductsListForAuthorOeuvre(AuthorOeuvre authorOeuvre) {
        this.setAuthorOeuvre(authorOeuvre);

        AuthorOeuvrePK authorOeuvrePK = this.getAuthorOeuvre()
                .getAuthorOeuvrePK();
        this.setAuthorOeuvreAcquisitionFiles(this.authorOeuvreAcquisitionFileDAO
                .findAuthorsOeuvresAcquisitionsByAttributes(
                "authorOeuvreAcquisitionFilePK.oeuvreTypeId", authorOeuvrePK.getOeuvreTypeId(),
                "authorOeuvreAcquisitionFilePK.oeuvreTypeName", authorOeuvrePK.getOeuvreTypeName(),
                "authorOeuvreAcquisitionFilePK.documentType", authorOeuvrePK.getDocumentType(),
                "authorOeuvreAcquisitionFilePK.idNumber", authorOeuvrePK.getIdNumber(),
                "authorOeuvreAcquisitionFilePK.contract", authorOeuvrePK.getContract()));
    }

    public void onSelectedAuthorOeuvreAcquisitionFile(
            AuthorOeuvreAcquisitionFile authorOeuvreAcquisitionFile) {
        this.setAuthorOeuvreAcquisitionFileSelected(authorOeuvreAcquisitionFile);

        ExternalContext c = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext o = (ServletContext) c.getContext();

        InputStream inputStream = o.getResourceAsStream("/home/rebien/Documentos/JuridicApp/salida.pdf");
        this.setFile(new DefaultStreamedContent(inputStream, "application/pdf", "salida.pdf"));
    }

    @PostConstruct()
    private void createFields() {
        this.setAuthorOeuvreAcquisitionFiles(
                new ArrayList<AuthorOeuvreAcquisitionFile>());
    }
}