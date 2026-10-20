class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if (Math.abs(target) > totalSum) {
            return 0;
        }

        if ((totalSum + target) % 2 != 0) {
            return 0;
        }

        int requiredSum = (totalSum + target) / 2;
        int n = nums.length;

        int[][] dp = new int[n][requiredSum + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, requiredSum, nums, dp);
    }

    private int solve(int index, int sum, int[] nums, int[][] dp) {
        // Base case
        if (index == 0) {
            if (sum == 0 && nums[0] == 0) {
                return 2;
            }

            if (sum == 0 || sum == nums[0]) {
                return 1;
            }

            return 0;
        }

        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }

        // Do not take the current element
        int notTake = solve(index - 1, sum, nums, dp);

        // Take the current element
        int take = 0;

        if (nums[index] <= sum) {
            take = solve(index - 1, sum - nums[index], nums, dp);
        }

        return dp[index][sum] = take + notTake;
    }
}