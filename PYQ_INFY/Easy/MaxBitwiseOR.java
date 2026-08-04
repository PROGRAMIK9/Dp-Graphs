// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class Main {
    public static int maxBit(int n, int[] arr, int k){
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = arr[0];
        suffix[n-1] = arr[n-1];
        for(int i = 1; i < n; i++){
            int ind = n-1-i;
            prefix[i] = prefix[i-1] | arr[i];
            suffix[ind] =  suffix[ind+1] | arr[ind];
        }
        int maxVal = 0;
        for(int i = 0; i < n; i++){
            int bitwise = arr[i] << k;
            if(i > 0){
                bitwise |= prefix[i-1];
            }
            if(i < n-1){
                bitwise |= suffix[i+1];
            }
            maxVal = Math.max(maxVal, bitwise);
        }
        return maxVal;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = s.nextInt();
        }
        System.out.println("Enter the k:");
        int k = s.nextInt();
        System.out.println(maxBit(n,arr,k));
    }
}
