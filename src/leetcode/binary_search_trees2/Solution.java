package leetcode.binary_search_trees2;

import leetcode.common.ListNode;
import leetcode.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import javax.xml.transform.SourceLocator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017/12/6.
 */
public class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<TreeNode>();
        }
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> res  = new ArrayList<TreeNode>();
        if (start < end) {
            res.add(null);
            return res;
        }

        for (int i=start; i <= end; i++) {
            List<TreeNode> lefts = helper(start, i - 1);
            List<TreeNode> rightss = helper(i+1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rightss) {
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = left;
                    tmp.right = right;
                    res.add(tmp);
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        List<TreeNode> res = s.generateTrees(3);
        System.out.println(res.size());
    }
}
