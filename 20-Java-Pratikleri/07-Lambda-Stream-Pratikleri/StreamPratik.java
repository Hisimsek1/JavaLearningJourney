import java.util.*;
import java.util.stream.*;

public class StreamPratik {
    public static void main(String[] args) {

        List<Integer> sayilar = Arrays.asList(1, 5, 2, 8, 3, 9, 4, 7, 6, 10);

        System.out.println("Orijinal: " + sayilar);

        // filter + collect
        List<Integer> ciftler = sayilar.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Çift sayılar: " + ciftler);

        // map + collect
        List<Integer> kareler = sayilar.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Kareler: " + kareler);

        // sorted + limit
        List<Integer> ilkUcSirali = sayilar.stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Sıralı ilk 3: " + ilkUcSirali);

        // reduce (toplam)
        int toplam = sayilar.stream()
                .reduce(0, Integer::sum);
        System.out.println("Toplam: " + toplam);

        // min ve max
        Optional<Integer> min = sayilar.stream().min(Integer::compareTo);
        Optional<Integer> max = sayilar.stream().max(Integer::compareTo);
        System.out.println("Min: " + min.get() + ", Max: " + max.get());

        // count
        long bestenBuyuk = sayilar.stream().filter(n -> n > 5).count();
        System.out.println("5'ten büyük sayı adedi: " + bestenBuyuk);

        // String stream
        System.out.println("\n=== String Stream ===");
        List<String> isimler = Arrays.asList("Ali", "Zeynep", "Ahmet", "Fatma", "Mehmet", "Ece");

        String uzunIsimler = isimler.stream()
                .filter(s -> s.length() > 3)
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
        System.out.println("4+ harfli isimler: " + uzunIsimler);

        // Ortalama
        OptionalDouble ortalama = sayilar.stream()
                .mapToInt(Integer::intValue)
                .average();
        System.out.printf("Ortalama: %.1f%n", ortalama.getAsDouble());
    }
}
