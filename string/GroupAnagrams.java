package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {

    private List<List<String>> ans = new ArrayList<>();
    private TreeNode root = new TreeNode(' ');
    private int index = 0;

    class TreeNode {
        char c;
        int index;
        TreeNode[] child;

        public TreeNode(char c) {
            this.c = c;
            child = new TreeNode[26];
        }

        public void add(TreeNode t) {
            child[t.c - 'a'] = t;
        }

        public boolean has(char c) {
            return child[c - 'a'] != null;
        }

        public TreeNode child(char c) {
            return child[c - 'a'];
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    private int hasStr(String str) {
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        TreeNode t = root;
        int permit = -1;
        for(int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if(!t.has(c)) {
                t.add(new TreeNode(c));
                permit = 0;
            }
            if(permit == 0 && i == chs.length - 1) {
                t.child(c).setIndex(++index);
            }
            t = t.child(c);
        }
        permit = permit == -1 ? t.getIndex() : permit;
        return permit;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        for(String str : strs) {
            int permit = hasStr(str);
            if(permit == 0) {
                List<String> t = new ArrayList<>();
                t.add(str);
                ans.add(t);
            }
            else {
                List<String> t = ans.get(permit - 1);
                t.add(str);
            }
        }
        return ans;
    }
}
