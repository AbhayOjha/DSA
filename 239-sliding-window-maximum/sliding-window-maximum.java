class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || nums == null || k <= 0){
            return new int[0];
        }

        int[] res = new int[n-k+1];
        int resIdx = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        for(int right = 0; right<n; right++){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[right]){
                dq.pollLast();
            }
            dq.offerLast(right);

            if(dq.peekFirst() <= right-k){
                dq.pollFirst();
            }

            if(right >= k-1){
                res[resIdx] = nums[dq.peekFirst()];
                resIdx++;
            }

        }
        return res;
    }
}