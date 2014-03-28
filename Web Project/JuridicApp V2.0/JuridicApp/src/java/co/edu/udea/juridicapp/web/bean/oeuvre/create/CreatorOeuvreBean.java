package co.edu.udea.juridicapp.web.bean.oeuvre.create;

import co.edu.udea.juridicapp.persistence.dao.IAuthorDAO;
import co.edu.udea.juridicapp.persistence.dao.IAuthorOeuvreDAO;
import co.edu.udea.juridicapp.persistence.dao.ICommentDAO;
import co.edu.udea.juridicapp.persistence.dao.IOeuvreDAO;
import co.edu.udea.juridicapp.persistence.dao.IOeuvreTypeDAO;
import co.edu.udea.juridicapp.persistence.entity.Author;
import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvre;
import co.edu.udea.juridicapp.persistence.entity.Comment;
import co.edu.udea.juridicapp.persistence.entity.CommentPK;
import co.edu.udea.juridicapp.persistence.entity.Contract;
import co.edu.udea.juridicapp.persistence.entity.Dependency;
import co.edu.udea.juridicapp.persistence.entity.Dnda;
import co.edu.udea.juridicapp.persistence.entity.PeoplePK;
import co.edu.udea.juridicapp.persistence.entity.Title;
import co.edu.udea.juridicapp.persistence.entity.Support;
import co.edu.udea.juridicapp.persistence.entity.Oeuvre;
import co.edu.udea.juridicapp.persistence.entity.OeuvreType;
import co.edu.udea.juridicapp.persistence.entity.OeuvreTypePK;
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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Part;
import org.primefaces.event.FileUploadEvent;
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
public final class CreatorOeuvreBean implements Serializable {

    private static final long serialVersionUID = 2901939557872617472L;
    @Autowired()
    private IAuthorDAO authorDAO;
    @Autowired()
    private IAuthorOeuvreDAO authorOeuvreDAO;
    @Autowired()
    private ICommentDAO commentDAO;
    @Autowired()
    private IOeuvreDAO oeuvreDAO;
    @Autowired()
    private IOeuvreTypeDAO oeuvreTypeDAO;
    private List<AuthorOeuvre> authorsOeuvres;
    private List<Author> foundAuthors;
    private List<Comment> comments;
    private String commentText;
    private String documentType;
    private String idNumber;
    private Oeuvre oeuvre;
    private Part file;

    public CreatorOeuvreBean() {
        super();
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

    public String getCommentText() {

        return (this.commentText);
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
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

    public Oeuvre getOeuvre() {

        return (this.oeuvre);
    }

    public void setOeuvre(Oeuvre oeuvre) {
        this.oeuvre = oeuvre;
    }

    public void addAuthor(Author author) {
        AuthorOeuvre authorOeuvre = new AuthorOeuvre(-1L, null,
                author.getPeoplePK().getDocumentType(),
                author.getPeoplePK().getIdNumber(), null);
        authorOeuvre.setAuthor(author);
        authorOeuvre.setContract1(new Contract());
        authorOeuvre.setDnda(new Dnda());
        authorOeuvre.setTitle(new Title());
        authorOeuvre.setSupportType(new Support());

        this.getAuthorsOeuvres().add(authorOeuvre);
        this.getFoundAuthors().remove(author);

        this.setIdNumber("");
    }

    public void addComment(ActionEvent actionEvent) {
        Comment c = new Comment();
        c.setDateTime(new Date());
        c.setText(this.getCommentText());

        this.getComments().add(c);

        this.setCommentText("");
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
                        "No se ha encontrado algún Author con los datos:\n\n"
                        + "Tipo De Documento: " + this.getDocumentType()
                        + "\nNúmero De Documento: " + this.getIdNumber());

                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }

    public void removeAuthorOeuvre(AuthorOeuvre author) {
        this.getAuthorsOeuvres().remove(author);
    }

    public void removeComment(Comment comment) {
        this.getComments().remove(comment);
    }

    public void saveAuthorsOeuvres(ActionEvent actionEvent) {
        if (this.getAuthorsOeuvres().isEmpty()) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "No Obras Creadas",
                    "No se ha creado ninguna Obra de ningún tipo asociada a algún Author.");

            FacesContext.getCurrentInstance().addMessage(null, msg);

            return;
        }

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

