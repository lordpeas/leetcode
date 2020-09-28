package tree;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * descrition：广度优先
 *
 * @author: Tianqi Cui
 * @create: 2018/12/13 19:36
 */
public class BFSTravelersal {

    public int bfsTravelersal(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queque = new LinkedList<>();
        if (root != null) {
            queque.add(new Pair(root, 1));
        }
        int depth = 0;
        while (!queque.isEmpty()) {
            Pair<TreeNode, Integer> current = queque.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                queque.add(new Pair(root.left, current_depth + 1));
                queque.add(new Pair(root.right, current_depth + 1));
            }
        }
        return depth;
    }

}
