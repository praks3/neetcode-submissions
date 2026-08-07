class Solution {
    public boolean isValidSudoku(char[][] board) {
        // row
        for (int i = 0; i < 9; i++) {
            HashSet<Character> seen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (seen.contains(board[i][j])) {
                    return false;
                }
                seen.add(board[i][j]);
            }
        }
        // col
        for (int i = 0; i < 9; i++) {
            HashSet<Character> seen = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.')
                    continue;
                if (seen.contains(board[j][i])) {
                    return false;
                }
                seen.add(board[j][i]);
            }
        }

        // 3*3 square
        for (int sq = 0; sq < 9; sq++) {
            HashSet<Character> seen = new HashSet<>();
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                   int row = (sq/3)*3+r;
                   int col = (sq%3)*3+c;
                   if (board[row][col] == '.')
                    continue;

                    if (seen.contains(board[row][col])) {
                    return false;
                }
                seen.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
