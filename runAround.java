package Ishank;

import java.util.Scanner;
public class runAround {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length of array");
        int n=sc.nextInt(), d=1, i=0, e=0, a=0;
        int arr[]=new int[n];
        int q[]=new int[n];
        System.out.println("Enter the numbers one by one");
        for(i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int c=arr[0];
        for(i=0;i<n;i++){
            for(int x=0;x<c;x++){
                if(d>=n)
                    d=0;
                e=arr[d];
                d++;
            }
            q[i]=d-1;
            c=e;
        }
        for(i=0;i<n;i++){
            for(int x=0;x<n;x++){
                if(q[i]==q[x])
                    a++;
            }
            if(a>1){
                System.out.println("Not a run around");
                break;
            }
            a=0;
        }
        if(i==n)
            System.out.println("Run around");
    }
}
