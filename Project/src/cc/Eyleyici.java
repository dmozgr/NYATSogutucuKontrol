package cc;

public class Eyleyici implements  IEyleyici{
    private String state;

    public String getState() {
        return state;
    }

    public Eyleyici() {
        state = String.valueOf(SogutucuSTATE.KAPALI);
    }

    @Override
    public void SogutucuyuAc() {

        state = String.valueOf(SogutucuSTATE.ACIK);

    }

    @Override
    public void SogutucuyuKapat() {
        state = String.valueOf(SogutucuSTATE.KAPALI);
    }
}
