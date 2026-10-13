import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long minSum = 0;

        long[] squared = new long[n];

        for (int i = 0; i < n; i++) {
            squared[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squared);

        for (int i = 0; i < n; i++) {
            sum += squared[i];

            if (i < n / 2) {
                minSum += squared[i];
            }
        }

        return sum - 2 * minSum;
    }
}