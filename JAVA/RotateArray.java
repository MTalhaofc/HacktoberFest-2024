import java.util.* ;
import java.io.*;
class RotateArray {
    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int arr[]=new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i]=in.nextInt();
        }
        int r=in.nextInt();
        for(int i=0 ; i<r ; i++){
            int temp=arr[0];
            for(int j=1 ; j<n ; j++){
                arr[j-1]=arr[j];
            }
            arr[n-1]=temp;
        }
        for(int i=0 ; i<n ; i++){
            System.out.print(arr[i]+" ");
        }
    }
}

