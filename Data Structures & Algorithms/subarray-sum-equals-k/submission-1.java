class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> freqMap =new HashMap<>();
        int count=0,prefix=0;
        freqMap.put(0,1);

        for(int n:nums){
            prefix+=n;
            count += freqMap.getOrDefault(prefix - k, 0);
            freqMap.put(prefix,freqMap.getOrDefault(prefix,0)+1);
        }
        return count;
    }
}