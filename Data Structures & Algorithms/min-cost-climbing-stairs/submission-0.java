
class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return Math.min(
            solve(n - 1, cost, dp),
            solve(n - 2, cost, dp)
        );
    }

    public int solve(int index, int[] cost, int[] dp) {

        if (index == 0) {
            return cost[0];
        }

        if (index == 1) {
            return cost[1];
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int oneStep = cost[index] + solve(index - 1, cost, dp);

        int twoStep = cost[index] + solve(index - 2, cost, dp);

        return dp[index] = Math.min(oneStep, twoStep);
    }
}