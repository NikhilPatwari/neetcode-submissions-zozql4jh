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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode l = head;
        ListNode r = head.next;
        l.next = null;
        while(r != null){
            ListNode temp = r;
            r = r.next;
            temp.next = l;
            l = temp;
        }
        return l;
    }
}
