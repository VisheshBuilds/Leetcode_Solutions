class Solution {
    class Pair {
        int i,j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int ans;
    boolean[][] visit;
    public int countIslands(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        visit=new boolean[m][n];

        ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 || visit[i][j]) continue;
                else{
                    helper(grid,i,j,k);
                }
            }
        }
        return ans;
    }
    public void helper(int[][] grid,int a,int b,int k){
        int m=grid.length,n=grid[0].length;
        long sum=0;
        Queue<Pair> q=new LinkedList<>();
        visit[a][b]=true;
        q.add(new Pair(a,b));
        while(!q.isEmpty()){
            Pair p=q.remove();
            int i=p.i,j=p.j;
            sum +=grid[i][j];
            
            if(i-1>=0 && i-1<=m-1 && j>=0 && j<=n-1 && grid[i-1][j]!=0 && !visit[i-1][j]){
                visit[i-1][j]=true;
                q.add(new Pair(i-1,j));
            }
            if(i+1>=0 && i+1<=m-1 && j>=0 && j<=n-1 && grid[i+1][j]!=0 && !visit[i+1][j]){
                visit[i+1][j]=true;
                q.add(new Pair(i+1,j));
            }
            if(i>=0 && i<=m-1 && j-1>=0 && j-1<=n-1 && grid[i][j-1]!=0 && !visit[i][j-1]){
                visit[i][j-1]=true;
                q.add(new Pair(i,j-1));
            }
            if(i>=0 && i<=m-1 && j+1>=0 && j+1<=n-1 && grid[i][j+1]!=0 && !visit[i][j+1]){
                visit[i][j+1]=true;
                q.add(new Pair(i,j+1));
            }
        }
        if(sum%k==0) ans++;
    }
}