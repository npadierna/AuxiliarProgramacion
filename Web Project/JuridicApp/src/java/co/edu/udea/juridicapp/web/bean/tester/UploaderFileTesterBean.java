package co.edu.udea.juridicapp.web.bean.tester;

import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope(value = "session")
@SessionScoped()
public class UploaderFileTesterBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private UploadedFile uploadedFile;

    public UploaderFileTesterBean() {
        super();
    }

    public UploadedFile getUploadedFile() {

        return (this.uploadedFile);
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public void onHandleUploadFile() {
        String fileName = this.getUploadedFile().getFileName();
    }

    public void onHandleUploadFile(FileUploadEvent fileUploadEvent) {
        UploadedFile file = fileUploadEvent.getFile();
        String fileName = file.getFileName();
    }
}