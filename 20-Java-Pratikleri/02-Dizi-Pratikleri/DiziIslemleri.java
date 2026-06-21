import java.util.Arrays;

public class DiziIslemleri {
    public static void main(String[] args) {

        int[] sayilar = {5, 3, 8, 1, 9, 2, 7, 4, 6};

        System.out.println("Orijinal dizi: " + Arrays.toString(sayilar));

        // En büyük ve en küçük
        int max = sayilar[0], min = sayilar[0];
        for (int s : sayilar) {
            if (s > max) max = s;
            if (s < min) min = s;
        }
        System.out.println("En büyük: " + max);
        System.out.println("En küçük: " + min);

        // Toplam ve ortalama
        int toplam = 0;
        for (int s : sayilar) toplam += s;
        System.out.println("Toplam: " + toplam);
        System.out.printf("Ortalama: %.2f%n", (double) toplam / sayilar.length);

        // Sıralama
        Arrays.sort(sayilar);
        System.out.println("Sıralı dizi: " + Arrays.toString(sayilar));

        // İkili arama
        int aranan = 7;
        int index = Arrays.binarySearch(sayilar, aranan);
        System.out.println(aranan + " sayısının indexi: " + index);

        // Ters çevirme
        int[] ters = new int[sayilar.length];
        for (int i = 0; i < sayilar.length; i++) {
            ters[i] = sayilar[sayilar.length - 1 - i];
        }
        System.out.println("Ters dizi: " + Arrays.toString(ters));
    }
}
