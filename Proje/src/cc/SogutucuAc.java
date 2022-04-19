package cc;

public class SogutucuAc extends Observable implements IIslem  {

    private IEyleyici eyleyici;
    public SogutucuAc(IEyleyici eyleyici) {
        this.eyleyici = eyleyici;
    }

    @Override
    public void IslemYap() {
        haberVer();
        eyleyici.SogutucuyuAc();
    }

    @Override
    public String toString() {
         if(eyleyici.getState().equalsIgnoreCase("ACIK"))
             return "Soğutucu Zaten Açık Durumdadır.";
         return "Soğutucu Açıldı.";
    }
}
