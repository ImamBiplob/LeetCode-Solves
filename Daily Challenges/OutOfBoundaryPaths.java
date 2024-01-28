public class OutOfBoundaryPaths {
    public int findPaths(int m, int n, int N, int x, int y) {
        final int M = 1000000000 + 7;
        int[][] dp = new int[m][n];
        dp[x][y] = 1;
        int count = 0;

        for (int moves = 1; moves <= N; moves++) {
            int[][] temp = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == m - 1)
                        count = (count + dp[i][j]) % M;
                    if (j == n - 1)
                        count = (count + dp[i][j]) % M;
                    if (i == 0)
                        count = (count + dp[i][j]) % M;
                    if (j == 0)
                        count = (count + dp[i][j]) % M;
                    temp[i][j] = (((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % M +
                            ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) % M) % M;
                }
            }
            dp = temp;
        }

        return count;
    }

    public Integer[][][] dp;
    public int mod = 1_000_000_000 + 7;
    public int m, n;

    public int findPaths2(int m, int n, int maxMove, int x, int y) {
        dp = new Integer[m][n][maxMove + 1];
        this.m = m;
        this.n = n;
        return helper(maxMove, x, y);
    }

    private int helper(int maxMove, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n)
            return 1;
        if (maxMove <= 0)
            return 0;
        if (dp[x][y][maxMove] != null) {
            return dp[x][y][maxMove];
        }
        int res = 0;

        res = (res + helper(maxMove - 1, x + 1, y)) % mod;
        res = (res + helper(maxMove - 1, x, y - 1)) % mod;
        res = (res + helper(maxMove - 1, x - 1, y)) % mod;
        res = (res + helper(maxMove - 1, x, y + 1)) % mod;

        dp[x][y][maxMove] = res;

        return res;
    }
}
