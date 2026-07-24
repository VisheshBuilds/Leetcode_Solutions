class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length,m=board[0].length;
        boolean[][] visit=new boolean[n][m];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0)==board[i][j] && helper(visit,board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(boolean[][] visit,char[][] board,int r,int c, String word,int idx){
        if(idx==word.length()) return true;

        if(r<0 || c<0 || r>=board.length || c>=board[0].length || visit[r][c] || word.charAt(idx)!=board[r][c]){
            return false;
        }

        visit[r][c]=true;
        if(helper(visit,board,r+1,c,word,idx+1)||helper(visit,board,r-1,c,word,idx+1)||helper(visit,board,r,c+1,word,idx+1)||helper(visit,board,r,c-1,word,idx+1)){
            return true;
        }

        visit[r][c]=false;
        return false;
    }
}