class Solution {
    public int longestConsecutive(int[] num) {
        int[] nums = Arrays.stream(num)
                                    .distinct()
                                    .sorted()
                                    .toArray();
        if(nums.length == 0)
            return 0;
        int maxCount = 1;
        int n = nums.length;
        for(int i=1; i<n; i++){
            int count = 1;
            if(nums[i] == nums[i-1]+1){
                while(i<n && nums[i] == nums[i-1]+1){
                    count++;
                    i++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}