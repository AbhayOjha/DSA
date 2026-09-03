class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int minLen = Integer.MAX_VALUE;
        int n = nums.length;
        int winSum = 0;
        int left = 0;
        for(int right = 0; right<n; right++){
            winSum += nums[right];
            while(winSum >= target){
                minLen = Math.min(minLen, right-left+1);
                winSum -= nums[left];
                left++;
            }
        }
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }
}