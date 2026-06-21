import java.util.Random;
import java.util.Scanner;

public class MiniMayinTarlasi {
    int rowNumber, colNumber;
    int size;
    int[][] map;
    int[][] board;
    boolean game = true;

    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    MiniMayinTarlasi(int rowNumber, int colNumber) {
        this.colNumber = colNumber;
        this.rowNumber = rowNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.size = rowNumber * colNumber;
    }

    public void check(int r, int c) {
        if (map[r][c] == 0) {
            if ((c < colNumber - 1) && (map[r][c + 1] == -1)) {
                board[r][c]++;
            }
            if ((r < rowNumber - 1) && (map[r + 1][c] == -1)) {
                board[r][c]++;
            }
            if ((r > 0) && (map[r - 1][c] == -1)) {
                board[r][c]++;
            }
            if ((c > 0) && (map[r][c - 1] == -1)) {
                board[r][c]++;
            }

            if (board[r][c] == 0) {
                board[r][c] = -2;
            }
        }
    }

    public void run() {
        OyunHazirligi();
        int row, col;
        System.out.println("Oyun basladiii ! ");

        while (game) {
            print(board);
            System.out.print("Satir sayisini giriniz : ");
            row = input.nextInt();
            System.out.print("Sutun sayisini giriniz : ");
            col = input.nextInt();

            if (row < 0 || row >= rowNumber || col < 0 || col >= colNumber) {
                System.out.println("Gecersiz koordinat girdiniz!");
                continue;
            }

            if (map[row][col] != -1) {
                check(row, col);
            } else {
                game = false;
                System.out.println("Oyunu Kaybettiniz !!");
            }
        }
    }

    public void OyunHazirligi() {
        int randRow, randCol, count = 0;
        while (count != (size / 4)) {
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(colNumber);

            if (map[randRow][randCol] != -1) {
                map[randRow][randCol] = -1;
                count++;
            }
        }
    }

    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] >= 0)
                    System.out.print(" ");
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }
}