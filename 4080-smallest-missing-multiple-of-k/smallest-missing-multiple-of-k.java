class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int j=1;
        while(true){
            if(!set.contains(k*j))
                return k*j;
            else{
                j++;
            }
        }
    }
}