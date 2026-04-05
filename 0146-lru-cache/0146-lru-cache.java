class LRUCache {
    class Node {
        int val,key;
        Node next,prev;
        Node(int key , int val){
            this.key = key;
            this.val = val;
        }
        Node(){}
    }

    private int capacity;
    private Map<Integer,Node> map;
    private Node head,tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node != null){
            deleteNode(node);
            addNode(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node updatedNode = map.get(key);
            updatedNode.val = value;
            deleteNode(updatedNode);
            addNode(updatedNode);
        } else{
            if(capacity == map.size()){
                Node lru = tail.prev;
                map.remove(lru.key);
                deleteNode(lru);
            }
            Node newNode = new Node(key, value);
            map.put(key,newNode);
            addNode(newNode);
        }
    }

    private void addNode(Node node){
        Node temp = head.next;

        head.next = node;
        node.next = temp;
        node.prev = head;
        temp.prev = node;
    }

    private void deleteNode(Node node){
        Node temp = node.next;
        node.prev.next = temp;
        temp.prev = node.prev;
    }
}

/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */