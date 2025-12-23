package Utilitarios;

import java.io.InputStream;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class MailSessionFactory {

    private static final Properties mailProps = new Properties();

    static {
        try (InputStream is = MailSessionFactory.class
        	    .getClassLoader()
        	    .getResourceAsStream("config/mail.properties");) {

            if (is == null) {
                throw new RuntimeException(
                    "mail.properties NO encontrado en el classpath (config/mail.properties)"
                );
            }

            mailProps.load(is);

            System.out.println("Mail config cargada OK: " + mailProps.getProperty("mail.username"));

        } catch (Exception e) {
            throw new RuntimeException("Error cargando mail.properties", e);
        }
    }

    public static Session createSession() {

        return Session.getInstance(mailProps, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        mailProps.getProperty("mail.username"),
                        mailProps.getProperty("mail.password")
                );
            }
        });
    }
}
