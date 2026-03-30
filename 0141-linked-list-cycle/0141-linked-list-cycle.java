/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //Initialize pointers
        ListNode slow = head;
        ListNode fast = head;
        
        // Traverse list
        while(fast != null && fast.next != null){

            //Advance pointers
            slow = slow.next;
            fast = fast.next.next;

            // Check if Cycle is detected
            if(fast == slow) return true;
        } 
        // No cycle found
        return false;
    }
}