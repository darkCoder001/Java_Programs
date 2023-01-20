package Ishank;

import java.util.Arrays;
import java.util.Scanner;
public class ConnectingDots {
    public static void main(String[] args) {
        System.out.println("This is a 2 player Game.");
        System.out.println("Player 1 gets green colour");
        System.out.println("Player 2 gets red colour");
        System.out.println("First person to connect 4 dots wins the game.");
        System.out.println();
        System.out.println("So lets start------>");
        System.out.println();
        int s = game();
        if (s == 1)
            System.out.println("Red Wins!!");
        else if (s == 0)
            System.out.println("Green Wins!!");
        else
            System.out.println("Hard luck, Both of You lose!!");
    }

    static int game() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row length");
        int r = sc.nextInt();
        System.out.println("Enter the column length");
        int c = sc.nextInt(), a = 0, o = 0, s1;
        char m;
        char[][] g = new char[r][c];
        int row = r - 1, col, x, s2;
        do {
            System.out.println("Enter the column number");
            col = sc.nextInt();
            if (o % 2 == 0)
                m = 'G';
            else
                m = 'R';
                o++;
                s1 = col;
                s2 = row;
                for (x = g.length - 1; x >= 0; x--) {
                    if (g[x][col] == 'G' || g[x][col] == 'R') {
                        continue;
                    } else {
                        g[x][col] = m;
                        for (int i = 0; i < g.length; i++) {
                            System.out.println(Arrays.toString(g[i]));
                        }
                    }
                    break;
                }
                if (x < 0) {
                    System.out.println("Column Full, choose another");
                    o--;
                    continue;
                }
                switch (g[x][col]) {
                    case 'G':
                        for (int i = x; i < g.length; i++) {
                            if (g[i][col] == 'G')
                                a++;
                            else break;
                        }
                        if (a >= 4) {
                            return 0;
                        }
                        a = 0;
                        for (int i = x; i < g.length; i++) {
                            if (g[i][s1] == 'G') {
                                a++;
                                if (s1 != g[0].length - 1)
                                    s1++;
                            } else break;
                        }
                        if (a >= 4)
                            return 0;
                        s1=col;
                        a = 0;
                        for (int i = x; i < g.length; i++) {
                            if (g[i][s1] == 'G') {
                                a++;
                                if (s1 != 0)
                                    s1--;
                            } else break;
                        }
                        if (a >= 4)
                            return 0;
                        s1=col;
                        a = 0;
                        for (int i = 0; i <= x; i++) {
                            if(g[s2][i]=='G')
                                a++;
                            else break;
                        }
                        if(a >= 4)
                            return 0;
                        for (int i = x; i < g[0].length; i++) {
                            if(g[s2][i]=='G')
                                a++;
                            else break;
                        }
                        if(a >= 4)
                            return 0;
                        a=0;
                        s1=col;
                        break;
                    case 'R':
                        for (int i = x; i < g.length; i++) {
                            if (g[i][col] == 'R')
                                a++;
                            else break;
                        }
                        if (a == 4) {
                            return 1;
                        }
                        a = 0;
                        s1 = col;
                        for (int i = x; i < g.length; i++) {
                            if (g[i][s1] == 'R') {
                                a++;
                                if (s1 != g[0].length - 1)
                                    s1++;
                            } else break;
                        }
                        if (a == 4)
                            return 1;
                        a = 0;
                        s1 = col;
                        for (int i = 0; i < g.length; i++) {
                            if (g[i][s1] == 'R') {
                                a++;
                                if (s1 != 0)
                                    s1--;
                            } else break;
                        }
                        if (a == 4)
                            return 1;
                        a = 0;
                        s1 = col;
                        for (int i = 0; i <= x; i++) {
                            if(g[s2][i]=='R')
                                a++;
                            else break;
                        }
                        if(a >= 4)
                            return 1;
                        for (int i = x; i < g[0].length; i++) {
                            if(g[s2][i]=='R')
                                a++;
                            else break;
                        }
                        if(a >= 4)
                            return 1;
                        a=0;
                        break;
                }
            }
            while (o < (r * c)) ;
            return -1;

    }
}
