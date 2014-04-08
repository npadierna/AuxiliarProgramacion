package co.edu.udea.juridicapp.service.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAutenticator extends Authenticator {

    private String myEmail;
    private String password;
    
    public MailAutenticator(String myEmail, String password){
        super();
        this.myEmail = myEmail;
        this.password = password;
    }
    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(myEmail, password);
    }
}
