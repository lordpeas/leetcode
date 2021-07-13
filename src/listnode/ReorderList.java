package listnode;

import java.util.LinkedList;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年7月13日 23:50
 */
public class ReorderList {

    public void reorderList(ListNode head) {

        LinkedList<ListNode> stack = new LinkedList<>();

        ListNode node = head;

        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        ListNode cur = head;

        ListNode stackCur = new ListNode(-1);

        while (cur.next != stackCur.next) {
            stackCur = stack.pop();
            stackCur.next = cur.next;
            cur.next = stackCur;
            cur = cur.next.next;
        }

        stackCur.next = null;
    }

    public static void main(String[] args) {
        ListNode draw = ListNode.draw(new int[]{1, 2, 3});
        ReorderList list = new ReorderList();
        list.reorderList(draw);
    }
}
