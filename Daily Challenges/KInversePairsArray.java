public class KInversePairsArray {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[1001][1001];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int x = 0; x <= Math.min(j, i - 1); x++) {
                    if (j - x >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - x]) % 1000000007;
                    }
                }
            }
        }

        return dp[n][k];
    }

    public int kInversePairs2(int n, int k) {
        final int MOD = 1000000007;
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    int val = (dp[i - 1][j] + MOD - (j - i >= 0 ? dp[i - 1][j - i] : 0)) % MOD;
                    dp[i][j] = (dp[i][j - 1] + val) % MOD;
                }
            }
        }

        return (dp[n][k] + MOD - (k > 0 ? dp[n][k - 1] : 0)) % MOD;
    }
}
