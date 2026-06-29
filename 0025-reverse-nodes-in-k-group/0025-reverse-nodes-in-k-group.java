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
    public ListNode reverseKGroup(ListNode head, int k) {
        boolean isFirstIteration = true;
        ListNode prevGroupTail = null;
        ListNode newHead = head;

        ListNode curr = head; // 1
        while(true){
            ListNode fast = curr; // 1 , 3
            int count = 0;
            while(count < k && fast != null){ // 0 < 2 , 1 < 2 ,
                fast = fast.next; // 6 , null
                count++;
            }

            if(count != k) return newHead;

            ListNode currGroupTail = curr;
            ListNode prev = fast; // 3 , 5
            while(curr != fast){ // 3 != 5 , 4 != 5
                ListNode temp = curr.next; // 4 , 5
                curr.next = prev; // 3 -> 5 , 4 -> 3
                prev = curr; // 3 , 4
                curr = temp; // 4 , 5
            }
            if(isFirstIteration) {
                newHead = prev; // t -> newHead = 2
                isFirstIteration = false;
            } else{
                prevGroupTail.next = prev;
            }

            prevGroupTail = currGroupTail;
        }
    }
}