class Solution {
    public class Pair implements Comparable<Pair>{
        int node;
        double prob;
        Pair(int node,double prob){
            this.node=node;
            this.prob=prob;
        }
        public int compareTo(Pair p){
            if(this.prob==p.prob) return this.node-p.node;
            return Double.compare(this.prob,p.prob);
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succ, int s, int e) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int a=edges[i][0],b=edges[i][1];
            double p=succ[i];
            adj.get(a).add(new Pair(b,p));
            adj.get(b).add(new Pair(a,p));
        }

        double[] ans=new double[n];
        ans[s]=1;

        PriorityQueue<Pair> pq=new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Pair(s,1));

        while(!pq.isEmpty()){
            Pair top=pq.remove();
            int node=top.node;
            double pro=top.prob;
            if(pro < ans[node]) continue;
            for(Pair p:adj.get(node)){
                double totalproba=pro*p.prob;
                if(totalproba > ans[p.node]){
                    ans[p.node]=totalproba;
                    pq.add(new Pair(p.node,totalproba));
                }
            }
        }
        return ans[e];
    }
}