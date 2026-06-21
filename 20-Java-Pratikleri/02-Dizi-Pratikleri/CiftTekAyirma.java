import java.util.Arrays;

public class CiftTekAyirma {
    public static void main(String[] args) {

        int[] sayilar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        int ciftSayac = 0, tekSayac = 0;
        for (int s : sayilar) {
            if (s % 2 == 0) ciftSayac++;
            else tekSayac++;
        }

        int[] ciftler = new int[ciftSayac];
        int[] tekler = new int[tekSayac];
        int ci = 0, ti = 0;

        for (int s : sayilar) {
            if (s % 2 == 0) ciftler[ci++] = s;
            else tekler[ti++] = s;
        }

        System.out.println("Orijinal: " + Arrays.toString(sayilar));
        System.out.println("Çift sayılar: " + Arrays.toString(ciftler));
        System.out.println("Tek sayılar: " + Arrays.toString(tekler));

        // Asal sayı kontrolü
        System.out.print("Asal sayılar: ");
        for (int s : sayilar) {
            if (asalMi(s)) System.out.print(s + " ");
        }
        System.out.println();
    }

    static boolean asalMi(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
