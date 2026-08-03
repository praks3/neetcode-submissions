class Solution {
    /*
    BF:nested loop
    Better: prefix sum
    Optimal: just compute the  total and calc the left on go,from left and 
    total calc right and compare both
    */
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length+1];
        prefix[0]=0;
        for(int i=0;i<nums.length;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        for(int i=1;i<prefix.length;i++){
        
            if(prefix[i-1]==prefix[prefix.length-1]-prefix[i]){
                return i-1;
            }
        }
        return -1;
    }
}