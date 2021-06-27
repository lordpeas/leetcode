package map;


import java.util.Objects;

/**
 * 2-3树实现左倾红黑树（红色节点在左边）
 *
 * @param <K>
 * @param <V>
 */
public class RedBlack23TreeMap<K extends Comparable<K>, V> extends AbstractRBTreeMap<K, V> {


    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public void put(K key, V value) {
        if (Objects.isNull(key)) {
            throw new IllegalArgumentException(" Key can not be null");
        }

        root = put(root, key, value);
        root.setColor(Node.BLACK);
    }

    private Node put(Node node, K key, V value) {
        if (Objects.isNull(node)) {
            node = new Node(key, value, Node.RED);
        } else {
            int compare = key.compareTo(node.getKey());
            if (compare > 0) {
                node.right = put(node.getRight(), key, value);
            } else if (compare < 0) {
                node.left = put(node.left, key, value);
            } else {
                node.value = value;
            }

            //
            if (isRed(node.right) && !isRed(node.left)) {
                node = rotateLeft(node);
            }

            if (isRed(node.left) && isRed(node.left.left)) {
                node = rotateRight(node);
            }

            if (isRed(node.left) && isRed(node.right)) {
                upSlit(node);
            }

            size(node);
        }
        return node;
    }

    private void upSlit(Node node) {
        if (Objects.isNull(node)) {
            return;
        }
        node.left.color = Node.BLACK;
        node.right.color = Node.BLACK;
        node.color = Node.RED;
    }

    @Override
    public void delete(K key) {

    }

    private Node reBalance(Node node) {
        //左边非红色，右边红色
        if (isRed(node.getRight()) && !isRed(node.getRight())) {
            //左旋
            node = rotateLeft(node);
        }

        //左边红色，左 左边也是红色
        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
        }

        if (isRed(node.getLeft()) && isRed(node.getRight())) {
            filpcolor(node);
        }
        return node;
    }
}
