import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int s;
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int j=1;
            int k=j;
            
            s=a;
            for (j=1;j<=n;j++){
                s += k*b;
                System.out.print(s+" ");
                k*=2;
            }
            System.out.print(" \n");
        }
        
        in.close();
    }
}