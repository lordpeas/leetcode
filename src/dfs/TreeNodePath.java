package dfs;

import bin.TreeNode;

import java.util.*;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年6月29日 22:47
 */
public class TreeNodePath {

    private List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (Objects.isNull(root)) return Collections.emptyList();
        LinkedList<Integer> trace = new LinkedList<>();
        traceBack(root, trace);
        return res;
    }

    private void traceBack(TreeNode node, LinkedList<Integer> trace) {
        if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
            trace.add(node.val);
            res.add(convertTrace2String(trace));
            trace.removeLast();
            return;
        }

        trace.add(node.val);
        if (!Objects.isNull(node.left)) {
            traceBack(node.left, trace);
        }

        if (!Objects.isNull(node.right)) {
            traceBack(node.right, trace);
        }

        trace.removeLast();
    }

    private String convertTrace2String(LinkedList<Integer> trace) {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : trace) {
            if (sb.length() != 0) {
                sb.append("->");
            }

            sb.append(integer);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode letf = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode ch = new TreeNode(5);
        root.left = letf;
        root.right = right;
        letf.right = ch;
        TreeNodePath path = new TreeNodePath();
        System.out.println(path.binaryTreePaths(root));
    }
}
