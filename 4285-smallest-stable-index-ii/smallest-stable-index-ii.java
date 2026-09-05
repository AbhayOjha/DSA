class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int [] minArr = new int[n];
        int min = nums[n-1];
        for(int i=n-1; i>=0; i--){
            min = Math.min(min, nums[i]);
            minArr[i] = min;                    // [0,0,1,4]
        }

        int max = nums[0];
        int minIdx = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
            int diff = max - minArr[i];
            if(diff <= k){
                minIdx = Math.min(minIdx, i);
            }
        }
        return minIdx == Integer.MAX_VALUE ? -1 : minIdx;

    }
}