class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] freq = new int[51];
        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            freq[nums[i]]++;
        }
        int res = -1;
        for(int i=0; i<nums.length; i++){
            if(k == n || (freq[nums[i]] == 1 && (i==0 || i == n-1 || k==1))){
                res = Math.max(res, nums[i]);
            }
        }
        return res;
    }
}