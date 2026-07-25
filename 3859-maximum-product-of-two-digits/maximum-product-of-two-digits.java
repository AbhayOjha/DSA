class Solution {
    public int maxProduct(int n) {
        int max = 0;
        int secMax = 0;
        while(n>0){
            int digit = n%10;
            n = n/10;
            if(digit >= max){
                secMax = max;
                max = digit;
            }
            else{
                secMax = Math.max(secMax, digit);
            }
        }
        return max*secMax;
    }
}