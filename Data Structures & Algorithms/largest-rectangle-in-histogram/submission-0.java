class Solution {
    public int largestRectangleArea(int[] heights) {
        /*
        Simple brute force mein:

        Har index i ko ek baar main bar maan lo. Uski height heights[i] hogi.

        Ab left mein jao aur jab tak bar ki height >= heights[i] hai, tab tak
        expand karo.

        Similarly right mein jao aur jab tak height >= heights[i] hai, tab tak
        expand karo.
        
        Isse humein us bar ke liye maximum possible width mil jayega.
        
        Phir: area = heights[i] × width
        Har bar ka area calculate karke maximum area return kar do.
        */
        int[] pse = pse(heights);
        int[] nse = nse(heights);
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1);
            max = Math.max(max, area);
        }
        return max;
    }

    public int[] pse(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] pse = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }
    public int[] nse(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] nse = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        return nse;
    }
}
