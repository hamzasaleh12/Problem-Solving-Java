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
    public ListNode mergeKLists(ListNode[] lists) {
        // 1. Base case : when 'lists' is null or empty
        if(lists == null || lists.length == 0) return null;

        // 2. 'interval' is the distance between what i should compare in every iteration
        int interval = 1;
        int k = lists.length;
        // 3. Still iterate through lists until end
        while(interval < k){
            // 4. Begin with 0 and jump 'interval * 2' otherwise 'i < k - interval' to avoid arrayOutOfIndex exception
            for(int i = 0 ; i < k - interval ; i+= interval * 2){
                // 5. Compare them and override on the first Ex: lists[0]=merge(0,1)
                lists[i] = merge2Lists(lists[i] , lists[i + interval]);
            }
            // 6. Update the interval
            interval *= 2;
        }
        // 7. The first one is the winner 
        return lists[0];
    }

    // Helper method to merge 2 lists
    private ListNode merge2Lists(ListNode list1 , ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tail.next = list1;
                list1 = list1.next;
            } else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if(list1 != null) tail.next = list1;
        if(list2 != null) tail.next = list2;

        return dummy.next;
    }
}