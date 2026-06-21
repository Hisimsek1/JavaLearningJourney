// Özel exception sınıfı
class YasSiniriException extends Exception {
    private int girilenYas;

    public YasSiniriException(int yas) {
        super("Geçersiz yaş değeri: " + yas + ". Yaş 0-150 arasında olmalıdır.");
        this.girilenYas = yas;
    }

    public int getGirilenYas() {
        return girilenYas;
    }
}

class BakiyeYetersizException extends RuntimeException {
    private double mevcutBakiye;
    private double istenenMiktar;

    public BakiyeYetersizException(double mevcutBakiye, double istenenMiktar) {
        super(String.format("Yetersiz bakiye! Mevcut: %.2f TL, İstenen: %.2f TL", mevcutBakiye, istenenMiktar));
        this.mevcutBakiye = mevcutBakiye;
        this.istenenMiktar = istenenMiktar;
    }

    public double getEksikMiktar() {
        return istenenMiktar - mevcutBakiye;
    }
}

public class OzelException {

    static void yasKontrol(int yas) throws YasSiniriException {
        if (yas < 0 || yas > 150) {
            throw new YasSiniriException(yas);
        }
        System.out.println("Geçerli yaş: " + yas);
    }

    static void paraCek(double bakiye, double miktar) {
        if (miktar > bakiye) {
            throw new BakiyeYetersizException(bakiye, miktar);
        }
        System.out.printf("%.2f TL çekildi. Kalan: %.2f TL%n", miktar, bakiye - miktar);
    }

    public static void main(String[] args) {
        System.out.println("=== Özel Exception - YasSiniriException ===");
        int[] yaslar = {25, -5, 200, 30};
        for (int yas : yaslar) {
            try {
                yasKontrol(yas);
            } catch (YasSiniriException e) {
                System.out.println("Hata: " + e.getMessage());
                System.out.println("Girilen yaş: " + e.getGirilenYas());
            }
        }

        System.out.println("\n=== Özel Exception - BakiyeYetersizException ===");
        try {
            paraCek(500.0, 300.0);
            paraCek(500.0, 750.0);
        } catch (BakiyeYetersizException e) {
            System.out.println("Hata: " + e.getMessage());
            System.out.printf("Eksik miktar: %.2f TL%n", e.getEksikMiktar());
        }
    }
}
