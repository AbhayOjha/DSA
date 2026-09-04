class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumFreq = new HashMap<>();
        sumFreq.put(0, 1);
        int count = 0;
        int curSum = 0;
        for(int i=0; i<nums.length; i++){
            curSum += nums[i];
            count += sumFreq.getOrDefault(curSum-k, 0);
            sumFreq.put(curSum, sumFreq.getOrDefault(curSum, 0)+1);
        }
        return count;
    }
}