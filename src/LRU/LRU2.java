package LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年7月11日 22:02
 */
public class LRU2 {
    private DoubleList queue;

    private Map<Integer, Node> map;

    private int capacity;

    public LRU2(int capacity) {
        this.queue = new DoubleList();
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node<Integer, Integer> value = map.get(key);
        if (value != null) {
            queue.remove(value);
            queue.addLast(value);
            return value.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node<Integer, Integer> node = new Node<>(key, value);
        if (map.containsKey(key)) {
            //覆盖
            Node old = map.put(key, node);
            queue.remove(old);
            queue.addLast(node);
        } else {
            //新增
            if (map.size() >= capacity) {
                //淘汰
                Node<Integer, Integer> abort = queue.removeFirst();
                if (null != abort) {
                    map.remove(abort.key);
                }
            }
            //新增
            map.put(key, node);
            queue.addLast(node);
        }
    }


    class DoubleList {
        private int size;
        private Node head, tail;

        public DoubleList() {
            this.head = new Node<>(-1, -1);
            this.tail = new Node<>(-1, -1);
            head.next = tail;
            tail.prev = head;
            this.size = 0;
        }

        public void addLast(Node x) {
            tail.prev.next = x;
            x.prev = tail.prev;
            x.next = tail;
            tail.prev = x;
            size++;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeFirst() {
            if (head.next == tail) {
                return null;
            }

            Node x = head.next;
            remove(x);
            size--;
            return x;
        }
    }

    class Node<K, V> {
        private K key;

        private V value;

        private Node<K, V> prev;

        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
//        ["LRUCache","put","put","get","put","get","put","get","get","get"]
//             [[2],  [1,1],[2,2],[1],  [3,3],[2],[4,4],[1],[3],[4]]

        LRU2 lru = new LRU2(2);
        lru.put(1, 1);
        lru.put(2, 2);
        int i = lru.get(1);
        lru.put(3, 3);
        int i1 = lru.get(2);
        lru.put(4, 4);
        int i2 = lru.get(1);
        int i3 = lru.get(3);
        int i4 = lru.get(4);
    }
}
