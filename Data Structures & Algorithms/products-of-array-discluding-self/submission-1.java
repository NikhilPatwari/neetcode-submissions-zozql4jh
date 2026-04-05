class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] prefixProduct = new int[n+1];
        int [] suffixProduct = new int[n+1];
        prefixProduct[0] = 1;
        suffixProduct[n] = 1;
        int prefix=1;
        int suffix = 1;
        for(int i = 0; i < n; i++) {
            prefix *= nums[i];
            prefixProduct[i+1] = prefix;
            suffix *= nums[n - i - 1];
            suffixProduct[n - i -1] = suffix;
        }
        int [] res = new int[n];
        for(int i = 0; i< n; i++){
            res[i] = prefixProduct[i] * suffixProduct[i+1];
        }
        return res;
    }
}  
