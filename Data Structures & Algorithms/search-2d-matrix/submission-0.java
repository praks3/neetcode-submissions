class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int targetRow=-1;
        for(int r=0; r< matrix.length;r++){
            if(target<=matrix[r][matrix[0].length-1]){
                targetRow=r;
                break;
            }
        }
        if(targetRow==-1) return false;
        int left =0,right =matrix[0].length-1;
        while(left<=right){
            int mid =left+ (right-left)/2;
            if(matrix[targetRow][mid]== target) return true;
            else if(matrix[targetRow][mid]<target) left= mid+1;
            else right= mid-1;
        }
        return false;
    }
}
