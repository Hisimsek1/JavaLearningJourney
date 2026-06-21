import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class LambdaPratik {

    @FunctionalInterface
    interface Hesap {
        double hesapla(double a, double b);
    }

    public static void main(String[] args) {

        // Temel lambda
        System.out.println("=== Temel Lambda ===");
        Hesap topla   = (a, b) -> a + b;
        Hesap carp    = (a, b) -> a * b;
        Hesap bol     = (a, b) -> a / b;
        Hesap cıkar   = (a, b) -> a - b;

        System.out.println("5 + 3 = " + topla.hesapla(5, 3));
        System.out.println("5 * 3 = " + carp.hesapla(5, 3));
        System.out.println("5 / 2 = " + bol.hesapla(5, 2));
        System.out.println("5 - 3 = " + cıkar.hesapla(5, 3));

        // Predicate
        System.out.println("\n=== Predicate ===");
        Predicate<Integer> ciftMi    = n -> n % 2 == 0;
        Predicate<Integer> pozitifMi = n -> n > 0;
        Predicate<String>  uzunMu    = s -> s.length() > 5;

        System.out.println("10 çift mi: " + ciftMi.test(10));
        System.out.println("-5 pozitif mi: " + pozitifMi.test(-5));
        System.out.println("'Merhaba' uzun mu: " + uzunMu.test("Merhaba"));

        // Predicate kombinasyonu
        Predicate<Integer> ciftVePozitif = ciftMi.and(pozitifMi);
        System.out.println("8 hem çift hem pozitif: " + ciftVePozitif.test(8));
        System.out.println("-4 hem çift hem pozitif: " + ciftVePozitif.test(-4));

        // Function
        System.out.println("\n=== Function ===");
        Function<String, Integer> uzunluk = String::length;
        Function<Integer, String> kareStr  = n -> n + "^2 = " + (n * n);

        System.out.println("'Java' uzunluğu: " + uzunluk.apply("Java"));
        System.out.println(kareStr.apply(7));

        // Consumer
        System.out.println("\n=== Consumer ===");
        Consumer<String> yazdir = System.out::println;
        List<String> diller = Arrays.asList("Java", "Python", "C++", "Kotlin");
        diller.forEach(yazdir);

        // Supplier
        System.out.println("\n=== Supplier ===");
        Supplier<String> selamlama = () -> "Merhaba Dünya!";
        System.out.println(selamlama.get());
    }
}
