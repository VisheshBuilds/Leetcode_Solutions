class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int ans=0;
        boolean[][] visit=new boolean[n][m];
        Queue<Pair> pq=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visit[i][j]){
                    pq.add(new Pair(i,j));
                    visit[i][j]=true;
                    int count=0;
                    while(pq.size()>0){
                        Pair top=pq.remove();
                        count++;
                        int k=top.i,l=top.j;

                        if(k>0 && grid[k-1][l]==1 && !visit[k-1][l]){
                            visit[k-1][l]=true;
                            pq.add(new Pair(k-1,l));
                        }
                        if(k<n-1 && grid[k+1][l]==1 && !visit[k+1][l]){
                            visit[k+1][l]=true;
                            pq.add(new Pair(k+1,l));
                        }
                        if(l>0 && grid[k][l-1]==1 && !visit[k][l-1]){
                            visit[k][l-1]=true;
                            pq.add(new Pair(k,l-1));
                        }
                        if(l<m-1 && grid[k][l+1]==1 && !visit[k][l+1]){
                            visit[k][l+1]=true;
                            pq.add(new Pair(k,l+1));
                        }
                    }
                    ans=Math.max(ans,count);
                }
            }
        }
        return ans;
    }
}