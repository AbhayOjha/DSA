class Solution {
    public int smallestNumber(int n, int t) {
        int ans = n;
        while(true){
            if(digitProd(ans)%t == 0)
                break;
            ans++;
        }
        return ans;
    }

    public int digitProd(int num){
        int ans = 1;
        while(num > 0){
            int digit = num%10;
            ans *= digit;
            num = num/10;
        }
        return ans;
    }
}