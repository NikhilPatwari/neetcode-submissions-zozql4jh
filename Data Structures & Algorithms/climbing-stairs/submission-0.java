class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
       return climbStairs(0,n);
    }
    public int climbStairs(int start, int end) {
        if(start == end){
            return 1;
        }else if(start > end){
            return 0;
        }
        if (cache[start] != -1) return cache[start];
        int sum = 0;
        if(start+2 > end){
            sum +=  climbStairs(start+1,end);
        }else{
            sum += climbStairs(start+1,end);
            sum += climbStairs(start+2,end);
        }
        return cache[start] = sum;
        
    }
}
