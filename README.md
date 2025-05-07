
# 📧 Java Mail Sender

Bu proje, Java kullanarak SMTP protokolü üzerinden e-posta göndermenizi sağlar.  
Kullanıcıdan alınan mesaj bir dosyaya kaydedilir ve belirtilen alıcıya e-posta olarak gönderilir.  
Gmail SMTP veya Mailtrap üzerinden test edilmiştir.

---

## 🛠️ Kullanılan Teknolojiler
- Java
- JavaMail API (Maven ile entegre)
- SMTP (Gmail veya Mailtrap)
- IntelliJ IDEA

---

## 💡 Özellikler
- Kullanıcıdan mesaj alma
- Mesajı `.txt` dosyasına kaydetme
- SMTP üzerinden e-posta gönderme
- Gmail veya Mailtrap ile uyumlu

---

## ⚙️ Yapılandırma

### `application.properties` (src/main/resources)

```properties
myapp.mail="your-email@gmail.com"
myapp.password="your-app-password"
````

> ⚠️ Gmail kullanıyorsanız, [Google App Passwords](https://myaccount.google.com/apppasswords) üzerinden 16 haneli bir **Uygulama Şifresi** oluşturmalısınız.
> Normal şifre ile çalışmaz.

---

## ▶️ Uygulamayı Çalıştırma

1. Projeyi indirin veya `git clone` ile alın
2. `MailSender.java` dosyasını çalıştırın
3. Alıcı e-posta adresini ve mesajı girin
4. Mesaj dosyaya kaydedilir ve e-posta gönderilir
5. Konsolda şu mesajı görürsünüz:

```
✅ Mail başarıyla gönderildi
```

---

## 🛠️ Maven ile Build ve Çalıştırma

### Derlemek için:

```bash
mvn clean install
```

### `.jar` dosyasını çalıştırmak için:

```bash
java -jar target/mail-sender-1.0-SNAPSHOT.jar
```

### Maven Wrapper ile (Maven kurulu değilse):

```bash
./mvnw clean install
```

---

## 🧠 Güvenlik Notu

* `application.properties` dosyasını `.gitignore` içine alın
* E-posta ve şifre bilgilerini asla GitHub’a push etmeyin ❌

