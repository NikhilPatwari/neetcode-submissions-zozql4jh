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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // split
        ListNode h1 = head;
        ListNode h2 = head.next, temp = head.next;
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }

        h2 = slow.next;
        slow.next = null;
        h1 = head;
        // slow  = h1; fast = h2;
        // while (slow != null){
        //     System.out.println(slow.val);
        //     slow = slow.next;
        // }
        // while (fast != null){
        //     System.out.println(fast.val);
        //     fast = fast.next;
        // }
        // reverse
        ListNode p = null;
        while (h2 != null) {
            temp = h2;
            h2 = h2.next;
            temp.next = p;
            p = temp;
        }
        h2 = p;
        // merge
        while (h1 != null && h2 != null) {
            temp = h1;
            h1 = h1.next;
            p = h2;
            h2 = h2.next;
            temp.next = p;
            p.next = h1;
        }
        return;
    }
}
