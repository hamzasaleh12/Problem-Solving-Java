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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> points = new ArrayList<>();

        int j = 1;
        ListNode curr = head.next;
        ListNode prev = head;
        while(curr.next != null){
            if((curr.val > prev.val && curr.val > curr.next.val)
            || (curr.val < prev.val && curr.val < curr.next.val)) points.add(j);

            prev = curr;
            curr = curr.next;
            j++;
        }
        if(points.size() <= 1) return new int[]{-1,-1};
        int[] res = new int[2];
        res[0] = Integer.MAX_VALUE;

        for(int i = 1 ; i < points.size() ; i++){
            res[0] = Math.min(res[0] , points.get(i) - points.get(i - 1));
        }
        res[1] = points.getLast() - points.getFirst();

        return res;
    }
}