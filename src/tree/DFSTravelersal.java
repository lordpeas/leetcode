package tree;

import java.util.Stack;

/**
 * descrition：
 *
 * @author: Tianqi Cui
 * @create: 2018/12/13 19:08
 * @company: www.ideabinder.com
 */
public class DFSTravelersal {


    public static void bfsTraveleral(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack();

        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                System.out.println(node.val);
                TreeNode right = node.right;
                TreeNode left = node.left;
                stack.push(right);
                stack.push(left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(3).setLeft(new TreeNode(9).setLeft(new TreeNode(2).setLeft(new TreeNode(1).setLeft(new TreeNode(55))))).setRight(new TreeNode(20).setLeft(new TreeNode(15)).setRight(new TreeNode(7)));

        bfsTraveleral(root);

    }

}
