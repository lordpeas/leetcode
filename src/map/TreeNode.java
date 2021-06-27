package map;



public interface TreeNode {



    TreeNode getLeft();

    TreeNode getRight();


//
//
//    /**
//     * 判断节点颜色
//     *
//     * @param node
//     * @return
//     */
//    private boolean isRed(TreeNode<K, V> node) {
//        if (Objects.isNull(node)) {
//            return TreeNode.BLACK;
//        }
//        return node.getColor();
//    }
//
//    /**
//     * 左旋
//     *
//     * @param h
//     * @return
//     */
//    private TreeNode<K, V> rotateLeft(TreeNode<K, V> h) {
//        TreeNode<K, V> x = h.right;
//        h.right = x.left;
//        x.left = h;
//        x.color = h.color;
//        h.color = RED;
//        size(h);
//        size(x);
//        return x;
//
//    }


}
