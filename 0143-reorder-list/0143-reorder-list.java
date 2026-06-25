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
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        } // 4 -> 3
        
        ListNode part1 = head; // 1 -> 2
        ListNode part2 = prev; // 4 -> 3
        while(part2 != null && part1 != null){
            ListNode temp1 = part1.next; // 2 , null
            ListNode temp2 = part2.next; // 3 , null

            part1.next = part2; // 1 -> 4 , 2 -> 3
            part2.next = temp1; // 4 -> 2 , 3 -> null

            part1 = temp1; // 2 , null
            part2 = temp2; // 3 , null
        }
    }
}