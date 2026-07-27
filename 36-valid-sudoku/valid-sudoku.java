class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(!isValid(board,i,j,board[i][j])) return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board,int row,int col,char d){
        for(int i=0;i<9;i++){
            if(i!= row && board[i][col]==d) return false;
            if(i!= col && board[row][i]==d) return false;
        }
        int stri=row/3 * 3;
        int strj=col/3 * 3;
        for(int k=0;k<3;k++){
            for(int l=0;l<3;l++){
                if((stri+k !=row && strj+l !=col) && board[stri+k][strj+l]==d) return false;
            }
        }
        return true;
    }
}