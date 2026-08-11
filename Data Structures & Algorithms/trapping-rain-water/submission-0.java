class Solution {
    public int trap(int[] heights) {
        /*
        BF:Use prefixMax and suffixMax to find the left and right max for an 
        index...
        Better..Instead of calc prefixMax before hand we can calc it while 
        traversing only
        */
        int n=heights.length;
        // int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        int total=0;
        int  prefixMax=heights[0];
        // prefixMax[0]=heights[0];
        // for(int i=1;i<n;i++){
        //     prefixMax[i]=Math.max(prefixMax[i-1],heights[i]);
        // }
        suffixMax[n-1]=heights[n-1];
        for(int i=n-2;i>=0;i--){
            suffixMax[i]=Math.max(suffixMax[i+1],heights[i]);
        }
        for(int i=0;i<n;i++){
            if(i>0) prefixMax=Math.max(prefixMax,heights[i-1]);
            if(heights[i]<suffixMax[i] && heights[i]<prefixMax ){
                total+=Math.min(prefixMax,suffixMax[i])-heights[i];
            }
        }

        return total;
    }
}
