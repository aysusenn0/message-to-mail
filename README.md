✍️ Proje Açıklaması:
Bu proje, Java kullanarak SMTP protokolü üzerinden e-posta göndermeyi sağlar. Kullanıcıdan alınan mesaj, dosyaya kaydedilir ve belirtilen alıcıya e-posta olarak gönderilir. Gmail SMTP veya Mailtrap kullanılarak test edilmiştir.

🛠️ Kullanılan Teknolojiler:
Java

JavaMail API

SMTP (Gmail veya Mailtrap)

IntelliJ IDEA (IDE)

💡 Proje Özellikleri:
Kullanıcıdan mesaj alma

Mesajı dosyaya kaydetme

E-posta gönderme (Gmail / Mailtrap üzerinden)

🚀 Kurulum ve Çalıştırma:
Gerekli Kütüphaneler:
Proje, JavaMail API'yi kullanmaktadır. Gerekli kütüphaneleri pom.xml dosyasına ekleyebilirsiniz (Maven projesi).

xml
Kopyala
Düzenle
<dependency>
    <groupId>com.sun.mail</groupId>
    <artifactId>javax.mail</artifactId>
    <version>1.6.2</version>
</dependency>
Gmail Ayarları:
Gmail üzerinden çalıştırmak için, Gmail hesabınızın şifresini "Uygulama Şifresi" olarak ayarlayın. Daha fazla bilgi için Google Destek.

Mail Gönderme:
JavaMail sınıfı kullanılarak e-posta gönderimi sağlanır. Kodun içerisinde SMTP ayarları ve kullanıcı bilgileri doğru bir şekilde girilmelidir.

💻 Çalıştırma:
Projeyi indirin veya clone'layın.

MailSender.java dosyasını çalıştırın.

Kullanıcıdan mesaj ve alıcı e-posta adresini girdikten sonra, mail başarıyla gönderilecektir.

