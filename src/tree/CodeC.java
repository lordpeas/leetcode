package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年1月31日 17:26
 */
public class CodeC {
    private String SEP = ",";

    private String NULL = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.substring(0,sb.lastIndexOf(SEP)).toString();
    }

    private void preOrder(TreeNode root, StringBuilder resBuilder) {
        if (root == null) {
            resBuilder.append(NULL).append(SEP);
            return;
        }

        resBuilder.append(root.val).append(SEP);
        preOrder(root.left, resBuilder);
        preOrder(root.right, resBuilder);
    }

    //1,2,3,#,#,4,5
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(SEP);
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : array) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes){
        if(nodes.isEmpty()) return null;
       String first = nodes.removeFirst();
        if (NULL.equals(first)) return null;
       TreeNode root = new TreeNode(Integer.parseInt(first));
       root.left = deserialize(nodes);
       root.right = deserialize(nodes);
       return root;
    }



    String serialize1(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            TreeNode cur = que.poll();
            if (cur==null){
                sb.append(NULL).append(SEP);
                continue;
            }

            sb.append(cur.val).append(SEP);
            que.offer(cur.left);
            que.offer(cur.right);
        }
        return  sb.toString();
    }



// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
