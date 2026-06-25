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

        int c = 0;
        while(l1 != null || l2 != null || c != 0){
            int fir = (l1 != null) ? l1.val : 0; // 2 , 4 , 3
            int sec = (l2 != null) ? l2.val : 0; // 5 , 6 , 4

            int sum = c + fir + sec; // 7 , 10 , 8
            l3.next = new ListNode(sum % 10); // 7 , 0 , 8
            c = sum / 10; // 0 , 1 , 0

            l3 = l3.next;
            if(l1 != null) l1 = l1.next; // t , t , t
            if(l2 != null) l2 = l2.next; // t , t , t
        }

        return dummy.next;
    }
}