package Ishank;
import java.util.*;
public class CompressDecompress {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your choice(1-Compress, 2-Decompress)");
        int a=sc.nextInt(), o=0, l=0;
        String r="";
        switch(a){
            case 1:
                String q=sc.nextLine();
                System.out.println("Enter the sentence");
                String w=sc.nextLine();
                compress(w);
                break;
            case 2:
                System.out.println("Enter the number of different words in a sentence");
                int b=sc.nextInt();
                String[] words=new String[b];
                String[] c=new String[b];
                for (int i = 0; i < b; i++) {
                    System.out.println("Enter the "+(i+1)+"th word");
                    words[i]=sc.next();
                    System.out.println("Enter the positions with commas");
                    c[i]=sc.next();
                    StringTokenizer st=new StringTokenizer(c[i],",");
                    l=l+st.countTokens();
                }
                decompress(words,c,l);
                break;
            default:
                System.out.println("Oho...Wrong Choice!");
        }
    }
    static void compress(String w){
        StringTokenizer st=new StringTokenizer(w);
        String[] e=new String[st.countTokens()];
        for (int i = 0; i < e.length; i++) {
            e[i]=st.nextToken();
        }
        for (int i = 0; i < e.length; i++) {
            if(e[i].equals(""))
                continue;
            System.out.print(e[i].toUpperCase()+" appears at postions "+(i+1));
            for (int j = i+1; j < e.length; j++) {
                if(e[j].equals(""))
                    continue;
                if(e[i] .equalsIgnoreCase (e[j])){
                    System.out.print(", "+(j+1));
                    e[j]="";
                }
            }
            System.out.println();
        }
    }
    static void decompress(String[] words, String[] c, int length){
        String[] arr=new String[length];
        String y="";
        for (int i = 0; i < words.length; i++) {
            StringTokenizer st=new StringTokenizer(c[i],",");
            while(st.hasMoreElements()){
            int a=Integer.parseInt(st.nextToken());
            arr[a-1]=words[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            y=y+arr[i]+" ";
        }
        System.out.println("The final sentence is-\n"+y);
    }
}
