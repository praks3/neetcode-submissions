class Solution {
    public int maxArea(int[] heights) {
        int maxAmt = 0;
        int left = 0, right = heights.length - 1;
        while (left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            maxAmt = Math.max(maxAmt, (minHeight * (right - left)));
            if(heights[left]<heights[right]) left++;
            else right--;
        }
        return maxAmt;
    }
}
