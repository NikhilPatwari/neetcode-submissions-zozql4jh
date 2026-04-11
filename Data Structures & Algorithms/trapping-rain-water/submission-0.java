class Solution {
    public int trap(int[] height) {
        int i = 0;
        int j = i+1;
        int highestTower = 0; //may have to revisit 
        int water = 0;
        while(j < height.length){
            if(height[j] >= height[i] ){
                int temp = j-1;
                while(temp>i){
                    water += height[i] - height[temp];
                    temp --;
                }
                highestTower = j;
                i = j;
            }
            j++;
        }
        if(highestTower < height.length -1){
            i = height.length -1;
            int tempHigh = i;
            j = i-1;
            while(j >= highestTower ){
                if(height[j] >= height[i] ){
                    int temp = i-1;
                    while(temp > j){
                        water += height[i] - height[temp];
                        temp --;
                    }
                    tempHigh = j;
                    i = j;
                }
                j--;
            }
        }
        return water;
    }
}
