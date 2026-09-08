class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for(int i=1; i<nums.length; i++){
            int cur = nums[i];
            if(cur < 0){
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            maxProd = Math.max(cur, cur * maxProd);
            minProd = Math.min(cur, cur * minProd);
            result = Math.max(result, maxProd);
        }
        return result;
    }
}