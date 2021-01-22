package bin;


import java.util.ArrayList;
import java.util.List;

/**
 * descrition：
 *
 * @author: stone
 * @create: 2018/07/21 16:12
 * @company: www.ideabinder.com
 */
public class graph {

    public static boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return true;
        orderBST(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) return false;
        }

        return true;
    }

    /**
     * 中序遍历
     */
    private static void orderBST(TreeNode root, List<Integer> list) {
        if (root == null) return;
        orderBST(root.left, list);
        list.add(root.val);
        orderBST(root.right, list);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode letf = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        right.left = new TreeNode(6);
        right.right = new TreeNode(20);

        root.left = letf;
        root.right = right;
        isValidBST(root);
    }



}

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre =null;
        ListNode cur = head;
        ListNode next = null;

        while(cur!=null){
            next =cur.next;
            cur.next =pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void main(String[] args) {

    }
}




