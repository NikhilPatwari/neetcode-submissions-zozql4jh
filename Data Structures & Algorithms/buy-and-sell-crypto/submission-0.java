class Solution {
    public int maxProfit(int[] prices) {
        int[] minArr = new int[prices.length];
        int[] maxArr = new int[prices.length];
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE; 
        for(int i = 0; i< n; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            minArr[i] = min;
            if(prices[n - i -1] > max ){
                max = prices[n - i -1];
            }
            maxArr[n - i - 1] = max;
        }
        int maxProfit = 0;
        for(int i = 0; i< n; i++){
            if(maxProfit < maxArr[i] - minArr[i]){
                maxProfit = maxArr[i] - minArr[i];
            }
        }
        return maxProfit;
    }
}
