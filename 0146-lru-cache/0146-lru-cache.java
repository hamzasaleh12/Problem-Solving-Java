class LRUCache {
    class Node{
        int key , val;
        Node next , prev;
        Node(int key , int val){
            this.key = key;
            this.val = val;
        }
        Node(){}
    }

    int capacity;
    Node head , tail;
    Map<Integer,Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;

        remove(node);
        add(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node updatedNode = map.get(key);
            updatedNode.val = value;
            remove(updatedNode);
            add(updatedNode);
        } else{
            if(map.size() == capacity){
                Node lru = map.get(tail.prev.key);
                map.remove(lru.key);
                remove(lru);
            }
            Node newNode = new Node(key , value);
            map.put(key , newNode);
            add(newNode);
        }
    }

    private void add(Node node){
        Node temp = head.next;

        node.next = temp;
        temp.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void remove(Node node){ // 1 = 3
        Node temp = node.next;

        node.next.prev = node.prev;
        node.prev.next = temp;
    }

}

/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */