public class PalindromeKontrol {

    public static boolean palindromeKontrol(String kelime) {
        kelime = kelime.toLowerCase().replaceAll("\\s+", "");
        String tersi = new StringBuilder(kelime).reverse().toString();
        return kelime.equals(tersi);
    }

    public static void main(String[] args) {
        String[] testler = {"kaşak", "racecar", "Merhaba", "level", "Java", "civic", "havah"};

        for (String test : testler) {
            System.out.printf("%-12s -> %s%n", test, palindromeKontrol(test) ? "Palindrom" : "Palindrom değil");
        }
    }
}
