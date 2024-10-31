public class KadanesAlgorithm {
    /*
     * Kadane's Algorithm : Finds the maximum sum of a contiguous subarray in the given array.
     * 
     * Intuition: The algorithm iterates through the array, adding each element to a running sum.
     *            If the sum becomes negative, we reset it to zero, discarding that subarray as part of the answer.
     * 
     * Approach:
     * 1. Initialize maxSum as the smallest integer and currentSum as 0.
     * 2. Loop through the array:
     *      - Add each element to currentSum.
     *      - If currentSum > maxSum, update maxSum.
     *      - If currentSum < 0, reset it to zero.
     * 3. maxSum will hold the maximum subarray sum at the end.
     * 
     * Special Case: If explicitly mentioned that an empty subarray (sum = 0) is valid, we compare maxSum with 0 before returning.
     *               For example, if the array is {-1, -4, -5}, the answer would be 0 instead of -1, as the empty subarray is preferable.
     *   
     * Time Complexity: O(n) - Iterates through the array once.
     * 
     * Space Complexity: O(1) - Only uses a few variables for tracking the maximum sum.
     * 
     */

    public int maxSubArray(int[] nums, boolean allowEmptySubarray) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        if (nums.length == 0 && !allowEmptySubarray) {
            throw new IllegalArgumentException("Input array cannot be empty when allowEmptySubarray is false");
        }
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;  // Reset current sum to zero when negative.
            }
        }

        // If empty subarray is allowed, return the maximum of maxSum and 0.
        return allowEmptySubarray ? Math.max(maxSum, 0) : maxSum;
    }

    public static void main(String[] args) {
        KadanesAlgorithm obj = new KadanesAlgorithm();

        // Test case 1: Mixed positive and negative numbers
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max subarray sum for nums1 : " + obj.maxSubArray(nums1, false)); 
        // Expected output: 6 (subarray [4, -1, 2, 1])

        // Test case 2: All negative numbers
        int[] nums2 = {-3, -2, -1, -4};
        System.out.println("Max subarray sum for nums2 : " + obj.maxSubArray(nums2, false)); 
        // Expected output: -1 (subarray [-1])

        // Test case 3: All negative numbers with empty subarray consideration
        int[] nums3 = {-1, -4, -5};
        System.out.println("Max subarray sum for nums3 : " + obj.maxSubArray(nums3, true)); 
        // Expected output: 0 
    }
}
