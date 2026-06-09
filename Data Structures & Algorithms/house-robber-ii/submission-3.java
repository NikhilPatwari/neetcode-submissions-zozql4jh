class Solution {
    int [] dp1;
    int [] dp2;
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        dp1 = new int[nums.length];
        dp2 = new int[nums.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(rob(nums,0, nums.length -1, true),rob(nums,1, nums.length,false)) ;
    }

    public int rob(int[] nums, int start, int end, boolean flag) {
        if(start >= end ){
            return 0;
        }
        if(flag){
            if(dp1[start]!= -1) return dp1[start];
            return dp1[start] = Math.max(nums[start] + rob(nums,start+2,end,flag),rob(nums,start+1,end,flag));
        }else{
            if(dp2[start]!= -1) return dp2[start];
            return dp2[start] = Math.max(nums[start] + rob(nums,start+2,end,flag),rob(nums,start+1,end,flag));
        }
    }
}

