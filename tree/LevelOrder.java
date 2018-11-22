package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {

    LinkedList<MyNode> queue = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();

    class MyNode {
        TreeNode node;
        int d;

        MyNode(TreeNode node, int d) {
            this.node = node;
            this.d = d;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        MyNode node = new MyNode(root, 1);
        queue.add(node);
        List<Integer> t = new ArrayList<>();
        while(!queue.isEmpty()) {
            MyNode n = queue.peek();
            queue.removeFirst();
            if(n.node.left != null) queue.add(new MyNode(n.node.left, n.d + 1));
            if(n.node.right != null) queue.add(new MyNode(n.node.right, n.d + 1));
            t.add(n.node.val);
            if(n.d != queue.peek().d) {
                ans.add(t);
                t = new ArrayList<>();
            }
        }
        return ans;
    }
}
