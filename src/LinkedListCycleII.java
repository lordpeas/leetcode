
/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021/3/9 20:50
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if(null == head|| head.next == null){
            return null;
        }

        ListNode slow,fast;
        slow =head.next;
        fast = head.next.next;

        while(slow!=fast){
            if(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }else{
                return null;
            }
        }

        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;


        ListNode node = new LinkedListCycleII().detectCycle(node1);
        System.out.println(node);
    }

}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }
}
