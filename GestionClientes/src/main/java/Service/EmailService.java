package Service;

import Utilitarios.MailSessionFactory;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	
	public void enviar(String destinatario, String asunto, String cuerpo) {
		
		try {
			Session session = MailSessionFactory.createSession();
			
			Message message = new MimeMessage(session);
			message.setFrom(
				new InternetAddress(
					session.getProperty("mail.username"))
			);
			
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			
			message.setSubject(asunto);
			message.setText(cuerpo);
			
			Transport.send(message);
			
		} catch (Exception e) {
			throw new RuntimeException("Error enviando correo", e);
		}
	}
}
