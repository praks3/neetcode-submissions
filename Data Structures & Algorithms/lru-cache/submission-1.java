class LRUCache {
/*
Use a HashMap for O(1) lookup: Store key -> DLL node so any cache entry can be accessed directly without traversing the list.

Use a Doubly Linked List to maintain usage order: Keep the LRU node near the tail and the MRU node near the head. Every get or put moves the accessed/inserted node to the MRU end.

On capacity overflow, evict the LRU node: Remove tail.prev (the least recently used node) from both the doubly linked list and the HashMap in O(1) time.
*/
    public class Node{
        int key;
        int value;
        Node back;
        Node front;
        
        public Node(int key,int value){
            this.key=key;
            this.value=value;
            this.back=null;
            this.front=null;
        }
    }
    Map<Integer,Node> cache;
    int size;
    Node tail;
    Node head;

    public LRUCache(int capacity) {
        this.size=capacity;
        this.cache = new HashMap<>();
        this.head= new Node(-1,-1);
        this.tail= new Node(-1,-1);
        head.front=tail;
        tail.back=head;
    }
    
    public int get(int key) {
        Node element = cache.get(key);
        if(element!=null){
            deleteNode(element);
            insertNodeAfterHead(element);
        return element.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node element = cache.get(key);
        if(element!=null){
            deleteNode(element);
            element.value=value;
            insertNodeAfterHead(element);
        }else if(cache.size()== size){
            Node lastNode= tail.back;
            cache.remove(lastNode.key);
            deleteNode(lastNode);
            lastNode.key=key;
            lastNode.value=value;
            insertNodeAfterHead(lastNode);
            cache.put(key,lastNode);
        }else{
            Node node= new Node(key,value);
            insertNodeAfterHead(node);
            cache.put(key,node);
        }
    }

    public void deleteNode(Node node){
        Node prevNode= node.back;
        Node nextNode= node.front;
        prevNode.front=nextNode;
        nextNode.back=prevNode;
    }
    public void insertNodeAfterHead(Node node){
        Node nextNode= head.front;
        head.front=node;
        node.back=head;
        node.front=nextNode;
        nextNode.back=node;
    }
}
