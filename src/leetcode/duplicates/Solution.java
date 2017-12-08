package leetcode.duplicates;

import com.sun.deploy.util.SyncAccess;

import java.util.*;

import static java.lang.Math.abs;

/**
 * Created by user on 2017/5/31.
 */
public class Solution {
    public int findDuplicates(int[] nums) {
        /*
        List<Integer> res = new ArrayList<Integer>(0);
        int len = nums.length;
        for (int i=0; i< len; i++) {
            int val = Math.abs(nums[i]) - 1;
            if ( nums[val] < 0) {
                res.add(Math.abs(nums[i]));
                System.out.println(Math.abs(nums[i]));
            } else {
                nums[val] = -nums[val];
            }
        }
        return res;
        */
        // 鸽子原理
        /*
        int low = 1, heigh = nums.length - 1;
        int i = 0, cnt = 0;
        while (low < heigh) {
            int mid = low + (heigh - low) / 2;
            for (; i<nums.length; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                heigh = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
        */

        //快慢指针
        int fast = 0, slow = 0;
        while (true) {
           slow = nums[slow];
           fast = nums[nums[fast]];
           if (slow == fast) {
                break;
           }
        }

        int t = 0;
        while(true) {
            slow = nums[slow];
            t = nums[t];
            if (slow == t) {
                break;
            }
        }

        return t;
}

    public static void main(String[] args) {
        int[] a = {5,4,3,2,1,1};
        Solution s = new Solution();
        int v = s.findDuplicates(a);
        System.out.println(v);
    }
}
