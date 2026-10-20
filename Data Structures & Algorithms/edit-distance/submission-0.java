
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, m - 1, word1, word2, dp);
    }

    private int solve(int i, int j, String word1,
                      String word2, int[][] dp) {

        // If word1 is exhausted, insert remaining characters of word2
        if (i < 0) {
            return j + 1;
        }

        // If word2 is exhausted, delete remaining characters of word1
        if (j < 0) {
            return i + 1;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Characters match: no operation needed
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] =
                    solve(i - 1, j - 1, word1, word2, dp);
        }

        // Characters don't match: try all three operations

        // 1. Insert
        int insert = 1 + solve(i, j - 1, word1, word2, dp);

        // 2. Delete
        int delete = 1 + solve(i - 1, j, word1, word2, dp);

        // 3. Replace
        int replace = 1 + solve(i - 1, j - 1, word1, word2, dp);

        return dp[i][j] = Math.min(insert,
                            Math.min(delete, replace));
    }
}
