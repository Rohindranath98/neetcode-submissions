class Solution {
    public int lengthOfLIS(int[] nums) {
      int n = nums.length;
        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, -1, nums, dp);
    }

    private int solve(int index, int prevIndex, int[] nums, int[][] dp) {
        // Base case
        if (index == nums.length) {
            return 0;
        }

        // Shift prevIndex by 1 because it can be -1
        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        // Choice 1: Do not take the current element
        int notTake = solve(index + 1, prevIndex, nums, dp);

        // Choice 2: Take the current element if increasing
        int take = 0;

        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + solve(index + 1, index, nums, dp);
        }

        return dp[index][prevIndex + 1] = Math.max(take, notTake);  
    }
}
