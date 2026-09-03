class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        long windowSum = 0;
        long maxSum = 0;

        for (int right = 0; right < n; right++) {
            // Add current element to window
            windowSum += nums[right];
            freq.merge(nums[right], 1, Integer::sum);

            int left = right - k + 1;

            // Shrink window if it exceeds size k
            if (right >= k) {
                int outgoing = nums[left - 1];
                windowSum -= outgoing;
                int count = freq.merge(outgoing, -1, Integer::sum);
                if (count == 0) {
                    freq.remove(outgoing);
                }
            }

            // Check window of exact size k
            if (right >= k - 1 && freq.size() == k) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }

        return maxSum;
    }
}