class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = nums1.length -1, target = 0;
        m--; n--;
        while(p >= 0 ){
            if(m >= 0 && n >= 0) {
                if(nums1[m] > nums2[n]){
                    nums1[p] = nums1[m];
                    p--; m--;
                }else{
                    nums1[p] = nums2[n];
                    p--; n--;
                }
            }else if(m >= 0){
                nums1[p] = nums1[m];
                p--; m--;
            }else{
                nums1[p] = nums2[n];
                p--; n--;
            }
        }
    }
}