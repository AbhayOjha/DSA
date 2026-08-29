class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        Map<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
        Map<Integer, Integer> numToGroup = new HashMap<>();

        int group = 0;
        numToGroup.put(arr[0], group);
        groupToList.put(group, new LinkedList<>());
        groupToList.get(group).add(arr[0]);

        for(int i=1; i<n; i++){
            if(Math.abs(arr[i]-arr[i-1]) > limit){
                group++;
            }
            numToGroup.put(arr[i], group);
            groupToList.putIfAbsent(group, new LinkedList<>());
            groupToList.get(group).add(arr[i]);
        }

        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            int num = nums[i];
            int g = numToGroup.get(num);
            ans[i] = groupToList.get(g).pollFirst();
        }

        return ans;
    }

}