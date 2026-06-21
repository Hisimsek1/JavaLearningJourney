import java.util.HashMap;
import java.util.Map;

public class HashMapPratik {
    public static void main(String[] args) {

        // Öğrenci notu sistemi
        HashMap<String, Integer> notlar = new HashMap<>();

        notlar.put("Ahmet", 85);
        notlar.put("Ayşe", 92);
        notlar.put("Mehmet", 78);
        notlar.put("Fatma", 95);
        notlar.put("Ali", 65);

        System.out.println("Tüm notlar:");
        for (Map.Entry<String, Integer> entry : notlar.entrySet()) {
            System.out.printf("  %-10s -> %d%n", entry.getKey(), entry.getValue());
        }

        System.out.println("\nAhmet'in notu: " + notlar.get("Ahmet"));
        System.out.println("'Fatma' var mı: " + notlar.containsKey("Fatma"));

        // En yüksek not
        String enIyiOgrenci = null;
        int enYuksekNot = 0;
        for (Map.Entry<String, Integer> entry : notlar.entrySet()) {
            if (entry.getValue() > enYuksekNot) {
                enYuksekNot = entry.getValue();
                enIyiOgrenci = entry.getKey();
            }
        }
        System.out.println("\nEn yüksek not: " + enIyiOgrenci + " - " + enYuksekNot);

        // Ortalama
        int toplam = 0;
        for (int not : notlar.values()) toplam += not;
        System.out.printf("Sınıf ortalaması: %.1f%n", (double) toplam / notlar.size());

        // Güncelleme
        notlar.put("Ali", 70);
        System.out.println("\nAli'nin güncel notu: " + notlar.get("Ali"));

        notlar.remove("Mehmet");
        System.out.println("'Mehmet' silindi. Kalan: " + notlar.keySet());
    }
}
