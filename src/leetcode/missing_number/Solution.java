package leetcode.missing_number;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

/**
 * Created by user on 2017/6/8.
 */
public class Solution {

    public int missingNumber(int[] nums) {
        /// 1
        /*
        int len = nums.length;
        Arrays.sort(nums);
        int i = 0;
        for (; i< len; i++) {
           if (nums[i] != i) {
               break;
           }
        }
        return i;
        */

        // 2 异或操作--相同的疑惑为零,所以用一个完整的数列和残缺的数列异或操作，就剩下少的数字
        /*
        int len = nums.length;
        int i = 0, res = 0;
        for (; i< len; i++) {
            // 为什么是i+1 而不是i，当缺少的是0时，所得的结果就是零
            // 为i时，[0],会漏掉这种情况
            res ^= (i + 1) ^ nums[i];
        }
        return res;
        */

        //3 等差数列求和公式
        int len = nums.length;
        int i = 0, sum = 0;
        for (; i< len; i++) {
            sum += nums[i];
        }
        return len * (len + 1) / 2 - sum;

    }

    public static void main(String[] args) {
        int[] arr = {0,1,3};
        Solution s = new Solution();
        int res = s.missingNumber(arr);
        System.out.println(res);
    }
}
