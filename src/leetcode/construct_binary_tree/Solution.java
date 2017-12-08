package leetcode.construct_binary_tree;

import leetcode.common.ListNode;
import leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by user on 2017/5/11.
 */

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        return buildTree(preorder, 0, len-1, inorder, 0, len-1);
    }

    public TreeNode buildTree(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart > pend || istart > iend) {
           return null;
        }

        int rootVal = preorder[pstart];
        int rootIndex = 0;
        for (int i=0; i<inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        int len = rootIndex - istart;
        TreeNode treeNode = new TreeNode(rootVal);
        treeNode.left = buildTree(preorder, pstart + 1, pstart + len, inorder, istart, rootIndex - 1);
        treeNode.right = buildTree(preorder, pstart + len + 1, pend, inorder, rootIndex + 1, iend);

        return treeNode;
    }

    public void levelTravel(TreeNode root){
        if(root==null)return;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp =  q.poll();
            System.out.println(temp.val);
            if(temp.left!=null)q.add(temp.left);
            if(temp.right!=null)q.add(temp.right);
        }
    }

    public static void main(String[] args) {
        int arr1[] = {1,2,4,5,3,6,7};
        int arr2[] = {4,2,5,1,6,3,7};
        Solution s = new Solution();
        TreeNode k = s.buildTree(arr1, arr2);
        System.out.println(k.val);
        s.levelTravel(k);
    }

}
