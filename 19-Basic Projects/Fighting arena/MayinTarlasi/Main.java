import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row , column;
        System.out.println("Mayin tarlasi oyunuma hosgeldiniz:");
        System.out.println("Lutfen oynamak istediginiz boyulari giriniz:");
        System.out.print("Satir sayisi : ");
        row = input.nextInt();
        System.out.print("Sutun sayisini giriniz : ");
        column = input.nextInt();

        MiniMayinTarlasi mayin = new MiniMayinTarlasi(row, column);
        mayin.run();
    }
}
