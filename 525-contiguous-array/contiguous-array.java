class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map= new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int preSum = 0;
        for(int i =0; i<nums.length; i++){
            preSum += (nums[i]==0) ? -1 : 1;
            if(map.containsKey(preSum)){
                maxLen = Math.max(maxLen, i - map.get(preSum));
            }else{
                map.put(preSum, i);
            }
        }
        return maxLen;
    }
}