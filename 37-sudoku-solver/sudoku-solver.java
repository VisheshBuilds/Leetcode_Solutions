class Solution {
    public void solveSudoku(char[][] board) {
        
        solve(board);
        return;
    }
    public boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char num='1';num<='9';num++){
                        if(isSafe(board,i,j,num)){
                            board[i][j]=num;
                            if(solve(board)) return true;
                            board[i][j]='.';
                        } 
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSafe(char[][] board,int row,int col,char num){

        for(int i=0;i<9;i++){
            if(board[row][i]==num) return false;
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==num) return false;
        }
        int rows=row/3 *3;
        int cols=col/3 *3;
        for(int i=rows;i<rows+3;i++){
            for(int j=cols;j<cols+3;j++){
                if(board[i][j]==num) return false;
            }
        }

        return true;
    }
}