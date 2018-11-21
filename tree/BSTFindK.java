package leetcode.tree;

public class BSTFindK {

    private int index = 0;
    private int ans;

    private void find(TreeNode root, int k) {
        if(null != root.left) find(root.left, k);
        index++;
        if(index == k) {
            ans = root.val;
            return;
        }
        if(null != root.right) find(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        find(root, k);
        return ans;
    }
}
