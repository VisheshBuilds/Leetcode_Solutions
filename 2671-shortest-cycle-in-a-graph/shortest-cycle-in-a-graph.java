class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0],v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int max=Integer.MAX_VALUE;

        for(int src=0;src<n;src++){
            int[] parent=new int[n];
            int[] dist=new int[n];

            Arrays.fill(parent,-1);
            Arrays.fill(dist,-1);

            PriorityQueue<Integer> pq=new PriorityQueue<>();
            dist[src]=0;
            pq.offer(src);

            while(!pq.isEmpty()){
                int top=pq.remove();
                for(int ele:adj.get(top)){
                    if(dist[ele]==-1){
                        dist[ele]=dist[top]+1;
                        parent[ele]=top;
                        pq.offer(ele);
                    }
                    else if(ele!=parent[top]){
                        int dis=dist[top]+dist[ele]+1;
                        max=Math.min(max,dis);
                    }
                }
            }
            
        }
        return max==Integer.MAX_VALUE ? -1:max;
    }
}