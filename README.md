## **HOMEWORK-5**
1. Spring Profile nedir? Properties ya da yml dosya formları ile isbasi uygulamasına test
profile ekleyin.(5 Puan)

Spring, konfigürasyon özelliklerini sözde profiller halinde gruplamak için güçlü bir araç sağlar ve tek bir profil parametresi ile bir grup konfigürasyonu etkinleştirmemize izin verir. Spring Boot, profilleri harici olarak yapılandırmamıza ve etkinleştirmemize izin vererek bunun üzerine kuruludur.
2. SQL injection örnekleyin. Nasıl korunabiliriz?(5 Puan)
   Bir kişinin veya kuruluşun verilerini silme, değiştirme, yedekleme, sisteme virüs ekleme, operasyonlara zarar verme gibi amaçlarla kullanılan SQL Injection, uygulamanın istemci ucundan SQL sorgu girişi eklenerek veya enjekte edilerek yapılır.

SQL enjeksiyonu için saldırganın bir web uygulamasında veya web sayfasında güvenlik açığı olan bir girişi bulması gerekir.

SQL enjeksiyonu, veriler güvenilmeyen bir kaynaktan bir programa girdiğinde ve bu veriler dinamik olarak bir SQL sorgusu oluşturmak için kullanıldığında gerçekleşir. Yanıt, saldırganın veritabanı mimarisini anlaması ve uygulamanın güvenli bilgilerine erişmesi için gereklidir. Bilgisayar korsanı, özel olarak hazırlanmış bir SQL komutuyla veritabanı yapısı hakkında net fikir sağlayan bir yanıt elde ederek veritabanındaki tüm bilgilere erişebilir.
3. Aşağıdaki kurallara göre bir film öneri uygulaması yazın. (90 Puan)

### **Teknolojiler;**
* Min Java8
* Spring Boot
* Restfull
* MySQL - Postgre - Mongo(Her servis farklı database kullanabilir)
* RabbitMQ

### **Gereksinimler;**

* Kullanıcı sisteme kayıt olup, login olabilmelidir.(Login işlemi için email ve şifre bilgileri
gereklidir.)
* Kullanıcı şifresi istediğiniz bir hashing algoritmasıyla database kaydedilmelidir.
* Kullanıcılar sisteme film ekleyebilir ve bu filmler herkes tarafından görülebilir.
* Kullanıcı kendi eklediği filmleri görebilmeli.(Profil sayfası gibi düşünün)
* Kullanıcı şifresini ve ismini değiştirebilir.
* Ücretli üye olmayan kullanıcılar sadece 3 film ekleyebilir.
* Ücretli üye olmayan kullanıcılar filmlere yorum yapamaz.
* Sisteme yeni bir film girildiğinde kullanıcılara email gider.
* Sistemi takip edebilmek için gerekli gördüğünüz yerlere Log ekleyin.

### **Sistem Kabulleri;**

* Ödeme işlemi senkron gerçekleşmelidir.
* Ödeme servisi sadece ödeme bilgilerini kaydeder ve başarılı response döner.
* Email gönderme işlemi asenkron gerçekleşmelidir.
* Üyelikler 1-3-6-12 ay olarak alınabilir.

### **Postman Sorguları** ##

3434 server portu kullanılmıştır. Sorgu sonucu örnek görseller eklenmiştir.

Payment feign ile senkron, email rabbitmq ile asenkron eklenmiştir.

- POST http://localhost:3434/movie/add-movie/{action}
- GET http://localhost:3434/movie/title
- GET http://localhost:3434/movie/movie-list/0
- POST http://localhost:3434/movie/delete/title

- GET http://localhost:3434/type/page
- GET http://localhost:3434/type/types

- POST http://localhost:3434/users/sign-up
- GET http://localhost:3434/users/sign-in
- PUT http://localhost:3434/users/update

![](../../../Masaüstü/Ekran görüntüsü 2022-07-24 211509.png)

![](../../../Masaüstü/Ekran görüntüsü 2022-07-24 212007.png)

![](../../../Masaüstü/Ekran görüntüsü 2022-07-24 212108.png)

![](../../../Masaüstü/Ekran görüntüsü 2022-07-24 214706.png)