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
    public ListNode mergeKLists(ListNode[] arr) {
        if (arr.length == 0) {
            return null;
        } else if (arr.length == 1) {
            return arr[0];
        }

        ListNode minNode = null, prev = null, curr = arr[0];
        int minRow = -1, minElement = Integer.MAX_VALUE;
        while (true) {
            if (minNode == null) {
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] != null && arr[i].val < minElement) {
                        minElement = arr[i].val;
                        minRow = i;
                        minNode = arr[i];
                    }
                }
            }
            if (minNode == null) {
                return arr[0];
            }
            if (curr == null && prev == null) {
                arr[0] = minNode;
                arr[minRow] = minNode.next;
                minNode.next = curr;
                prev = minNode;
                minNode = null;
            } else if (prev != null && curr == null) {
                arr[minRow] = minNode.next;
                prev.next = minNode;
                minNode.next = curr;
                prev = minNode;
                minNode = null;
            } else if (curr.val <= minNode.val) {
                prev = curr;
                curr = curr.next;
            } else {
                if (prev == null) {
                    arr[0] = minNode;
                } else {
                    prev.next = minNode;
                }
                arr[minRow] = minNode.next;
                minNode.next = curr;
                prev = minNode;
                minNode = null;
            }
            minElement = Integer.MAX_VALUE;
        }
    }
}
