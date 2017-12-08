package leetcode.inorder;

import java.util.*;

import leetcode.common.TreeNode;


/**
 * Created by user on 2017/11/29.
 */
public class Solution {

    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        this.orderLeft(root);
        return res;
    }

    public void orderLeft(TreeNode root) {
        if (root == null) {
           return;
        }
        if (root.left != null) {
            this.orderLeft(root.left);
        }

        res.add(root.val);

        if (root.right != null) {
            this.orderLeft(root.right);
        }
    }

}
