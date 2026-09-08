class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int n = nums.length;
        if(n<=1){
            return;
        }
        for(int right = 0; right<n; right++){
            if(nums[right] != 0){
                if(left >= right){
                    left++;
                    continue;
                }
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
            }
        }
    }
}