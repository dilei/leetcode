package leetcode.remove_boxes;

/**
 * Created by user on 2017/5/11.
 */

public class Solution {

    public int removeBoxes(int[] boxes) {
        int len = boxes.length;
        int dp[][][] = new int[len][len][len];
        return helper(boxes, 0, len-1, 0, dp);
    }

    public int helper(int[] boxes, int i, int j, int k, int dp[][][]) {
        if (i > j) {
           return 0;
        }

        if (dp[i][j][k] > 0) {
           return dp[i][j][k];
        }

        int res = (k+1) * (k+1) + helper(boxes, i+1, j, 0, dp);
        for (int m = i+1; m<=j; m++) {
            if (boxes[m] == boxes[i]) {
                res = Math.max(res, helper(boxes, i+1, m-1, 0, dp) + helper(boxes, m, j, k+1, dp));
            }
        }
        dp[i][j][k] = res;
        return res;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,2,2,5,1,1,1};
        Solution s = new Solution();
        int res = s.removeBoxes(a);
        System.out.println(res);
    }
}
