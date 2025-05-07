package com.example.mailsender;

import com.example.mailsender.util.MailSender;
import jakarta.mail.MessagingException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MailSenderApplication {
    public static void main(String[] args) throws MessagingException, IOException, InterruptedException {
        System.out.println("===========================================");
        System.out.println(" Mail Gönderme Uygulamasına Hoş Geldiniz!");
        System.out.println("===========================================");
        Thread.sleep(1000);
        System.out.println("Bu uygulama ile kolayca e-posta gönderebilirsiniz.");
        Thread.sleep(1000);
        System.out.println("Tek yapmanız gereken mesajınızı yazmak.");
        Thread.sleep(2000);
        System.out.println("Hepsi bu kadar. Hadi başlayalım!");
        System.out.println();
        Thread.sleep(1000);


        Scanner scanner = new Scanner(System.in);

        System.out.print("Mesajınızı girin: ");
        String message = scanner.nextLine();

        System.out.print("Alıcı mail adresini girin: ");
        String email = scanner.nextLine();

        String filePath = "mesaj.txt";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(message);
            System.out.println("Mesaj dosyaya kaydedildi.");
        } catch (IOException e) {
            System.out.println("Hata oluştu: " + e.getMessage());
            return;
        }
        try{
            MailSender.sendEmailWithAttachment(email, filePath);
        }
        catch (MessagingException e) {
            System.err.println("mesaji gondermede hata : " + e.getMessage());
        }

    }
}
