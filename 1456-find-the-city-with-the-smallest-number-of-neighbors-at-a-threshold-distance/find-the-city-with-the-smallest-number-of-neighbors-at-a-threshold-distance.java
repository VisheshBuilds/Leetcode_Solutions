class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adj=new int[n][n];

        for(int i=0;i<n;i++){
           Arrays.fill(adj[i],Integer.MAX_VALUE);
           adj[i][i]=0;
        } 

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0],v=edges[i][1],w=edges[i][2];
            adj[u][v]=w;
            adj[v][u]=w;
        }
        
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if(i==k) continue;
                for(int j=0;j<n;j++){
                    if(j==k) continue;
                    if(adj[i][k]!=Integer.MAX_VALUE && adj[k][j]!=Integer.MAX_VALUE){
                        adj[i][j]=Math.min(adj[i][j],adj[i][k]+adj[k][j]);
                    }
                }
            }
        }
        
        int mincity=Integer.MAX_VALUE,idx=-1;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(adj[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=mincity){
                mincity=count;
                idx=i;
            }
        }
        
        return idx;
    }
}