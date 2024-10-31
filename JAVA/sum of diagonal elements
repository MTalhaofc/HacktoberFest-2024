import java.util.*;

public class sumofdiagonalelements {
    public static void main(String[]hg){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int [][] A=new int[size][size];
        int [] B = new int[2*size-1];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                A[i][j] = sc.nextInt();
            }
        } 
        int startrow=0;
        int l=0;
        int i=0;
        while(startrow<size){
            int k = 0;
            int y=l;
            while(k<=startrow && y>=0){
                B[i]+=A[k][y];
                k++;
                y--;
            }
            l++;
            i++;
            startrow++;
        }
        int startcolumn = size - 1;
        int f=1;
        while(startcolumn>0){
            int h = size-1;
            int n=f;
            while(h>0 && n<=size-1){
                 B[i]+=A[n][h];
                 h--;
                 n++;
            }
            i++;
            startcolumn--;
            f++;
        }
         for(int m=0;m<2*size-1;m++){
            System.out.print(B[m]+" ");
         }
         sc.close();
    }
}
