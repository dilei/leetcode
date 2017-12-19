package leetcode.unique_paths;

/**
 * Created by user on 2017/12/8.
 */
public class Solution {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        return helper(1, 1, m, n);
    }

    public int helper(int i, int j, int m, int n) {
        if (i == m && j == n) {
            return 1;
        }

        if (i < m && j < n) {
            return helper(i, j+1, m, n) + helper(i+1, j, m, n);
        } else if (j < n) {
            return helper(i, j+1, m, n);
        }
        return helper(i+1, j, m, n);
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int cnt = s.uniquePaths(3,3);
        System.out.println(cnt);
    }
}
