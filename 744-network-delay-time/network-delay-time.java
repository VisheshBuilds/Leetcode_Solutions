class Solution {
    class Pair implements Comparable<Pair> {
        int node;
        int time;
        Pair(int node,int time){
            this.node=node;
            this.time=time;
        }
        public int compareTo(Pair p){
            if(this.time==p.time) return this.node-p.node;
            return this.time-p.time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<Pair>());

        for(int i=0;i<times.length;i++){
            int u=times[i][0], v=times[i][1] , t=times[i][2];
            adj.get(u).add(new Pair(v,t));
        }

        int[] ans=new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair p=pq.remove();
            int node=p.node,time=p.time;
            if(time > ans[node]) continue;
            for(Pair pr:adj.get(node)){
                int totaltime=time + pr.time;
                if(totaltime < ans[pr.node]){
                    ans[pr.node]=totaltime;
                    pq.add(new Pair(pr.node,totaltime));
                }
            }
        }

        int max=-1;
        for(int i=1;i<=n;i++){
            if(ans[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,ans[i]);
        }
        return max;

    }
}