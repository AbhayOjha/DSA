class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remIdx = new HashMap<>();
        remIdx.put(0, -1);
        int preSum = 0;
        for(int i=0; i<nums.length; i++){
            preSum += nums[i];
            int rem = k == 0 ? preSum : preSum % k;
            if(remIdx.containsKey(rem)){
                if(i - remIdx.get(rem) >= 2){
                    return true;
                }
            } else{
                remIdx.put(rem, i);
            }
        }
        return false;
    }
}