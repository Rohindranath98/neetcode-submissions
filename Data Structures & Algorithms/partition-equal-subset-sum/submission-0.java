class Solution {
    public boolean canPartition(int[] nums) {
         int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        int n = nums.length;

        int[][] dp = new int[n][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n - 1, target, nums, dp);
    }

    private boolean solve(int index, int target, int[] nums, int[][] dp) {
        // Target reached
        if (target == 0) {
            return true;
        }
        // Only one element remains
        if (index == 0) {
            return nums[0] == target;
        }

        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }

        // Choice 1: Do not take current element
        boolean notTake = solve(index - 1, target, nums, dp);

        // Choice 2: Take current element if it does not exceed target
        boolean take = false;

        if (nums[index] <= target) {
            take = solve(index - 1, target - nums[index], nums, dp);
        }

        boolean result = take || notTake;

        dp[index][target] = result ? 1 : 0;

        return result;
    }
}
