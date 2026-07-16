class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        Character[][] board=new Character[n][n];
        for(Character[] row:board){
            Arrays.fill(row,'.');
        }
        helper(ans,board,0);

        return ans;
    }
    public void helper(List<List<String>> ans,Character[][] board,int row){
        int n=board.length;
        if(row==n){
            construct(ans,board);
            return;
        }

             for(int col=0;col<n;col++){
                if(isSafe(board,row,col)){
                    board[row][col]='Q';
                    helper(ans,board,row+1);
                    board[row][col]='.';
                }
             }


    }
    public void construct(List<List<String>> ans,Character[][] board){
        List<String> list=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String s="";
            for(int j=0;j<board.length;j++){
                 s +=board[i][j];
            }
            list.add(s);
        }
        ans.add(list);
        return;
    }
    public boolean isSafe(Character[][] board,int row,int col){
        int n=board.length;
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q') return false;
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;
    }
}