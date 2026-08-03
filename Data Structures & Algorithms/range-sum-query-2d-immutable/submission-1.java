class NumMatrix {
    /*
    Optimised:
    1->Padded with zero on left and top
    2->Without padding but with index checks for 0
    */
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        prefix = new int [matrix.length][matrix[0].length];
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[0].length;c++){
                int topLeft = (r>0 && c>0)? prefix[r-1][c-1]:0;
                int top = (r>0 )? prefix[r-1][c]:0;
                int left = (c>0)? prefix[r][c-1]:0;
                prefix[r][c]= matrix[r][c]+top+left-topLeft;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = prefix[row2][col2];
        int topLeft = (row1>0 && col1>0)? prefix[row1-1][col1-1]:0;
        int top = (row1>0 )? prefix[row1-1][col2]:0;
        int left = (col1>0)? prefix[row2][col1-1]:0;

        return total-top-left+topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */