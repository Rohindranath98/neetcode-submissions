class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Step 1: Store prefix products
        res[0] = 1;

        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply by suffix products
        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * suffix;
            suffix *= nums[i];
        }

        return res;
    }
}