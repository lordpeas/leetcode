package LRU;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private Map<Integer,Node> map;

    private DoubleList cache;

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleList();
    }

    public int get(int key) {
        Node x = map.get(key);
        if(x == null) {
            return -1;
        }
        cache.remove(x);
        cache.addLast(x);
        return x.v;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node x = map.get(key);
            cache.remove(x);
            map.remove(key);

            Node newX  = new Node(key, value);
            cache.addLast(newX);
            map.put(key,newX);
            return;
        }

        if(cache.getSize()>=capacity){
            Node x = cache.removeFirst();
            map.remove(x.k);
        }

        Node x = new Node(key,value);
        cache.addLast(x);
        map.put(key,x);
    }



    private void makeRecently(int key){
        Node x = map.get(key);
        if(x!=null){
            cache.remove(x);
            cache.addLast(x);
        }
    }


    private void addRecently(int key,int val){
        Node x =  new Node(key,val);
        cache.addLast(x);
        map.put(key,x);
    }

    private void deleteKey(int key){
        Node x =  map.get(key);
        if(x!=null){
            cache.remove(x);
            map.remove(key);
        }
    }

    private void removeLeastRecently(){
        Node x = cache.removeFirst();
        map.remove(x.k);
    }

    class DoubleList {
        private Node head,tail;
        private int size;
        public DoubleList(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next =tail;
            tail.prev = head;
            this.size = 0;
        }


        public void addLast(Node x){
            tail.prev.next = x;
            x.prev = tail.prev;
            x.next = tail;
            tail.prev = x;
            size++;
        }


        public void remove(Node x){
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size --;
        }

        public Node removeFirst(){
            if(head.next==tail){
                return null;
            }
            Node first = head.next;
            remove(first);
            return first;
        }


        public int getSize(){
            return size;
        }
    }

    class Node {
        private Node prev;
        private Node next;
        private int k,v;
        public Node(int k,int v){
            this.k = k;
            this.v = v;
        }
    }


//    ["LRU.LRUCache","put","put","get","put","put","get"]
//            [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(2,2);
        lruCache.get(2);
        lruCache.put(1,1);
        lruCache.put(1,4);
        lruCache.get(2);
        System.out.println("hahah");
    }
}

/**
 * Your LRU.LRUCache object will be instantiated and called as such:
 * LRU.LRUCache obj = new LRU.LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Your LRU.LRUCache object will be instantiated and called as such:
 * LRU.LRUCache obj = new LRU.LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
