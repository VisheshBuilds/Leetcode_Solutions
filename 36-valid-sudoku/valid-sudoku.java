class Solution {
    public boolean isValidSudoku(char[][] board) {
        return solve(board);
    }
    public boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                if(!isSafe(board,i,j)) return false;
            }
        }
        return true;
    }
    public boolean isSafe(char[][] board,int row,int col){
        char num=board[row][col];
        for(int i=0;i<9;i++){
            if(i==col) continue;
            if(board[row][i]==num) return false;
        }
        for(int i=0;i<9;i++){
            if(i==row) continue;
            if(board[i][col]==num) return false;
        }
        int rows=row/3 *3;
        int cols=col/3 *3;
        for(int i=rows;i<rows+3;i++){
            for(int j=cols;j<cols+3;j++){
                if(i==row && j==col) continue;
                if(board[i][j]==num) return false;
            }
        }

        return true;
    }
}