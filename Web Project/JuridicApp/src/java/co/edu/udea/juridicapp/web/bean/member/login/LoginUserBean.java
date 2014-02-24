package co.edu.udea.juridicapp.web.bean.member.login;

import co.edu.udea.juridicapp.persistence.dao.IUserDAO;
import co.edu.udea.juridicapp.persistence.dao.impl.UserDAO;
import co.edu.udea.juridicapp.persistence.entity.User;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@SessionScoped()
public class LoginUserBean implements Serializable {

    //private static final long serialVersionUID;
    private IUserDAO userDAO;
    private User user;
    private String userName;
    private String password;
    private String rol;

    public LoginUserBean() {
        super();
        this.userDAO = new UserDAO();
    }

    public User getLoggedUser() {
        return user;
    }

    public void setLoggedUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
