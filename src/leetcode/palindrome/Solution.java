package leetcode.palindrome;

/**
 * Created by user on 2017/5/11.
 */

public class Solution {

    public boolean isPalindrome(int x) {
        int max = x;
        int min = 0;
        while (max > 0) {
            min *= 10;
            min += max % 10;
            max /= 10;
        }

        return min == x;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean res = s.isPalindrome(1221);
        System.out.println(res);
    }
}
