public class StringBuilderPratik {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        sb.append("Merhaba");
        sb.append(", ");
        sb.append("Dünya!");
        System.out.println("Append: " + sb);

        sb.insert(7, " Güzel");
        System.out.println("Insert: " + sb);

        sb.delete(7, 13);
        System.out.println("Delete: " + sb);

        sb.reverse();
        System.out.println("Reverse: " + sb);

        sb.reverse();
        sb.replace(0, 7, "Selam");
        System.out.println("Replace: " + sb);

        System.out.println("Uzunluk: " + sb.length());

        // String'e dönüştür
        String sonuc = sb.toString();
        System.out.println("toString: " + sonuc);
    }
}
