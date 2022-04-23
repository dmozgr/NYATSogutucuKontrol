package cc;

public class Secenekler implements ISecenekler {

    private IEkran ekran;
    public Secenekler(IEkran ekran) {
        this.ekran = ekran;
    }

    @Override
    public  void AnaMenuyuGoster() {
        ekran.mesajYazdir("-- Ana Menüye Hoşgeldiniz.");
        ekran.mesajYazdir("1- Soğutuyucu Aç");
        ekran.mesajYazdir("2- Soğutucuyu Kapat");
        ekran.mesajYazdir("3- Sıcaklığı Öğren");
        ekran.mesajYazdir("Hangi işlemi yapmak istiyorsunuz ?");

    }
}
