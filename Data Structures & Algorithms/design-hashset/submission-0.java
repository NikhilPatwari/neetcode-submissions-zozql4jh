class MyHashSet {
    private List<List<Integer>> arrayLists;

    public MyHashSet() {
        this.arrayLists =  new ArrayList<>(1000);
        for(int i = 0; i < 1000; i++ ){
            arrayLists.add(new ArrayList<>());
        }
    }

    public void add(int key) {
        if(!contains(key)) {
            int index = key % 1000;
            List<Integer> n =this.arrayLists.get(index);
            n.add(key);
        }
    }

    public void remove(int key) {
        int index = key % 1000;
        List<Integer> n = this.arrayLists.get(index);
        n.removeIf(element -> element.equals(key));
    }

    public boolean contains(int key) {
        int index = key % 1000;
        List<Integer> n;
        if((n = this.arrayLists.get(index)) == null) {
            return false;
        }else {
            for(int a : n){
                if(a == key) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */