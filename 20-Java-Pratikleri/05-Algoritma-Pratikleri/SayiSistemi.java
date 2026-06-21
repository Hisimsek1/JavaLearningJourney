public class SayiSistemi {

    // Decimal -> Binary
    static String decimalToBinary(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int sayi = Math.abs(n);
        while (sayi > 0) {
            sb.insert(0, sayi % 2);
            sayi /= 2;
        }
        return (n < 0 ? "-" : "") + sb.toString();
    }

    // Binary -> Decimal
    static int binaryToDecimal(String binary) {
        int sonuc = 0;
        for (int i = 0; i < binary.length(); i++) {
            sonuc = sonuc * 2 + (binary.charAt(i) - '0');
        }
        return sonuc;
    }

    // Decimal -> Hexadecimal
    static String decimalToHex(int n) {
        if (n == 0) return "0";
        String hexKarakterler = "0123456789ABCDEF";
        StringBuilder sb = new StringBuilder();
        int sayi = Math.abs(n);
        while (sayi > 0) {
            sb.insert(0, hexKarakterler.charAt(sayi % 16));
            sayi /= 16;
        }
        return (n < 0 ? "-" : "") + sb.toString();
    }

    public static void main(String[] args) {
        int[] sayilar = {0, 1, 10, 42, 255, 1000};

        System.out.printf("%-8s | %-12s | %-8s | %-6s%n", "Decimal", "Binary", "Octal", "Hex");
        System.out.println("---------|--------------|----------|--------");

        for (int s : sayilar) {
            System.out.printf("%-8d | %-12s | %-8s | %-6s%n",
                s,
                decimalToBinary(s),
                Integer.toOctalString(s),
                decimalToHex(s)
            );
        }

        System.out.println("\n=== Binary -> Decimal ===");
        String[] binaryler = {"1010", "11111111", "1000000000"};
        for (String b : binaryler) {
            System.out.println(b + " (binary) = " + binaryToDecimal(b) + " (decimal)");
        }
    }
}
