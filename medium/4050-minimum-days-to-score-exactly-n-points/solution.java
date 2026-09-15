class Solution {
    public int minDays(int n) {
        int INF = 1_000_000;

        // dp[i] = minimum (earning days + skips)
        // needed to get exactly i points
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int k = 1; k * (k + 1) / 2 <= n; k++) {
            int points = k * (k + 1) / 2;

            for (int i = points; i <= n; i++) {
                dp[i] = Math.min(dp[i], dp[i - points] + k + 1);
            }
        }

        // There is no skip after the final streak
        return dp[n] - 1;
    }
}