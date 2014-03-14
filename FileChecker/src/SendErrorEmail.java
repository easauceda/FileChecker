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
		props.put(//host ip);
		props.put(//host port);

		Session session = Session.getDefaultInstance(props);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(//email goes here));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(//email goes here));
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
