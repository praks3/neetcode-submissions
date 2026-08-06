class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        Optimised: Use hashset to check if consecutive value exists or not
        */
        if(nums==null) return 0;
        if(nums.length==0) return 0;
        int maxCount=0;
        HashSet<Integer> hash = new HashSet<>();
        for(int num:nums){
            hash.add(num);
        }

        for(int num:nums){
           
           if(!hash.contains(num-1)){
                int initial=num;
                int count=1;
                while(hash.contains(initial+1)){
                    initial++;
                    count++;
                }
                maxCount = Math.max(maxCount,count);
           }
        }
        return maxCount;
    }
}
