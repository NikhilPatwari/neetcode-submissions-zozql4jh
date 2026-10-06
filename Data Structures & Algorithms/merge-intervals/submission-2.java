class Solution {
    public int[][] merge(int[][] intervals) {
        int max = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            max = Math.max(interval[0], max);
        }
        int[] range = new int[max + 1];
        for (int[] interval : intervals) {
            range[interval[0]] = Math.max(interval[1] + 1, range[interval[0]]);
        }
        List<int[]> res = new ArrayList<>();
        int start = -1;
        int have = -1;
        for(int i = 0; i< range.length; i++){
            if(range[i] != 0){
                if(start == -1){
                    start = i;
                }
                have = Math.max(have, range[i] -1);
            }
            if(have == i){
                res.add(new int[]{start, have});
                have = -1;
                start =-1;
            }
        }
        if(start != -1){
            res.add(new int[]{start, have});
        }
        int n = res.size();
        int [][] result = new int[n][2];
        for(int i = 0; i< n; i++){
            result[i] = res.get(i);
        }
        return result;
    }
}
