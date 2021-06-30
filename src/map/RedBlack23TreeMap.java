package map;


import java.util.NoSuchElementException;
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
        if (isEmpty()) {
            throw new NoSuchElementException("BST underflow");
        }

        //左右子节点均为单 key节点
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = Node.RED;
        }
        root = deleteMin(root);
        if (!isEmpty()) {
            root.color = Node.BLACK;
        }

    }

    private Node deleteMin(Node node) {
        if (Objects.isNull(node.left)) {
            return null;
        }

        //如果左子节点是单key节点
        if (!isRed(node.left) && !isRed(node.left.left)) {
            node = moveRedToLeft(node);
        }

        node.left = deleteMin(node.left);
        if (!isEmpty()) {
            root.color = Node.BLACK;
        }
        return reBalance(node);
    }

    private Node moveRedToLeft(Node h) {
        //反向着色
        filpcolor(h);
        //如果左子节点兄弟节点是双key节点
        if (isRed(h.right.left)) {
            //该兄弟节点右旋
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            filpcolor(h);
        }
        return h;
    }

    @Override
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("BST under flow");
        }
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = Node.RED;
        }

        root = deleteMax(root);
        if (!isEmpty()) {
            root.color = Node.BLACK;
        }
    }

    private Node deleteMax(Node h) {
        //与删除最小值不同，若左侧子节点为红色，先借一个到右侧
        //  --如果左侧借空了，直接向下递归了
        if (isRed(h.left)) {
            h = rotateRight(h);
        }

        if (Objects.isNull(h.right)) {
            return null;
        }

        //如果右子节点为单key节点
        // 根据红黑树定律，路径包含相同的黑色节点，故左侧子节点包含一个不为空的黑色节点
        //通过右旋，为右侧节点增加一个红色节点
        if (!isRed(h.right) && isRed(h.right.left)) {
            h = moveRedToRight(h);
        }

        h.right = deleteMax(h.right);
        return reBalance(h);
    }


    private Node moveRedToRight(Node h) {
        //颜色反转
        filpcolor(h);
        //左子节点是双key节点
        if (isRed(h.left.left)) {
            //右旋
            h = rotateRight(h);
            //颜色反转
            filpcolor(h);
        }
        return h;
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

            //右子节点出现红色 ，左旋
            if (isRed(node.right) && !isRed(node.left)) {
                node = rotateLeft(node);
            }
            //左子节点及子子节点出现红色
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
        if (isEmpty()) {
            throw new IllegalArgumentException(" Key can not be null");
        }

        //根节点变色
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = Node.RED;
        }

        root = delete(root, key);
        //颜色变回来
        if (isEmpty()) {
            root.color = Node.BLACK;
        }
    }

    private Node delete(Node root, K key) {
        if (Objects.isNull(key)) {
            throw new IllegalArgumentException("kye can not be null");
        }

        int compare = key.compareTo(root.key);
        if (compare > 0) {
            //删除大于根节点的值
            if (isRed(root.left)) {
                root = rotateRight(root);
            }

            //如果右子节点为单key节点
            //根据红黑树定律，路径包含相同的黑色节点，故左侧子节点包含一个不为空的黑色节点
            //通过右旋，为右侧节点增加一个红色节点
            if (!isRed(root.right) && !isRed(root.right.left)) {
                root = moveRedToRight(root);
            }

            root.right = delete(root.right, key);
        } else if (compare < 0) {
            //删除小于根节点的值
            if (!isRed(root.left) && !isRed(root.left.left)) {
                root = moveRedToLeft(root);
            }

            root.left = delete(root.left,key);
        }else {
            if(Objects.isNull(root.left)&&Objects.isNull(root.right)){
                return null;
            }

            //左侧节点不为空，与左侧最大值交换
            if(!Objects.isNull(root.left)){
              Node max =  max(root.left);
              root.key = max.key;
              root.value = max.value;
              root.left = deleteMax(root.left);
            }else{
                //右侧节点不为空，与右侧最小值交换
                Node min =  min(root.right);
                root.key = min.key;
                root.value = min.value;
                root.left = deleteMin(root.left);
            }
        }
        return reBalance(root);
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
