public class RekursifAlgoritmalar {

    // Faktöriyel
    static long faktoriyel(int n) {
        if (n <= 1) return 1;
        return n * faktoriyel(n - 1);
    }

    // Fibonacci
    static long fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Üs alma
    static double usAlma(double taban, int us) {
        if (us == 0) return 1;
        if (us < 0) return 1.0 / usAlma(taban, -us);
        return taban * usAlma(taban, us - 1);
    }

    // EBOB (En Büyük Ortak Bölen) - Öklit algoritması
    static int ebob(int a, int b) {
        if (b == 0) return a;
        return ebob(b, a % b);
    }

    // Hanoi Kulesi
    static void hanoi(int n, char kaynak, char hedef, char yardimci) {
        if (n == 1) {
            System.out.println("Disk 1: " + kaynak + " -> " + hedef);
            return;
        }
        hanoi(n - 1, kaynak, yardimci, hedef);
        System.out.println("Disk " + n + ": " + kaynak + " -> " + hedef);
        hanoi(n - 1, yardimci, hedef, kaynak);
    }

    public static void main(String[] args) {
        System.out.println("=== Faktöriyel ===");
        for (int i = 0; i <= 10; i++) {
            System.out.println(i + "! = " + faktoriyel(i));
        }

        System.out.println("\n=== Fibonacci (ilk 10) ===");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();

        System.out.println("\n=== Üs Alma ===");
        System.out.println("2^10 = " + (long) usAlma(2, 10));
        System.out.println("3^5  = " + (long) usAlma(3, 5));

        System.out.println("\n=== EBOB ===");
        System.out.println("EBOB(48, 18) = " + ebob(48, 18));
        System.out.println("EBOB(100, 75) = " + ebob(100, 75));

        System.out.println("\n=== Hanoi Kulesi (3 disk) ===");
        hanoi(3, 'A', 'C', 'B');
    }
}
