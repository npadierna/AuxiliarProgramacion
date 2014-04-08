package co.edu.udea.juridicapp.web.bean.client.update;

import co.edu.udea.juridicapp.persistence.dao.IClientDAO;
import co.edu.udea.juridicapp.persistence.dao.IPeopleDAO;
import co.edu.udea.juridicapp.persistence.entity.Client;
import co.edu.udea.juridicapp.persistence.entity.People;
import co.edu.udea.juridicapp.persistence.entity.PeoplePK;
import co.edu.udea.juridicapp.persistence.entity.enums.DocumentTypeClientEnum;
import co.edu.udea.juridicapp.service.mail.MailSender;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
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
public class RecoverClientPasswordBean implements Serializable {

    private static final long serialVersionUID = 3717147504987197440L;
     private static final String SENT = "sent";
    @Autowired()
    private IPeopleDAO peopleDAO;
    @Autowired()
    private IClientDAO ClientDAO;
    private List<String> documentsType;
    private People people;
    private String documentType;
    private String idNumber;
    private String email;
    private Client client;
    private MailSender mailSender;
    private boolean sent;

    public RecoverClientPasswordBean() {
        super();
        this.sent = false;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void recoverPassword(ActionEvent actionEvent) {
         RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        if (this.email != null && this.idNumber != null) {
            this.client.setPeoplePK(new PeoplePK(this.documentType,
                    this.idNumber.trim()));
            this.people.setPeoplePK(new PeoplePK(this.documentType,
                    this.idNumber.trim()));
            People p = this.peopleDAO.findPeople(new PeoplePK(this.documentType,
                    this.idNumber.trim()));
            Client c = this.ClientDAO.findClient(new PeoplePK(this.documentType,
                    this.idNumber.trim()));
            if (p != null && c != null) {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Enviando Correo Electrónico",
                        "Se está enviando un correo electrónico con su contraseña");
                this.sent = true;
                this.send(this.email,c.getPassword( ));
            } else {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Campos Inválidos",
                        "El Cliente no existe");
            }
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Campos Inválidos",
                    "Los campos ingresados no son válidos.");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam(RecoverClientPasswordBean.SENT, this.sent);
        this.setEmail("");
        this.setIdNumber("");
    }
    
    public void send( String email, String password) {
        this.mailSender = new MailSender("miguelcold8@gmail.com","coldlomejor",
        email,"Obras Recuperación de Contraseña", "Su contraseña es: " + password);
    }
    
    @PostConstruct()
    private void createFields() {
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);

        this.setPeople(new People());
        this.setClient(new Client());

        this.documentsType = DocumentTypeClientEnum.obtainDocumentsTypeList();
    }
}
