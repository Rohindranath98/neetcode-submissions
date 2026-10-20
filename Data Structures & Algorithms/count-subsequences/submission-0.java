class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, m - 1, s, t, dp);
    }

    private int solve(int i, int j, String s, String t, int[][] dp) {

        // All characters of t have been matched
        if (j < 0) {
            return 1;
        }

        // s is exhausted, but t still has characters
        if (i < 0) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If characters match, take both choices
        if (s.charAt(i) == t.charAt(j)) {
            int match = solve(i - 1, j - 1, s, t, dp);
            int skip = solve(i - 1, j, s, t, dp);

            return dp[i][j] = match + skip;
        }

        // If characters don't match, skip from s
        return dp[i][j] = solve(i - 1, j, s, t, dp);
    }
}
