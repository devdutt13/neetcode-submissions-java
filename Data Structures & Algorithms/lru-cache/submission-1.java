class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.value = val;
            this.prev = null;
            this.next = null;
        }
    }
class LRUCache {
    
    private HashMap<Integer,Node> map;
    private int capacity;
    private Node left;
    private Node right;
    private int curCap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.curCap = 0;
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
        this.map = new HashMap<>();

        
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node n = map.get(key);
        remove(n);
        insert(n);
        return n.value;
        
    }
    public void insert(Node n){
       
        Node prev = this.right.prev;
        n.next = this.right;
        this.right.prev = n;
        prev.next = n;
        n.prev = prev;
        this.curCap++;
        return;

    }
    public void remove(Node n){
        Node prev = n.prev;
        Node next = n.next;
        prev.next = next;
        next.prev = prev;
        this.curCap--;
        return;
    }
    
    public void put(int key, int value) {
         if(map.containsKey(key)){
            
            remove(map.get(key));
            map.remove(key);
        }
        Node n = new Node(key,value);
        map.put(key,n);
        insert(n);
        if(curCap > capacity){
            Node lru = this.left.next;
            remove(this.left.next);
            map.remove(lru.key);
           
        }
        return;

        
    }
}
