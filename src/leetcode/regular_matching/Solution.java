package leetcode.regular_matching;

/**
 * Created by user on 2017/12/6.
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        // 第一种情况
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        // 2 长度为一
        if (p.length() == 1) {
            if (s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
                return true;
            } else {
                return false;
            }
        }

        // 3 第二位不是 *
        if (p.charAt(1) != '*') {
            if (s.isEmpty()) {
                return false;
            }
            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }

        //  4 第二位是 *
        while (s.isEmpty() == false && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            s = s.substring(1);
        }

        System.out.println(s);
        return isMatch(s, p.substring(2));
    }

    public static void main(String args[]) {
        // System.out.println("sb".substring(1));
        Solution s = new Solution();
        // boolean b = s.isMatch("aa", "a");
       //  boolean b = s.isMatch("aa", "aa");
        // boolean b = s.isMatch("aaa", "aa");
        // boolean b = s.isMatch("aaa", "aa*");
        // boolean b = s.isMatch("aa", ".*");
        // .* == ..* == ...* == ........
        // boolean b = s.isMatch("aab", "c*a*b");

        String str = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbabaaabb";
        String ptr = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        boolean b = s.isMatch(str, ptr);
        System.out.println(b);
    }



}
