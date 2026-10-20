

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(m - 1, n - 1, dp);
    }

    private int solve(int i, int j, int[][] dp) {
        // Base case: starting cell
        if (i == 0 && j == 0) {
            return 1;
        }

        // Outside the grid
        if (i < 0 || j < 0) {
            return 0;
        }

        // Return cached result
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Come from above
        int up = solve(i - 1, j, dp);

        // Come from the left
        int left = solve(i, j - 1, dp);

        return dp[i][j] = up + left;
    }
}