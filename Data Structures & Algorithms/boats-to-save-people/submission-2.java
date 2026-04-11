class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] freq = new int[30001];
        int n = people.length, i = 0, j=30000;
        for(int a : people){
            freq[a]++;
        }
        int boatCount = 0;
        while(i<=j){
            if(freq[j]<= 0 ){
                j--;
            }else if(freq[i]<= 0){
                i++;
            }else if(i == j) {
                if(freq[i]>=2 && i+i <= limit){
                    boatCount++;
                    freq[i] -=2;
                }else{
                    freq[i] --;
                    boatCount++;
                }
            }else if(i+j > limit){
                freq[j] --;
                boatCount++;
            }else{
                freq[i]--;
                freq[j] --;
                boatCount++;
            }
        }
        return boatCount;        
    }
}