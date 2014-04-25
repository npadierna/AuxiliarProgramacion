package co.edu.udea.obras.web.bean.contract;

import co.edu.udea.obras.persistence.dao.IContractDAO;
import co.edu.udea.obras.persistence.entity.AuthorOeuvre;
import co.edu.udea.obras.persistence.entity.Contract;
import co.edu.udea.obras.web.bean.product.AuthorOeuvreFileBean;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
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
public final class ContractBean implements Serializable {

    private static final long serialVersionUID = 1332869958240524352L;
    private static final String SELECTED_CONTRACT = "selectedContract";
    @Autowired()
    private IContractDAO contractDAO;
    private AuthorOeuvre authorOeuvre;
    private Contract contract;
    private StreamedContent contractFile;
    private boolean selectedContract;

    public ContractBean() {
        super();

        this.selectedContract = false;
    }

    public AuthorOeuvre getAuthorOeuvre() {

        return (this.authorOeuvre);
    }

    public void setAuthorOeuvre(AuthorOeuvre authorOeuvre) {
        this.authorOeuvre = authorOeuvre;
    }

    public Contract getContract() {

        return (this.contract);
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public StreamedContent getContractFile() {

        return (this.contractFile);
    }

    public void setContractFile(StreamedContent contractFile) {
        this.contractFile = contractFile;
    }

    public void onViewContractForAuthorOeuvre(AuthorOeuvre authorOeuvre) {
        RequestContext context = RequestContext.getCurrentInstance();

        if (authorOeuvre != null) {
            this.setAuthorOeuvre(authorOeuvre);
            this.setContract(this.contractDAO.findContract(authorOeuvre
                    .getAuthorOeuvrePK().getContract()));

            if (this.getContract().getRoute() != null) {
                InputStream inputStream;
                try {
                    File f = new File("/home/rebien/Documentos/Obras/"
                            .concat(Long.toString(authorOeuvre.getOeuvreType()
                            .getOeuvre().getId())).concat("/contracts/").
                            concat(this.getContract().getRoute()));
                    inputStream = new FileInputStream(f);
                    ExternalContext externalContext = FacesContext.getCurrentInstance()
                            .getExternalContext();

                    this.setContractFile(new DefaultStreamedContent(inputStream,
                            externalContext.getMimeType(f.getName()), f.getName()));
                    this.selectedContract = true;
                } catch (IOException ex) {
                    Logger.getLogger(AuthorOeuvreFileBean.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            } else {
                this.selectedContract = true;
            }
        } else {
            this.selectedContract = false;
        }
        context.addCallbackParam(ContractBean.SELECTED_CONTRACT, this.selectedContract);
    }

    @PostConstruct()
    private void createFields() {
    }
}