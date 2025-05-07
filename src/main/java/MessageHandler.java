import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MessageHandler {
    public static void main(String[] args) {
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

        MailSender.sendEmailWithAttachment(email, filePath);
    }
}
