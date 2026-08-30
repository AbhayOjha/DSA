class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIdx = 0;
        int maxIdx = 0;

        for(int i=0; i<n; i++){
            if(nums[i] < min){
                min = nums[i];
                minIdx = i;
            }
            if(nums[i] > max){
                max = nums[i];
                maxIdx = i;
            }    
        }

        int leftIdx = Math.min(minIdx, maxIdx);
        int rightIdx = Math.max(minIdx, maxIdx);

        return Math.min(leftIdx+1+(n-rightIdx), Math.min(rightIdx+1, n-leftIdx));

    }
}