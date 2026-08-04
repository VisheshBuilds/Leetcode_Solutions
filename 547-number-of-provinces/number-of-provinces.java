class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length,count=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(visited,i,isConnected);
                count++;
            }
        }
        return count;
    }
    public void dfs(boolean[] vis,int i,int[][] adj){
        int n=adj.length;
        vis[i]=true;
        for(int j=0;j<n;j++){
            if(adj[i][j]==1 && vis[j]==false){
                dfs(vis,j,adj);
            }
        }
        
    }

    public void bfs(boolean[] visited,int num,int[][] isConnected){
        Queue<Integer> q=new LinkedList<>();
        q.add(num);
        visited[num]=true;
        while(!q.isEmpty()){
            int front=q.remove();
            for(int i=0;i<visited.length;i++){
                int val=isConnected[front][i];
                if(!visited[i] && val!=0){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
        
    }
}