class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Kth largest = (n-k)th smallest -> use QuickSelect
        return quickselect(nums, 0, nums.length-1, nums.length-k);
    }

    public int quickselect(int[] nums, int low, int high, int k){
        if(low == high){
            return nums[low];
        }
        int pivotIdx = randomIdx(nums, low, high);
        if(pivotIdx == k){
            return nums[pivotIdx];
        }
        else if(pivotIdx < k){
            return quickselect(nums, pivotIdx+1, high, k);
        }
        else{
            return quickselect(nums, low, pivotIdx-1, k);
        }
    }

    public int randomIdx(int[] nums, int low, int high){
        int pivotIdx = low + new Random().nextInt(high-low+1);
        swap(nums, pivotIdx, high);
        return partition(nums, low, high);
    }

     private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);   // pivot lands in its final sorted position
        return i;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}