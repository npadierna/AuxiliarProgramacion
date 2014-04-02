package co.edu.udea.juridicapp.web.bean.product;

import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvre;
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
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
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
    private static final String SELECTED_PRODUCT = "selectedProduct";
    private AuthorOeuvre authorOeuvreSelected;
    private List<AuthorOeuvre> authorOeuvreFileList;
    private StreamedContent productFile;
    private boolean selectedProduct;


    public AuthorOeuvreFileBean() {
        super();
        this.selectedProduct = false;
    }

    public AuthorOeuvre getAuthorOeuvreSelected() {

        return (this.authorOeuvreSelected);
    }

    public void setAuthorOeuvre(AuthorOeuvre authorOeuvre) {
        this.authorOeuvreSelected = authorOeuvre;
    }

    public StreamedContent getProductFile() {

        return (this.productFile);
    }

    public void setProductFile(StreamedContent productFile) {
        this.productFile = productFile;
    }

    public List<AuthorOeuvre> getAuthorOeuvreFileList() {

        return (this.authorOeuvreFileList);
    }

    public void setAuthorOeuvreFileList(
            List<AuthorOeuvre> authorOeuvreFileList) {
        this.authorOeuvreFileList = authorOeuvreFileList;
    }

    public void onSelectedAuthorOeuvre(
            AuthorOeuvre authorOeuvreSelected) {
         RequestContext context = RequestContext.getCurrentInstance();
        if (authorOeuvreSelected != null) {
            this.setAuthorOeuvre(authorOeuvreSelected);
            this.getAuthorOeuvreFileList().clear();
            this.getAuthorOeuvreFileList().add(this.getAuthorOeuvreSelected());

            if (this.getAuthorOeuvreSelected().getRoute() != null) {
                InputStream inputStream;
                try {
                    File f = new File(this.getAuthorOeuvreSelected().getRoute());
//            File f = new File("/home/rebien/Documentos/JuridicApp/salida.pdf");
                    inputStream = new FileInputStream(f);
                    ExternalContext externalContext = FacesContext.getCurrentInstance()
                            .getExternalContext();

                    this.setProductFile(new DefaultStreamedContent(inputStream,
                            externalContext.getMimeType(f.getName()), f.getName()));
                     
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AuthorOeuvreFileBean.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
                this.selectedProduct = true;
            } else {
                this.selectedProduct = true;
            }
        } else {
            this.selectedProduct = false;
        }
        context.addCallbackParam(AuthorOeuvreFileBean.SELECTED_PRODUCT, this.selectedProduct);
    }

    @PostConstruct()
    private void createFields() {
        this.setAuthorOeuvreFileList(new ArrayList<AuthorOeuvre>());
    }
}
