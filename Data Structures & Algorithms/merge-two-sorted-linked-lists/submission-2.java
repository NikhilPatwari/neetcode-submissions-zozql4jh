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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        ListNode h1 = list1, h2 = list2,temp = null, p1 = null;
        while(h1 != null && h2 != null){
            temp = h2.next;
            if(h1.val > h2.val){
                if(p1 != null){
                    p1.next = h2;
                }else{
                    list1 = h2;
                }
                p1 = h2;
                h2.next = h1;
                h2 = temp;
            }else{
                p1 = h1;
                h1 = h1.next;
            }
        }
        if(h1 == null && h2 != null){
            p1.next = h2;
        }
        return list1;
        
    }
}