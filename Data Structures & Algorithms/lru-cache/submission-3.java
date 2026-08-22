class LRUCache {
    Node head, tail;
    Map<Integer, Node> map;
    int capacity;
    int size = 0;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1,-1); // dummy Node
        tail = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            delete(n);
            addToHead(n);
            return n.val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) { // cap check
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.val = value;
            delete(n);
            addToHead(n);

        } else {
            if(size == capacity){
                // delete tail;
                map.remove(tail.key);
                tail = tail.prev;
                tail.next.prev = null;
                tail.next = null;
            }else{
                size++;
            }
            Node n = new Node(key, value);
            addToHead(n);
            map.put(key, n);
        }
    }
    public void addToHead(Node n) {
        if (head.next == null) {
            head.next = n;
            n.prev = head;
            tail = n;
        } else {
            n.next = head.next;
            n.next.prev = n;
            n.prev = head;
            head.next = n;
        }
    }
    public void delete(Node n) {
        if(n == tail){
            tail = tail.prev;
            tail.next = null;
            n.prev = null;
        }else{
            n.prev.next = n.next;
            n.next.prev = n.prev;
            n.next = null;
            n.prev = null;
        }
    }
}
class Node {
    int val;
    int key;
    Node prev;
    Node next;
    public Node(int key, int val) {
        this.val = val;
        this.key = key;
    }
}
