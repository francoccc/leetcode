package leetcode.list;

import leetcode.list.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ListSort {

    private List<ListNode> nodes = new ArrayList<ListNode>();

    private ListNode mergeList(int l, int r) {
        if(l == r) {
            return nodes.get(l);
        }
        int m = (l + r) / 2;
        ListNode ll = mergeList(l, m);
        ListNode rl = mergeList(m + 1, r);
        ListNode h = null;
        ListNode hlast = null;
        while(null != ll && null != rl) {
            ListNode t;
            if(ll.val < rl.val) {
                t = ll;
                ll = ll.next;
            }
            else {
                t = rl;
                rl = rl.next;
            }
            if(null == h) {
                h = t;
                hlast = t;
            }
            hlast.next = t;
            hlast = t;
        }
        if(null != ll) hlast.next = ll;
        if(null != rl) hlast.next = rl;
        return h;
    }

    public ListNode sortList(ListNode head) {
        int len = 0;
        while(null != head) {
            ListNode l = head;
            nodes.add(l);
            len++;
            head = head.next;
            l.next = null;
        }
        return mergeList(0, len - 1);
    }
}
