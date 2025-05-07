import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.File;
import java.util.Properties;

public class MailSender {
    public static void sendEmailWithAttachment(String toEmail, String filePath) {
        final String fromEmail = "yourMail@gmail.com";
        final String password = "yourpassword";  // 16 karakterli uygulama şifresi


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Kullanıcı Mesajı");

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Mesajınız ektedir.");

            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File(filePath));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Mail başarıyla gönderildi.");
        } catch (Exception e) {
            System.out.println("Mail gönderme hatası: " + e.getMessage());
        }
    }
}
