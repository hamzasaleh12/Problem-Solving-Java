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
        ListNode curr = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int l1Val = (l1 == null) ? 0 : l1.val; // 9 , 9 , 9 , 9 , 9 , 9
            int l2Val = (l2 == null) ? 0 : l2.val; // 9 , 9 , 9 , 9 , 0 , 0
            int sum = l1Val + l2Val + carry; // 18 , 18 , 18  , 18 , 9
            curr.next = new ListNode((sum) % 10); // 8 , 9 , 9 , 9 , 0 , 0
            carry = sum / 10; // 1 , 1 , 1 , 1 , 1 , 1

            if(l1 != null) l1 = l1.next; // 9 , 9 , 9 , 9 , 9 , 9
            if(l2 != null) l2 = l2.next; // 9 , 9 , 9 , 9 , null
            curr = curr.next;
        }
        
        return dummy.next;
    }
}