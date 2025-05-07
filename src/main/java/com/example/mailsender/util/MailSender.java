package com.example.mailsender.util;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MailSender {

    private static final Properties props = new Properties();
    private static String fromEmail;
    private static String password;

    static {
        try {
            InputStream input = MailSender.class.getClassLoader().getResourceAsStream("application.properties");
            props.load(input);

            fromEmail = props.getProperty("myapp.mail").replace("\"", "");
            password = props.getProperty("myapp.password").replace("\"", "");;

            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

        } catch (IOException e) {
            throw new RuntimeException("❌ application.properties yüklenemedi: " + e.getMessage());
        }
    }

    public static void sendEmailWithAttachment(String toEmail, String filePath) throws MessagingException, IOException {

        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("❌ Dosya bulunamadı: " + filePath);
        }

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject("Kullanıcı Mesajı");

        // E-posta mesajı
        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setText("Merhaba, mesajınız ekte yer almaktadır.");

        // Ek dosya
        MimeBodyPart attachmentPart = new MimeBodyPart();
        attachmentPart.attachFile(file);

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(textPart);
        multipart.addBodyPart(attachmentPart);

        message.setContent(multipart);

        Transport.send(message);
        System.out.println("✅ Mail başarıyla gönderildi: " + toEmail);
    }
}
