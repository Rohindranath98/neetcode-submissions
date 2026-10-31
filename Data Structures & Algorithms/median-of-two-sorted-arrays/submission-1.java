class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always choose smaller array for binary search
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;

        int low = 0;
        int high = n;

        while (low <= high) {

            // Divide first array
            int cut1 = (low + high) / 2;

            // Divide second array
            int cut2 = (n + m + 1) / 2 - cut1;

            // Four boundary elements
            int left1 = (cut1 == 0) ?
                    Integer.MIN_VALUE : nums1[cut1 - 1];

            int right1 = (cut1 == n) ?
                    Integer.MAX_VALUE : nums1[cut1];

            int left2 = (cut2 == 0) ?
                    Integer.MIN_VALUE : nums2[cut2 - 1];

            int right2 = (cut2 == m) ?
                    Integer.MAX_VALUE : nums2[cut2];

            // Check whether partition is correct
            if (left1 <= right2 && left2 <= right1) {

                // Odd length
                if ((n + m) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // Even length
                return (Math.max(left1, left2) +
                        (double) Math.min(right1, right2)) / 2.0;
            }

            // Too many elements taken from nums1
            else if (left1 > right2) {
                high = cut1 - 1;
            }

            // Too few elements taken from nums1
            else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}