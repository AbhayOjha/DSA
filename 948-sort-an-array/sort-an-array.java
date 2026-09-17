class Solution {

    public static final Random RAND = new Random();

    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length-1);
        return nums;
    }

    public void quicksort(int[] nums, int low, int high){
        if(low < high){
            int pivotIdx = randomPivot(nums, low, high);
            quicksort(nums, low, pivotIdx-1);
            quicksort(nums, pivotIdx+1, high);
        }
    }

    public int partition(int[] nums, int low, int high){
        if(low == high){
            return low;
        }
        int pivot = nums[high];
        int i = low-1;
        for(int j=low; j<high; j++){
            if(nums[j] < pivot){
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i+1, high);
        return i+1;
    }

    public int randomPivot(int[] nums, int low, int high){
        int pivotIdx = low + RAND.nextInt(high-low+1);
        swap(nums, pivotIdx, high);
        return partition(nums, low, high);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}