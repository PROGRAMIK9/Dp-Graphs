class Solution {
    public long countCommas(long n) {
        if(n < 1000) return 0;
        long p = 1000, res = 0;
        while( p <= n){
            res += n - p +1;
            p *= 1000;
        }
        return res;
    }
}