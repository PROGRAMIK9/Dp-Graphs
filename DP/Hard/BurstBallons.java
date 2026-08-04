class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] pad = new int[n+2];
        pad[0] =1;
        pad[n+1]=1;
        for(int i = 1; i<=n;i++){
            pad[i]=nums[i-1];
        }
        int dp[][] = new int[n+2][n+2];
        // int memo[][] = new int[n+2][n+2];
        for (int len = 1; len <= n; len++) {
    
            // Loop 2: The left boundary of the interval
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                
                // Loop 3: Testing every 'k' as the LAST balloon to burst in this interval
                for (int k = left; k <= right; k++) {
                    
                    dp[left][right] = Math.max(
                        dp[left][right], 
                        dp[left][k - 1] + dp[k + 1][right] + (pad[left - 1] * pad[k] * pad[right + 1])
                    );
                }
            }
        }
        // return dfs(pad, memo, 0, n+1);
        return dp[1][n];
    }
    private int dfs(int[] pad, int[][] memo, int left, int right){
        if(left+1 == right) return 0;
        if(memo[left][right]!=0) return memo[left][right];
        int max  = 0;
        for(int k = left+1; k<right; k++){
            int leftVal = dfs(pad, memo, left, k);
            int rightVal = dfs(pad, memo, k, right);
            int padval = pad[left]*pad[k]*pad[right];
            max = Math.max(max, leftVal+rightVal+padval);
        }
        return memo[left][right] = max;
       
    }
}s
