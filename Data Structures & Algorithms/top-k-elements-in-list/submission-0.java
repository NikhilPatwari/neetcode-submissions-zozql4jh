class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> elemFreq = new HashMap<>();
        int [] result = new int[k];
        Map<Integer, List<Integer>> freqElems = new TreeMap<>(Collections.reverseOrder());
        for(int a : nums) {
            elemFreq.put(a,elemFreq.getOrDefault(a, 0)+1);
        }

        elemFreq.forEach((key, value) -> {
            List<Integer> freqElemList = freqElems.getOrDefault(value, new ArrayList<>());
            freqElemList.add(key);
            freqElems.put(value,freqElemList);
        });
        int count = 0;
        for (Integer key : freqElems.keySet()) {
            List<Integer> vals = freqElems.get(key);
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
