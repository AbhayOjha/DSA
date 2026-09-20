class Solution {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i=1; i<=s.length(); i++){
            int val = (int) s.charAt(i-1);
            int deg = (123 - val) * i;
            sum += deg;
        }
        return sum;
    }
}