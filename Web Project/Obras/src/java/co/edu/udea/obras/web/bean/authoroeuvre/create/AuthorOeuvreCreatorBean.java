package co.edu.udea.obras.web.bean.authoroeuvre.create;

import co.edu.udea.obras.persistence.dao.IAuthorDAO;
import co.edu.udea.obras.persistence.dao.IAuthorOeuvreDAO;
import co.edu.udea.obras.persistence.dao.ICommentDAO;
import co.edu.udea.obras.persistence.dao.IContractDAO;
import co.edu.udea.obras.persistence.dao.IDndaDAO;
import co.edu.udea.obras.persistence.dao.IOeuvreDAO;
import co.edu.udea.obras.persistence.dao.IOeuvreTypeDAO;
import co.edu.udea.obras.persistence.entity.Acquisition;
import co.edu.udea.obras.persistence.entity.Author;
import co.edu.udea.obras.persistence.entity.AuthorOeuvre;
import co.edu.udea.obras.persistence.entity.Comment;
import co.edu.udea.obras.persistence.entity.CommentPK;
import co.edu.udea.obras.persistence.entity.Contract;
import co.edu.udea.obras.persistence.entity.Dependency;
import co.edu.udea.obras.persistence.entity.Dnda;
import co.edu.udea.obras.persistence.entity.PeoplePK;
import co.edu.udea.obras.persistence.entity.Title;
import co.edu.udea.obras.persistence.entity.Support;
import co.edu.udea.obras.persistence.entity.Oeuvre;
import co.edu.udea.obras.persistence.entity.OeuvreType;
import co.edu.udea.obras.persistence.entity.OeuvreTypePK;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultUploadedFile;
import org.primefaces.model.UploadedFile;
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
public final class AuthorOeuvreCreatorBean implements Serializable {

    private static final long serialVersionUID = 2901939557872617472L;
    private static final String ON_CREATED = "onCreated";
    @Autowired()
    private IAuthorDAO authorDAO;
    @Autowired()
    private IAuthorOeuvreDAO authorOeuvreDAO;
    @Autowired()
    private ICommentDAO commentDAO;
    @Autowired()
    private IContractDAO contractDAO;
    @Autowired()
    private IDndaDAO dndaDAO;
    @Autowired()
    private IOeuvreDAO oeuvreDAO;
    @Autowired()
    private IOeuvreTypeDAO oeuvreTypeDAO;
    private List<AuthorOeuvre> authorsOeuvres;
    private List<Author> foundAuthors;
    private List<Comment> comments;
    private List<Contract> contracts;
    private List<String> contractsNumbersList;
    private Oeuvre oeuvre;
    private String commentText;
    private String contractNumber;
    private String dndaNumber;
    private String documentType;
    private String idNumber;
    private UploadedFile uploadedFile;
    private Date beginningDate;
    private Date deliveringDate;
    private boolean onCreated;

    public AuthorOeuvreCreatorBean() {
        super();
        this.onCreated = false;
    }

    public List<AuthorOeuvre> getAuthorsOeuvres() {

        return (this.authorsOeuvres);
    }

    public void setAuthorsOeuvres(List<AuthorOeuvre> authorsOeuvres) {
        this.authorsOeuvres = authorsOeuvres;
    }

    public List<Author> getFoundAuthors() {

        return (this.foundAuthors);
    }

    public void setFoundAuthors(List<Author> foundAuthors) {
        this.foundAuthors = foundAuthors;
    }

    public List<Comment> getComments() {

        return (this.comments);
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Contract> getContracts() {

        return (this.contracts);
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public List<String> getContractsNumbersList() {

        return (this.contractsNumbersList);
    }

    public void setContractsNumbersList(List<String> contractsNumbersList) {
        this.contractsNumbersList = contractsNumbersList;
    }

    public Oeuvre getOeuvre() {

        return (this.oeuvre);
    }

    public void setOeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
    }

    public String getCommentText() {

        return (this.commentText);
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getContractNumber() {

        return (this.contractNumber);
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getDndaNumber() {

        return (this.dndaNumber);
    }

    public void setDndaNumber(String dndaNumber) {
        this.dndaNumber = dndaNumber;
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

    public UploadedFile getUploadedFile() {

        return (this.uploadedFile);
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public Date getBeginningDate() {

        return (this.beginningDate);
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Date getDeliveringDate() {

        return (this.deliveringDate);
    }

    public void setDeliveringDate(Date deliveringDate) {
        this.deliveringDate = deliveringDate;
    }

    public void addAuthor(Author author) {
        AuthorOeuvre authorOeuvre = new AuthorOeuvre();
        authorOeuvre.setAuthor(author);
        authorOeuvre.setAuthor(author);
        authorOeuvre.setAcquisition(new Acquisition());
        authorOeuvre.setContract(new Contract());
        authorOeuvre.setDnda(null);
        authorOeuvre.setProductFile(new DefaultUploadedFile());
        authorOeuvre.setTitle(new Title());
        authorOeuvre.setSupportType(new Support());

        this.getAuthorsOeuvres().add(authorOeuvre);
        this.getFoundAuthors().remove(author);

        this.setIdNumber("");
    }

    public void addComment(ActionEvent actionEvent) {
        this.setCommentText(this.getCommentText().trim());
        if (!this.getCommentText().equals("")) {
            Comment c = new Comment();
            c.setDateTime(new Date());
            c.setText(this.getCommentText());

            this.getComments().add(c);

            this.setCommentText("");
        }
    }

    public void addContract(ActionEvent actionEvent) {
        FacesMessage msg;

        this.setContractNumber(this.getContractNumber().trim());
        this.setDndaNumber(this.getDndaNumber().trim());

        if (this.getContractNumber().equals("")) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Campos Vacíos",
                    "El campos de Número de Contrato no puede estar vacío.");

            FacesContext.getCurrentInstance().addMessage(null, msg);

            return;
        }

        Contract contract = this.contractDAO.findContract(
                this.getContractNumber());
        if (contract != null) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Contrato Existente",
                    "El Contrato con número: " + this.getContractNumber()
                    + ", ya existe dentro del Sistema.");

            FacesContext.getCurrentInstance().addMessage(null, msg);
            this.setContractNumber("");
            this.setDndaNumber("");

            return;
        }

        Dnda dnda = this.dndaDAO.findDnda(this.getDndaNumber());
        if (dnda != null) {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "D.N.D.A. Existente", "El número de D.N.D.A.: "
                    + this.getDndaNumber() + ", ya existe dentro del Sistema.");

            FacesContext.getCurrentInstance().addMessage(null, msg);
            this.setContractNumber("");
            this.setDndaNumber("");

            return;
        }

        if (!this.getDndaNumber().equals("")) {
            dnda = new Dnda(this.getDndaNumber());
        }

        contract = new Contract(this.getContractNumber());
        contract.setContractFile(this.getUploadedFile());
        contract.setDnda(dnda);
        contract.setBeginning(this.getBeginningDate());
        contract.setDelivering(this.getDeliveringDate());

        if (!this.findContractInContractList(contract)) {
            this.getContracts().add(contract);
            this.getContractsNumbersList().add(contract.getId());
            this.setContractNumber("");
            this.setDndaNumber("");
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Datos Repetidos",
                    "Alguno de los datos ingresados ya corresponden a un registro de la tabla inferior.");

            FacesContext.getCurrentInstance().addMessage(null, msg);
            this.setContractNumber("");
            this.setDndaNumber("");
        }
    }

    public void findAuthor(ActionEvent actionEvent) {
        if ((this.getDocumentType() != null) && (this.getIdNumber() != null)) {
            this.getFoundAuthors().clear();

            Author a = this.authorDAO.findAuthor(
                    new PeoplePK(this.getDocumentType(), this.getIdNumber()));
            if (a != null) {
                this.getFoundAuthors().add(a);
            } else {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Autor No Existente",
                        "No se ha encontrado algún Autor con los datos:\n\n"
                        + "Tipo de Documento: " + this.getDocumentType()
                        + "\nNúmero de Documento: " + this.getIdNumber());

                FacesContext.getCurrentInstance().addMessage(null, msg);
                this.setIdNumber("");
            }
        }
    }

    private boolean findContractInContractList(Contract contract) {
        for (Contract c : this.getContracts()) {
            if (c.getId().equals(contract.getId())) {

                return (true);
            }

            if ((c.getDnda() != null) && (contract.getDnda() != null)) {
                if (c.getDnda().getNumber().equals(contract.getDnda()
                        .getNumber())) {

                    return (true);
                }
            }
        }

        return (false);
    }

    public void removeAuthorOeuvre(AuthorOeuvre author) {
        this.getAuthorsOeuvres().remove(author);
    }

    public void removeComment(Comment comment) {
        this.getComments().remove(comment);
    }

    public void removeContract(Contract contract) {
        this.getContracts().remove(contract);
        this.getContractsNumbersList().remove(contract.getId());
    }

    public void saveAuthorsOeuvres(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage m;

        if (this.getAuthorsOeuvres().isEmpty()) {
            m = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "No hay Obras Creadas",
                    "No se ha creado ninguna Obra de ningún tipo asociada a algún Author.");

            FacesContext.getCurrentInstance().addMessage(null, m);

            return;
        }

        m = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Creando la Obra", "Este proceso puede tardar un momento...");
        this.getOeuvre().setDescription(this.getOeuvre().getDescription().trim());
        if (this.getOeuvre().getDescription().equals("")) {
            this.getOeuvre().setDescription(null);
        }

        Long idOeuvre = this.oeuvreDAO.saveOeuvre(this.getOeuvre());

        for (Comment c : this.getComments()) {
            CommentPK commentPK = new CommentPK();
            commentPK.setOeuvreId(idOeuvre);
            c.setCommentPK(commentPK);

            this.commentDAO.saveComment(c);
        }

        for (Contract c : this.getContracts()) {
            if (c.getDnda() != null) {
                this.dndaDAO.saveDnda(c.getDnda());
            }

            if ((c.getContractFile() == null)
                    || (c.getContractFile().getFileName().equals(""))) {
                c.setRoute(null);
            } else {
                c.setRoute(c.getContractFile().getFileName());
            }
            c.setBeginning(this.getBeginningDate());
            c.setDelivering(this.getDeliveringDate());
            this.contractDAO.saveContract(c);

            this.saveFileUpload(c.getContractFile(), true);
        }

        for (AuthorOeuvre authorOeuvre : this.getAuthorsOeuvres()) {
            OeuvreTypePK oeuvreTypePK = new OeuvreTypePK(idOeuvre,
                    authorOeuvre.getOeuvreType().getType().getName());
            OeuvreType oeuvreType = new OeuvreType(oeuvreTypePK);

            if (this.oeuvreTypeDAO.findOeuvreType(oeuvreTypePK) == null) {
                this.oeuvreTypeDAO.saveOeuvreType(oeuvreType);
            }

            if (authorOeuvre.getDndaNumber() != null) {
                authorOeuvre.setDndaNumber(authorOeuvre.getDndaNumber().trim());

                if (!authorOeuvre.getDndaNumber().equals("")) {
                    Dnda dnda = new Dnda(authorOeuvre.getDndaNumber());

                    authorOeuvre.setDnda(dnda);
                    this.dndaDAO.saveDnda(dnda);
                }
            }

            if (authorOeuvre.getIsbn() != null) {
                authorOeuvre.setIsbn(authorOeuvre.getIsbn().trim());
                if (authorOeuvre.getIsbn().equals("")) {
                    authorOeuvre.setIsbn(null);
                }
            }

//            authorOeuvre.getAuthorOeuvrePK().setOeuvreTypeId(idOeuvre);
            authorOeuvre.setOeuvreType(oeuvreType);
//            authorOeuvre.setAcquisition(new Acquisition(
//                    authorOeuvre.getAuthorOeuvrePK().getAcquisition()));
//            authorOeuvre.setContract(new Contract(
//                    authorOeuvre.getAuthorOeuvrePK().getContract()));

            this.authorOeuvreDAO.saveAuthorOeuvre(authorOeuvre);

            this.saveFileUpload(authorOeuvre.getProductFile(), false);
        }
        this.onCreated = true;

        FacesContext.getCurrentInstance().addMessage(null, m);
        context.addCallbackParam(AuthorOeuvreCreatorBean.ON_CREATED,
                this.onCreated);
    }

    public void addProductFileToOeuvre(AuthorOeuvre authorOeuvre) {
        authorOeuvre.setProductFile(this.getUploadedFile());
        authorOeuvre.setRoute(authorOeuvre.getProductFile().getFileName());
    }

    private void saveFileUpload(UploadedFile uploadedFile,
            boolean isContract) {
        ExternalContext externalContext = FacesContext.getCurrentInstance()
                .getExternalContext();
        String directory = externalContext.getInitParameter("directory");

        File targetFolder;
        if (isContract) {
            targetFolder = new File(directory.concat(this.getOeuvre().getId()
                    .toString()).concat(File.separator).concat("contracts"));
        } else {
            targetFolder = new File(directory.concat(this.getOeuvre().getId()
                    .toString()).concat(File.separator).concat("products"));
        }

        targetFolder.mkdirs();
        try {
            InputStream inputStream = uploadedFile.getInputstream();
            OutputStream outputStream = new FileOutputStream(new File(targetFolder,
                    uploadedFile.getFileName()));

            int read = 0;
            byte[] bytes = new byte[2048];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            inputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(AuthorOeuvreCreatorBean.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    @PostConstruct()
    private void createFields() {
        this.setAuthorsOeuvres(new ArrayList<AuthorOeuvre>());
        this.setComments(new ArrayList<Comment>());
        this.setContracts(new ArrayList<Contract>());
        this.setContractsNumbersList(new ArrayList<String>());
        this.setUploadedFile(null);
        this.setFoundAuthors(new ArrayList<Author>());
        this.setOeuvre(new Oeuvre());
        this.getOeuvre().setDependency(new Dependency());
        this.setBeginningDate(new Date());
        this.setDeliveringDate(new Date());
    }
}