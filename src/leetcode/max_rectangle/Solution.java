package leetcode.max_rectangle;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by user on 2017/12/14.
 */
/*
public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int maxArea = 0;
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        System.out.println(Arrays.toString(h));
        while(i < h.length){
            if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                stack.push(i);
                i++;
            } else {
                System.out.print(stack.toString());
                System.out.print("\t");
                int t = stack.pop();
                int square = -1;
                if(stack.isEmpty())
                    square = h[t]*i;
                else{
                    int x = i-stack.peek()-1;
                    square = h[t]*x;
                }
                System.out.print(h[t]);
                System.out.print("\t");
                System.out.print(i);
                System.out.print("\t");
                System.out.println(maxArea);
                maxArea = Math.max(maxArea, square);
            }
        }
        return maxArea;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int[]  arr = {0, 0, 2, 4};
        int val = s.largestRectangleArea(arr);
        System.out.println(val);
    }
}
*/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int res = 0;
        int[] h = new int[col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                h[j] = matrix[i][j] == '0' ? 0 : h[j] + 1;
            }
            res = Math.max(res, maxRect(h));
        }

        return res;
    }

    public int maxRect(int[] height)  {
        int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
        int i = 0;
        int maxArea = 0;

        Stack<Integer> s = new Stack<Integer>();
        while (i < h.length) {
            if (s.isEmpty() || h[s.peek()] <= h[i]) {
                s.push(i);
                i++;
            } else {
                int squence = -1;
                int t = s.pop();
                if (s.isEmpty()) {
                    squence = h[t] * i;
                } else {
                    int len = i - s.peek() - 1;
                    squence = h[t] * len;
                }
                maxArea = Math.max(maxArea, squence);

            }
        }

        return maxArea;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        char[][]  arr = {
                {0, 0, 1, 1},
                {0, 0, 1, 1},
                {0, 0, 1, 1},
                {0, 0, 1, 1},
        };
        int val = s.maximalRectangle(arr);
        System.out.println(val);
    }
}
