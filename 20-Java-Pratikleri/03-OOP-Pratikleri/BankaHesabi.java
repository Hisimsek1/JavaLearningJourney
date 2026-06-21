public class BankaHesabi {

    private String hesapNo;
    private String sahip;
    private double bakiye;

    public BankaHesabi(String hesapNo, String sahip, double ilkBakiye) {
        this.hesapNo = hesapNo;
        this.sahip = sahip;
        this.bakiye = ilkBakiye;
    }

    public void para_yatir(double miktar) {
        if (miktar <= 0) {
            System.out.println("Geçersiz miktar!");
            return;
        }
        bakiye += miktar;
        System.out.printf("%s hesabına %.2f TL yatırıldı. Yeni bakiye: %.2f TL%n", sahip, miktar, bakiye);
    }

    public void para_cek(double miktar) {
        if (miktar <= 0) {
            System.out.println("Geçersiz miktar!");
            return;
        }
        if (miktar > bakiye) {
            System.out.println("Yetersiz bakiye! Mevcut bakiye: " + bakiye + " TL");
            return;
        }
        bakiye -= miktar;
        System.out.printf("%s hesabından %.2f TL çekildi. Kalan bakiye: %.2f TL%n", sahip, miktar, bakiye);
    }

    public void havale(BankaHesabi hedef, double miktar) {
        if (miktar > bakiye) {
            System.out.println("Havale için yetersiz bakiye!");
            return;
        }
        this.bakiye -= miktar;
        hedef.bakiye += miktar;
        System.out.printf("%.2f TL, %s'dan %s'a havale edildi.%n", miktar, this.sahip, hedef.sahip);
    }

    public void bilgiGoster() {
        System.out.printf("[%s] %s -> Bakiye: %.2f TL%n", hesapNo, sahip, bakiye);
    }

    public static void main(String[] args) {
        BankaHesabi hesap1 = new BankaHesabi("TR001", "Ali Veli", 5000);
        BankaHesabi hesap2 = new BankaHesabi("TR002", "Ayşe Yılmaz", 2000);

        hesap1.bilgiGoster();
        hesap2.bilgiGoster();

        System.out.println();
        hesap1.para_yatir(3000);
        hesap1.para_cek(1500);
        hesap1.havale(hesap2, 2000);

        System.out.println();
        hesap1.bilgiGoster();
        hesap2.bilgiGoster();
    }
}
