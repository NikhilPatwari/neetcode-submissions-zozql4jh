class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        Set<Integer> duplicateIndex = new HashSet<>();
        for(int i = 0; i< n-1; i++){
            if(nums[i] == nums[i+1]){
                duplicateIndex.add(i);
            }
        }
        for(int i = 0; i<n; i++){
            if(duplicateIndex.contains(i)){
                int nonDuplicateIndex = findFisrtNonDuplicatIndex(i+1,duplicateIndex);
                if(nonDuplicateIndex == n){
                    return i;
                }else{
                    nums[i] = nums[nonDuplicateIndex];
                    duplicateIndex.remove(i);
                    duplicateIndex.add(nonDuplicateIndex);
                }
            }
        }
        return n;
    }
    public int findFisrtNonDuplicatIndex(int startIndex, Set<Integer>duplicateIndex ){
        while(duplicateIndex.contains(startIndex)){
            startIndex++;
        }
        return startIndex;
    }
}