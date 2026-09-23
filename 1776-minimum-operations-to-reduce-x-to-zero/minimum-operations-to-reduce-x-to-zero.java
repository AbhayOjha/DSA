class Solution {
    public int minOperations(int[] nums, int x) {
        // totalSum = x + k
        // k = totalSum - x
        int n = nums.length;

        int totalSum = 0;
        for(int i=0; i<n; i++){
            totalSum += nums[i];
        }

        int k = totalSum - x;
        int left = 0;
        int maxLen = -1;
        int curSum = 0;

        if(k < 0) return -1;
        
        for(int right = 0; right<n; right++){
            curSum += nums[right];
            while(curSum > k){
                curSum -= nums[left];
                left++;
            }
            if(curSum == k){
                maxLen = Math.max(right-left+1, maxLen);
            }
        }
        return maxLen == -1 ? -1 : n-maxLen;
    }
}