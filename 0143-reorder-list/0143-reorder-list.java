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
        // 1 2 3 4 5 -> slow = 3
        ListNode current = slow.next; // 4
        slow.next = null; // 1 -> 2 -> 3 || 4 -> 5
        ListNode prev = null;
        while(current != null){ // 4 != null , 5 != null , f
            ListNode temp = current.next; // 5 , null
            current.next = prev; // 4 -> null , 5 -> 4 -> null
            prev = current; // 4 , 5
            current = temp; // 5 , null
        }
        // 1 -> 2 -> 3 || 5 -> 4

        ListNode first = head;
        ListNode second = prev; 
        while(second != null){
            ListNode tem1 = first.next; // 2 -> 3 , 3
            ListNode tem2 = second.next; // 4  , null

            first.next = second; // 1 -> 5 
            second.next = tem1; // 5 -> 2


            first = tem1; // 2 -> 3
            second = tem2; // 4
        }
    }
}