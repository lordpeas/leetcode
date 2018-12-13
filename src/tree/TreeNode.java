package tree;

/**
 * descrition：
 *
 * @author: Tianqi Cui
 * @create: 2018/12/13 18:03
 * @company: www.ideabinder.com
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode setLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode getRight() {
        return right;

    }

    public TreeNode setRight(TreeNode right) {
        this.right = right;
        return this;
    }
}
