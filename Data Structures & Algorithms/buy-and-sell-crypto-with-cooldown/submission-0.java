class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 1, prices, dp);
    }

    private int solve(int index, int canBuy, int[] prices, int[][] dp) {
        // Base case: no days left
        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][canBuy] != -1) {
            return dp[index][canBuy];
        }

        int profit;

        if (canBuy == 1) {
            // Choice 1: Buy the stock
            int buy = -prices[index] + solve(index + 1, 0, prices, dp);

            // Choice 2: Skip buying
            int skip = solve(index + 1, 1, prices, dp);

            profit = Math.max(buy, skip);
        } else {
            // Choice 1: Sell the stock, then cool down
            int sell = prices[index] + solve(index + 2, 1, prices, dp);

            // Choice 2: Hold the stock
            int hold = solve(index + 1, 0, prices, dp);

            profit = Math.max(sell, hold);
        }

        return dp[index][canBuy] = profit;
    }
}