package co.edu.udea.juridicapp.web.bean.tester;

import co.edu.udea.juridicapp.persistence.entity.AuthorOeuvre;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void onHandleUploadFileEvent(AuthorOeuvre authorOeuvre) {
        try {
            this.saveFileIntoDisc(authorOeuvre.getContract1().getContractFile());
        } catch (IOException ex) {
            Logger.getLogger(UploaderFileTesterBean.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

//    public void onHandleUploadFileEvent() {
//        if (this.getUploadedFile() != null) {
//            try {
//                this.saveFileIntoDisc(this.getUploadedFile());
//            } catch (IOException e) {
//            }
//        }
//    }

//    public void onHandleUploadFileEvent(FileUploadEvent fileUploadEvent) {
//        UploadedFile uploadedFileForEvent = fileUploadEvent.getFile();
//
//        if (uploadedFileForEvent != null) {
//            this.setUploadedFile(uploadedFileForEvent);
//
//            try {
//                this.saveFileIntoDisc(this.getUploadedFile());
//            } catch (IOException e) {
//            }
//        }
//    }

    private void saveFileIntoDisc(UploadedFile uploadedFile)
            throws IOException {
        File targetFolder = new File("/home/rebien/Documentos/JuridicApp/");
        InputStream inputStream = uploadedFile.getInputstream();
        OutputStream outputStream = new FileOutputStream(
                new File(targetFolder, uploadedFile.getFileName()));

        int read = 0;
        byte[] bytes = new byte[2048];
        while ((read = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }

        inputStream.close();
        outputStream.flush();
        outputStream.close();
    }
}