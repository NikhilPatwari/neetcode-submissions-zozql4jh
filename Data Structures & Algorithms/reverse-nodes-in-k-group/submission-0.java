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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = null, q = head, start = head, end = start, result = head;
        boolean firstTime = true;
        while (true) {
            int i = 0;
            while (i < k && end != null) {
                end = end.next;
                i++;
            }
            if (i != k) {
                break;
            }
            if (firstTime) {
                firstTime = false;
                result = reverse(p, q, end);
                start = end;
                q = start;
            } else {
                head.next = reverse(null, q, end);
                head = start;
                start = end;
                q = start;
            }
        }
        head.next = start;
        return result;
    }

    public ListNode reverse(ListNode p, ListNode q, ListNode end) {
        ListNode qn;
        while (q != end) {
            qn = q.next;
            q.next = p;
            p = q;
            q = qn;
        }
        return p;
    }
}
