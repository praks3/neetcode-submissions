class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap= new HashMap<>();
        
        for(int n:nums ){
            freqMap.put(n,freqMap.getOrDefault(n,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a,b)->b.getValue() - a.getValue());
        int [] result = new int[k];
        for(int i=0;i<k;i++){
            result[i]=list.get(i).getKey();
        }
        return result;
    }
}
