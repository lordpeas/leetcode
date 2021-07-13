//package LRU;
//
///**
// * Description: leetcode
// * Created by : Tianqi Cui
// * Create Date: 2021年7月11日 22:56
// */
//public class Node<K, V> {
//    private K key;
//
//    private V value;
//
//    private Node<K, V> prev;
//
//    private Node<K, V> next;
//
//    public Node(K key, V value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    public static  <K, V> Node<K, V> getNode(K key, V value) {
//        Node<K, V> node = new Node<>(key, value);
//        return node;
//    }
//}