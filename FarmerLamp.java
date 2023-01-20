package Ishank;

import java.sql.SQLOutput;
import java.util.*;
public class FarmerLamp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the length of the row");
        int row = scan.nextInt();
        System.out.println("Enter the length of column");
        int col = scan.nextInt();
        int[][] arr = new int[row][col];
        int r = position(arr);
        System.out.println("There are " + r + " unused lamps.");

    }

    static int position(int[][] arr) {
        Scanner sc = new Scanner(System.in);
        char[][] back=new char[arr.length][arr[0].length];
        char c;
        int t=0;
        do {
            t++;
            System.out.println("Enter the position of lamp");
            String s = sc.nextLine();
            int row = (int) (s.charAt(0)) - 48;
            int col = (int) (s.charAt(s.length() - 1)) - 48;
            arr[row][col] = arr[row][col] + 10;
            back[row][col]='!';
            for (int i = row - 1; i <= row + 1; i++) {
                if (i >= 0 && i < arr.length) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (j >= 0 && j < arr[0].length) {
                            arr[i][j]++;
                        }
                    }
                }
            }
            System.out.println("Do You want anymore lamps? (Y-yes, N-no)");
            c = sc.next().charAt(0);
            String q = sc.nextLine();
        } while (c == 'Y');
        int l = 0, k = 0, d = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] >= 10) {
                    arr[i][j] = arr[i][j] - 10;
abc:                    for (k = i - 1; k <= i + 1; k++) {
    if (k >= 0 && k < arr.length) {
        for (l = j - 1; l <= j + 1; l++) {
            if (l >= 0 && l < arr[0].length) {
                arr[k][l]--;
                if (arr[k][l] == 0) {
                    d++;
                    back[i][j]='X';
                    break abc;
                }
            }
        }
    }
}
                }
            }
       }
        for (int i = 0; i < back.length; i++) {
            System.out.println(Arrays.toString(back[i]));
        }
        System.out.println("Here 'X' signifies the useful lamps and '!' signifies unused lamps.");
        return t-d;
    }
}

