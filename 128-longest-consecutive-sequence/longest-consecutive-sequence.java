class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;

        Set<Integer> hs = new HashSet<>();
        for(int n: nums){
            hs.add(n);
        }

        int maxCount = 1;
        for(int n: hs){
            if(!hs.contains(n-1)){
                int count = 1;
                while(hs.contains(n+1)){
                    count++;
                    n++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}