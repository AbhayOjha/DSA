class Solution {
    public int maxProfit(int[] prices) {
        int minPTN = prices[0];
        int maxP = Integer.MIN_VALUE;
        for(int price: prices){
            minPTN = Math.min(minPTN, price);
            maxP = Math.max(maxP, price - minPTN);
        }
        return maxP < 0 ? 0 : maxP;
    }
}