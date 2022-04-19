package cc;

public class SogutucuKapat extends Observable implements IIslem {
    private IEyleyici eyleyici;
    public SogutucuKapat(IEyleyici eyleyici) {
        this.eyleyici = eyleyici;
    }

    @Override
    public void IslemYap() {
        haberVer();
        eyleyici.SogutucuyuKapat();
    }

    @Override
    public String toString() {
        if(eyleyici.getState().equalsIgnoreCase("KAPALI"))
            return "Soğutucu Zaten Kapalı Durumdadır.";
        return "Soğutucu Kapatıldı.";
    }

}
