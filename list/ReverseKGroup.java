package leetcode.list;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        int i = 0;
        ListNode t = head;
        ListNode oldH = head;
        ListNode oldT = null;
        ListNode pre = null;
        while(t != null) {
            if(i == 0) {
                oldT = t;
                pre = t;
                t = t.next;
            }
            else {
                ListNode nex = t.next;
                t.next = pre;
                pre = t;
                if(i == k - 1) {
                    oldT.next = nex;
                    if(oldH == head) {
                        head = t;
                    } else {
                        oldH.next = t;
                    }
                    oldH = oldT;
                }
                t = nex;
            }

            i = (i + 1) % k;
        }
        return head;
    }
}
