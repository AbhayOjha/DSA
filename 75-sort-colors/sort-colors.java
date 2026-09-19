class Solution {
    public void sortColors(int[] nums) {    //solving it through Dutch National Flag Algo
        int low = 0, mid = 0;
        int high = nums.length-1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{       // nums[mid] == 2
                swap(nums, mid, high); 
                high--;     // after swap mid is not checked so we will not increase mid
            }
        } 
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}