        for (AuthorOeuvre authorOeuvre : this.getAuthorsOeuvres()) {
            OeuvreTypePK oeuvreTypePK = new OeuvreTypePK(idOeuvre,
                    authorOeuvre.getAuthorOeuvrePK().getOeuvreTypeName());
            OeuvreType oeuvreType = new OeuvreType(oeuvreTypePK);

            if (this.oeuvreTypeDAO.findOeuvreType(oeuvreTypePK) == null) {
                this.oeuvreTypeDAO.saveOeuvreType(oeuvreType);
            }

            // TODO: Buscar el DNDA y el número del contrato.
//            if (this.dnd)
            if (authorOeuvre.getIsbn() != null) {
                authorOeuvre.setIsbn(authorOeuvre.getIsbn().trim());
                if (authorOeuvre.getIsbn().equals("")) {
                    authorOeuvre.setIsbn(null);
                }
            }

            authorOeuvre.getAuthorOeuvrePK().setOeuvreTypeId(idOeuvre);
            authorOeuvre.setOeuvreType(oeuvreType);

            this.authorOeuvreDAO.saveAuthorOeuvre(authorOeuvre);
        }
    }

    public void onHandleContractFileUpload(FileUploadEvent fileUploadEvent) {
        UploadedFile contractFile = fileUploadEvent.getFile();
        String name = contractFile.getFileName();
         System.out.println("ENTRO!!!!!");

        File targetFolder = new File("D:/tmp/"
                + this.getOeuvre().getTitle() + "/contracts");
        try {
            InputStream inputStream = fileUploadEvent.getFile().getInputstream();
            OutputStream outputStream = new FileOutputStream(new File(targetFolder,
                    fileUploadEvent.getFile().getFileName()));

            int read = 0;
            byte[] bytes = new byte[2048];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            inputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(CreatorOeuvreBean.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public void subir(ActionEvent actionEvent) throws IOException {
        FacesMessage m = null;
       
       /* if (this.file != null) {
            System.out.println("ENTRO!!!!!");
            UploadedFile contractFile = this.getFile();
            String name = contractFile.getFileName();

            File targetFolder = new File("D:/tmp/"
                    + this.getOeuvre().getTitle() + "/contracts");
            try {
                InputStream inputStream = this.file.getInputstream();
                OutputStream outputStream = new FileOutputStream(new File(targetFolder,
                        this.file.getFileName()));

                int read = 0;
                byte[] bytes = new byte[2048];
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }

                inputStream.close();
                outputStream.flush();
                outputStream.close();
               m = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Archivo Adjuntado",
                    "El archivo ha sido subido correctamente.");
            } catch (IOException ex) {
                Logger.getLogger(CreatorOeuvreBean.class.getName()).log(
                        Level.SEVERE, null, ex);
              m =  new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Error Al Subir.",
                    "Ha ocurrido un error inesperado, comuniquese con soporte.");
            }
        }else{
            m = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Ningun Archivo",
                    "No sé ha subido ningún archivo.");
        }
          FacesContext.getCurrentInstance().addMessage(null, m);*/
        if( this.file != null){
        System.out.println("ENTRO!!!");
        InputStream inputStream = file.getInputStream();          
        FileOutputStream outputStream = new FileOutputStream(getFilename(file));  
          
        byte[] buffer = new byte[4096];          
        int bytesRead = 0;  
        while(true) {                          
            bytesRead = inputStream.read(buffer);  
            if(bytesRead > 0) {  
                outputStream.write(buffer, 0, bytesRead);  
            }else {  
                break;  
            }                         
        }
        outputStream.close();  
        inputStream.close();  
         

        }else{

        }
    }
    
    private static String getFilename(Part part) {  
        for (String cd : part.getHeader("content-disposition").split(";")) {  
            if (cd.trim().startsWith("filename")) {  
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");  
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.  
            }  
        }  
        return null;  
    }  

    @PostConstruct()
    private void createFields() {
        this.setAuthorsOeuvres(new ArrayList<AuthorOeuvre>());
        this.setComments(new ArrayList<Comment>());
        this.setFoundAuthors(new ArrayList<Author>());
        this.setOeuvre(new Oeuvre());
        this.getOeuvre().setDependency(new Dependency());
    }
}
