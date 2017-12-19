package leetcode.classic_sort;

import java.lang.reflect.Array;
import java.util.Arrays;

// from  https://www.cnblogs.com/eniac12/p/5329396.html

/**
 * Created by user on 2017/12/19.
 */
public class Solution {
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 冒泡排序
    public void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i=0; i<len-1; i++) {
            for (int j=0; j<len-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    // 鸡尾酒排序
    public void cocktailSort(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len -1;
        while (left < right) {
            for (int i=left; i<right; i++) {
                if (nums[i] > nums[i+1]) {
                    swap(nums, i, i+1);
                }
            }
            right--;

            for (int i=right; i>left; i--) {
                if (nums[i-1] > nums[i]) {
                    swap(nums, i-1, i);
                }
            }
            left++;
        }

        System.out.println(Arrays.toString(nums));
    }

    // 选择排序
    public void selectSort(int[] nums) {
        int len = nums.length;
        for (int i=0; i<len-1; i++) {
            int min = i;
            for (int j=i+1; j<len; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(nums, min, i);
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    // 插入排序
    public void insertSort(int[] nums) {
        int len = nums.length;
        for (int i=1; i<len; i++) {
            int get = nums[i];
            int j = i-1;
            while (j >=0 && nums[j] > get) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = get;
        }

        System.out.println(Arrays.toString(nums));
    }

    // 二分插入排序
    public void binaryInsertSort(int[] nums) {
        int len = nums.length;
        for (int i=1; i<len; i++) {
            int get = nums[i];
            int left = 0;
            int right = i - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (nums[mid] > get) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i-1; j >=left; j--) {
                nums[j+1] = nums[j];
            }
            nums[left] = get;
        }

        System.out.println(Arrays.toString(nums));
    }

    // 希尔排序
    public void shellSort(int[] nums) {
        int len = nums.length;
        int h = 0;
        while (h <= len) {
            h = h*3 +1;
        }

        while (h >= 1) {
            for (int i=1; i<len; i++) {
                int get = nums[i];
                int j = i - 1;
                while (j >= 0 && nums[j] > get) {
                    nums[j+1] = nums[j];
                    j--;
                }
                nums[j+1] = get;
            }
            h = (h-1) / 3;
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {9,3,6,1,2,5,4,8,7};
        // s.bubbleSort(nums);
        // s.cocktailSort(nums);
        // s.selectSort(nums);
        // s.insertSort(nums);
        // s.binaryInsertSort(nums);
        s.shellSort(nums);
        // s.binaryInsertSort(nums);
        // s.binaryInsertSort(nums);
        // s.binaryInsertSort(nums);
        // s.binaryInsertSort(nums);

    }
}
