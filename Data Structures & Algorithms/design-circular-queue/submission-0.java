class MyCircularQueue {
    int capacity;
    int size = 0;
    Node realTail,head,tail;

    public MyCircularQueue(int k) {
        this.capacity = k;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.next = head;
    }
    
    public boolean enQueue(int value) {
        if(size == capacity){
            return false;
        }
        size++;
        if(realTail == null) {
            realTail = new Node(value);
            realTail.next = tail;
            head.next = realTail;
            return true;
        }
        Node n = new Node(value);
        realTail.next = n;
        n.next = tail;
        realTail = n;
        return true;
    }
    
    public boolean deQueue() {
        if(size == 0){
            return false;
        }
        size--;
        Node n = head.next;
        head.next = head.next.next;
        if(n == realTail){
            realTail.next = null;
            realTail = null;
        }
        return true;
 
    }
    
    public int Front() {
        if(size == 0){
            return -1;
        }
        return head.next.val;
        
    }
    
    public int Rear() {
        if(size == 0){
            return -1;
        }
        return realTail.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
        
    }
    private static class Node {
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
}


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */