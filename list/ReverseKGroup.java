package leetcode.list;


public class ReverseKGroup {

    private ListNode reverseNodes(ListNode start, ListNode end) {
        ListNode curStart = start.next;
        ListNode pre = start.next;
        ListNode t = start.next.next;
        while(t != end) {
            ListNode nex = t.next;
            t.next = pre;
            pre = t;
            t = nex;
        }
        start.next = pre;
        curStart.next = end;
        return curStart;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int i = 0;
        ListNode node = new ListNode(0);
        node.next = head;
        head = node;
        ListNode t = head.next;
        ListNode start = head;
        while(t != null) {
            t = t.next;
            if(i == k - 1) {
                start = reverseNodes(start, t);
            }
            i = (i + 1) % k;
        }
        return head;
    }
}
