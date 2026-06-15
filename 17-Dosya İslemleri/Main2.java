import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) {
        
        // Bağlantı adresi
        String url = "jdbc:mariadb://localhost:3306/javadersi";
        String kullanici = "root";
        String sifre = "SIFRENIZ"; // <--- Kurulumda belirlediğin şifre buraya yaz
        
        try {
            System.out.println("Bağlantı deneniyor...");
            
            Connection baglanti = DriverManager.getConnection(url, kullanici, sifre);
            
            System.out.println("Harika Hisimsek! Veritabanına başarıyla bağlandın.");
            
            baglanti.close(); 
            
        } catch (SQLException e) {
            System.out.println("Bir hata oluştu: " + e.getMessage());
        }
    }
}