public class MatrisIslemleri {
    public static void main(String[] args) {

        int[][] matrisA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] matrisB = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        System.out.println("Matris A:");
        yazdir(matrisA);

        System.out.println("\nMatris B:");
        yazdir(matrisB);

        // Toplama
        int[][] toplam = topla(matrisA, matrisB);
        System.out.println("\nA + B:");
        yazdir(toplam);

        // Transpose
        int[][] transpoz = transpoz(matrisA);
        System.out.println("\nA Transpozu:");
        yazdir(transpoz);

        // Çapraz toplam
        int caprazToplam = 0;
        for (int i = 0; i < matrisA.length; i++) {
            caprazToplam += matrisA[i][i];
        }
        System.out.println("\nA'nın çapraz toplamı: " + caprazToplam);
    }

    static void yazdir(int[][] m) {
        for (int[] satir : m) {
            for (int val : satir) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }

    static int[][] topla(int[][] a, int[][] b) {
        int n = a.length, m = a[0].length;
        int[][] sonuc = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                sonuc[i][j] = a[i][j] + b[i][j];
        return sonuc;
    }

    static int[][] transpoz(int[][] a) {
        int n = a.length, m = a[0].length;
        int[][] t = new int[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                t[j][i] = a[i][j];
        return t;
    }
}
