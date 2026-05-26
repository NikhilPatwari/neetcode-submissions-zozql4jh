class LRUCache {
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            putAhead(n, false);
            return n.val;
        }
        return -1;
    }

    public void putAhead(Node n, boolean isNew) {
        if (n == head) {
            return;
        } else if (head == null) {
            head = n;
            tail = n;
        } else if (n == tail) {
            tail = tail.prev;
            tail.next = null;
            n.next = head;
            n.prev = null;
            head.prev = n;
            head = n;
        } else if (isNew) {
            n.next = head;
            head.prev = n;
            head = n;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            n.next = head;
            n.prev = null;
            head.prev = n;
            head = n;
        }
    }

    public void put(int key, int value) {
        if (map.size() == capacity && !map.containsKey(key)) {
            Node n = new Node(key, value);
            if (tail != null) {
                map.remove(tail.key);
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                }
            }
            putAhead(n, true);
            map.put(key, n);
        } else if (map.containsKey(key)) {
            Node n = map.get(key);
            n.val = value;
            putAhead(n, false);
        } else {
            Node n = new Node(key, value);
            putAhead(n, true);
            map.put(key, n);
        }
    }
}

class Node {
    public int val;
    public int key;
    public Node prev;
    public Node next;

    public Node(int key, int val) {
        this.val = val;
        this.key = key;
    }
}
