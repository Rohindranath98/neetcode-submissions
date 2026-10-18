class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(n - 1, amount, coins, dp);

        return ans >= 1_000_000_000 ? -1 : ans;
    }

    private int solve(int index, int amount, int[] coins, int[][] dp){
        // Base case
        if (index == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            }
            return 1_000_000_000;
        }

        // Return cached result
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        // Choice 1: Do not take this coin
        int notTake = solve(index - 1, amount, coins, dp);

        // Choice 2: Take this coin (unlimited times)
        int take = 1_000_000_000;

        if (coins[index] <= amount) {
            take = 1 + solve(index, amount - coins[index], coins,dp);
        }

        return dp[index][amount] = Math.min(take, notTake);
    }
}
