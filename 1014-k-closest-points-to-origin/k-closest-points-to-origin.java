class Solution {

    private static final Random RAND = new Random();

    public int[][] kClosest(int[][] points, int k) {
        quickselect(points, 0, points.length-1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    public void quickselect(int[][] points, int low, int high, int k){
        if(low >= high) return;
        int pivotIdx = randomPivot(points, low, high);
        if(pivotIdx == k) return;
        if(pivotIdx < k){
            quickselect(points, pivotIdx+1, high, k);
        }
        else{
            quickselect(points, low, pivotIdx-1, k);
        }
    }

    public int partition(int[][] points, int low, int high){
        int[] pivot = points[high];
        int pivotDist = dist(pivot);
        int i = low;
        for(int j=low; j<high; j++){
            if(dist(points[j]) < pivotDist){
                swap(points, i, j);
                i++;
            }
        }
        swap(points, i, high);
        return i;
    }

    public int dist(int[] p){
        return ((p[0]*p[0]) + (p[1]*p[1]));     // ignoring sqrt bcz we need for comparision purpose only
    }

    public int randomPivot(int[][] points, int low, int high){
        int pivotIdx = low + RAND.nextInt(high-low+1);
        swap(points, pivotIdx, high);
        return partition(points, low, high);
    }

    public void swap(int[][] points, int i, int j){
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}