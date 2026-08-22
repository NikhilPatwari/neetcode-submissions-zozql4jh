class LFUCache {
    int capacity, minFrequency;
    Map<Integer, Node> lfuCache;
    Map<Integer, LinkedHashSet<Integer>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFrequency = Integer.MAX_VALUE;
        lfuCache = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!lfuCache.containsKey(key)) return -1;
        bumpFreq(key);
        return lfuCache.get(key).val;
    }
    
    public void put(int key, int value) {
        if(lfuCache.containsKey(key)){
            Node n = lfuCache.get(key);
            n.val = value;
            get(key);
            return;
        }
        Node n = new Node(value,1);
        if(lfuCache.size() == capacity) {
            evict();
        }
        lfuCache.put(key, n);
        freqMap.computeIfAbsent(1, k -> new LinkedHashSet<Integer>()).add(key);
        minFrequency = 1;
    }
    private void bumpFreq(int key){
        Node n  = lfuCache.get(key);
        int currentFreq = n.freq;
        n.freq ++;
        freqMap.get(currentFreq).remove(key);
        if(freqMap.get(currentFreq).size() == 0){
            freqMap.remove(currentFreq);    
            if(minFrequency == currentFreq) minFrequency++;
        }
        freqMap.computeIfAbsent(currentFreq+1, k -> new LinkedHashSet<Integer>()).add(key);
    }

    private void evict(){
        LinkedHashSet<Integer> freqKeys = freqMap.get(minFrequency);
        int key = freqKeys.iterator().next();
        freqKeys.remove(key);
            if(freqKeys.size() == 0){
                freqMap.remove(minFrequency);
            }
        lfuCache.remove(key);
    }

    private static class Node{
        int val;
        int freq;
        Node(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */