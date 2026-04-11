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
        if(lists == null || lists.length == 0) return null;
        
        int interval = 1;
        int k = lists.length;

        while(interval < k){
            for(int i = 0; i < k - interval ; i += interval * 2){
                lists[i] = merge(lists[i] , lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }
    private ListNode merge(ListNode list1 , ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode l3 = dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                l3.next = list1;
                list1 = list1.next;
            } else{
                l3.next = list2;
                list2 = list2.next;
            }
            l3 = l3.next;
        }

        if(list1 != null) l3.next = list1;
        if(list2 != null) l3.next = list2;

        return dummy.next;
    }
}