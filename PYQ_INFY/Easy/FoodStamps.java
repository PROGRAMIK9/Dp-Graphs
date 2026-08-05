// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class Main {
    private static long countMeals(int n, int v[], int[] d, long mid){
        int meals = 0;
        for(int i = 0; i < n; i++){
            if(v[i]>=mid){
                meals+= (v[i]-mid/d[i])+1;
            }
        }
        return meals;
    }
    private static long maxEat(int n, int m, int[] v, int[] d){
       long bestThreshold = 0;
       long low = 0, high = 1_000_000_000;
       while(low<high){
           long mid = low +(high-low)/2;
           if(countMeals(n,v,d,mid)>=m){
               bestThreshold = mid;
               low = mid+1;
           }else{
               high = mid-1;
           }
       }
       long totalScore  = 0;
       long meals = 0;
       for(int i = 0; i < n; i++){
           if(v[i] > bestThreshold){
               long k = ((v[i] - bestThreshold)/d[i])+1;
               meals+=k;
               totalScore = (k * (2*v[i] - ((k-1) * d[i]))/2);
           }
       }
       long remaining = Math.min(n-meals, countMeals(n,v,d,bestThreshold)-meals);
       totalScore += remaining*bestThreshold;
       return totalScore;
       
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] v = new int[n];
        for(int i= 0; i<n; i++){
            v[i] = s.nextInt();
        }
        int[] d = new int[n];
        for(int i = 0; i<n;i++){
            d[i] = s.nextInt();
        }
        System.out.println(maxEat(n,m,v,d));
    }
}
