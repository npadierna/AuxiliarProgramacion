package co.edu.udea.juridicapp.web.bean.admin.creator;

import co.edu.udea.juridicapp.persistence.dao.IDependencyDAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
@SessionScoped()
public class CreatorEntityBean implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Autowired()
    private IDependencyDAO dependencyDAO;
    private String mock = "http://192.168.1.1:8080/Juridicapp/faces/co/edu/udea/juridicapp/web/user/registration/registeruser.xhtml";

    public CreatorEntityBean() {
        super();
    }

    public String getMock() {

        return (this.mock);
    }

    public void setMock(String mock) {
        this.mock = mock;
    }

    @PostConstruct()
    private void createFields() {
    }
}