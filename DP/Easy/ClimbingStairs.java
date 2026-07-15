class Solution {
    public int climbStairs(int n) {
        if(n<=3) return n;
        int dp[] = new int[46];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public int helper(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        // if(dp[n]!=0) return dp[n];
        // dp[n] = helper(n-1)+helper(n-2);
        // return dp[n];
        return 0;
    }
}
