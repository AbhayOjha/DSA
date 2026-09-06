class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int result = Integer.MIN_VALUE;

        for(int left = 0; left < cols; left++){
            int[] rowSum = new int[rows];

            for(int right = left; right < cols; right++){
                for(int i=0; i<rows; i++){
                    rowSum[i] += matrix[i][right]; 
                }
                result = Math.max(result, maxSubarrayNoLargerThanK(rowSum, k));
            } 
            if(result == k){
                return result;
            }
        }
        return result;
    }

    public int maxSubarrayNoLargerThanK(int[] arr, int k){
        TreeSet<Integer> prefixSum = new TreeSet<>();
        prefixSum.add(0);
        int curSum = 0;
        int best = Integer.MIN_VALUE;

        for(int num: arr){
            curSum += num;

            Integer ceiling = prefixSum.ceiling(curSum - k);
            if(ceiling != null){
                best = Math.max(best, curSum - ceiling);
            }
            prefixSum.add(curSum);
        }
        return best;
    }
}