
class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        // Case 1: Exclude first house
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);

        int case1 = solve(n - 1, 1, nums, dp1);

        // Case 2: Exclude last house
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);

        int case2 = solve(n - 2, 0, nums, dp2);

        return Math.max(case1, case2);
    }

    public int solve(int index, int start, int[] nums, int[] dp) {

        // Base case
        if (index < start) {
            return 0;
        }

        if (index == start) {
            return nums[start];
        }

        // Already calculated
        if (dp[index] != -1) {
            return dp[index];
        }

        // Pick current house
        int pick = nums[index] + solve(index - 2, start, nums, dp);

        // Not pick current house
        int notPick = solve(index - 1, start, nums, dp);

        return dp[index] = Math.max(pick, notPick);
    }
}