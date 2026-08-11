class Solution {
    public int trap(int[] heights) {
        /*
        Optimal:
        At every step, process the side with the smaller current wall because it 
        is the bottleneck. Use the tallest wall seen so far on that side 
        (`leftMax`/`rightMax`) to calculate the trapped water at the current 
        position. Then move that pointer inward.
        */        
        int total=0,leftMax=0,rightMax=0;
        int left=0,right=heights.length-1;
        while(left<right){
            if(heights[left]<=heights[right]){
                leftMax=Math.max(leftMax,heights[left]);
                total+=leftMax-heights[left];
                left++;
            }else{
                rightMax=Math.max(rightMax,heights[right]);
                total+=rightMax-heights[right];
                right--;
            }
        }
        return total;
    }
}
