class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        int n = nums.length;
        for(int j=0; j<n; j++){
            while(i<n && nums[i] != 0){
                i++;
            }
            while(j<n && nums[j] == 0){
                j++;
            }
            if(i<n && j<n && i<j){
                nums[i] = nums[j];
                nums[j] = 0;
            }

        }
    }
}