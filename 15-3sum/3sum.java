class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-2; i++){
            if(i>0 && nums[i] == nums[i-1]) // if same as previous to avoid duplicate
                continue;
            
            if(nums[i] > 0)     // if first number is positive them further will also be positive then can't be 0
                break;

            int left = i+1;
            int right = n-1;
            int target = -nums[i];
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum == target){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left<right && nums[left] == nums[left+1]){     //to avoid duplicate
                        left++;
                    }
                    while(left<right && nums[right] == nums[right-1]){     //to avoid duplicate
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(sum > target){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return res;
    }
}