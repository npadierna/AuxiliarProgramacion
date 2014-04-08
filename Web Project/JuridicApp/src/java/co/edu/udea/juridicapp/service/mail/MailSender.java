package co.edu.udea.juridicapp.service.mail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Miguel Ossa Ruiz
 * @author Neiber Padierna P&eacute;rez
 */
public class MailSender {

    private String myEmail;
    private String password;
    private String SMTPserver = "smtp.gmail.com";
    private String port = "465";
    private String userEmail;
    private String subject;
    private String body;

    public MailSender(String myEmail, String password,
            String userEmail, String subject, String body) {
        this.myEmail = myEmail;
        this.password = password;
        this.userEmail = userEmail;
        this.subject = subject;
        this.body = body;
        Properties props = new Properties();
        props.put("mail.smtp.user", this.myEmail);
        props.put("mail.smtp.host", SMTPserver);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        SecurityManager security = System.getSecurityManager();
        try {
            Authenticator auth = new MailAutenticator(myEmail, password);
            Session session = Session.getInstance(props, auth);
            // session.setDebug(true);
            MimeMessage msg = new MimeMessage(session);
            msg.setText(this.body);
            msg.setSubject(this.subject);
            msg.setFrom(new InternetAddress(this.myEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(this.userEmail));
            Transport.send(msg);
            System.out.println("Email enviado");
        } catch (Exception mex) {
            System.out.println("Email no enviado");
        }
    }
}
