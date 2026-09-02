class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        if(n==0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++){
            int l = i+1;
            int r = n-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r] > 0){
                    r--;
                }
                else if(nums[i]+nums[l]+nums[r] < 0){
                    l++;
                }
                else{
                    set.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }
            }     
        }
        return new ArrayList<>(set);
    }
}