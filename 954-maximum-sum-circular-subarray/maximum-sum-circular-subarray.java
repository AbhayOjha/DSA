class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int total = 0;
        int curMax = 0;
        int curMin = 0;

        for(int i =0; i<nums.length; i++){
            // Kadane for max subarray
            curMax = Math.max(nums[i], curMax+nums[i]);
            maxSum = Math.max(maxSum, curMax);

            // Kadane for min subarray
            curMin = Math.min(nums[i], curMin+nums[i]);
            minSum = Math.min(minSum, curMin);

            total += nums[i];
        }
        if(maxSum < 0){     // if all elements are negative then total - minSum will 0 idicating false empty array so for that we return max sum as per plain Kadane
            return maxSum;
        }
        return Math.max(maxSum, total - minSum);
    }      //Plain Kadane -|        |- wrap around minimum subarray
}