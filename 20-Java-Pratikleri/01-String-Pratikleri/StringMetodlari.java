public class StringMetodlari {
    public static void main(String[] args) {

        String metin = "Merhaba Java Dünyası";

        System.out.println("Orijinal: " + metin);
        System.out.println("Büyük harf: " + metin.toUpperCase());
        System.out.println("Küçük harf: " + metin.toLowerCase());
        System.out.println("Uzunluk: " + metin.length());
        System.out.println("3. karakter: " + metin.charAt(3));
        System.out.println("'Java' içeriyor mu: " + metin.contains("Java"));
        System.out.println("'Java' başlangıç index: " + metin.indexOf("Java"));
        System.out.println("Alt string (0-7): " + metin.substring(0, 7));
        System.out.println("Boşluk sayısı: " + (metin.length() - metin.replace(" ", "").length()));

        String[] parcalar = metin.split(" ");
        System.out.print("Kelimeler: ");
        for (String kelime : parcalar) {
            System.out.print("[" + kelime + "] ");
        }
        System.out.println();

        String yeni = metin.replace("Java", "Python");
        System.out.println("Değiştirilen: " + yeni);
    }
}
