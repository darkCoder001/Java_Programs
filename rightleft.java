package Ishank;

import java.util.Scanner;
public class rightleft {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the rows");
        int r=sc.nextInt();
        System.out.println("Enter the length of the columns");
        int c= sc.nextInt();
        String s="", q=sc.nextLine();
        char[][] arr=new char[r][c];
        for (int i = 0; i < r; i++) {
            s=sc.nextLine();
            for (int j = 0; j < c; j++) {
                arr[i][j]=s.charAt(j);
            }
        }
        boolean w=huihui(arr);
        if(w)
            System.out.println("VICTORY!!");
        else
            System.out.println("Bhakk saale");




    }
    static boolean huihui(char[][] arr){
        if(arr[arr.length-1][arr[0].length-1]!='R')
            return false;
        if(arr[0][0]=='L' || arr[0][0]=='U')
            return false;
        int row=0, col=0;
        int[][] arr2 =new int[arr.length][arr[0].length];
        while (row >= 0 && row < arr.length && col >= 0 && col < arr[0].length) {
            if(row==arr.length-1 && col==arr[0].length-1)
                return true;
            if(arr[row][col]=='X')
                break;
            switch(arr[row][col]){
                case 'R':
                    arr[row][col]='X';
                    col++;
                    break;
                case 'L':
                    arr[row][col]='X';
                    col--;
                    break;
                case 'U':
                    arr[row][col]='X';
                    row--;
                    break;
                case 'D':
                    arr[row][col]='X';
                    row++;
                    break;
            }
        }
        return false;
    }
}
