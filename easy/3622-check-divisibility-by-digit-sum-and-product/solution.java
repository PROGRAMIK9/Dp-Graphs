class Solution {
    public boolean checkDivisibility(int n) {
        int sum  = 0;
        int prod  = 1;
        int num = n;
        while(n != 0){
            int dig = n % 10;
            // if(dig == 0) return false;
            sum += dig;
            prod *= dig;
            n=n/10;
        }
        if(num % (sum+prod) == 0) return true;
        return false;
    }
}