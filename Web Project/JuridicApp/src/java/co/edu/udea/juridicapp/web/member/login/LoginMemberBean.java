package co.edu.udea.juridicapp.web.member.login;

import co.edu.udea.juridicapp.persistence.dao.IMemberDAO;
import co.edu.udea.juridicapp.persistence.dao.impl.MemberDAO;
import co.edu.udea.juridicapp.persistence.entity.Member;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
@SessionScoped()
public class LoginMemberBean implements Serializable {

    //private static final long serialVersionUID;
    private IMemberDAO memberDAO;
    private Member loggedMember;
    private String userName;
    private String password;
    private String rol;

    public LoginMemberBean() {
        super();
        this.memberDAO = new MemberDAO();
    }

    public Member getLoggedMember() {
        return loggedMember;
    }

    public void setLoggedMember(Member loggedMember) {
        this.loggedMember = loggedMember;
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