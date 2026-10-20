class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        long[][] dp = new long[n][amount + 1];

        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        long ans = solve(n - 1, amount, coins, dp);

        return (int) ans;
    }

    private long solve(int index, int target, int[] coins, long[][] dp) {
        // Base case
        if (index == 0) {
            return target % coins[0] == 0 ? 1 : 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        // Choice 1: Do not take this coin
        long notTake = solve(index - 1, target, coins, dp);

        // Choice 2: Take this coin
        long take = 0;
        if (coins[index] <= target) {
            take = solve(index, target - coins[index], coins, dp);
        }

        return dp[index][target] = take + notTake;
    }
}