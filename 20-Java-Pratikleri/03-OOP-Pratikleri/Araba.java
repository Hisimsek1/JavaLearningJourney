public class Araba {

    private String marka;
    private String model;
    private int yil;
    private double fiyat;
    private int hiz;

    public Araba(String marka, String model, int yil, double fiyat) {
        this.marka = marka;
        this.model = model;
        this.yil = yil;
        this.fiyat = fiyat;
        this.hiz = 0;
    }

    public void hizlan(int miktar) {
        hiz += miktar;
        System.out.println(marka + " " + model + " hızlandı -> " + hiz + " km/s");
    }

    public void frenle(int miktar) {
        hiz = Math.max(0, hiz - miktar);
        System.out.println(marka + " " + model + " yavaşladı -> " + hiz + " km/s");
    }

    public void bilgiGoster() {
        System.out.println("----------------------------");
        System.out.println("Marka : " + marka);
        System.out.println("Model : " + model);
        System.out.println("Yıl   : " + yil);
        System.out.printf ("Fiyat : %.2f TL%n", fiyat);
        System.out.println("Hız   : " + hiz + " km/s");
    }

    // Getter & Setter
    public String getMarka() { return marka; }
    public double getFiyat() { return fiyat; }
    public void setFiyat(double fiyat) { this.fiyat = fiyat; }

    public static void main(String[] args) {
        Araba a1 = new Araba("Toyota", "Corolla", 2022, 850000);
        Araba a2 = new Araba("BMW", "320i", 2023, 2100000);

        a1.bilgiGoster();
        a1.hizlan(60);
        a1.hizlan(40);
        a1.frenle(30);
        a1.bilgiGoster();

        System.out.println();
        a2.bilgiGoster();
    }
}
