package bin;

/**
 * descrition：
 *
 * @author: stone
 * @create: 2018/07/21 17:26
 * @company: www.ideabinder.com
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

   public TreeNode(int x) {
        this.val = x;
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

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
