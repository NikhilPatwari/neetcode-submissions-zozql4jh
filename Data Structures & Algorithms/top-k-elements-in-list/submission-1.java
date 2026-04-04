class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elemFreq = new HashMap<>();
        int [] result = new int[k];
        List<List<Integer>> freqElems = new ArrayList<>(nums.length + 1);
        for(int a : nums) {
            elemFreq.put(a,elemFreq.getOrDefault(a, 0)+1);
            freqElems.add(new ArrayList<Integer>());
        }
        freqElems.add(new ArrayList<Integer>());

        for(Map.Entry<Integer, Integer> e : elemFreq.entrySet()){
            int freq = e.getValue();
            int element = e.getKey();
            freqElems.get(freq).add(element);
        }
        int count = 0;
        for(int i = freqElems.size() -1 ; i>=0; i--){

            List<Integer> vals = freqElems.get(i);
            for(int a : vals){
                if(count <k){
                    result[count] =a;
                    count++;
                }else{
                    break;
                }
            }
            if(count>=k){
                break;
            }
        }
        return result;
    }
}
