class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        BF: Sort and check adjacent and find longest consective sequence
        */
        if(nums==null) return 0;
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int count=1,maxCount=1;

        for(int i=0;i<=nums.length-2;i++){
            int diff=nums[i+1]-nums[i];
            if(diff==1){
                count++;
            }else if(diff>1){
                maxCount=Math.max(maxCount,count);
                count=1;
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}
