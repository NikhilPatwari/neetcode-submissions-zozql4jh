class LRUCache {
    Node head, tail;
    Map<Integer, Node> map;
    int capacity;
    int size = 0;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1); // dummy Node
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            delete(n);
            addToHead(n);
            return n.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if (n != null) {
            n.val = value;
            delete(n);
            addToHead(n);
            return;
        }
        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            delete(tail.prev);
        }
        n = new Node(key, value);
        addToHead(n);
        map.put(key, n);
    }
    
    public void addToHead(Node n) {
        n.next = head.next;
        n.next.prev = n;
        n.prev = head;
        head.next = n;
    }
    
    public void delete(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next = null;
        n.prev = null;
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
