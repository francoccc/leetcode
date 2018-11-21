package leetcode;

import leetcode.tree.TreeNode;


public class Solution {

    private boolean cancel = false;
    private boolean end = true;
    private TreeNode ans;
    private int md = Integer.MAX_VALUE;

    private void deepthSearch(TreeNode t, TreeNode p, TreeNode q, int d) {
        if(cancel) return;
        if(null != t.left) deepthSearch(t.left, p, q, d + 1);
        if((t == p || t == q) && (end = !end)) {
            cancel = true;
        }
        if(!end || cancel) {
            if(d < md) {
                md = d;
                ans = t;
            }
        }
        if(null != t.right) deepthSearch(t.right, p, q, d + 1);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        deepthSearch(root, p, q, 0);
        return ans;
    }
}
