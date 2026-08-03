class NumMatrix {
    /*
    BF:
    Calc prefixSum for each rows in the matrix and then apply the 
    prefixSum formula for each row upto the given cols.
    */
    List<List<Integer>> prefixSumList = new ArrayList<>();

    public NumMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            List<Integer> prefixSum = new ArrayList<>();
            prefixSum.add(0);
            for (int j = 0; j < matrix[0].length; j++) {
                prefixSum.add(matrix[i][j] + prefixSum.get(prefixSum.size() - 1));
            }
            prefixSumList.add(prefixSum);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            List<Integer> prefixSum = prefixSumList.get(i);
            sum += prefixSum.get(col2 + 1) - prefixSum.get(col1);
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */