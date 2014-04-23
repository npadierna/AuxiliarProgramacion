package co.edu.udea.obras.web.bean.authoroeuvre.update;

import co.edu.udea.obras.persistence.dao.IAuthorDAO;
import co.edu.udea.obras.persistence.dao.IAuthorOeuvreDAO;
import co.edu.udea.obras.persistence.dao.ICommentDAO;
import co.edu.udea.obras.persistence.dao.IContractDAO;
import co.edu.udea.obras.persistence.dao.IDndaDAO;
import co.edu.udea.obras.persistence.dao.IOeuvreDAO;
import co.edu.udea.obras.persistence.dao.IOeuvreTypeDAO;
import co.edu.udea.obras.persistence.entity.Author;
import co.edu.udea.obras.persistence.entity.AuthorOeuvre;
import co.edu.udea.obras.persistence.entity.Comment;
import co.edu.udea.obras.persistence.entity.CommentPK;
import co.edu.udea.obras.persistence.entity.Contract;
import co.edu.udea.obras.persistence.entity.Dependency;
import co.edu.udea.obras.persistence.entity.Oeuvre;
import co.edu.udea.obras.persistence.entity.OeuvreType;
import co.edu.udea.obras.persistence.entity.OeuvreTypePK;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;
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
public final class AuthorOeuvreUpdateBean implements Serializable {

    private static final long serialVersionUID = 4901939557872617472L;
    private static final String ON_EDIT = "onEdit";
    private static final String ON_UPDATE = "onUpdate";
    public static final String FORMAT_FOR_DATE = "yyyy-MM-dd hh:mm aaa";
    @Autowired()
    private IAuthorDAO authorDAO;
    @Autowired()
    private IAuthorOeuvreDAO authorOeuvreDAO;
    @Autowired()
    private IDndaDAO dndaDAO;
    @Autowired()
    private ICommentDAO commentDAO;
    @Autowired()
    private IOeuvreDAO oeuvreDAO;
    @Autowired()
    private IContractDAO contractDAO;
    @Autowired()
    private IOeuvreTypeDAO oeuvreTypeDAO;
    private List<AuthorOeuvre> authorsOeuvres;
    private List<Author> foundAuthors;
    private List<Comment> oeuvreComments;
    private List<Comment> oeuvreDeleteComments;
    private List<Contract> contracts;
    private List<String> contractsNumbersList;
    private AuthorOeuvre selectedAuthorOeuvre;
    private Oeuvre oeuvre;
    private DateFormat dateFormat;
    private String commentText;
    private String contractNumber;
    private String dndaNumber;
    private String documentType;
    private String idNumber;
    private UploadedFile contractUploadedFile;
    private Date beginningDate;
    private Date deliveringDate;
    private boolean onEdit;
    private boolean onUpdate;

    public AuthorOeuvreUpdateBean() {
        super();
        this.onEdit = false;
        this.onUpdate = false;
    }

    public IDndaDAO getDndaDAO() {
        return dndaDAO;
    }

    public void setDndaDAO(IDndaDAO dndaDAO) {
        this.dndaDAO = dndaDAO;
    }

    public List<AuthorOeuvre> getAuthorsOeuvres() {
        return authorsOeuvres;
    }

    public void setAuthorsOeuvres(List<AuthorOeuvre> authorsOeuvres) {
        this.authorsOeuvres = authorsOeuvres;
    }

    public List<Author> getFoundAuthors() {
        return foundAuthors;
    }

    public void setFoundAuthors(List<Author> foundAuthors) {
        this.foundAuthors = foundAuthors;
    }

    public List<Comment> getOeuvreComments() {
        return oeuvreComments;
    }

    public void setOeuvreComments(List<Comment> oeuvreComments) {
        this.oeuvreComments = oeuvreComments;
    }

    public List<Comment> getOeuvreDeleteComments() {
        return oeuvreDeleteComments;
    }

    public void setOeuvreDeleteComments(List<Comment> oeuvreDeleteComments) {
        this.oeuvreDeleteComments = oeuvreDeleteComments;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public List<String> getContractsNumbersList() {
        return contractsNumbersList;
    }

    public void setContractsNumbersList(List<String> contractsNumbersList) {
        this.contractsNumbersList = contractsNumbersList;
    }

    public Oeuvre getOeuvre() {
        return oeuvre;
    }

    public void setOeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getDndaNumber() {
        return dndaNumber;
    }

    public void setDndaNumber(String dndaNumber) {
        this.dndaNumber = dndaNumber;
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

    public UploadedFile getContractUploadedFile() {
        return contractUploadedFile;
    }

    public void setContractUploadedFile(UploadedFile contractUploadedFile) {
        this.contractUploadedFile = contractUploadedFile;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Date getDeliveringDate() {
        return deliveringDate;
    }

    public void setDeliveringDate(Date deliveringDate) {
        this.deliveringDate = deliveringDate;

    }

    public AuthorOeuvre getSelectedAuthorOeuvre() {
        return selectedAuthorOeuvre;
    }

    public void setSelectedAuthorOeuvre(AuthorOeuvre selectedAuthorOeuvre) {
        this.selectedAuthorOeuvre = selectedAuthorOeuvre;
    }

    public void addComment(ActionEvent actionEvent) {
        Comment c = new Comment();
        c.setDateTime(new Date());
        c.setText(this.getCommentText().trim());

        this.getOeuvreComments().add(c);

        this.setCommentText("");
    }

    public void removeComment(Comment comment) {
        System.out.println(comment.getText());
        this.getOeuvreDeleteComments().add(comment);
        this.getOeuvreComments().remove(comment);
    }

    public void onEditAuthorOeuvre(AuthorOeuvre selectedAuthorOeuvre) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;

        if (selectedAuthorOeuvre != null) {
            this.setSelectedAuthorOeuvre(selectedAuthorOeuvre);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cargando...",
                    selectedAuthorOeuvre.getAuthorOeuvrePK()
                    .getOeuvreTypeName());
            this.onEdit = true;
            this.setOeuvre(this.getSelectedAuthorOeuvre().getOeuvreType().getOeuvre());
            this.findAuthorsOeuvres();
            this.findOeuvreComments();
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Datos Inválidos",
                    "Por favor seleccione una Obra válida.");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
        context.addCallbackParam(AuthorOeuvreUpdateBean.ON_EDIT,
                this.onEdit);
    }

    private void findAuthorsOeuvres() {
        this.setAuthorsOeuvres(this.authorOeuvreDAO.findAuthorsOeuvresByOeuvreId(
                this.getSelectedAuthorOeuvre().getAuthorOeuvrePK()
                .getOeuvreTypeId()));
    }

    private void findOeuvreComments() {
        this.setOeuvreComments(this.commentDAO.findCommnetsByOeuvreId(
                this.getSelectedAuthorOeuvre().getAuthorOeuvrePK()
                .getOeuvreTypeId()));
    }

    public String applyFormatForDate(Date date) {

        return (this.dateFormat.format(date));
    }

    public void updateAuthorsOeuvres(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage m = null;
        if (this.getAuthorsOeuvres().isEmpty()) {
            m = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "No hay Obras Creadas",
                    "No se ha creado ninguna Obra de ningún tipo asociada a algún Author.");

            FacesContext.getCurrentInstance().addMessage(null, m);

            return;
        }
        m = new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Actualizando la Obra",
                "Este proceso puede tardar un momento...");
        this.setOeuvre(this.getSelectedAuthorOeuvre().getOeuvreType().getOeuvre());

        Long idOeuvre = this.oeuvreDAO.updateOeuvre(this.getOeuvre()).getId();

        for (Comment c : this.getOeuvreComments()) {
            CommentPK commentPK = new CommentPK();
            commentPK.setOeuvreId(idOeuvre);
            c.setCommentPK(commentPK);

            this.commentDAO.saveComment(c);
        }

        if (this.getOeuvreDeleteComments() != null) {
            System.out.println("Borrando Comentarios...");
            for (Comment c : this.getOeuvreDeleteComments()) {
                this.commentDAO.deleteComment(c);
            }
            System.out.println("Comentarios Borrados...");
        }

        for (Contract c : this.getContracts()) {
            if (c.getDnda() != null) {
                this.dndaDAO.updateDnda(c.getDnda());
            }

            if ((c.getContractFile() == null)
                    || (c.getContractFile().getFileName().equals(""))) {
                c.setRoute(null);
            } else {
                c.setRoute(c.getContractFile().getFileName());
            }
            this.contractDAO.updateContract(c);
        }

        for (AuthorOeuvre authorOeuvre : this.getAuthorsOeuvres()) {
            OeuvreTypePK oeuvreTypePK = new OeuvreTypePK(idOeuvre,
                    authorOeuvre.getAuthorOeuvrePK().getOeuvreTypeName());
            OeuvreType oeuvreType = new OeuvreType(oeuvreTypePK);

            if (this.oeuvreTypeDAO.findOeuvreType(oeuvreTypePK) == null) {
                this.oeuvreTypeDAO.updateOeuvreType(oeuvreType);
            }

            // TODO: Buscar el D.N.D.A. y el número del contrato.
//            if (this.dnd)
            if (authorOeuvre.getIsbn() != null) {
                authorOeuvre.setIsbn(authorOeuvre.getIsbn().trim());
                if (authorOeuvre.getIsbn().equals("")) {
                    authorOeuvre.setIsbn(null);
                }
            }
           

            /*authorOeuvre.getAuthorOeuvrePK().setOeuvreTypeId(idOeuvre);
             authorOeuvre.setOeuvreType(oeuvreType);
             authorOeuvre.setRoute(authorOeuvre.getProductFile().getFileName());
             authorOeuvre.setAcquisition1(new Acquisition(
             authorOeuvre.getAuthorOeuvrePK().getAcquisition()));
             authorOeuvre.setContract1(new Contract(
             authorOeuvre.getAuthorOeuvrePK().getContract()));

             this.authorOeuvreDAO.updateAuthorOeuvre(authorOeuvre);*/
        }
         this.onUpdate = true;
            FacesContext.getCurrentInstance().addMessage(null, m);
            context.addCallbackParam(AuthorOeuvreUpdateBean.ON_UPDATE,
                    this.onUpdate);
    }

    @PostConstruct()
    private void createFields() {
        this.setAuthorsOeuvres(new ArrayList<AuthorOeuvre>());
        this.setOeuvreComments(new ArrayList<Comment>());
        this.setOeuvreDeleteComments(new ArrayList<Comment>());
        this.setContracts(new ArrayList<Contract>());
        this.setContractsNumbersList(new ArrayList<String>());
        this.setContractUploadedFile(null);
        this.setFoundAuthors(new ArrayList<Author>());
        this.setOeuvre(new Oeuvre());
        this.getOeuvre().setDependency(new Dependency());
    }
}
