package cc;

public class SicaklikAlgilayiciCalistir extends Observable implements IIslem {
    private ISicaklikAlgilayici sicaklikAlgilayici;

    public SicaklikAlgilayiciCalistir(ISicaklikAlgilayici sicaklikAlgilayici) {
        this.sicaklikAlgilayici = sicaklikAlgilayici;
    }

    public void IslemYap(){
        sicaklikAlgilayici.SicaklikOlc();
        haberVer();
    }

    @Override
    public String toString() {
        return "Sıcaklık : "+ sicaklikAlgilayici.getSicaklik()+" Derece";
    }
}
