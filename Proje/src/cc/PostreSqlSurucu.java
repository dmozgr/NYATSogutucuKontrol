package cc;

import java.sql.*;
import java.util.concurrent.ExecutionException;

public class PostreSqlSurucu implements IVeriTabaniSurucusu {
    private Connection connection;
    @Override
    public boolean baglan() {
        String jdbcURL = "jdbc:postgresql://localhost:5432/NYATProje";
        String username = "postgres";
        String password = "145090";
        try{
            connection = DriverManager.getConnection(jdbcURL,username,password);
            return true;
        }
        catch (Exception e) {
            System.out.println("Error in connecting to PostreSql");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean kullaniciKontrol(IKisi kullanici) {
        String sql = "SELECT * FROM \"KullaniciBilgileri\" WHERE \"kullaniciAdi\"='"+kullanici.getKullaniciAdi()+"' AND \"sifre\"='"+kullanici.getSifre()+"'";
        try
        {
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery(sql);
            if(rs.next())
            {
                return true;
            }
            else return false;
        }catch (Exception e)
        {
            e.printStackTrace();
            return  false;
        }
    }
}
