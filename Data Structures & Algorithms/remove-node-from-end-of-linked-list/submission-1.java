/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head, p = null;
        int count = 0;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        int pos = count - n + 1;
        if(pos == 1){
            return head.next;
        }
        count =1;
        temp =head;
        while(count != pos){
            p = temp;
            temp = temp.next;
            count ++;
        }
        if(p != null && temp != null){
            p.next = temp.next;
        }else if(p != null && temp == null){
            p.next = null;
        }
        if(p == null ){
            return p;
        }
        return head;
    }
}
