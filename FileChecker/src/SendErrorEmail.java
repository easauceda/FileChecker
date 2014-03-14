import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendErrorEmail implements Runnable {
	public SendErrorEmail() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "192.168.101.180");
		props.put("mail.smtp.socketFactory.port", "25");

		Session session = Session.getDefaultInstance(props);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("msauceda@jonsmarketplace.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("msauceda@jonsmarketplace.com"));
			message.setSubject("ERROR FILE NOT FOUND");
			message.setText("Authfile.DAT was not found" + "\n\n -File Checker");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void run() {
		new SendErrorEmail();

	}
}