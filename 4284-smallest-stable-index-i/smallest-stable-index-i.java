class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minArr = new int[n];
        minArr[n-1] = nums[n-1];
        int curMin = nums[n-1];
        for(int i = n-2; i>= 0; i--){
            curMin = Math.min(curMin, nums[i]);
            minArr[i] = curMin;
        }

        int curMax = nums[0];
        for(int i=0; i<n; i++){
            curMax = Math.max(curMax, nums[i]);
            if(curMax - minArr[i] <= k){
                return i;
            }
        }
        return -1;
    }
}