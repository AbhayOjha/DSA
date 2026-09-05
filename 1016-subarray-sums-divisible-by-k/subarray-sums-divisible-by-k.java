class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        int count = 0;
        int preSum = 0;
        for(int i=0; i<nums.length; i++){
            preSum += nums[i];
            int rem = k==0 ? preSum : ((preSum % k) + k)%k;
            if(freq.containsKey(rem)){
                count += freq.get(rem);
                freq.put(rem, freq.get(rem)+1);
            }
            else{
                freq.put(rem, 1);
            }
        }
        return count;
    }
}