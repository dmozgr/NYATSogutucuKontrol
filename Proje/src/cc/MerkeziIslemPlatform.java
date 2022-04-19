package cc;

public class MerkeziIslemPlatform implements IMerkeziIslemPlatform {
    private final IEyleyici eyleyici;
    private final ISicaklikAlgilayici algilayici;
    private final IAgArayuz agArayuz;
    private final IEkran ekran;

    public MerkeziIslemPlatform(IEkran ekran,AgArayuz agArayuz) {
        this.eyleyici = new Eyleyici();
        this.algilayici = new SicaklikAlgilayici();
        this.agArayuz = agArayuz;
        this.ekran = ekran;

    }



    @Override
    public void IslemiGerceklestir(int secim){
        IIslem islem;
        switch (secim)
        {
            case 1:
                islem = new SogutucuAc(eyleyici);
                islem.attach((Observer) agArayuz);
                ekran.mesajYazdir("Eyleyici Çalıştırılıyor.");
                Araclar.delay(1000);
                islem.IslemYap();
                break;
            case 2:
                islem = new SogutucuKapat(eyleyici);
                islem.attach((Observer) agArayuz);
                ekran.mesajYazdir("Eyleyici Çalıştırılıyor.");
                Araclar.delay(1000);
                islem.IslemYap();
                break;
            case 3:
                islem = new SicaklikAlgilayiciCalistir(algilayici);
                islem.attach((Observer) agArayuz);
                ekran.mesajYazdir("Sıcaklık Algılayıcı Çalıştırılıyor..");
                Araclar.delay(1000);
                islem.IslemYap();
                break;
            default:
                ekran.mesajYazdir("Lütfen Geçerli Seçim Yapınız.");
        }
    }


}
