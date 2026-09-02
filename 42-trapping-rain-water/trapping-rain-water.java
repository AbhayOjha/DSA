class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = height[0];
        int rightMax = height[n-1];
        int left = 0;
        int right = n-1;
        int water = 0;

        while(left<right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            water += leftMax - height[left];
            water += rightMax - height[right];
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return water;
        
    }
}