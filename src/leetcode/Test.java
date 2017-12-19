package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by user on 2017/5/11.
 */
public class Test {
    public static void  main(String[] args) {
        System.out.println("hello");
        HashSet<Integer> s = new HashSet<Integer>();
        s.add(1);
        s.toArray();

        StringBuilder sb = new StringBuilder();
        sb.insert(0, 12);
        sb.insert(0,13);
        System.out.println(sb);

        String  s1 = "asdfg";
        System.out.println(s1);

        String  s2 = "asdfg";
        System.out.println(s2);

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i=0; i<s1.length(); i++) {
            hm.put(s1.charAt(i) - 'a', 1);
        }
        for (int i=0; i<s2.length(); i++) {
            hm.remove(s2.charAt(i) - 'a');
        }

        if (hm.size() > 0) {
            System.out.println("不同");
        } else {
            System.out.println("相同");
        }
        System.out.println(s1.substring(0));
        System.out.println(s1.substring(0, 1));

        String s3 = "12345";
        char s0 = s3.charAt(0);
        System.out.println(s0);

        System.out.println(s3.substring(1, 3));

        int[] n1 = {1,5,3};
        int[] n2 = {4,2,6};
        int[] res = new int[6];
        System.arraycopy(n1, 0, res, 0, 3);
        System.arraycopy(n2, 0, res, 3, 3);
        System.out.print(Arrays.toString(res));
        Arrays.sort(res);
        System.out.print(Arrays.toString(res));



    }
}
