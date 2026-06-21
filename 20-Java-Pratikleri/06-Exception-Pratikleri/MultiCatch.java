public class MultiCatch {

    static int bolme(int a, int b) {
        return a / b;
    }

    static String diziElemanAl(String[] dizi, int index) {
        return dizi[index].toUpperCase();
    }

    static int stringeSayiyaCevir(String metin) {
        return Integer.parseInt(metin);
    }

    public static void main(String[] args) {

        // Multi-catch (Java 7+)
        System.out.println("=== Multi-Catch ===");
        Object[] testler = {10, 0, null, "abc", "123"};

        for (Object t : testler) {
            try {
                if (t instanceof Integer) {
                    System.out.println("10 / " + t + " = " + bolme(10, (int) t));
                } else {
                    System.out.println(stringeSayiyaCevir((String) t));
                }
            } catch (ArithmeticException | NumberFormatException e) {
                System.out.println("[Multi-catch] " + e.getClass().getSimpleName() + ": " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("[NullPointer] Null değer!");
            }
        }

        // Try-with-resources (kaynak otomatik kapatma)
        System.out.println("\n=== Zincirlenmiş Exception ===");
        try {
            String[] dizi = {"Java", "Python", null, "C++"};
            for (int i = 0; i <= dizi.length; i++) {
                try {
                    System.out.println(i + ". eleman: " + diziElemanAl(dizi, i));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Index sınırı: " + i + " >= " + dizi.length);
                } catch (NullPointerException e) {
                    System.out.println("Index " + i + " null değer!");
                }
            }
        } catch (Exception e) {
            System.out.println("Beklenmedik hata: " + e.getMessage());
        }

        System.out.println("\nProgram başarıyla tamamlandı.");
    }
}
