package listnode;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/6/8 16:01
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head;

        cur.next = pre;

        while (next != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode cur = new ListNode(1);
        ListNode pre = new ListNode(-1);
        ListNode next = new ListNode(2);

        cur.next = pre;
        pre = cur;
        cur = next;
        System.out.println(1);
    }
}

//*Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode draw(int[] list) {
        ListNode node = new ListNode(-1);
        ListNode cur = node;
        for (int i = 0; i <= list.length - 1; i++) {
            ListNode next = new ListNode(list[i]);
            cur.next = next;
            cur = cur.next;
        }
        return node.next;
    }

}
