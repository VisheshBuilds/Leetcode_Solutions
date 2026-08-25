class Solution {
    class triplet  {
        int node;
        int cost;
        int stops;
        triplet(int node,int cost,int stops){
            this.node=node;
            this.cost=cost;
            this.stops=stops;
        }
    }
    class Pair{
        int node;
        int cost;
        Pair(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<flights.length;i++){
            int a=flights[i][0],b=flights[i][1],c=flights[i][2];
            adj.get(a).add(new Pair(b,c));
        }
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src]=0;

        Queue<triplet> pq=new LinkedList<>();
        pq.add(new triplet(src,0,0));

        while(!pq.isEmpty()){
            triplet top=pq.remove();
            int node=top.node;
            int cost=top.cost;
            int stops=top.stops;
            if(stops==k+1) continue;
            for(Pair p:adj.get(node)){
                int totalcost=cost + p.cost;
                if(ans[p.node]>totalcost){
                    ans[p.node]=totalcost;
                    pq.add(new triplet(p.node,totalcost,stops+1));
                }
            }
        }
        
        if(ans[dst]==Integer.MAX_VALUE) return -1;
        return ans[dst];
    }
}