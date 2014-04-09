package co.edu.udea.juridicapp.service.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public class MailAutenticator extends Authenticator {

    private String myEmail;
    private String password;

    public MailAutenticator(String myEmail, String password) {
        super();

        this.myEmail = myEmail;
        this.password = password;
    }

    @Override()
    public PasswordAuthentication getPasswordAuthentication() {

        return (new PasswordAuthentication(this.myEmail, this.password));
    }
}