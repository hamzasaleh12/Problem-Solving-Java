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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        int count = 0;
        while(count < n){
            fast = fast.next; // 3
            count++; // 2
        }

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        if(fast == null) return slow.next;

        if (slow.next == null){
            return null;
        }

        slow.next = slow.next.next;

        return head;
    }
}