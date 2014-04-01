package co.edu.udea.juridicapp.web.bean.product;

import co.edu.udea.juridicapp.persistence.dao.IAuthorOeuvreDAO;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvre;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvrePK;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
    private IAuthorOeuvreDAO authorOeuvreDAO;
    private AuthorOeuvre authorOeuvre;
    private AuthorOeuvre authorOeuvreAcquisitionFileSelected;
    private List<AuthorOeuvre> authorOeuvreAcquisitionFiles;
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

    public AuthorOeuvre getAuthorOeuvreAcquisitionFileSelected() {

        return (this.authorOeuvreAcquisitionFileSelected);
    }

    public void setAuthorOeuvreAcquisitionFileSelected(
            AuthorOeuvre authorOeuvreAcquisitionFileSelected) {
        this.authorOeuvreAcquisitionFileSelected = authorOeuvreAcquisitionFileSelected;
    }

    public List<AuthorOeuvre> getAuthorOeuvreAcquisitionFiles() {

        return (this.authorOeuvreAcquisitionFiles);
    }

    public void setAuthorOeuvreAcquisitionFiles(
            List<AuthorOeuvre> authorOeuvreAcquisitionFiles) {
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

//        AuthorOeuvrePK authorOeuvrePK = this.getAuthorOeuvre()
//                .getAuthorOeuvrePK();
//        this.setAuthorOeuvreAcquisitionFiles(this.authorOeuvreAcquisitionFileDAO
//                .findAuthorsOeuvresAcquisitionsByAttributes(
//                "authorOeuvreAcquisitionFilePK.oeuvreTypeId", authorOeuvrePK.getOeuvreTypeId(),
//                "authorOeuvreAcquisitionFilePK.oeuvreTypeName", authorOeuvrePK.getOeuvreTypeName(),
//                "authorOeuvreAcquisitionFilePK.documentType", authorOeuvrePK.getDocumentType(),
//                "authorOeuvreAcquisitionFilePK.idNumber", authorOeuvrePK.getIdNumber(),
//                "authorOeuvreAcquisitionFilePK.contract", authorOeuvrePK.getContract()));
    }

    public void onSelectedAuthorOeuvreAcquisitionFile(
            AuthorOeuvre authorOeuvreAcquisitionFile) {
//        this.setAuthorOeuvreAcquisitionFileSelected(
//                authorOeuvreAcquisitionFile);
//
//        InputStream inputStream = null;
//        try {
//            File f = new File("/home/rebien/Documentos/JuridicApp/salida.pdf");
//            inputStream = new FileInputStream(f);
//            ExternalContext externalContext = FacesContext.getCurrentInstance()
//                    .getExternalContext();
//
//            this.setFile(new DefaultStreamedContent(inputStream,
//                    externalContext.getMimeType(f.getName()), f.getName()));
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(AuthorOeuvreFileBean.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
    }

    @PostConstruct()
    private void createFields() {
        this.setAuthorOeuvreAcquisitionFiles(
                new ArrayList<AuthorOeuvre>());
    }
}