/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> oldNewMap = new HashMap<>();
        Node temp = head;
        while(temp != null){
            oldNewMap.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            if(temp.next != null){
                oldNewMap.get(temp).next = oldNewMap.get(temp.next);
            }
            if(temp.random != null){
                oldNewMap.get(temp).random = oldNewMap.get(temp.random);
            }
            temp = temp.next;
        }
        return oldNewMap.get(head);
        
    }
}
