package co.edu.udea.obras.web.bean.tester;

import co.edu.udea.obras.persistence.dao.IContractDAO;
import co.edu.udea.obras.persistence.dao.IDndaDAO;
import co.edu.udea.obras.persistence.entity.Contract;
import co.edu.udea.obras.persistence.entity.Dnda;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope(value = "session")
@SessionScoped()
public class ContractUploaderBean implements Serializable {

    @Autowired()
    private IContractDAO contractDAO;
    @Autowired()
    private IDndaDAO dndaDAO;
    private Contract contract;
    private List<Contract> contracts;

    public ContractUploaderBean() {
        super();
    }

    public Contract getContract() {

        return (this.contract);
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public List<Contract> getContracts() {

        return (this.contracts);
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public void addContract(ActionEvent actionEvent) {
        FacesMessage msg;

        if (this.getContract().getKey().equals("") || this.getContract().getKey() == null) {
            
            return;
        }
        
        if (this.contractDAO.findContract(this.getContract().getKey()) != null) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Contrato Existente",
                    "Los datos diligenciados pertenecen a algún contrato ya existente.");
        } else {
            // Invocación al método para subir el Contrato a una carpeta temporal.

            Dnda dnda = this.getContract().getDnda();
            dnda.setNumber(dnda.getNumber().trim());
            if (dnda.getNumber().equals("")) {
                this.getContract().setDnda(null);
            } else {
                if (this.dndaDAO.findDnda(dnda.getKey()) != null) {
                    msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "D.N.D.A. Existente",
                            "El número de D.N.D.A. ya está asignado, por favor verifique.");

                    FacesContext.getCurrentInstance().addMessage(null, msg);
                    this.getContract().getDnda().setNumber("");

                    return;
                } else {
                    this.dndaDAO.saveDnda(dnda);
                }
            }

            this.contractDAO.saveContract(this.getContract());
            this.getContracts().add(this.getContract());

            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Guardado Exitoso",
                    "El Contrato ha sido guardado exitosamente.");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        this.setContract(new Contract());
        this.getContract().setDnda(new Dnda());
    }

    public void deleteContract(Contract c) {
        // Invocación al método para eliminar el Contrato de la carpeta temporal.

        this.contractDAO.deleteContract(c);
        this.dndaDAO.deleteDnda(c.getDnda());
        this.getContracts().remove(c);
    }

    @PostConstruct()
    private void createFields() {
        this.setContract(new Contract());
        this.getContract().setDnda(new Dnda());
        this.setContracts(new ArrayList<Contract>());
    }
}