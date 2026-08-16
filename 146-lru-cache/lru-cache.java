class LRUCache {
    class Node{
        int key,val;
        Node next,prev;
        Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    HashMap<Integer,Node> map;
    int len;
    Node head,tail;
    public LRUCache(int capacity) {
        len=capacity;
        map=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node n=map.get(key);
        remove(n);
        addFirst(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n=map.get(key);
            n.val=value;
            remove(n);
            addFirst(n);
        }
        else{
            if(len==map.size()){
                Node lru=tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node n=new Node(key,value);
            addFirst(n);
            map.put(key,n);
        }
    }
    public void remove(Node n){
        n.prev.next=n.next;
        n.next.prev=n.prev;
    }
    public void addFirst(Node n){
        n.next=head.next;
        n.prev = head;
        head.next.prev = n;
        head.next = n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */