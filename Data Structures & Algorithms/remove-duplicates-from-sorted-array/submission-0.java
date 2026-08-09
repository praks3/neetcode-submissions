class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0;
        for(int i=1;i<nums.length;i++){
            if(nums[left]!=nums[i]){
                left++;
                swap(nums,left,i);
            }
        }
        return left+1;
    }
    public void swap(int[] nums,int i,int j){
        int temp= nums[i];
        nums[i]=nums[j];
        nums[j]=nums[i];
    }
}