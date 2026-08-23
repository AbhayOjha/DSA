class Solution {
    public boolean sumGame(String num) {
        int leftSum = 0;
        int rightSum = 0;
        int leftQues = 0;
        int rightQues = 0;
        int n = num.length();
        for(int i=0; i<n; i++){
            if(num.charAt(i) == '?'){
                if(i < n/2){
                    leftQues++;
                }
                else{
                    rightQues++;
                }
            }
            else{
                if(i < n/2){
                    leftSum += num.charAt(i) - '0';
                }
                else{
                    rightSum += num.charAt(i) - '0';
                }
            }
        }

        int totalQues = leftQues + rightQues;
        if(totalQues % 2 == 1){
            return true;
        }

        int left = 2 * leftSum + (9 * leftQues);
        int right = 2 * rightSum + (9 * rightQues);
        if(left == right){
            return false;
        }
        else{
            return true;
        }
    }
}