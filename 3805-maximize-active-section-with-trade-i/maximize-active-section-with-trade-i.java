class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        ArrayList<Integer> inactive = new ArrayList<>();
        int activecount = 0;
        int i=0;
        while(i<n){
            if(s.charAt(i) == '0'){
                int start = i;
                while(i<n && s.charAt(i) == '0'){
                    i++;
                }
                inactive.add(i-start);
            }
            if(i<n && s.charAt(i) == '1'){
                activecount++;
                i++;
            }
        }

        int maxSum = 0;
        for(int j=1; j<inactive.size(); j++){
            maxSum = Math.max(maxSum, inactive.get(j-1)+inactive.get(j));
        }

        return maxSum+activecount;
    }
}