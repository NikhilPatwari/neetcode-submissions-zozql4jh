class LRUCache {
    Node head, tail;
    Map<Integer, Node> map;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        Node n = map.get(key);
        if (n != null) {
            remove(n);
            moveToHead(n);
            return n.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if(n != null){
            n.val = value;
            remove(n);
            moveToHead(n);
            return;
        }
        n = new Node(key, value);
        if(map.size() == capacity){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
        moveToHead(n);
        map.put(key,n);
    }

    private void moveToHead(Node n){
        n.next = head.next;
        head.next.prev = n;
        n.prev = head;
        head.next = n;
    }
    private void remove(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next= null;
        n.prev = null;
    }

    private static class Node {
        int key;
        int val;
        Node next;
        Node prev;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
