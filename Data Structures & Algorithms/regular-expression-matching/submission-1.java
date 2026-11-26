class Solution {
    private Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        dp = new Boolean[m + 1][n + 1];

        return dfs(0, 0, s, p, m, n);
    }

    private boolean dfs(int i, int j, String s, String p, int m, int n) {

        // Pattern is finished:
        // String must also be finished
        if (j == n) {
            return i == m;
        }

        // Memoization
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // Check if current characters match
        boolean match = i < m &&
                (s.charAt(i) == p.charAt(j) ||
                 p.charAt(j) == '.');

        // If next pattern character is '*'
        if (j + 1 < n && p.charAt(j + 1) == '*') {

            // Choice 1: Skip character and '*'
            // '*' represents zero occurrences
            boolean skip = dfs(i, j + 2, s, p, m, n);

            // Choice 2: Consume one matching character
            // Keep j because '*' can match more characters
            boolean take = match &&
                    dfs(i + 1, j, s, p, m, n);

            dp[i][j] = skip || take;

        } else {

            // No '*': character must match exactly once
            dp[i][j] = match &&
                    dfs(i + 1, j + 1, s, p, m, n);
        }

        return dp[i][j];
    }
}