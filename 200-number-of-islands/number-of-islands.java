class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length,m=grid[0].length;
        int count=0;
        boolean[][] visit=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visit[i][j] && grid[i][j]=='1'){
                    // bfs(visit,grid,i,j);
                    dfs(visit,grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(boolean[][] visit,char[][] grid,int i,int j){
        visit[i][j]=true;
        if(i-1>=0 && grid[i-1][j]=='1' && visit[i-1][j]!=true){
            dfs(visit,grid,i-1,j);
        }
        if(i+1<=grid.length-1 && grid[i+1][j]=='1' && visit[i+1][j]!=true){
            dfs(visit,grid,i+1,j);
        }
        if(j-1>=0 && grid[i][j-1]=='1' && visit[i][j-1]!=true){
            dfs(visit,grid,i,j-1);
        }
        if(j+1<=grid[0].length-1 && grid[i][j+1]=='1' && visit[i][j+1]!=true){
            dfs(visit,grid,i,j+1);
        }
    }
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public void bfs(boolean[][] visit,char[][] grid,int i,int j){
        int n=visit.length,m=visit[0].length;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(i,j));
        visit[i][j]=true;
        while(!q.isEmpty()){
            Pair front=q.remove();
            int row=front.row,col=front.col;
            //top row-1,col
            if(row>0 && !visit[row-1][col]&& grid[row-1][col]=='1'){
                q.add(new Pair(row-1,col));
                visit[row-1][col]=true;
            }
            //bottom row+1,col
            if(row<n-1 && !visit[row+1][col]&& grid[row+1][col]=='1'){
                q.add(new Pair(row+1,col));
                visit[row+1][col]=true;
            }
            //left row,col-1
            if(col>0 && !visit[row][col-1]&& grid[row][col-1]=='1'){
                q.add(new Pair(row,col-1));
                visit[row][col-1]=true;
            }
            //right row,col+1
            if(col<m-1 && !visit[row][col+1]&& grid[row][col+1]=='1'){
                q.add(new Pair(row,col+1));
                visit[row][col+1]=true;
            }
        }

    }
}