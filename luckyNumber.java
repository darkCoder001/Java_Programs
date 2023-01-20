package Ishank;

import java.util.Scanner;
public class luckyNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of array");
        int N=sc.nextInt();
        int s=N;
        int arr[]= new int[N];
        System.out.println("Enter the numbers");
        for(int x=0;x<N;x++){
            arr[x]=sc.nextInt();
        }
        int c=arr[0], a=1, q=0, d=0;
        N=N-1;
        arr[0]=0;
        for(int x=0;x<(N-1);x++){
            if(c>(N))
                c=c%(N);
            q=0;
            for(int y=0;y<c;y++){
                d=arr[a];
                if(d==0)
                    y--;
                a++;
                if(a>s)
                    a=0;
            }
            c=d;
            arr[a]=0;
            --N;
            if(N==1)
                break;
        }
        for(int x=0;x<N;x++){
            if(arr[x]!=0)
                System.out.print("The Lucky Number is "+arr[x]+" at index "+x);
        }
    }
}
