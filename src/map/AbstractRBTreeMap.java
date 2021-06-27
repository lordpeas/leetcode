package map;


import java.util.Objects;

public abstract class AbstractRBTreeMap<K extends Comparable<K>, V> implements SortedMap<K, V> {

    protected Node root;


    class Node implements TreeNode {

        public static final boolean RED = true;
        public static final boolean BLACK = false;

        public K key;

        public V value;

        public Node left;

        public Node right;

        public boolean color;

        private int size = 1;

        public Node(K key, V value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }

        @Override
        public Node getLeft() {
            return this.left;
        }

        @Override
        public Node getRight() {
            return this.right;
        }



        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public boolean getColor() {
            return color ? RED : BLACK;
        }



        public void setColor(boolean color) {
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }


    /**
     * 获取节点个数
     *
     * @param
     * @return
     */

    @Override
    public int size(){
        return size(root);
    }

    public int size(Node node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node.size;
    }

    /**
     * 判断节点颜色
     *
     * @param node
     * @return
     */
    public boolean isRed(Node node) {
        if (Objects.isNull(node)) {
            return Node.BLACK;
        }
        return node.color;
    }

    /**
     * 左旋
     *
     * @param h
     * @return
     */
    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = Node.RED;
        size(x);
        size(h);
        return x;
    }

    /**
     * 右旋
     *
     * @param h
     * @return
     */
    public Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = Node.RED;
        size(x);
        size(h);
        return x;
    }

    /**
     * 颜色反转
     * @param h
     */
    public void filpcolor(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    /**
     *get
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        if (Objects.isNull(key)) {
            throw new IllegalArgumentException("the key can't null");
        }
        Node res = get(root, key);
        return Objects.isNull(res) ? null : res.getValue();

    }


    private Node get(Node node, K key) {
        int compare = key.compareTo(root.key);
        if (compare > 0) {
            return get(node.right, key);
        } else if (compare < 0) {
            return get(node.left, key);
        } else {
            return node;
        }
    }


    @Override
    public K min() {
        Node min = min(root);
        return min.key;
    }

    @Override
    public K max() {
        Node max = max(root);
        return max.key;
    }

    private Node min(Node node){
        if(Objects.isNull(node.left)){
            return node;
        }
        return min(node.left);
    }

    private Node max(Node node){
        if(Objects.isNull(node.right)){
            return node;
        }
        return min(node.right);
    }

}
