import java.util.Optional;
import java.util.Arrays;
import java.util.List;

public class OptionalPratik {

    static Optional<String> kullaniciBul(String isim) {
        List<String> kullanicilar = Arrays.asList("Ali", "Ayşe", "Mehmet", "Fatma");
        return kullanicilar.stream()
                .filter(k -> k.equalsIgnoreCase(isim))
                .findFirst();
    }

    static Optional<Integer> bolme(int a, int b) {
        if (b == 0) return Optional.empty();
        return Optional.of(a / b);
    }

    public static void main(String[] args) {

        System.out.println("=== Optional Temel Kullanım ===");

        Optional<String> dolu = Optional.of("Merhaba");
        Optional<String> bos  = Optional.empty();

        System.out.println("Dolu mu: " + dolu.isPresent());
        System.out.println("Boş mu:  " + bos.isEmpty());
        System.out.println("Değer:   " + dolu.get());
        System.out.println("OrElse:  " + bos.orElse("Varsayılan değer"));

        System.out.println("\n=== Kullanıcı Arama ===");
        String[] aramalar = {"Ali", "Zeynep", "Fatma", "Hasan"};

        for (String arama : aramalar) {
            Optional<String> sonuc = kullaniciBul(arama);
            String mesaj = sonuc.map(k -> "Bulundu: " + k)
                                .orElse("'" + arama + "' bulunamadı");
            System.out.println(mesaj);
        }

        System.out.println("\n=== Optional ile Güvenli Bölme ===");
        int[][] islemler = {{10, 2}, {15, 3}, {7, 0}, {20, 4}};

        for (int[] islem : islemler) {
            Optional<Integer> sonuc = bolme(islem[0], islem[1]);
            System.out.printf("%2d / %d = %s%n",
                islem[0], islem[1],
                sonuc.map(String::valueOf).orElse("Tanımsız (sıfıra bölme)"));
        }

        System.out.println("\n=== Optional Zincirleme ===");
        Optional<String> zincir = Optional.of("  java öğreniyorum  ")
                .map(String::trim)
                .map(String::toUpperCase)
                .filter(s -> s.length() > 5);

        System.out.println("Zincirleme sonucu: " + zincir.orElse("Yok"));
    }
}
