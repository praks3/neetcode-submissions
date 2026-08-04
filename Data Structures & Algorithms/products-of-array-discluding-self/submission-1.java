class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        BF: nested for loop
        Optimal: find product prefix and suffix prefix and then mulitply 
        both
        More optimal: in one array only first find prefix and then 
        calculate the suffix also.
        */
        int[] output= new int[nums.length];

        output[0]=1;
        for(int i=1;i<nums.length;i++){
            output[i]=output[i-1]*nums[i-1];
        }
        int productSuffix=1;
        for(int i = nums.length-1;i>=0;i--){
            output[i] *= productSuffix;
            productSuffix*=nums[i];
        }
        
        return output;
    }
}  
