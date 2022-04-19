package cc;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {
    private int sicaklik;

    public SicaklikAlgilayici() {

    }

    public int getSicaklik() {
        return sicaklik;
    }

    @Override
    public void SicaklikOlc() {
        sicaklik = (int)(Math.random()*25+15);
    }
}
