class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int majority1 = nums[0];
        int majority2 = nums[n/3];
        int majority3 = nums[(2*n)/3];
        int count = 1;
        for(int i = 1; i < n/3; i++ ){
            if(count==0){
                majority1 = nums[i];
                count++;
            }else{
                if(nums[i] == majority1){
                    count++;
                }else{
                    count--;
                }
            }
        }
        count=1;
        for(int i = n/3+1; i < (2*n)/3; i++ ){
            if(count == 0){
                majority2 = nums[i];
                count++;
            }else{
                if(nums[i] == majority2){
                    count++;
                }else{
                    count--;
                }
            }
        }
        count=1;
        for(int i = (2*n)/3+1; i < n; i++ ){
            if(count == 0){
                majority3 = nums[i];
                count++;
            }else{
                if(nums[i] == majority3){
                    count++;
                }else{
                    count--;
                }
            }
        }
        int count1 = 0;
        int count2 =0;
        int count3 = 0;
        for(int nu : nums){
            if(majority1 == nu){
                count1++;
            }else if(majority2 == nu){
                count2++;
            }else if(majority3 == nu){
                count3++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(count1 > n/3){
            ans.add(majority1);
        }
        if(count2 > n/3){
            ans.add(majority2);
        }
        if(count3 > n/3){
            ans.add(majority3);
        }
        return ans;
    }
}