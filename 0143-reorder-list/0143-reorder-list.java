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
        // 1 -> 2 -> 3 -> 4 -> 5
        // 1 -> 2 , 3 -> 4
        ListNode slow = head; // 1
        ListNode fast = head.next; // 2
        while(fast != null && fast.next != null){
            slow = slow.next; // 2 , 3
            fast = fast.next.next; //4 , null
        }
        // 1 -> 2 -------- 3 -> 4
        // 1 -> 2 -> 3 --- 4 -> 5
        ListNode curr = slow.next;
        ListNode prev = null;
        slow.next = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        // 1(head) -> 2(slow) -------- 4(prev) -> 3
        // 1(head) -> 2 -> 3(slow) --- 5(prev) -> 4

        ListNode fir = head; // 1 -> 2
        ListNode sec = prev; // 4 -> 3
        while(sec != null){
            ListNode temp1 = fir.next; // 2 , null
            ListNode temp2 = sec.next; // 3 , null

            fir.next = sec; // 1 -> 4 -> 2 -> 3
            sec.next = temp1; // 4 -> 2 -> 3 -> null

            fir = temp1; // 2 , null
            sec = temp2; // 3 , null
        } 
        // 1 -> 4 -> 2 -> 3 -> null
    }
}