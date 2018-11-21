package leetcode.list;

import leetcode.list.ListNode;

import java.util.Arrays;
import java.util.List;

public class MergeKLists23 {
    private List<ListNode> array;

    private ListNode listMerge(int l, int r) {
        if(l == r) {
            ListNode t = null;
            try {
                t = array.get(l);
            } catch (Exception e) {
            } finally {
                return t;
            }
        }
        int m = (l + r) / 2;
        ListNode ll = listMerge(l, m);
        ListNode rl = listMerge(m+1, r);
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
        if(null != ll) {
            if(null == h) {
                h = ll;
            } else hlast.next = ll;
        }
        if(null != rl) {
            if(null == h) {
                h = rl;
            } else hlast.next = rl;
        }
        return h;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        array = Arrays.asList(lists);
        if(array.size() == 0) {
            return null;
        }
        return listMerge(0, lists.length - 1);
    }
}
