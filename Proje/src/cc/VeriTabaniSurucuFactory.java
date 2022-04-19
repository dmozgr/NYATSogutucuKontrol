package cc;

public class VeriTabaniSurucuFactory {
    public static IVeriTabaniSurucusu getVeritabani(String surucu)
    {
        IVeriTabaniSurucusu veriTabaniSurucusu = null;
        if(surucu.equalsIgnoreCase("postresql"))
        {
            veriTabaniSurucusu = new PostreSqlSurucu();
        }
        return veriTabaniSurucusu;
    }
}
