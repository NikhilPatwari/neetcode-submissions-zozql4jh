class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majority = 0;
        for(int n : nums) {
            if(count == 0){
                majority = n;
                count = 1;
            }else if(majority == n){
                count++;
            }else{
                count --;
            }
        }
        return majority;
    }
}