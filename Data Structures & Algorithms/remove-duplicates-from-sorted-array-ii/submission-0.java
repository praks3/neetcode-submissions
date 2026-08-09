class Solution {
    public int removeDuplicates(int[] nums) {
        int pointer=0;
        for(int i=0;i<nums.length;i++){
            if(pointer<2 || nums[i]!=nums[pointer-2]){
                nums[pointer] =nums[i];
                pointer++;
            }
        }
        return pointer;
    }
}