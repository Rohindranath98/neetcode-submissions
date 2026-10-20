class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Add 1 at both boundaries
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(1, n, arr, dp);
    }

    private int solve(int i, int j, int[] arr, int[][] dp) {

        // No balloons left in this range
        if (i > j) {
            return 0;
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int maxCoins = 0;

        // Try every balloon as the last balloon to burst
        for (int k = i; k <= j; k++) {

            int coins = arr[i - 1] * arr[k] * arr[j + 1];

            int leftCoins = solve(i, k - 1, arr, dp);
            int rightCoins = solve(k + 1, j, arr, dp);

            int totalCoins = coins + leftCoins + rightCoins;

            maxCoins = Math.max(maxCoins, totalCoins);
        }

        return dp[i][j] = maxCoins;
    }
}
