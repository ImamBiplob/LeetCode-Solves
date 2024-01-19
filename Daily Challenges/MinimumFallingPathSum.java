import java.util.Arrays;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int ld = Integer.MAX_VALUE, rd = Integer.MAX_VALUE;
                int up = matrix[i][j] + dp[i - 1][j];

                if (j - 1 >= 0) {
                    ld = matrix[i][j] + dp[i - 1][j - 1];
                }
                if (j + 1 < m) {
                    rd = matrix[i][j] + dp[i - 1][j + 1];
                }

                dp[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }

        int minSum = dp[n - 1][0];
        for (int j = 1; j < m; j++) {
            minSum = Math.min(minSum, dp[n - 1][j]);
        }

        return minSum;
    }

    public int minFallingPathSum2(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int ans = Integer.MAX_VALUE;

        int[][] dp = new int[r][c];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for (int i = 0; i < c; i++) {
            ans = Math.min(ans, rec(0, i, matrix, dp));
        }

        return ans;
    }

    private int rec(int i, int j, int arr[][], int[][] dp) {
        if (i == arr.length)
            return 0;
        if (j < 0 || j >= arr[0].length)
            return Integer.MAX_VALUE;

        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];

        int ops1 = rec(i + 1, j - 1, arr, dp);
        int ops2 = rec(i + 1, j, arr, dp);
        int ops3 = rec(i + 1, j + 1, arr, dp);

        dp[i][j] = arr[i][j] + Math.min(ops1, Math.min(ops2, ops3));

        return dp[i][j];
    }
}
