class Solution {
    public int maxArea(int[] heights) {
        int maxWater = Integer.MIN_VALUE;
        int i = 0, j = heights.length -1;
        while(i<j){
            int water = Math.min(heights[i], heights[j]) * (j-i);
            if(water > maxWater){
                maxWater = water;
            }
            if(heights[i] > heights[j]){
                j--;
            }else{
                i++;
            }
        }
        return maxWater;
    }
}
