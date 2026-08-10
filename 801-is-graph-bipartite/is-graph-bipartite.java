class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] visit=new int[n];
        Arrays.fill(visit,-1);
       // 0 - blue,1- red
        for(int i=0;i<n;i++){
            if(visit[i]==-1 ){
                visit[i]=0;
                if( !bfs(graph,visit,i)) return false;
            }
        }
        return true;
    }
    public boolean bfs(int[][] graph,int[] visit,int i){
        
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int front=q.remove();
            int color=visit[front];
            for(int ele:graph[front]){
                if(visit[front]==visit[ele]) return false;
                if(visit[ele]==-1){
                    q.add(ele);
                    visit[ele]=1-color;
                }
            }
        }
        return true;
    }
}