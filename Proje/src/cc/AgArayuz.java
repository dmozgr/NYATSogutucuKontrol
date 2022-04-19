package cc;

import java.util.Scanner;

import static java.lang.System.in;

public class AgArayuz implements IAgArayuz,Observer{
    private IEkran ekran;
    private IKisi kullanici;
    private IVeriTabaniSurucusu veriTabaniSurucusu;
    private IMerkeziIslemPlatform CPU;
    public AgArayuz() {
        this.ekran = new Ekran();
        this.veriTabaniSurucusu=VeriTabaniSurucuFactory.getVeritabani("postresql");
        this.CPU=new MerkeziIslemPlatform(ekran,this);
    }

    public void Basla()
    {
        Scanner scanner = new Scanner(in);
        do {
            ekran.mesajYazdir("--------------------------------");
            ekran.mesajYazdir("- Hoşgeldiniz -- \n\nLütfen Giriş Yapınız");
            ekran.mesajYazdir("Kullanıcı Adınızı Giriniz :");
            String kullaniciadi =scanner.nextLine();
            ekran.mesajYazdir("Şifrenizi Giriniz :");
            String sifre = scanner.nextLine();
            kullanici = new Kullanici(kullaniciadi,sifre);
        }while (!KullaniciDogrula(kullanici));
        ekran.mesajYazdir(kullanici.getKullaniciAdi()+", Başarıyla Giriş Yaptınız.");
        IslemSecimi();
    }

    @Override
    public boolean KullaniciDogrula(IKisi kullanici) {
        ekran.mesajYazdir("Veritabanına bağlanılıyor...");
        Araclar.delay(500);
        if(!veriTabaniSurucusu.baglan())
        {
            ekran.mesajYazdir("Veritabanına bağlanılamıyor. Tekrar deneyiniz.");
            return false;
        }
        if(!veriTabaniSurucusu.kullaniciKontrol(kullanici))
        {
            ekran.mesajYazdir("Kullanıcı adı veya şifreniz hatalıdır. Lütfen tekrar giriş yapınız.");
            return  false;
        }
        else{
            return true;
        }
    }


    @Override
    public void IslemSecimi() {
        Scanner scanner = new Scanner(in);
        Secenekler secenekler = new Secenekler(ekran);
        String devam;
        do {
            secenekler.AnaMenuyuGoster();
            int islem = scanner.nextInt();
            scanner.nextLine();
            CPU.IslemiGerceklestir(islem);
            ekran.mesajYazdir("İşleme devam etmek istiyor musunuz ? (E/H)");
            devam = scanner.nextLine();
        } while ((devam.equalsIgnoreCase("E") && devam.equalsIgnoreCase("e")));
        ekran.mesajYazdir("İyi günler dileriz.");
    }

    @Override
    public void update(Observable observable) {
        ekran.mesajYazdir(observable.toString());
    }
}
