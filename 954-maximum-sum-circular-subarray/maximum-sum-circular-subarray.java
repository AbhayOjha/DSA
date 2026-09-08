class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int curMin = nums[0];
        int curMax = nums[0];
        int total = nums[0];

        for(int i=1; i<nums.length; i++){
            //kadane for max
            curMax = Math.max(nums[i], curMax+nums[i]);
            maxSum = Math.max(maxSum, curMax);

            //kadane for min
            curMin = Math.min(nums[i], curMin+nums[i]);
            minSum = Math.min(minSum, curMin);

            total += nums[i];
        }

        if(maxSum < 0){
            return maxSum;
        }

        return Math.max(maxSum, total-minSum);

    }
}