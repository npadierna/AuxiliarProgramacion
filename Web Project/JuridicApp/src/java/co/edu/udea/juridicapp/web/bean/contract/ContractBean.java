package co.edu.udea.juridicapp.web.bean.contract;

import co.edu.udea.juridicapp.persistence.dao.IContractDAO;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvre;
import co.edu.udea.juridicapp.persistence.entity.Contract;
import java.io.Serializable;
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
public class ContractBean implements Serializable {

    private static final long serialVersionUID = 1332869958240524352L;
    @Autowired()
    private IContractDAO contractDAO;
    private AuthorOeuvre authorOeuvre;
    private Contract contract;

    public ContractBean() {
        super();
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

    public void onViewContractForAuthorOeuvre(AuthorOeuvre authorOeuvre) {
        this.setAuthorOeuvre(authorOeuvre);
        this.setContract(this.contractDAO.findContract(authorOeuvre
                .getAuthorOeuvrePK().getContract()));
    }

    @PostConstruct()
    private void createFields() {
    }
}