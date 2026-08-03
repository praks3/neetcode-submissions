class Solution {
    /*
    BF:nested loop
    Better: prefix sum
    Optimal: just compute the  total and calc the left on go,from left and 
    total calc right and compare both
    */
    public int pivotIndex(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        int left=0;
        for(int i=0;i<nums.length;i++){
        int right=total-nums[i]-left;
        if(left==right) return i;
        left+=nums[i];
        }
        return -1;
    }
}