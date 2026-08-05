// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class Main {
    static Set<Integer> fib = new HashSet<>();
    private static void generateFib(int n){
        int fib1 = 1;
        int fib2 = 1;
        while(fib1 < n){
            fib.add(fib1);
            int temp = fib1+fib2;
            fib2 = fib1;
            fib1 = temp;
        } 
    }
    private static int climb(int n, int a, int b){
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer. MAX_VALUE);
        dp[1] = 0;
        for(int i = 1; i <= n; i++){
            for(int fibVal: fib){
                if (dp[i] == Integer.MAX_VALUE) continue;
                if(i+fibVal <= n){
                    dp[i+fibVal] = Math.min(dp[i+fibVal], dp[i] + (a + b * fibVal) );
                    System.out.println((i+fibVal)+ ":" + dp[i+fibVal]);
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        // System.out.println("Start small. Ship something.");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a = s.nextInt();
        int b = s.nextInt();
        generateFib(n);
        System.out.println(climb(n,a,b));
    }
}
