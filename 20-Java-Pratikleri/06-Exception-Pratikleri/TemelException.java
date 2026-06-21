public class TemelException {
    public static void main(String[] args) {

        // ArithmeticException
        System.out.println("=== ArithmeticException ===");
        try {
            int sonuc = 10 / 0;
            System.out.println("Sonuç: " + sonuc);
        } catch (ArithmeticException e) {
            System.out.println("Hata yakalandı: " + e.getMessage());
        }

        // ArrayIndexOutOfBoundsException
        System.out.println("\n=== ArrayIndexOutOfBoundsException ===");
        try {
            int[] dizi = {1, 2, 3};
            System.out.println(dizi[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Dizi sınırı aşıldı: " + e.getMessage());
        }

        // NullPointerException
        System.out.println("\n=== NullPointerException ===");
        try {
            String metin = null;
            System.out.println(metin.length());
        } catch (NullPointerException e) {
            System.out.println("Null pointer hatası yakalandı!");
        }

        // NumberFormatException
        System.out.println("\n=== NumberFormatException ===");
        try {
            int sayi = Integer.parseInt("abc123");
        } catch (NumberFormatException e) {
            System.out.println("Sayı formatı hatası: " + e.getMessage());
        }

        // ClassCastException
        System.out.println("\n=== ClassCastException ===");
        try {
            Object nesne = "Merhaba";
            Integer sayi = (Integer) nesne;
        } catch (ClassCastException e) {
            System.out.println("Cast hatası yakalandı!");
        }

        // finally bloğu
        System.out.println("\n=== Finally Bloğu ===");
        try {
            System.out.println("Try bloğu çalışıyor");
            int x = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Catch bloğu: " + e.getMessage());
        } finally {
            System.out.println("Finally bloğu HER ZAMAN çalışır");
        }

        System.out.println("\nProgram devam ediyor...");
    }
}
