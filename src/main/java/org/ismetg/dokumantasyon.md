   
    Öncelikle projeyi spring olarak kurdum ve gerekli özellikleri seçtim. Gerekli bağımlılıkları 
    ekleyip veritabanını oluşturdum ve application.yml dosyasında bağlantı ayarlarını belirledim.

    Sonra katmanları açıp sırasıyla entity repository service ve controller katmanlarını oluşturdum.
    Answer ve Question entitylerini oluşturup her biri için repository service ve controller oluşturdum.
    
    Question ve Answer için işi kolaylaştırıcak dtolar ve mapper katmanı ekledim.

    Question için QuestionService üzerinde save metodu ekledim ve bir soru eklenirken
    içerisinde içerisinde cevaplarda ekleniyor. 
    
    Doğru cevabı eklemek için ayrı bir metod ekledim ve bu metodda gerekli kontroller yaptım.
    Eksik veya hatalı bir durum varsa kontrol ediliyor. Varsa ExamException sınıfından
    hata oluşturuyor.

    Listeleme isteklerine göre 
    tüm soruları ve içerisindeki cevapları getiricek bir metod yazdım.
    birde sadece bir soruyu getiricek içerisinde doğru cevabında olacağı ayrı bir metod yazdım.

    Answer tarafından ise bir cevabı silecek ve bir soruya yeni bir cevap ekleyecek 
    istekleri ekledim.

    Son olarak bir listeleme daha ekledim. getQuestionsBySubject metodu ile dışardan girilen
    konuya göre soruları ve şıkları listeliyor.

    Util Katmanında Bir DemoData sınıfı ekledim ve proje başlatılırken ayağa kalkıcak şekilde ekleme yaptım.
    (Yorum satırı içinde bıraktım).