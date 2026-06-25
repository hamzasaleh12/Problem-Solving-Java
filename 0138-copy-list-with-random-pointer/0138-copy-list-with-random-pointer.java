/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node curr = head;
        while(curr != null){
            Node temp = curr.next; // 13

            Node newNode = new Node(curr.val); // 7(c)
            newNode.next = temp; // 7(c) -> 13
            curr.next = newNode; // 7 -> 7(c) -> 13

            curr = temp; // 13
        }

        curr = head; // 7
        while(curr != null){
            curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }

        curr = head; // 7
        Node dummy = new Node(-1);
        Node copyTail = dummy;
        while(curr != null){
            Node temp = curr.next; // 7(c)
            curr.next = curr.next.next; // 7 -> 13
            dummy.next = temp; // 7(c) -> 13(c)

            curr = curr.next;
            dummy = dummy.next;
        }

        return copyTail.next;
    }
}