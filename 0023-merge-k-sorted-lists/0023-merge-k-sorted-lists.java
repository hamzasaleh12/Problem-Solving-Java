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

        int mul = 2;
        int start = 1;
        while(start < lists.length){
            for(int i = start ; i < lists.length ; i += mul){ // 4
            lists[i - start] = merge(lists[i - start] , lists[i]); // 0=(0,1)  2=(2,3) 4=(4,5) 6=(6,7)
                                                                  // 0=(0,2)  4=(4,6)
                                                                  // 0 = (0,4)
                                                          // 0= 0,1  2= 2,3  4= 4,5  6= 6,7
                                                          // 0= 0,2  4= 4,6
            }                                                 // 0= 0,4
            start *= 2; // 4 , 8
            mul *= 2; // 8 , 16
        }
        return lists[0];
    }
    private ListNode merge(ListNode l1 , ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode l3 = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                l3.next = l1;
                l1 = l1.next;
            } else{
                l3.next = l2;
                l2 = l2.next;
            }

            l3 = l3.next;
        }
        l3.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}