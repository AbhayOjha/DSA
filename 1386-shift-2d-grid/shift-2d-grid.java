class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int el = n*m;

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                list.add(grid[i][j]);
            }
        }

        k = k%el;

        reverse(list, 0, el-1);
        reverse(list, 0, k-1);
        reverse(list, k, el-1);

        List<List<Integer>> ans = new ArrayList<>();
        int idx = 0;
        for(int i=0; i<n; i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<m; j++){
                row.add(list.get(idx++));
            }
            ans.add(row);
        }

        return ans;
    }

    public void reverse(List<Integer> list, int i, int j){
        while(i<j){
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }
}