package leetcode.wildcard_matching;

/**
 * Created by user on 2017/12/7.
 */
class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        if (p.length() == 1 && p.charAt(0) == '*') {
            return true;
        }

        if (p.charAt(0) != '*') {
            if (s.isEmpty()) {
                return false;
            }

            return (p.charAt(0) == s.charAt(0) || p.charAt(0) == '?') && isMatch(s.substring(1), p.substring(1));
        }

        while (!p.isEmpty() && p.charAt(0) == '*') {
            p = p.substring(1);
        }
        if (p.isEmpty()) {
            return true;
        }

        while (!s.isEmpty()) {
            if (isMatch(s, p)) {
                return true;
            }
            s = s.substring(1);
        }

        return false;
    }

    public static void main(String args[]) {
        /*
        "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb"
        "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"
        */
        Solution so = new Solution();
        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbabaaabb";
        String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        boolean res = so.isMatch(s, p);
        System.out.println(res);
    }
}
