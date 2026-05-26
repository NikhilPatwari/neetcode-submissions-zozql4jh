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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head = null, temp = null;
        int rem = 0;
        while (l1 != null || l2 != null) {
            int count = rem;
            if (l1 != null) {
                count += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                count += l2.val;
                l2 = l2.next;
            }
            rem = count / 10;
            count = count % 10;
            if (head == null) {
                head = new ListNode(count);
                temp = head;
            } else {
                temp.next = new ListNode(count);
                temp = temp.next;
            }
        }
        if(rem != 0){
            temp.next = new ListNode(rem);
        }
        return head;
    }
}
