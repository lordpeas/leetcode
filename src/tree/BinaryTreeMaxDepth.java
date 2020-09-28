package tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * descrition：
 *
 * @author: Tianqi Cui
 * @create: 2018/12/13 18:01
 * @company: www.ideabinder.com
 */
public class BinaryTreeMaxDepth {

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth1(root.left);
        int rightDepth = maxDepth1(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }


    /**
     * 该方法用到了广度优先遍历
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }
        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(new Pair(root.left, current_depth + 1));
                stack.add(new Pair(root.right, current_depth + 1));
            }
        }
        return depth;
    }


    public static void main(String[] args) {
        System.out.println("hah");
    }

}


