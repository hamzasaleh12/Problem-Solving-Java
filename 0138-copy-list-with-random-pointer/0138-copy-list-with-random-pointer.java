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
        Node curr = head;
        while(curr != null){
            Node temp = curr.next;
            Node newNode = new Node(curr.val);
            curr.next = newNode;
            newNode.next = temp;
            curr = temp;
        }
        Node cur = head;
        while(cur != null && cur.next != null){
            cur.next.random = (cur.random != null ) ? cur.random.next : null;
            cur = cur.next.next;
        }

        Node current = head;
        Node dummy = new Node(-1);
        Node newHead = dummy;

        // 7 -> 7 -> 13 -> 13 -> 11 -> 11 -> 10 -> 10 -> 1 -> 1 -> null
        while(current != null && current.next != null){
            Node copy = current.next; // 7(c) , 13(c)
            Node ori = copy.next; // 13 , 11

            current.next = ori; // 7 -> 13 -> 11
            newHead.next = copy; // -1 -> 7(c) -> 13(c)

            current = ori; // 13
            newHead = copy; // 11
        }

        return dummy.next;
    }
}