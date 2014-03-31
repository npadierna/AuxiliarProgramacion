package co.edu.udea.juridicapp.web.bean.client.delete;

import co.edu.udea.juridicapp.persistence.dao.IPeopleDAO;
import co.edu.udea.juridicapp.persistence.entity.Client;
import co.edu.udea.juridicapp.persistence.entity.People;
import co.edu.udea.juridicapp.persistence.entity.PeoplePK;
import co.edu.udea.juridicapp.persistence.entity.enums.DocumentTypeClientEnum;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
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
public class DeleteClientBean implements Serializable{
    
    private static final long serialVersionUID = 3157147504987197440L;
    @Autowired()
    private IPeopleDAO peopleDAO;
    private List<String> documentsType;
    private People people;
    private String documentType;
    private String idNumber;
    private Client client;

    public DeleteClientBean() {
        super();
    }

    public List<String> getDocumentsType() {
        return documentsType;
    }

    public void setDocumentsType(List<String> documentsType) {
        this.documentsType = documentsType;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public void findClient(ActionEvent actionEvent){
         FacesMessage m = null;
        if ((this.getDocumentType() != null) && (this.getIdNumber() != null)) {
            People p = this.peopleDAO.findPeople(
                    new PeoplePK(this.getDocumentType(), this.getIdNumber( )));
            
            if( p != null){
                  m = new FacesMessage(FacesMessage.SEVERITY_INFO, 
                        "Buscando Cliente","Esto puede tardar un momento...");
                this.setPeople( p);
                this.setClient(p.getClient( ));
            }else{
                m = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                        "Cliente No Existe","No se ha encontrado algún Cliente "
                                + "con : \n\n"
                                + "Tipo De Documento: " + this.getDocumentType( )
                                + "\nNúmero De Documento: " + this.getIdNumber( ));
            }
        }else{
              m = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                        "Datos Inválidos","Los datos ingresados no son válidos");
        }
         FacesContext.getCurrentInstance().addMessage(null, m);
    }
    
    public void deleteClient(ActionEvent actionEvent){
       System.out.println("ELIMINANDO...."); 
    }
    
    
    @PostConstruct()
    private void createFields() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);

        this.setPeople(new People());
        this.setClient(new Client());

        this.documentsType = DocumentTypeClientEnum.obtainDocumentsTypeList();
    }
}