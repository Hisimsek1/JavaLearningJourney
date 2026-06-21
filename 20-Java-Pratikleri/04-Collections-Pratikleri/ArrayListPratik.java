import java.util.ArrayList;
import java.util.Collections;

public class ArrayListPratik {
    public static void main(String[] args) {

        ArrayList<String> isimler = new ArrayList<>();

        isimler.add("Zeynep");
        isimler.add("Ahmet");
        isimler.add("Mehmet");
        isimler.add("Fatma");
        isimler.add("Ali");
        isimler.add("Ayşe");

        System.out.println("Orijinal liste: " + isimler);
        System.out.println("Boyut: " + isimler.size());
        System.out.println("İlk eleman: " + isimler.get(0));
        System.out.println("'Mehmet' var mı: " + isimler.contains("Mehmet"));

        Collections.sort(isimler);
        System.out.println("Sıralı: " + isimler);

        Collections.reverse(isimler);
        System.out.println("Ters: " + isimler);

        isimler.remove("Ali");
        System.out.println("'Ali' silindi: " + isimler);

        // Döngü ile yazdırma
        System.out.print("For-each: ");
        for (String isim : isimler) {
            System.out.print(isim + " ");
        }
        System.out.println();

        // indexOf
        System.out.println("'Zeynep' index: " + isimler.indexOf("Zeynep"));

        isimler.clear();
        System.out.println("Temizlendi, boş mu: " + isimler.isEmpty());
    }
}
