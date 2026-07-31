class Solution {
    public boolean validPath(int n, int[][] edges, int s, int e) {
        if(s==e) return true;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int a=edges[i][0],b=edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] visited=new boolean[n];
        bfs(adj,s,e,visited);
        return visited[e];
    }
    public void bfs(List<List<Integer>> adj,int s,int e,boolean[] visited){
        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        
        while(!q.isEmpty()){
            int front=q.remove();
            visited[front]=true;
            for(int ele:adj.get(front)){
                if(!visited[ele]){
                    q.add(ele);
                    visited[ele]=true;
                    if(front==e) return;
                }
            }
        }
    }
}