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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode prev = null, temp = head, next, l = null, r = null;
        int i = 1;
        while (i <= right) {
            if (i == left) {
                l = temp;
            } else if (i == left - 1) {
                prev = temp;
            }
            if (i == right) {
                r = temp;
            }
            temp = temp.next;
            i++;
        }
        next = temp;
        if (left == 1) {
            head = reverse(l, r);
        } else {
            prev.next = reverse(l, r);
        }
        l.next = next;
        return head;
    }

    private ListNode reverse(ListNode left, ListNode right) {
        ListNode p = null, q = left, qn;
        while (p != right) {
            if (q != null) {
                qn = q.next;
            } else {
                qn = null;
            }
            q.next = p;
            p = q;
            q = qn;
        }
        return p;
    }
}