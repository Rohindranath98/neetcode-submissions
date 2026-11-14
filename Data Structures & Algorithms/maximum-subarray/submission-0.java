
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, solve(i, nums, dp));
        }

        return maxSum;
    }

    public int solve(int index, int[] nums, int[] dp) {
        if (index == 0) {
            return nums[0];
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index] + solve(index - 1, nums, dp);
        int startNew = nums[index];

        return dp[index] = Math.max(pick, startNew);
    }
}