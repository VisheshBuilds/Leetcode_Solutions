class Solution {
    public int findCircleNum(int[][] adj) {
        int n=adj.length,count=0;
        boolean[] visit=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]){
                bfs(i,visit,adj);
                count++;
            }
        }
        return count;
    }
    public void bfs(int i,boolean[] visit,int[][] adj){
        visit[i]=true;
        int n=adj.length;
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        while(q.size()>0){
            int front=q.remove();
            for(int j=0;j<n;j++){
                if(adj[front][j]==1 && !visit[j]){
                    q.add(j);
                    visit[j]=true;
                }
            }
        }
    }
}