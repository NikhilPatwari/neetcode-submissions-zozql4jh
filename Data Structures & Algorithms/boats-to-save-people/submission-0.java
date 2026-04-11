class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boatCount = 0;
        int i = 0, j = people.length -1; 
        while(i<=j){
            if(i == j){
                boatCount++;
                i++; j--;
            }else if(people[i] + people[j] > limit){
                boatCount++;
                j--;
            }else{
                i++; j--;
                boatCount++;
            }
        }
        return boatCount;
        
    }
}