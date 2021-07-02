package listnode;

/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年7月3日 00:20
 */
public class Add2Sum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode x = l1;
        ListNode y = l2;
        int forword = 0;
        int xv ;
        int yv ;
        ListNode anc = new ListNode(-1);
        ListNode cur = anc;
        while (true) {
            if (x == null && y == null) {
                if (forword == 0) {
                    break;
                }
            }

            if (x != null) {
                xv = x.val;
            }else {
                xv = 0;
            }

            if (y != null) {
                yv = y.val;

            }else {
                yv = 0;
            }

            int sum = xv + yv + forword;
            forword = sum / 10;
            int v = sum % 10;
            cur.next = new ListNode(v);
            cur = cur.next;
            if (x != null) {
                x = x.next;
            }
            if (y != null) {
                y = y.next;
            }
        }
        return anc.next;
    }

    public static void main(String[] args) {
        Add2Sum sum = new Add2Sum();
        ListNode l1 = ListNode.draw(new int[]{9, 9, 9});
        ListNode l2 = ListNode.draw(new int[]{9, 9, 9});
        ListNode res = sum.addTwoNumbers(l1, l2);

        System.out.println(res.val);
    }
}
