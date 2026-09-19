class Solution {

    public static final Random RAND = new Random();

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n: nums){
            freq.merge(n, 1, Integer::sum);
        }

        // creating new array with unique elements
        int size = freq.size();
        int[] unique = new int[size];
        int idx = 0;
        for(int key: freq.keySet()){
            unique[idx++] = key;
        }

        quickselect(unique, 0, size-1, size-k, freq);
        return Arrays.copyOfRange(unique, size-k, size);
    }

    public void quickselect(int[] arr, int low, int high, int target, Map<Integer, Integer> freq){
        if(low >= high) return;
        int pivotIdx = randomPivot(arr, low, high, freq);
        if(pivotIdx == target) return;
        quickselect(arr, low, pivotIdx-1, target, freq);
        quickselect(arr, pivotIdx+1, high, target, freq);
    }

    public int partition(int[] arr, int low, int high, Map<Integer, Integer> freq){
        int pivotFreq = freq.get(arr[high]);
        int i = low;
        for(int j=low; j<high; j++){
            if(freq.get(arr[j]) < pivotFreq){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    public int randomPivot(int[] arr, int low, int high, Map<Integer, Integer> freq){
        int idx = low + RAND.nextInt(high-low+1);
        swap(arr, idx, high);
        return partition(arr, low, high, freq);
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}