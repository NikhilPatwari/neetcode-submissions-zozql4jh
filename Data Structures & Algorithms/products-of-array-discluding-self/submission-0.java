class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        for(int n : nums){
            if(n == 0){
                zeroCount ++;
            }else {
                product *= n;
            }
        }
        int[] res = new int[nums.length];
        if(zeroCount > 1){
            return res;
        }
        int i = 0;
        for(int n : nums){
            if(n == 0) {
                res[i] = product;
            }else if(zeroCount == 1){
                res[i] = 0;
            }else{
                res[i] = product / n;
            }
            i++;
        }
        return res;
    }
}  
