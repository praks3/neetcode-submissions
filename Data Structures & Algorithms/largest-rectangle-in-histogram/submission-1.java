class Solution {
    public int largestRectangleArea(int[] heights) {
        /*
        Optimal: Use one stack and calc previous and next smaller element on the
        fly while traversing.
        */
        Deque<Integer> stack = new ArrayDeque<>();
    int maxArea = 0;

    for (int i = 0; i < heights.length; i++) {

        while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {

            int currIndex = stack.pop();

            int prevSmallest = stack.isEmpty() ? -1 : stack.peek();

            int area = heights[currIndex] * (i - prevSmallest - 1);

            maxArea = Math.max(maxArea, area);
        }

        stack.push(i);
    }

    while (!stack.isEmpty()) {

        int nextSmallest = heights.length;

        int currIndex = stack.pop();

        int prevSmallest = stack.isEmpty() ? -1 : stack.peek();

        int area = heights[currIndex] * (nextSmallest - prevSmallest - 1);

        maxArea = Math.max(maxArea, area);
    }

    return maxArea;
    }
}
