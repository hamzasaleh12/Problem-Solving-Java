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
        ListNode dummy = new ListNode(-1);
        ListNode l3 = dummy;

        int cin = 0; 
        while(l1 != null || l2 != null || cin != 0){
            int fir = (l1 != null) ? l1.val : 0;
            int sec = (l2 != null) ? l2.val : 0;

            int sum = fir + sec + cin;
            cin = sum / 10;

            l3.next = new ListNode(sum % 10);
            l3 = l3.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}