import java.util.Arrays;

public class AramaAlgoritmasi {

    // Doğrusal Arama - O(n)
    static int dogrusalArama(int[] dizi, int hedef) {
        for (int i = 0; i < dizi.length; i++) {
            if (dizi[i] == hedef) return i;
        }
        return -1;
    }

    // İkili Arama - O(log n) - dizi sıralı olmalı
    static int ikiliArama(int[] dizi, int hedef) {
        int sol = 0, sag = dizi.length - 1;
        while (sol <= sag) {
            int orta = (sol + sag) / 2;
            if (dizi[orta] == hedef) return orta;
            else if (dizi[orta] < hedef) sol = orta + 1;
            else sag = orta - 1;
        }
        return -1;
    }

    // İkili Arama (Rekürsif)
    static int ikiliAramaRekursif(int[] dizi, int hedef, int sol, int sag) {
        if (sol > sag) return -1;
        int orta = (sol + sag) / 2;
        if (dizi[orta] == hedef) return orta;
        if (dizi[orta] < hedef) return ikiliAramaRekursif(dizi, hedef, orta + 1, sag);
        return ikiliAramaRekursif(dizi, hedef, sol, orta - 1);
    }

    public static void main(String[] args) {
        int[] dizi = {64, 34, 25, 12, 22, 11, 90, 45, 78, 56};
        int hedef = 22;

        System.out.println("Dizi: " + Arrays.toString(dizi));
        System.out.println("Aranan: " + hedef);
        System.out.println();

        int i1 = dogrusalArama(dizi, hedef);
        System.out.println("Doğrusal Arama sonucu: index = " + i1);

        Arrays.sort(dizi);
        System.out.println("Sıralı dizi: " + Arrays.toString(dizi));

        int i2 = ikiliArama(dizi, hedef);
        System.out.println("İkili Arama sonucu: index = " + i2);

        int i3 = ikiliAramaRekursif(dizi, hedef, 0, dizi.length - 1);
        System.out.println("İkili Arama (Rekürsif) sonucu: index = " + i3);
    }
}
